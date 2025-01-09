package telas;

import dao.PedidoDAO;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Pedido;
import model.Produto;


public class TelaPedidos extends javax.swing.JFrame {
    
    private PedidoDAO pedidoDAO;
    
    public TelaPedidos() {
        initComponents();
        pedidoDAO = new PedidoDAO();
        atualizarTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btCadastrar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setText("Pedidos Cadastrados");

        btCadastrar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btCadastrar.setText("Cadastrar");
        btCadastrar.setToolTipText("Ir para a tela de cadastro de pedidos");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btExcluir.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setToolTipText("Exclui o pedido selecionado");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btVoltar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.setToolTipText("Volta ao menu principal");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        tblPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID_Cliente", "Ids_Produtos", "Data_Hora", "Valor_Total"
            }
        ));
        jScrollPane2.setViewportView(tblPedidos);

        jScrollPane1.setViewportView(jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(173, 173, 173)
                        .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar)
                    .addComponent(btExcluir)
                    .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        Excluir();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        CadastrarPedido telaCP = new CadastrarPedido(this);
        telaCP.setVisible(true);
    }//GEN-LAST:event_btCadastrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblPedidos;
    // End of variables declaration//GEN-END:variables

    public void atualizarTabela() {
        // Recupera todos os pedidos do banco de dados
        List<Pedido> pedidos = pedidoDAO.getPedidos();  
        DefaultTableModel model = (DefaultTableModel) tblPedidos.getModel();

        model.setRowCount(0); // Limpa a tabela antes de adicionar os novos dados

        for (Pedido pedido : pedidos) {
            // Para pegar os IDs dos produtos, se necessário, percorre a lista de produtos
            StringBuilder produtosIds = new StringBuilder();
            for (Produto produto : pedido.getProdutos()) {
                if (produtosIds.length() > 0) {
                    produtosIds.append(", ");
                }
                produtosIds.append(produto.getId()); // Adiciona o ID do produto
            }

            // Atualiza a tabela com os dados do pedido
            model.addRow(new Object[]{
                pedido.getId(), // ID do pedido
                pedido.getIdCliente(), // ID do cliente
                produtosIds.toString(), // IDs dos produtos no formato "id1, id2, ..."
                pedido.getDataHora().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), // Data e hora formatada
                pedido.getValorTotal().toString() // Valor total do pedido
            });
        }
    }

    
    private void Excluir() {
        // Verifica se a tabela está vazia
        if (tblPedidos.getRowCount() == 0) {
            // Exibe uma mensagem se a tabela estiver vazia
            JOptionPane.showMessageDialog(this, "A tabela está vazia. Nenhum pedido para excluir.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;  // Retorna para não continuar a execução
        }

        int row = tblPedidos.getSelectedRow();  // Verifica se algum pedido foi selecionado
        if (row != -1) {  // Verifica se um pedido foi selecionado
            int idPedido = (int) tblPedidos.getValueAt(row, 0);  // Obtém o ID do pedido selecionado

            // Definir as opções "Sim" e "Não"
            String[] options = {"Sim", "Não"};

            // Exibe um diálogo de confirmação com as opções em português
            int resposta = JOptionPane.showOptionDialog(
                this, 
                "Você tem certeza que deseja excluir este pedido?", 
                "Confirmar Exclusão", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                options, 
                options[0]
            );

            // Se o usuário clicar em "Sim" (resposta == 0)
            if (resposta == 0) {
                // Exclui o pedido
                pedidoDAO.excluir(idPedido);

                // Atualiza a tabela
                atualizarTabela();
            } else {
                // Desmarca a seleção do pedido, se o usuário escolher "Não"
                tblPedidos.clearSelection();
            }
        } else {
            // Exibe mensagem de erro caso não tenha um pedido selecionado
            JOptionPane.showMessageDialog(null, "Selecione um Pedido!", "Erro!", JOptionPane.INFORMATION_MESSAGE);
        }
    }   
        
}
