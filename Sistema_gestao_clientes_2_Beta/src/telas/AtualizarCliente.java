package telas;

import dao.ClienteDAO;
import javax.swing.JOptionPane;
import model.Cliente;
import model.ListaCliente;

public class AtualizarCliente extends javax.swing.JFrame {
    
    private final TelaClientes telaClientes;
    private Cliente cliente;
    private int posicao;
    
    public AtualizarCliente(TelaClientes telaClientes, Cliente cliente) {
        this.cliente = cliente;
        this.telaClientes = telaClientes;
        
        initComponents();
        
        txtNome.setText(cliente.getNome());
        txtTelefone.setText(cliente.getTelefone());
        txtEndereco.setText(cliente.getEndereco());
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        btAtualizar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Dados Cadastrados");

        jLabel2.setText("Nome:");

        jLabel3.setText("Telefone:");

        jLabel4.setText("Endereço:");

        txtEndereco.setToolTipText("Insira seu Endereço");

        txtNome.setToolTipText("Insira seu Nome");

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.setToolTipText("Insira seu Telefone");

        btAtualizar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btAtualizar.setText("Atualizar");
        btAtualizar.setToolTipText("atualiza o cadastro com os novos dados");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        btVoltar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.setToolTipText("Volta a tela inicial");
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
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEndereco)
                            .addComponent(txtNome)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAtualizar)
                    .addComponent(btVoltar))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        
        if (!camposVazios()){
            atualizarCadastro();
        }
    }//GEN-LAST:event_btAtualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables

    private boolean camposVazios(){
        
        boolean empty = true;
        
        if (txtNome.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "ATENÇÃO! O Campo Nome não pode estar vazio.");
            txtNome.requestFocus();
        }
        else if (txtEndereco.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "ATENÇÃO! O Campo endereço não pode estar vazio.");
            txtEndereco.requestFocus();
        }
        else {
            empty = false;
        }
        
        return empty;
    }
    
    private void atualizarCadastro() {
        
        String strNome = txtNome.getText().toUpperCase();
        String strTelefone = txtTelefone.getText();
        String strEndereco = txtEndereco.getText();

        boolean verifica = strNome.matches("[\\p{L} ]+");
        boolean verifica2 = strTelefone.matches("\\(\\d{2}\\) \\d{5}-\\d{4}");

        if (!verifica) {
            JOptionPane.showMessageDialog(null, "O campo nome só pode conter letras.");
            txtNome.setText("");
            txtNome.requestFocus();
        } else if (!verifica2) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Telefone com 11 dígitos.");
            txtTelefone.setText("");
            txtTelefone.requestFocus();
        } else {
            // Atualizar o objeto cliente
            cliente.setNome(strNome);
            cliente.setTelefone(strTelefone);
            cliente.setEndereco(strEndereco);

            // Atualizar no banco de dados
            ClienteDAO clienteDAO = new ClienteDAO();
            clienteDAO.editar(cliente);

            // Atualizar a tabela na tela principal
            telaClientes.preencherTabela();
            
            dispose();
        }
    }


}
