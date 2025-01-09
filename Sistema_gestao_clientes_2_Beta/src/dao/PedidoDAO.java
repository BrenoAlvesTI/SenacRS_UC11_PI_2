package dao;

import conexao.Conexao;
import model.Pedido;
import model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class PedidoDAO {

    private Conexao conexao;
    private Connection conn;
    private ProdutoDAO produtoDAO;

    public PedidoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
        this.produtoDAO = new ProdutoDAO(); // Inicializando o ProdutoDAO
    }

    // Método para inserir um pedido no banco de dados
    public boolean inserir(Pedido pedido) {
        // Inserir o pedido na tabela pedido
        String sqlPedido = "INSERT INTO pedido (id_cliente, data_hora, valor_total) VALUES (?, ?, ?)";
        try {
            // Preparando a inserção na tabela 'pedido'
            PreparedStatement psPedido = this.conn.prepareStatement(sqlPedido, PreparedStatement.RETURN_GENERATED_KEYS);
            psPedido.setInt(1, pedido.getIdCliente());
            psPedido.setString(2, pedido.getDataHora().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

            // Usando diretamente o valor de BigDecimal retornado por getValorTotal()
            BigDecimal valorTotal = pedido.getValorTotal();
            psPedido.setBigDecimal(3, valorTotal); // Usando BigDecimal diretamente

            int linhasAfetadas = psPedido.executeUpdate();
            if (linhasAfetadas > 0) {
                // Recuperando o ID do pedido inserido
                ResultSet rs = psPedido.getGeneratedKeys();
                int idPedido = 0;
                if (rs.next()) {
                    idPedido = rs.getInt(1);
                }

                // Inserir os produtos relacionados ao pedido na tabela pedido_produto
                String sqlProduto = "INSERT INTO pedido_produto (pedido_id, produto_id, quantidade) VALUES (?, ?, ?)";
                PreparedStatement psProduto = this.conn.prepareStatement(sqlProduto);
                for (Produto produto : pedido.getProdutos()) {
                    psProduto.setInt(1, idPedido); // ID do pedido
                    psProduto.setInt(2, produto.getId()); // ID do produto
                    psProduto.setInt(3, produto.getQuantidade()); // Quantidade do produto
                    psProduto.addBatch(); // Adicionando a operação ao batch
                }
                // Executando o batch de inserção dos produtos
                psProduto.executeBatch();
                
                JOptionPane.showMessageDialog(null, "Pedido cadastrado com sucesso!", "Êxito!", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar pedido: " + e.getMessage() + "", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;
    }



    // Método para excluir um pedido do banco de dados
    public void excluir(int id) {
        String sqlPedidoProduto = "DELETE FROM pedido_produto WHERE pedido_id = ?";
        String sqlPedido = "DELETE FROM pedido WHERE id = ?";
        try {
            // Primeiro, excluir os produtos relacionados ao pedido
            PreparedStatement psPedidoProduto = this.conn.prepareStatement(sqlPedidoProduto);
            psPedidoProduto.setInt(1, id);
            psPedidoProduto.execute();

            // Agora, excluir o pedido
            PreparedStatement psPedido = this.conn.prepareStatement(sqlPedido);
            psPedido.setInt(1, id);
            
            psPedido.execute();
            JOptionPane.showMessageDialog(null, "Pedido excluído com sucesso!", "Êxito!", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir pedido:" + e.getMessage() + "", "Erro!", JOptionPane.ERROR_MESSAGE);            
        }
    }

    public List<Pedido> getPedidos() {
        String sql = "SELECT p.id, p.id_cliente, p.data_hora, p.valor_total, pp.produto_id, pp.quantidade "
                   + "FROM pedido p "
                   + "INNER JOIN pedido_produto pp ON p.id = pp.pedido_id "
                   + "ORDER BY p.id DESC";
        List<Pedido> listaPedidos = new ArrayList<>();

        try (PreparedStatement ps = this.conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            // Utiliza um Map para garantir que os pedidos sejam agrupados corretamente
            Map<Integer, Pedido> pedidosMap = new HashMap<>();

            while (rs.next()) {
                int id = rs.getInt("id");
                int idCliente = rs.getInt("id_cliente");
                LocalDateTime dataHora = rs.getTimestamp("data_hora").toLocalDateTime();
                BigDecimal valorTotal = rs.getBigDecimal("valor_total");

                // Recuperando os dados do produto relacionado ao pedido
                int produtoId = rs.getInt("produto_id");
                int quantidade = rs.getInt("quantidade");

                // Busca o Produto correspondente ao produto_id
                Produto produto = buscarProdutoPorId(produtoId); // Método para buscar produto
                if (produto != null) {
                    // Verifica se o pedido já existe no Map
                    Pedido pedido = pedidosMap.get(id);
                    if (pedido == null) {
                        // Se o pedido não existir, cria um novo pedido e adiciona no Map
                        pedido = new Pedido(id, idCliente, new ArrayList<>(), dataHora, valorTotal);
                        pedidosMap.put(id, pedido);
                    }

                    // Adiciona o produto à lista de produtos do pedido
                    pedido.getProdutos().add(produto);
                }
            }

            // Adiciona todos os pedidos ao retorno
            listaPedidos.addAll(pedidosMap.values());

        } catch (Exception e) {
            System.out.println("Erro ao buscar pedidos: " + e.getMessage());
        }

        return listaPedidos;
    }

    // Método para buscar o Produto pelo ID
    public Produto buscarProdutoPorId(int produtoId) {
        String sql = "SELECT * FROM produto WHERE id = ?";
        try (PreparedStatement ps = this.conn.prepareStatement(sql)) {
            ps.setInt(1, produtoId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValorCusto(rs.getBigDecimal("ValorCusto").doubleValue());
                produto.setValorVenda(rs.getBigDecimal("ValorVenda").doubleValue());
                produto.setQuantidade(rs.getInt("quantidade"));
                return produto;
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar produto por ID: " + e.getMessage());
        }
        return null;
    }


    // Método auxiliar para buscar os produtos relacionados a um pedido
    private List<Produto> getProdutosFromPedido(int pedidoId) {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT p.id, p.nome, p.ValorCusto, p.ValorVenda, p.quantidade "
                   + "FROM produto p "
                   + "JOIN pedido_produto pp ON p.id = pp.produto_id "
                   + "WHERE pp.pedido_id = ?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, pedidoId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValorCusto(rs.getBigDecimal("ValorCusto").doubleValue());
                produto.setValorVenda(rs.getBigDecimal("ValorVenda").doubleValue());
                produto.setQuantidade(rs.getInt("quantidade"));
                produtos.add(produto);
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar produtos do pedido: " + e.getMessage());
        }
        return produtos;
    }
}
