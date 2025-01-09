
package telas;

import dao.ClienteDAO;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import model.Cliente;

public class TelaClientes extends javax.swing.JFrame {
    
    public TelaClientes() {
        initComponents();
        preencherTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btCadastrar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setText("Clientes Cadastrados");

        btCadastrar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btCadastrar.setText("Cadastrar");
        btCadastrar.setToolTipText("Ir a tela de cadastro de cliente");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btExcluir.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setToolTipText("Exclui o cliente selecionado");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btAtualizar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btAtualizar.setText("Atualizar");
        btAtualizar.setToolTipText("Atualia o cliente selecionado");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        btVoltar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.setToolTipText("Volta ao menu principal");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        jLabel2.setText("Pesquisar por Nome:");

        txtNome.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNomeCaretUpdate(evt);
            }
        });

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Telefone", "Endereço"
            }
        ));
        jScrollPane1.setViewportView(tblClientes);

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(468, 468, 468))
                    .addComponent(jScrollPane2))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        CadastrarCliente telaCadastrar = new CadastrarCliente(this);
        telaCadastrar.setVisible(true);
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        excluirCliente();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        AtualizarCliente();
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void txtNomeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNomeCaretUpdate
        preencherTabela();
    }//GEN-LAST:event_txtNomeCaretUpdate

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
   
    public int getPosicaoCliente(){
        
        int posCliente = tblClientes.getSelectedRow();
        
        if (posCliente == -1){
            JOptionPane.showMessageDialog(null, "Selecione um cliente!", "Erro!", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return posCliente;
    }
    
    private void excluirCliente() {
        
        ClienteDAO clienteDAO = new ClienteDAO();
        List<Cliente> listaTotal = clienteDAO.getClientesTotal("");
        
        if (listaTotal.isEmpty()){
            JOptionPane.showMessageDialog(null, "A lista está vazia!");
        }
        else{
            int posCliente = getPosicaoCliente(); // Obter a posição selecionada na tabela

        if (posCliente >= 0) {
            String[] options = {"Sim", "Não"};

            int deletar = JOptionPane.showOptionDialog(
                rootPane,
                "Tem certeza que deseja excluir?",
                "Exclusão de cliente",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
            );

            if (deletar == 0) {
                // Obter o ID do cliente diretamente da tabela
                int idCliente = (int) tblClientes.getValueAt(posCliente, 0);

                // Chamar o método do DAO para excluir do banco
                clienteDAO.excluir(idCliente);

                // Atualizar a tabela
                preencherTabela();               
            } 
            else {
                tblClientes.clearSelection();
            }
        }
        }
                      
    }

    
    private void AtualizarCliente() {
        int posCliente = getPosicaoCliente();

        if (posCliente >= 0) {
            int idCliente = (int) tblClientes.getValueAt(posCliente, 0); // Obter ID da tabela
            String nome = (String) tblClientes.getValueAt(posCliente, 1); // Nome do cliente
            String telefone = (String) tblClientes.getValueAt(posCliente, 2); // Telefone
            String endereco = (String) tblClientes.getValueAt(posCliente, 3); // Endereço

            // Criar o objeto cliente com os dados atuais
            Cliente clienteSelecionado = new Cliente();
            clienteSelecionado.setId(idCliente);
            clienteSelecionado.setNome(nome);
            clienteSelecionado.setTelefone(telefone);
            clienteSelecionado.setEndereco(endereco);

            // Abrir tela de atualização
            AtualizarCliente telaAtualizar = new AtualizarCliente(this, clienteSelecionado);
            telaAtualizar.setVisible(true);
        }
    }

    
    public void preencherTabela() {
        ClienteDAO clienteDAO = new ClienteDAO();
        
        String nome = txtNome.getText();
        List<Cliente> listaClientes = clienteDAO.getClientesTotal(nome);

        DefaultTableModel tabelaClientes = (DefaultTableModel) tblClientes.getModel();
        //Limpar a tabela para preencher com os novos dados
        tabelaClientes.setNumRows(0);

        tblClientes.setRowSorter(new TableRowSorter(tabelaClientes));

        for (Cliente c : listaClientes) { //em cada volta do laço for, o mesmo adiciona uma dado(empresa) dentro do objeto c
            Object[] obj = new Object[] { 
                c.getId(),            
                c.getNome(),        
                c.getTelefone(),   
                c.getEndereco()
            };
            tabelaClientes.addRow(obj);
        }    
    }    
    
}
