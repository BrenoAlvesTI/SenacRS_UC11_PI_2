package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;

public class ClienteDAO {
    
    private Conexao conexao;
    private Connection conn;
    
    public ClienteDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public boolean inserir(Cliente cliente) {
        String sql = ("INSERT INTO cliente(nome, telefone, endereco) VALUES "
                + "(?, ?, ?)");
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getTelefone());
            ps.setString(3, cliente.getEndereco());
            
            int linhasAfetadas = ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Êxito!", JOptionPane.INFORMATION_MESSAGE);
            return linhasAfetadas > 0;            
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente: " + e.getMessage() + "", "Erro!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public void editar (Cliente cliente){
        //string sql com o código de update para o banco de dados
        String sql = "UPDATE cliente SET nome=?, telefone=?, endereco=? WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            //Setando os parâmetros
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getTelefone());
            ps.setString(3, cliente.getEndereco());
            ps.setInt(4, cliente.getId());
            //Executando a query
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!", "Êxito!", JOptionPane.INFORMATION_MESSAGE);
            //tratando o erro, caso ele ocorra
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar cliente: " + e.getMessage() + "", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void excluir (int id){
                
        String sql = "DELETE FROM cliente WHERE id = ?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.execute();
            JOptionPane.showMessageDialog(null,"Cliente excluído com sucesso!", "Sucesso!",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir cliente, esse cliente tem um pedido associado a ele!\n (Exclua o pedido associado ao cliente para excluir o cliente)", "Erro!",JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public List<Cliente> getClientesTotal(String nome ) { 
            String sql = "SELECT * FROM cliente WHERE nome LIKE ?"; 

            try {
                PreparedStatement ps = this.conn.prepareStatement(sql);
                //Como temos um parâmetro, devemos defini-lo
                ps.setString(1,"%" + nome + "%"); //Conforme for a palavra ou letra digitada para pesquisa, será buscada antes, no meio e no fim

                ResultSet rs = ps.executeQuery();            

                List<Cliente> listaClientes = new ArrayList<>();

                //Estrutura de repetição While
                while (rs.next()) { //.next retorna verdadeiro caso exista uma próxima posição dentro do array
                Cliente cliente = new Cliente();
           
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEndereco(rs.getString("endereco"));

                listaClientes.add(cliente);

                }
                //Após finalizar o while, o retorno será a listaEmpresas, onde cada posição é um registro do banco de dados
                return listaClientes;

                //Se o método entrar no "Catch" quer dizer que não encontrou nenhuma empresa, então damos um "return null"
            } catch (Exception e) {
                return null;
            }

        }
    
    public Cliente buscarClientePorId(int id) {
        String sql = "SELECT * FROM cliente WHERE id = ?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) { // Se encontrou o cliente
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEndereco(rs.getString("endereco"));
                return cliente;
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar cliente por ID: " + e.getMessage());
        }
        return null; // Retorna null se o cliente não for encontrado
    }

    
}
