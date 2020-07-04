package view;

import bll.FuncionarioBLL;
import javax.swing.JOptionPane;
import model.Funcionario;

public class FrmLogin extends javax.swing.JFrame {

    Funcionario funcionario = new Funcionario();
    FuncionarioBLL funcionarioBLL = new FuncionarioBLL();

    FrmMenuPrincipal menu;

    public FrmLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        lblogomarca = new javax.swing.JLabel();
        btnFazerLogin = new javax.swing.JButton();
        btnEsqueceuSenha = new javax.swing.JButton();
        lblFundoLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login dos funcionários");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(330, 30, 80, 30);

        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(330, 60, 160, 28);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Senha : ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(330, 90, 70, 30);

        txtSenha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSenhaKeyTyped(evt);
            }
        });
        getContentPane().add(txtSenha);
        txtSenha.setBounds(330, 120, 160, 28);

        lblogomarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/logotipo_empresa.png"))); // NOI18N
        getContentPane().add(lblogomarca);
        lblogomarca.setBounds(30, 10, 270, 240);

        btnFazerLogin.setBackground(new java.awt.Color(255, 255, 255));
        btnFazerLogin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnFazerLogin.setText("Fazer Login");
        btnFazerLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 255), new java.awt.Color(255, 255, 255)));
        btnFazerLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFazerLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFazerLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnFazerLogin);
        btnFazerLogin.setBounds(330, 180, 160, 35);

        btnEsqueceuSenha.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnEsqueceuSenha.setForeground(new java.awt.Color(255, 255, 255));
        btnEsqueceuSenha.setText("Esqueceu a senha?");
        btnEsqueceuSenha.setToolTipText("");
        btnEsqueceuSenha.setContentAreaFilled(false);
        btnEsqueceuSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEsqueceuSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEsqueceuSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(btnEsqueceuSenha);
        btnEsqueceuSenha.setBounds(370, 140, 150, 30);

        lblFundoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/tela_login.jpg"))); // NOI18N
        getContentPane().add(lblFundoLogin);
        lblFundoLogin.setBounds(-90, -20, 810, 410);

        setSize(new java.awt.Dimension(702, 358));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEsqueceuSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEsqueceuSenhaActionPerformed

    }//GEN-LAST:event_btnEsqueceuSenhaActionPerformed

    private void btnFazerLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFazerLoginActionPerformed
        if (txtUsuario.getText().isEmpty() || txtSenha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "TODOS OS CAMPOS SÃO OBRIGATORIOS!", "Atenção!", JOptionPane.WARNING_MESSAGE);
        } else {
            if (!funcionarioBLL.autenticarLogin(txtUsuario.getText(), txtSenha.getText())) {
                JOptionPane.showMessageDialog(rootPane, "USUÁRIO OU SENHA INVALIDA!", "Atenção!", JOptionPane.WARNING_MESSAGE);
                txtSenha.setText("");
                txtUsuario.setText("");
            } else {
                menu = new FrmMenuPrincipal();
                menu.setVisible(true);
                dispose();
            }
        }


    }//GEN-LAST:event_btnFazerLoginActionPerformed

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();

            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "DIGITE SOMENTE NUMEROS!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }

        Character ch = evt.getKeyChar();
        int comprimentoDeCampo = txtUsuario.getText().length();
        if (comprimentoDeCampo >= 11) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "   LIMITE DE 11 CARACTERES!\n(Se ja for cadastrado digite seu cpf)", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtSenhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyTyped
        Character ch = evt.getKeyChar();
        int comprimentoDeCampo = txtSenha.getText().length();
        if (comprimentoDeCampo >= 20) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, " MAXIMO DE 20 CARACTERES!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtSenhaKeyTyped

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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEsqueceuSenha;
    private javax.swing.JButton btnFazerLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblFundoLogin;
    private javax.swing.JLabel lblogomarca;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
