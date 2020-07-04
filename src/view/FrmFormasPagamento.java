package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmFormasPagamento extends javax.swing.JFrame {
    DefaultTableModel modelo = new DefaultTableModel();

    public FrmFormasPagamento() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFormasPagamento = new javax.swing.JTable();
        txtFormasDePagamento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblFundoCadastro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de formas de pagamento");
        setResizable(false);
        getContentPane().setLayout(null);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_salvar.png"))); // NOI18N
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(120, 260, 55, 40);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_excluir.png"))); // NOI18N
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnExcluir);
        btnExcluir.setBounds(190, 260, 55, 40);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_editar.png"))); // NOI18N
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnEditar);
        btnEditar.setBounds(260, 260, 55, 40);

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_limpar.png"))); // NOI18N
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnLimpar);
        btnLimpar.setBounds(330, 260, 55, 40);

        tblFormasPagamento.setModel(modelo);
        tblFormasPagamento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblFormasPagamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFormasPagamentoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblFormasPagamento);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 80, 400, 170);

        txtFormasDePagamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFormasDePagamentoKeyTyped(evt);
            }
        });
        getContentPane().add(txtFormasDePagamento);
        txtFormasDePagamento.setBounds(40, 30, 310, 28);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Forma de pagamento");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 10, 121, 20);

        lblFundoCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/tela_cadastro.jpg"))); // NOI18N
        getContentPane().add(lblFundoCadastro);
        lblFundoCadastro.setBounds(0, 0, 490, 370);

        setSize(new java.awt.Dimension(425, 340));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblFormasPagamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFormasPagamentoMouseClicked
        btnSalvar.setEnabled(false);
        int linha = tblFormasPagamento.getSelectedRow();
        Integer codigo = (Integer) tblFormasPagamento.getValueAt(linha, 0);
        //preencheCampos((int) codigo);
    }//GEN-LAST:event_tblFormasPagamentoMouseClicked

    private void txtFormasDePagamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFormasDePagamentoKeyTyped
        Character ch = evt.getKeyChar();
        int comprimentoDeCampo = txtFormaDePagamento.getText().length();
        if (comprimentoDeCampo >= 30) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "LIMITE DE 30 DIGITOS!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }

        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit().beep();

            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "DIGITE SOMENTE LETRAS!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtFormasDePagamentoKeyTyped


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
            java.util.logging.Logger.getLogger(FrmFormasPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmFormasPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmFormasPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmFormasPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmFormasPagamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFundoCadastro;
    private javax.swing.JTable tblFormasPagamento;
    private javax.swing.JTextField txtFormaDePagamento;
    private javax.swing.JTextField txtFormaDePagamento1;
    private javax.swing.JTextField txtFormaDePagamento2;
    private javax.swing.JTextField txtFormasDePagamento;
    // End of variables declaration//GEN-END:variables
}
