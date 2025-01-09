package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import model.Produto;
import java.sql.SQLException;

public class ProdutoDAO {
    
    private Conexao conexao;
    private Connection conn;
    
    public ProdutoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public boolean inserir(Produto produto) {
        String sql = ("INSERT INTO produto(nome, ValorCusto, ValorVenda, quantidade) VALUES "
                + "(?, ?, ?, ?)");
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, produto.getNome());
            ps.setDouble(2, produto.getValorCusto());
            ps.setDouble(3, produto.getValorVenda());
            ps.setInt(4, produto.getQuantidade());
            
            int linhasAfetadas = ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!", "Êxito", JOptionPane.INFORMATION_MESSAGE);
            return linhasAfetadas > 0;           
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + e.getMessage() + "", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean editar(Produto produto) {
        // string sql com o código de update para o banco de dados
        String sql = "UPDATE produto SET quantidade=? WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            // Setando os parâmetros
            ps.setInt(1, produto.getQuantidade());
            ps.setInt(2, produto.getId());

            // Executando a query
            int rowsAffected = ps.executeUpdate();

            // Verificando se a atualização foi bem-sucedida
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!", "Êxito!", JOptionPane.INFORMATION_MESSAGE);
                return true;  // Sucesso
            } else {
                return false; // Nenhuma linha foi afetada (não encontrou o produto)
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar produto: " + e.getMessage() + "", "Erro", JOptionPane.ERROR_MESSAGE);
            return false; // Em caso de erro
        }
    }
    
    public void excluir (int id){
                
        String sql = "DELETE FROM produto WHERE id = ?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.execute();
            JOptionPane.showMessageDialog(null,"Produto excluído com sucesso!", "Êxito!",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir produto, esse produto tem pedidos associados a ele!\n (Exclua os pedidos associados ao produto para excluir o produto)", "Erro!",JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public List<Produto> getProdutosTotal(String nome ) { 
            String sql = "SELECT * FROM produto WHERE nome LIKE ?"; 

            try {
                PreparedStatement ps = this.conn.prepareStatement(sql);
                //Como temos um parâmetro, devemos defini-lo
                ps.setString(1,"%" + nome + "%"); //Conforme for a palavra ou letra digitada para pesquisa, será buscada antes, no meio e no fim

                ResultSet rs = ps.executeQuery();            

                List<Produto> listaProdutos = new ArrayList<>();

                //Estrutura de repetição While
                while (rs.next()) { //.next retorna verdadeiro caso exista uma próxima posição dentro do array
                Produto produto = new Produto();
           
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValorCusto(rs.getDouble("ValorCusto"));
                produto.setValorVenda(rs.getDouble("ValorVenda"));
                produto.setQuantidade(rs.getInt("quantidade"));

                listaProdutos.add(produto);

                }
                //Após finalizar o while, o retorno será a listaEmpresas, onde cada posição é um registro do banco de dados
                return listaProdutos;

                //Se o método entrar no "Catch" quer dizer que não encontrou nenhuma empresa, então damos um "return null"
            } catch (Exception e) {
                return null;
            }

        }
    
    public List<Produto> buscarProdutosPorIds(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            return new ArrayList<>(); // Retorna lista vazia se não houver IDs
        }

        String sql = "SELECT * FROM produto WHERE id IN (" + 
                     ids.stream().map(String::valueOf).collect(Collectors.joining(",")) + ")";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            List<Produto> produtos = new ArrayList<>();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValorCusto(rs.getDouble("ValorCusto"));
                produto.setValorVenda(rs.getDouble("ValorVenda"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produtos.add(produto);
            }
            return produtos;
        } 
        catch (SQLException e) {
            System.out.println("Erro ao buscar produtos: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    public Produto buscarProdutoPorId(int id) {
        Produto produto = null;
        String sql = "SELECT * FROM produto WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    produto = new Produto();
                    produto.setId(rs.getInt("id"));
                    produto.setNome(rs.getString("nome"));
                    produto.setValorCusto(rs.getDouble("ValorCusto"));
                    produto.setValorVenda(rs.getDouble("ValorVenda"));
                    produto.setQuantidade(rs.getInt("quantidade"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar produto: " + e.getMessage());
        }
        return produto;
    }
    
    public boolean atualizarEstoque(Produto produto) {
        String sql = "UPDATE produto SET quantidade = ? WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, produto.getQuantidade());  // Atualiza a quantidade no banco
            ps.setInt(2, produto.getId());  // ID do produto
            int linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas > 0;  // Retorna true se a atualização for bem-sucedida
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

   
}
