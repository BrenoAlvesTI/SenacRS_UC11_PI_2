
package telas;

import dao.ClienteDAO;
import javax.swing.JOptionPane;
import model.Cliente;
import model.ListaCliente;

public class CadastrarCliente extends javax.swing.JFrame {

    private final TelaClientes telaClientes;
    
    public CadastrarCliente(TelaClientes telaClientes) {
        this.telaClientes = telaClientes;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        btVoltar = new javax.swing.JButton();
        btCadastrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome:");

        jLabel2.setText("Telefone:");

        jLabel3.setText("Endereço:");

        txtEndereco.setToolTipText("Insira seu Endereço");

        txtNome.setToolTipText("Insira seu Nome");

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.setToolTipText("Insira seu Telefone");

        btVoltar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.setToolTipText("Volta para a tela Inicial");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btCadastrar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btCadastrar.setText("Cadastrar");
        btCadastrar.setToolTipText("Cadastra o Cliente");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel4.setText("Cadastrar Cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNome)
                            .addComponent(txtEndereco)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar)
                    .addComponent(btVoltar))
                .addGap(36, 36, 36))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        
        if (!camposVazios()){
            cadastrarCliente(getCliente());
        }
    }//GEN-LAST:event_btCadastrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
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
    
    private Cliente getCliente() {

        String nome = txtNome.getText().toUpperCase();
        String telefone = txtTelefone.getText();
        String endereco = txtEndereco.getText();

        Cliente cliente = new Cliente();

        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setEndereco(endereco);

        return cliente;
    }
    
    private void cadastrarCliente(Cliente cliente) {
        // Capturar os valores dos campos
        String strNome = txtNome.getText().toUpperCase();
        String strTelefone = txtTelefone.getText();
        String strEndereco = txtEndereco.getText();

        // Validações
        boolean verificaNome = strNome.matches("[\\p{L} ]+"); // Apenas letras e espaços
        boolean verificaTelefone = strTelefone.matches("\\(\\d{2}\\) \\d{5}-\\d{4}"); // Formato (XX) XXXXX-XXXX

        if (!verificaNome) {
            JOptionPane.showMessageDialog(null, "O campo nome só pode conter letras.", "Erro", JOptionPane.ERROR_MESSAGE);
            txtNome.setText("");
            txtNome.requestFocus();
        } else if (!verificaTelefone) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Telefone no formato correto: (XX) XXXXX-XXXX", "Erro", JOptionPane.ERROR_MESSAGE);
            txtTelefone.setText("");
            txtTelefone.requestFocus();
        } else {
            // Criar o objeto cliente com os dados capturados
            cliente.setNome(strNome);
            cliente.setTelefone(strTelefone);
            cliente.setEndereco(strEndereco);

            // Inserir o cliente no banco de dados
            ClienteDAO clienteDAO = new ClienteDAO();
            boolean sucesso = clienteDAO.inserir(cliente);

            if (sucesso) {                
                // Atualizar a tabela de clientes visualmente
                telaClientes.preencherTabela();

                // Limpar os campos
                txtNome.setText("");
                txtTelefone.setText("");
                txtEndereco.setText("");
                txtNome.requestFocus();
            }
        }
    }

    
}
