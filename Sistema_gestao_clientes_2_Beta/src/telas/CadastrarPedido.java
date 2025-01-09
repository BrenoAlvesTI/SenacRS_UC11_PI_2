package telas;

import dao.ClienteDAO;
import dao.PedidoDAO;
import dao.ProdutoDAO;
import java.math.BigDecimal;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;
import model.Cliente;
import model.Produto;
import model.Pedido;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.stream.Collectors;

public class CadastrarPedido extends javax.swing.JFrame {

    private final TelaPedidos telaPedidos;
    
    public CadastrarPedido(TelaPedidos telaPedidos) {
        this.telaPedidos = telaPedidos;
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIdProdutos = new javax.swing.JTextField();
        txtIdCliente = new javax.swing.JTextField();
        btCadastrar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Cadastrar Pedidos");

        jLabel2.setText("ID Cliente:");

        jLabel3.setText("ID Produtos:");

        txtIdProdutos.setToolTipText("Insira o ID dos produtos (idProduto:quantidade) no formato x:x (caso seja mais de um separe por vírgula e com um espaço) ");

        txtIdCliente.setToolTipText("Insira o ID do Cliente (apenas números)");

        btCadastrar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btCadastrar.setText("Cadastrar");
        btCadastrar.setToolTipText("Cadastra o pedido");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btVoltar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.setToolTipText("Volta a página de pedidos cadastrados");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIdProdutos)
                                    .addComponent(txtIdCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIdProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar)
                    .addComponent(btVoltar))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        cadastrarPedido();
    }//GEN-LAST:event_btCadastrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdProdutos;
    // End of variables declaration//GEN-END:variables

    public void cadastrarPedido() {
        // Verificar se os campos estão vazios
        if (camposVazios()) {
            return;  // Retorna caso algum campo esteja vazio
        }
        
        if (validarCampos()){
            return;
        }

        // Validar cliente
        Cliente cliente = validarCliente();
        if (cliente == null) {
            return;  // Retorna caso o cliente não seja encontrado
        }

        // Validar e obter a lista de produtos
        List<Produto> produtos = validarProdutos();
        if (produtos == null || produtos.isEmpty()) {
            return;  // Retorna caso a lista de produtos seja inválida ou vazia
        }

        try {
            // Calcula o valor total do pedido
            BigDecimal valorTotal = produtos.stream()
                .map(p -> {
                    BigDecimal valorVenda = BigDecimal.valueOf(p.getValorVenda()); // Convertendo o valorVenda para BigDecimal
                    BigDecimal quantidadeRequisitada = BigDecimal.valueOf(p.getQuantidadeRequisitada());  // Convertendo a quantidade para BigDecimal
                    return valorVenda.multiply(quantidadeRequisitada);  // Multiplicando os valores como BigDecimal
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);  // Somando os valores

            // Criar o pedido (o id do pedido será gerado automaticamente no banco)
            Pedido pedido = new Pedido(0, cliente.getId(), produtos, LocalDateTime.now(), valorTotal);

            // Salvar o pedido no banco de dados
            PedidoDAO pedidoDAO = new PedidoDAO();
            if (pedidoDAO.inserir(pedido)) {
                               
                for (Produto produto : produtos) {
                    // Atualizar o estoque de cada produto no banco de dados
                    produto.setQuantidade(produto.getQuantidade() - produto.getQuantidadeRequisitada());
                    ProdutoDAO produtoDAO = new ProdutoDAO();
                    produtoDAO.atualizarEstoque(produto); // Chama o método de atualização de estoque
                }                
                
                limparCampos();
                telaPedidos.atualizarTabela();
            }
        } catch (Exception e) {
            System.out.println("Erro ao inserir pedido: " + e.getMessage());
        }
    }

    private boolean camposVazios() {
        if (txtIdCliente.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ATENÇÃO! O campo ID Cliente não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            txtIdCliente.requestFocus();
            return true;
        } else if (txtIdProdutos.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ATENÇÃO! O campo ID Produtos não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            txtIdProdutos.requestFocus();
            return true;
        }
        return false;
    }

    private Cliente validarCliente() {
        try {
            int idCliente = Integer.parseInt(txtIdCliente.getText().trim());
            ClienteDAO clienteDAO = new ClienteDAO();
            Cliente cliente = clienteDAO.buscarClientePorId(idCliente);
            if (cliente == null) {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            return cliente;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID Cliente inválido! Apenas números são permitidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }


    public List<Produto> validarProdutos() {
        String[] produtoStrings = txtIdProdutos.getText().split(",");  // Para separar os produtos no formato "id:quantidade"
        List<Produto> produtos = new ArrayList<>();

        ProdutoDAO produtoDAO = new ProdutoDAO();  // Instanciando ProdutoDAO

        for (String produtoString : produtoStrings) {
            try {
                String[] dados = produtoString.trim().split(":");
                int idProduto = Integer.parseInt(dados[0].trim());
                int quantidadeRequisitada = Integer.parseInt(dados[1].trim());

                // Buscar o produto pelo ID usando buscarProdutosPorIds
                List<Produto> produtosBuscados = produtoDAO.buscarProdutosPorIds(Collections.singletonList(idProduto));  // Passando uma lista com o ID
                if (!produtosBuscados.isEmpty()) {
                    Produto produto = produtosBuscados.get(0);  // Pega o primeiro produto da lista

                    // Verifica se a quantidade solicitada é maior que a quantidade em estoque
                    if (quantidadeRequisitada > produto.getQuantidade()) {
                        JOptionPane.showMessageDialog(null, "Quantidade Insuficiente em Estoque para Produto\n ID: "
                                + produto.getId() + "\n Nome: " + produto.getNome() 
                                + "\nQuantidade requisitada: " + quantidadeRequisitada 
                                + "\nQuantidade em estoque: " + produto.getQuantidade(), 
                                "Erro", JOptionPane.ERROR_MESSAGE);
                        return null;  // Retorna null caso a quantidade seja insuficiente
                    }

                    produto.setQuantidadeRequisitada(quantidadeRequisitada);
                    produtos.add(produto);
                } else {
                    JOptionPane.showMessageDialog(null, "Produto de ID: " + idProduto + " não encontrado! ", "Erro", JOptionPane.ERROR_MESSAGE);
                    return null;  // Retorna null caso não encontre o produto
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Formato inválido para os produtos.", "Erro", JOptionPane.ERROR_MESSAGE);
                return null;  // Retorna null em caso de erro no formato
            }
        }

        return produtos.isEmpty() ? null : produtos;  // Verifica se a lista de produtos está vazia
    }
    
    private boolean validarCampos(){
        
        String strIdCliente = String.valueOf(txtIdCliente.getText());
        String strIdProdutos = String.valueOf(txtIdProdutos.getText());

        boolean verifica = strIdCliente.matches("\\d+");
        boolean verifica2 = strIdProdutos.matches("(\\d+:\\d+)(, (\\d+:\\d+))*");

        if (!verifica){
            JOptionPane.showMessageDialog(null, "O Campo ID Cliente só pode conter números", "Erro!", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        else if (!verifica2){
            JOptionPane.showMessageDialog(null, "O Campo ID Produtos deve estar no formato 'idProduto:quantidade'\n (Caso seja mais de um produto separe-os por vírgula e com um espaço)\nExemplo: idProduto:quantidade, idProduto:quantidade",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
    }

    private void limparCampos() {
        txtIdCliente.setText("");
        txtIdProdutos.setText("");
    }

}
