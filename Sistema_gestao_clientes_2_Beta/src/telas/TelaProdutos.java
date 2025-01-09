package telas;

import dao.ClienteDAO;
import dao.ProdutoDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Produto;
import model.ListaProduto;


public class TelaProdutos extends javax.swing.JFrame {
    
    private String tipoUsuario;

    public TelaProdutos() {
        initComponents();
        preencherTabela();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btCadastrar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setText("Produtos Cadastrados");

        btCadastrar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btCadastrar.setText("Cadastrar");
        btCadastrar.setToolTipText("Ir a tela de cadastro de produtos");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btExcluir.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setToolTipText("Exclui o cliente selecionado");
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

        btAtualizar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btAtualizar.setText("Atualizar");
        btAtualizar.setToolTipText("Atualiza a quantidade do produto selecionado");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        jLabel2.setText("Pesquisar por Nome:");

        txtNome.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNomeCaretUpdate(evt);
            }
        });

        String[] colunas = {"Id", "Nome", "Valor Custo R$", "Valor Venda R$", "Quantidade"};
        DefaultTableModel tabelaModelo = new DefaultTableModel(colunas, 0);

        List<Produto> listaCompleta = ListaProduto.listarProdutos();

        for (int i=0; i < listaCompleta.size(); i++){

            Produto produtoAtual = listaCompleta.get(i);

            Object[] linha = {
                String.valueOf(produtoAtual.getId()),
                produtoAtual.getNome(),
                produtoAtual.getValorCusto(),
                produtoAtual.getValorVenda(),
                produtoAtual.getQuantidade()
            };

            tabelaModelo.addRow(linha);
        }
        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "ValorCusto", "ValorVenda", "Quantidade"
            }
        ));
        jScrollPane1.setViewportView(tblProdutos);

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btCadastrar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btVoltar)
                        .addComponent(btAtualizar)
                        .addComponent(btExcluir)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        CadastrarProduto telaCP = new CadastrarProduto(this);
        telaCP.setVisible(true);
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        excluirProduto();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        AtualizarQuantidade();
    }//GEN-LAST:event_btAtualizarActionPerformed

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
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
  
    public int getPosicaoProduto() {
        // Verifica se a tabela está vazia
        if (tblProdutos.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "A tabela está vazia!", "Erro!", JOptionPane.INFORMATION_MESSAGE);
            return -1;  // Retorna -1, indicando que não há produtos para selecionar
        }

        // Verifica se algum produto foi selecionado
        int posProduto = tblProdutos.getSelectedRow();

        if (posProduto == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um produto!", "Erro!", JOptionPane.INFORMATION_MESSAGE);
        }

        return posProduto;
    }
    
    private void excluirProduto() {
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> listaTotal = produtoDAO.getProdutosTotal("");
        
        if (listaTotal.isEmpty()){
            JOptionPane.showMessageDialog(null, "A lista está vazia!", "Erro!", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            int posProduto = getPosicaoProduto(); // Obter a posição selecionada na tabela

        if (posProduto >= 0) {
            String[] options = {"Sim", "Não"};

            int deletar = JOptionPane.showOptionDialog(
                rootPane,
                "Tem certeza que deseja excluir?",
                "Exclusão de Produto",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
            );

            if (deletar == 0) {
                // Obter o ID do cliente diretamente da tabela
                int idProduto = (int) tblProdutos.getValueAt(posProduto, 0);

                // Chamar o método do DAO para excluir do banco
                produtoDAO.excluir(idProduto);

                // Atualizar a tabela
                preencherTabela();
            } 
            else {
                tblProdutos.clearSelection();
            }
        }
        }
                      
    }    
    
    private void AtualizarQuantidade() {
        int posProduto = getPosicaoProduto();

        if (posProduto >= 0) {
            
            int idProduto = (int) tblProdutos.getValueAt(posProduto, 0);
            int quantidade = (int) tblProdutos.getValueAt(posProduto, 4);

            Produto produtoSelecionado = new Produto();
            produtoSelecionado.setId(idProduto);
            produtoSelecionado.setQuantidade(quantidade);

            AtualizarProduto telaAtualizar = new AtualizarProduto(this, produtoSelecionado);
            telaAtualizar.setVisible(true);
        }
    }
    
    public void preencherTabela() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        String nome = txtNome.getText();
        List<Produto> listaProdutos = produtoDAO.getProdutosTotal(nome);

        DefaultTableModel tabelaProdutos = (DefaultTableModel) tblProdutos.getModel();
        //Limpar a tabela para preencher com os novos dados
        tabelaProdutos.setNumRows(0);

        tblProdutos.setRowSorter(new TableRowSorter(tabelaProdutos));

        for (Produto p : listaProdutos) { //em cada volta do laço for, o mesmo adiciona uma dado(empresa) dentro do objeto c
            Object[] obj = new Object[] { 
                p.getId(),            
                p.getNome(),        
                p.getValorCusto(),   
                p.getValorVenda(),
                p.getQuantidade()
            };
            tabelaProdutos.addRow(obj);
        }    
    }

}
