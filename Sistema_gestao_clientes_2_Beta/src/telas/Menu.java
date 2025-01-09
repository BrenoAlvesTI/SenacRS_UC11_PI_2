package telas;

public class Menu extends javax.swing.JFrame {      
    
    public Menu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btClientes = new javax.swing.JButton();
        btProdutos = new javax.swing.JButton();
        btPedidos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu Principal");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setText("Mercado Virtual");

        btClientes.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btClientes.setText("Clientes");
        btClientes.setToolTipText("Cadastra Clientes");
        btClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClientesActionPerformed(evt);
            }
        });

        btProdutos.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btProdutos.setText("Produtos");
        btProdutos.setToolTipText("Cadastra Produtos");
        btProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProdutosActionPerformed(evt);
            }
        });

        btPedidos.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btPedidos.setText("Pedidos");
        btPedidos.setToolTipText("Cadastra Pedidos");
        btPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPedidosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(238, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(btClientes)
                .addGap(29, 29, 29)
                .addComponent(btProdutos)
                .addGap(30, 30, 30)
                .addComponent(btPedidos)
                .addGap(102, 102, 102))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
    
    private void btClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClientesActionPerformed
        TelaClientes telaTC = new TelaClientes();
        telaTC.setVisible(true);
    }//GEN-LAST:event_btClientesActionPerformed

    private void btProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProdutosActionPerformed
        TelaProdutos telaTP = new TelaProdutos();
        telaTP.setVisible(true);
    }//GEN-LAST:event_btProdutosActionPerformed

    private void btPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPedidosActionPerformed
        TelaPedidos telaTPe = new TelaPedidos();
        telaTPe.setVisible(true);
    }//GEN-LAST:event_btPedidosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClientes;
    private javax.swing.JButton btPedidos;
    private javax.swing.JButton btProdutos;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
