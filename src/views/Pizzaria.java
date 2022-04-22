/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.util.ArrayList;
import java.util.List;
import models.Cliente;

/**
 *
 * @author user
 */
public class Pizzaria extends javax.swing.JFrame {

    private List<Cliente> clientes = new ArrayList<>();
    private int clientesLinhaSelecionada = -1;
    private ClienteTable clientesTableModel = new ClienteTable();

    /**
     * Creates new form Pizzaria
     */
    public Pizzaria() {
        initComponents();
    }

    private void limparClientesForm() {
        clienteNomeField.setText("");
        clienteSobreNomeField.setText("");
        clienteTelefoneField.setText("");
        clientesLinhaSelecionada = -1;
        clientesTableModel.atualizarTabela(clientes);
    }

    private void preencherClientesForm(Cliente cliente) {
        clienteNomeField.setText(cliente.getNome());
        clienteSobreNomeField.setText(cliente.getSobrenome());
        clienteTelefoneField.setText(cliente.getTelefone());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        clienteNomeField = new javax.swing.JTextField();
        clienteSobreNomeField = new javax.swing.JTextField();
        clienteTelefoneField = new javax.swing.JTextField();
        clienteCadastrarButton = new javax.swing.JButton();
        clienteAtualizarButton = new javax.swing.JButton();
        clienteExcluirButton = new javax.swing.JButton();
        clientePesquisarButton = new javax.swing.JButton();
        clientesLimparButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        clientesTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome");

        jLabel2.setText("Sobrenome");

        jLabel3.setText("Telefone");

        clienteCadastrarButton.setText("cadastrar");
        clienteCadastrarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                clienteCadastrarButtonMouseReleased(evt);
            }
        });
        clienteCadastrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteCadastrarButtonActionPerformed(evt);
            }
        });

        clienteAtualizarButton.setText("atualizar");
        clienteAtualizarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                clienteAtualizarButtonMouseReleased(evt);
            }
        });
        clienteAtualizarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteAtualizarButtonActionPerformed(evt);
            }
        });

        clienteExcluirButton.setText("excluir");
        clienteExcluirButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                clienteExcluirButtonMouseReleased(evt);
            }
        });
        clienteExcluirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteExcluirButtonActionPerformed(evt);
            }
        });

        clientePesquisarButton.setText("pesquisar");
        clientePesquisarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientePesquisarButtonActionPerformed(evt);
            }
        });

        clientesLimparButton.setText("limpar");
        clientesLimparButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                clientesLimparButtonMouseReleased(evt);
            }
        });

        clientesTable.setModel(clientesTableModel);
        clientesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                clientesTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(clientesTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(clientesLimparButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clientePesquisarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clienteExcluirButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clienteAtualizarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clienteCadastrarButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clienteNomeField)
                            .addComponent(clienteSobreNomeField)
                            .addComponent(clienteTelefoneField))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(clienteNomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(clienteSobreNomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(clienteTelefoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clienteCadastrarButton)
                    .addComponent(clienteAtualizarButton)
                    .addComponent(clienteExcluirButton)
                    .addComponent(clientePesquisarButton)
                    .addComponent(clientesLimparButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Clientes", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 832, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Pedidos", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 832, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Sabores", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 832, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab4", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clienteCadastrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteCadastrarButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clienteCadastrarButtonActionPerformed

    private void clienteAtualizarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteAtualizarButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clienteAtualizarButtonActionPerformed

    private void clienteExcluirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteExcluirButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clienteExcluirButtonActionPerformed

    private void clientePesquisarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientePesquisarButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientePesquisarButtonActionPerformed

    private void clienteCadastrarButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clienteCadastrarButtonMouseReleased
        if (clientesLinhaSelecionada != -1) {
            return;
        }
        Cliente cliente = new Cliente();
        cliente.setNome(clienteNomeField.getText());
        cliente.setSobrenome(clienteSobreNomeField.getText());
        cliente.setTelefone(clienteTelefoneField.getText());
        clientes.add(cliente);
        clientesTableModel.adicionar(cliente);

        limparClientesForm();
    }//GEN-LAST:event_clienteCadastrarButtonMouseReleased

    private void clienteAtualizarButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clienteAtualizarButtonMouseReleased
        if (clientesLinhaSelecionada == -1) {
            return;
        }
        Cliente cliente = this.clientes.get(clientesLinhaSelecionada);

        cliente.setNome(clienteNomeField.getText());
        cliente.setSobrenome(clienteSobreNomeField.getText());
        cliente.setTelefone(clienteTelefoneField.getText());

        clientesTableModel.atualizarTabela(this.clientes);

        limparClientesForm();
    }//GEN-LAST:event_clienteAtualizarButtonMouseReleased

    private void clientesTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientesTableMouseReleased
        // preenche form com dados do cliente selecionado
        clientesLinhaSelecionada = clientesTable.getSelectedRow();
        if (clientesLinhaSelecionada == -1) {
            return;
        }
        Cliente cliente = this.clientes.get(clientesLinhaSelecionada);

        preencherClientesForm(cliente);
    }//GEN-LAST:event_clientesTableMouseReleased

    private void clientesLimparButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientesLimparButtonMouseReleased
        limparClientesForm();
    }//GEN-LAST:event_clientesLimparButtonMouseReleased

    private void clienteExcluirButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clienteExcluirButtonMouseReleased
        if (clientesLinhaSelecionada == -1) {
            return;
        }
        Cliente cliente = this.clientes.get(clientesLinhaSelecionada);

        this.clientes.remove(cliente);

        clientesTableModel.remover(cliente);
        clientesTableModel.atualizarTabela(this.clientes);

        limparClientesForm();
    }//GEN-LAST:event_clienteExcluirButtonMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pizzaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pizzaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pizzaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pizzaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pizzaria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clienteAtualizarButton;
    private javax.swing.JButton clienteCadastrarButton;
    private javax.swing.JButton clienteExcluirButton;
    private javax.swing.JTextField clienteNomeField;
    private javax.swing.JButton clientePesquisarButton;
    private javax.swing.JTextField clienteSobreNomeField;
    private javax.swing.JTextField clienteTelefoneField;
    private javax.swing.JButton clientesLimparButton;
    private javax.swing.JTable clientesTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}