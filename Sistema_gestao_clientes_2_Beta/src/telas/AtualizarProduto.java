package telas;

import dao.ProdutoDAO;
import javax.swing.JOptionPane;
import model.Produto;
import model.ListaProduto;

public class AtualizarProduto extends javax.swing.JFrame {
    
    private final TelaProdutos telaProdutos;
    private Produto produto;
    private int posicao;
    
    public AtualizarProduto(TelaProdutos telaProdutos, Produto produto) {       
        this.telaProdutos = telaProdutos;
        this.produto = produto;
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        btAtualizar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        jLabel1.setText("Atualizar Quantidade");

        jLabel2.setText("Quantidade em Estoque:");

        txtQuantidade.setToolTipText("Insira a Quantidade");

        btAtualizar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btAtualizar.setText("Atualizar");
        btAtualizar.setToolTipText("Atualiza a Quantidade");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        btVoltar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.setToolTipText("Volta a tela Inicial");
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
                        .addGap(53, 53, 53)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAtualizar)
                    .addComponent(btVoltar))
                .addGap(39, 39, 39))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        if (!camposVazios()){
            atualizarQuantidadeEstoque();
        }
    }//GEN-LAST:event_btAtualizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables

    private boolean camposVazios(){

            boolean empty = true;

            if (txtQuantidade.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "ATENÇÃO! O Campo Quantidade não pode estar vazio.");
                txtQuantidade.requestFocus();
            }
            else {
                empty = false;
            }

            return empty;
    }
    
    private void atualizarQuantidadeEstoque() {
        
        String strQuantidade = String.valueOf(txtQuantidade.getText());

        boolean verifica = strQuantidade.matches("\\d+");

        if (!verifica) {
            JOptionPane.showMessageDialog(null, "O campo Quantidade só pode conter números!");
            txtQuantidade.setText("");
            txtQuantidade.requestFocus();
        } 
        else {
            // Atualizar o objeto cliente
            produto.setQuantidade(Integer.valueOf(strQuantidade));

            // Atualizar no banco de dados
            ProdutoDAO produtoDAO = new ProdutoDAO();
            boolean sucesso = produtoDAO.editar(produto);

            // Atualizar a tabela na tela principal
            if (sucesso) {
            telaProdutos.preencherTabela();            
            dispose();
            }
        }
    }
    
}
