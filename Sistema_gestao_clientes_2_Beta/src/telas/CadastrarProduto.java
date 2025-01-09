package telas;

import dao.ProdutoDAO;
import javax.swing.JOptionPane;
import model.Produto;
import model.ListaProduto;

public class CadastrarProduto extends javax.swing.JFrame {

    private final TelaProdutos telaProdutos;
    
    public CadastrarProduto(TelaProdutos telaProdutos) {
        this.telaProdutos = telaProdutos;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btCadastrar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtValorCusto = new javax.swing.JFormattedTextField();
        txtValorVenda = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Cadastrar Produto");

        jLabel2.setText("Nome:");

        txtNome.setToolTipText("Insira o nome do Produto");

        btCadastrar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btCadastrar.setText("Cadastrar");
        btCadastrar.setToolTipText("Cadastra o produto");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btVoltar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.setToolTipText("Volta a tela de produtos cadastrados");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        jLabel4.setText("Quantidade:");

        txtQuantidade.setToolTipText("Insira a Quantidade Atual");

        jLabel5.setText("Valor Custo:");

        jLabel6.setText("Valor Venda:");

        txtValorCusto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        txtValorVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(txtValorCusto))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(txtValorVenda))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtValorCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
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
        if (!camposVazios()){
            cadastroValido();
        }
    }//GEN-LAST:event_btCadastrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JFormattedTextField txtValorCusto;
    private javax.swing.JFormattedTextField txtValorVenda;
    // End of variables declaration//GEN-END:variables

    private boolean camposVazios(){
        
        boolean empty = true;
        
        if (txtNome.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "ATENÇÃO! O Campo Nome não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            txtNome.requestFocus();
        }
        else if (txtValorCusto.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "ATENÇÃO! O Campo Valor Custo não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            txtValorCusto.requestFocus();
        }
        else if (txtValorVenda.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "ATENÇÃO! O Campo Valor Venda não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            txtValorVenda.requestFocus();
        }
        else if (txtQuantidade.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "ATENÇÃO! O Campo Quantidade não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            txtQuantidade.requestFocus();
        }
        else {
            empty = false;
        }
        
        return empty;
    }
    
    private Produto getProduto(){
        
        String nome = txtNome.getText().toUpperCase();
        double ValorCusto = Double.parseDouble(txtValorCusto.getText().replace(',', '.'));
        double ValorVenda = Double.parseDouble(txtValorVenda.getText().replace(',', '.'));
        int quantidade = Integer.parseInt(txtQuantidade.getText());
        
        Produto produto = new Produto();
        
        produto.setNome(nome);
        produto.setValorCusto(ValorCusto);
        produto.setValorVenda(ValorVenda);
        produto.setQuantidade(quantidade);
        
        return produto;
    }
    
    private void cadastrarProduto(Produto produto){                
            
            produto.setNome(txtNome.getText().toUpperCase());
            produto.setValorCusto(Double.valueOf(txtValorCusto.getText().replace(',', '.')));
            produto.setValorVenda(Double.valueOf(txtValorVenda.getText().replace(',', '.')));
            produto.setQuantidade(Integer.valueOf(txtQuantidade.getText()));
            
            ProdutoDAO produtoDAO = new ProdutoDAO();
            boolean sucesso = produtoDAO.inserir(produto);
            
            if (sucesso) {                
                telaProdutos.preencherTabela();

                txtNome.setText("");
                txtValorCusto.setText("");
                txtValorVenda.setText("");
                txtQuantidade.setText("");
                txtNome.requestFocus(); 
            }
    }
    
    private void cadastroValido() {
        
        String strNome = txtNome.getText().toUpperCase();
        String strValorCusto = String.valueOf(txtValorCusto.getText().replace(',', '.'));
        String strValorVenda = String.valueOf(txtValorVenda.getText().replace(',', '.'));
        String strQuantidade = String.valueOf(txtQuantidade.getText());

        boolean verifica = strNome.matches("[\\p{L} ]+");
        boolean verifica2 = strValorCusto.matches("^\\d+\\.\\d{2}");
        boolean verifica3 = strValorVenda.matches("^\\d+\\.\\d{2}");
        boolean verifica4 = strQuantidade.matches("\\d+");

        if (!verifica){
            JOptionPane.showMessageDialog(null, "O Campo nome só pode conter letras", "Erro", JOptionPane.ERROR_MESSAGE);
            txtNome.setText("");
            txtNome.requestFocus();          
        }
        else if (!verifica2){
            JOptionPane.showMessageDialog(null, "O campo Valor Custo deve começar com números e terminar com .xx", "Erro", JOptionPane.ERROR_MESSAGE);
            txtValorCusto.setText("");
            txtValorCusto.requestFocus();
        }
        else if (!verifica3){
            JOptionPane.showMessageDialog(null, "O campo Valor Venda deve começar com números e terminar com .xx", "Erro", JOptionPane.ERROR_MESSAGE);
            txtValorVenda.setText("");
            txtValorVenda.requestFocus();
        }
        else if (!verifica4){
            JOptionPane.showMessageDialog(null, "O campo quantidade deve conter apenas números", "Erro", JOptionPane.ERROR_MESSAGE);
            txtQuantidade.setText("");
            txtQuantidade.requestFocus();
        }
        else {
            cadastrarProduto(getProduto());
        }
    }

}
