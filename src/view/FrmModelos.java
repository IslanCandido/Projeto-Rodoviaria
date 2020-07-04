package view;

import bll.ModeloBLL;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Marca;
import model.Modelo;

public class FrmModelos extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    ModeloBLL modeloBLL = new ModeloBLL();
    Modelo modelo = new Modelo();
    
    Vector<Marca> vetorMarcas;
    
    public FrmModelos() {
        criarTabela();
        consultar();
        initComponents();
        preencherCbxs();
    }
    
    private void criarTabela() {
        tblModelos = new JTable(model);
        model.addColumn("Código");
        model.addColumn("Modelo");
        model.addColumn("Marca");
    }

    private void consultar() {
        model.setNumRows(0);
        List<Modelo> lista = modeloBLL.consultar();

        if (lista.size() > 0) {
            for (int i = 0; i < lista.size(); i++) {
                model.addRow(new Object[]{
                    lista.get(i).getCodigo(),
                    lista.get(i).getDescricao(), 
                    lista.get(i).getIdMarca().getDescricao()
                });
            }
        } else {
            model.setNumRows(0);
        }
    }
    
    private void preencheCampos(int id) {
        modelo = modeloBLL.consultaPorId(id);
        txtModelo.setText(modelo.getDescricao());
        cbxMarcas.setSelectedItem(modelo.getIdMarca().toString());
    }

    private void limparCampos() {
        txtModelo.setText("");
        cbxMarcas.setSelectedIndex(0);
        btnSalvar.setEnabled(true);
    }
    
    private void preencherCbxs() {
        vetorMarcas = modeloBLL.listarMarcas();
        cbxMarcas.setModel(new DefaultComboBoxModel(vetorMarcas));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblModelos = new javax.swing.JTable();
        txtModelo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxMarcas = new javax.swing.JComboBox<>();
        btnAdicionarMarca = new javax.swing.JButton();
        lblFundoCadastro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de modelos dos ônibus");
        setResizable(false);
        getContentPane().setLayout(null);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_salvar.png"))); // NOI18N
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(280, 260, 55, 40);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_excluir.png"))); // NOI18N
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir);
        btnExcluir.setBounds(350, 260, 55, 40);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_editar.png"))); // NOI18N
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar);
        btnEditar.setBounds(420, 260, 55, 40);

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_limpar.png"))); // NOI18N
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar);
        btnLimpar.setBounds(490, 260, 55, 40);

        tblModelos.setModel(model);
        tblModelos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblModelos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblModelosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblModelos);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 80, 610, 170);

        txtModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtModeloKeyTyped(evt);
            }
        });
        getContentPane().add(txtModelo);
        txtModelo.setBounds(20, 30, 300, 28);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Modelo do ônibus");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 10, 98, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Marca");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(350, 10, 50, 20);

        getContentPane().add(cbxMarcas);
        cbxMarcas.setBounds(350, 30, 220, 28);

        btnAdicionarMarca.setText("+");
        btnAdicionarMarca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdicionarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarMarcaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionarMarca);
        btnAdicionarMarca.setBounds(570, 30, 41, 28);

        lblFundoCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/tela_cadastro.jpg"))); // NOI18N
        getContentPane().add(lblFundoCadastro);
        lblFundoCadastro.setBounds(0, 0, 650, 330);

        setSize(new java.awt.Dimension(635, 340));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblModelosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblModelosMouseClicked
        btnSalvar.setEnabled(false);
        int linha = tblModelos.getSelectedRow();
        Integer codigo = (Integer) tblModelos.getValueAt(linha, 0);
        preencheCampos((int) codigo);
    }//GEN-LAST:event_tblModelosMouseClicked

    private void txtModeloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModeloKeyTyped
        Character ch = evt.getKeyChar();
        int comprimentoDeCampo = txtModelo.getText().length();
        if (comprimentoDeCampo >= 40) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "LIMITE DE 40 DIGITOS!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_txtModeloKeyTyped

    FrmMarcas telaMarcas;
    
    private void btnAdicionarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarMarcaActionPerformed
        if (telaMarcas == null) {
            telaMarcas = new FrmMarcas();
            telaMarcas.setVisible(true);
        } else {
            telaMarcas.dispose();
            telaMarcas.setVisible(true);
        }
    }//GEN-LAST:event_btnAdicionarMarcaActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            modelo.setDescricao(txtModelo.getText().toUpperCase());
            modelo.setIdMarca(vetorMarcas.get(cbxMarcas.getSelectedIndex()));

            if (txtModelo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "CAMPO EM BRANCO!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else {
                if (!modeloBLL.verificarModelosIguais(txtModelo.getText())) {
                    if (modeloBLL.salvar(modelo)) {
                        JOptionPane.showMessageDialog(rootPane, "Salvo com sucesso!", "Mensagem!!!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Erro ao salvar!", "Mensagem!!!", JOptionPane.WARNING_MESSAGE);
                    }
                    consultar();
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "MODELO JÁ FOI CADASTRADO!", "Cuidado!", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "ERRO AO SALVAR!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            if (txtModelo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "CAMPO EM BRANCO!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else {
                if (modeloBLL.remover(modeloBLL.consultaPorId(modelo.getCodigo()))) {
                    JOptionPane.showMessageDialog(rootPane, "Removido com sucesso!", "Mensagem!!!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao remover!", "Mensagem!!!", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "ERRO AO REMOVER!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
        consultar();
        limparCampos();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            modelo.setDescricao(txtModelo.getText().toUpperCase());
            modelo.setIdMarca(vetorMarcas.get(cbxMarcas.getSelectedIndex()));

            if (txtModelo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "CAMPO EM BRANCO!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else {
                if (modeloBLL.editar(modelo)) {
                    JOptionPane.showMessageDialog(rootPane, "Editado com sucesso!", "Mensagem!!!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao editar!", "Mensagem!!!", JOptionPane.WARNING_MESSAGE);
                }
                consultar();
                limparCampos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "ERRO AO EDITAR!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
        preencherCbxs();
    }//GEN-LAST:event_btnLimparActionPerformed

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
            java.util.logging.Logger.getLogger(FrmModelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmModelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmModelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmModelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmModelos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarMarca;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxMarcas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFundoCadastro;
    private javax.swing.JTable tblModelos;
    private javax.swing.JTextField txtModelo;
    // End of variables declaration//GEN-END:variables
}
