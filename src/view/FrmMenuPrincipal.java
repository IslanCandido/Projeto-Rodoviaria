package view;

public class FrmMenuPrincipal extends javax.swing.JFrame {

    FrmClientes telaClientes;
    FrmFuncionarios telaFuncionarios;
    FrmOnibus telaOnibus;
    FrmModelos telaModelos;
    FrmMarcas telaMarcas;
    FrmLogin telaLogin;
    FrmRotas telaRotas;
    FrmVenderPassagem telaVendas;

    public FrmMenuPrincipal() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFundoMenu = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        MenuPessoa = new javax.swing.JMenu();
        MenuItemCadastrarCliente = new javax.swing.JMenuItem();
        MenuItemCadastrarFuncionario = new javax.swing.JMenuItem();
        MenuOnibus = new javax.swing.JMenu();
        MenuItemCadastrarOnibus = new javax.swing.JMenuItem();
        MenuItemCadastrarModelo = new javax.swing.JMenuItem();
        MenuItemCadastrarMarca = new javax.swing.JMenuItem();
        MenuRota = new javax.swing.JMenu();
        MenuItemCadastrarRota = new javax.swing.JMenuItem();
        MenuVenda = new javax.swing.JMenu();
        MenuItemRegistrarVenda = new javax.swing.JMenuItem();
        MenuSair = new javax.swing.JMenu();
        MenuItemFecharSistema = new javax.swing.JMenuItem();
        MenuItemFazerLogoff = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu principal");
        setResizable(false);
        getContentPane().setLayout(null);

        lblFundoMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/tela_menu_principal.jpg"))); // NOI18N
        getContentPane().add(lblFundoMenu);
        lblFundoMenu.setBounds(-130, -110, 1250, 630);

        MenuPessoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/cadastrar_pessoa.png"))); // NOI18N
        MenuPessoa.setToolTipText("");
        MenuPessoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        MenuItemCadastrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_cliente.png"))); // NOI18N
        MenuItemCadastrarCliente.setText("Cadastrar Cliente");
        MenuItemCadastrarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuItemCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemCadastrarClienteActionPerformed(evt);
            }
        });
        MenuPessoa.add(MenuItemCadastrarCliente);

        MenuItemCadastrarFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_funcionario.png"))); // NOI18N
        MenuItemCadastrarFuncionario.setText("Cadastrar Funcionário");
        MenuItemCadastrarFuncionario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuItemCadastrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemCadastrarFuncionarioActionPerformed(evt);
            }
        });
        MenuPessoa.add(MenuItemCadastrarFuncionario);

        jMenuBar2.add(MenuPessoa);

        MenuOnibus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/cadastrar_onibus.png"))); // NOI18N
        MenuOnibus.setToolTipText("");
        MenuOnibus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        MenuItemCadastrarOnibus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_onibus.png"))); // NOI18N
        MenuItemCadastrarOnibus.setText("Cadastrar Ônibus");
        MenuItemCadastrarOnibus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuItemCadastrarOnibus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemCadastrarOnibusActionPerformed(evt);
            }
        });
        MenuOnibus.add(MenuItemCadastrarOnibus);

        MenuItemCadastrarModelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_modelo_onibus.png"))); // NOI18N
        MenuItemCadastrarModelo.setText("Cadastrar Modelo");
        MenuItemCadastrarModelo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuItemCadastrarModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemCadastrarModeloActionPerformed(evt);
            }
        });
        MenuOnibus.add(MenuItemCadastrarModelo);

        MenuItemCadastrarMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_marca_onibus.png"))); // NOI18N
        MenuItemCadastrarMarca.setText("Cadastrar Marca");
        MenuItemCadastrarMarca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuItemCadastrarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemCadastrarMarcaActionPerformed(evt);
            }
        });
        MenuOnibus.add(MenuItemCadastrarMarca);

        jMenuBar2.add(MenuOnibus);

        MenuRota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/cadastrar_rota.png"))); // NOI18N
        MenuRota.setToolTipText("");
        MenuRota.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        MenuItemCadastrarRota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_rota.png"))); // NOI18N
        MenuItemCadastrarRota.setText("Cadastrar Rota");
        MenuItemCadastrarRota.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuItemCadastrarRota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemCadastrarRotaActionPerformed(evt);
            }
        });
        MenuRota.add(MenuItemCadastrarRota);

        jMenuBar2.add(MenuRota);

        MenuVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/registrar_venda.png"))); // NOI18N
        MenuVenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        MenuItemRegistrarVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_passagem.png"))); // NOI18N
        MenuItemRegistrarVenda.setText("Registrar venda/reserva");
        MenuItemRegistrarVenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuItemRegistrarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemRegistrarVendaActionPerformed(evt);
            }
        });
        MenuVenda.add(MenuItemRegistrarVenda);

        jMenuBar2.add(MenuVenda);

        MenuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/sair.png"))); // NOI18N
        MenuSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        MenuItemFecharSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_fechar.png"))); // NOI18N
        MenuItemFecharSistema.setText("Fechar Programa");
        MenuItemFecharSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemFecharSistemaActionPerformed(evt);
            }
        });
        MenuSair.add(MenuItemFecharSistema);

        MenuItemFazerLogoff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_reiniciar.png"))); // NOI18N
        MenuItemFazerLogoff.setText("Fazer Logoff");
        MenuItemFazerLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemFazerLogoffActionPerformed(evt);
            }
        });
        MenuSair.add(MenuItemFazerLogoff);

        jMenuBar2.add(MenuSair);

        setJMenuBar(jMenuBar2);

        setSize(new java.awt.Dimension(1113, 628));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MenuItemCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemCadastrarClienteActionPerformed
        if(telaClientes == null){
            telaClientes = new FrmClientes();
            telaClientes.setVisible(true);
        } else{
            telaClientes.dispose();
            telaClientes.setVisible(true);
        }
    }//GEN-LAST:event_MenuItemCadastrarClienteActionPerformed

    private void MenuItemCadastrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemCadastrarFuncionarioActionPerformed
        if(telaFuncionarios == null){
            telaFuncionarios = new FrmFuncionarios();
            telaFuncionarios.setVisible(true);
        } else{
            telaFuncionarios.dispose();
            telaFuncionarios.setVisible(true);
        }
    }//GEN-LAST:event_MenuItemCadastrarFuncionarioActionPerformed

    private void MenuItemCadastrarOnibusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemCadastrarOnibusActionPerformed
        if(telaOnibus == null){
            telaOnibus = new FrmOnibus();
            telaOnibus.setVisible(true);
        } else{
            telaOnibus.dispose();
            telaOnibus.setVisible(true);
        }
    }//GEN-LAST:event_MenuItemCadastrarOnibusActionPerformed

    private void MenuItemCadastrarModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemCadastrarModeloActionPerformed
        if(telaModelos == null){
            telaModelos = new FrmModelos();
            telaModelos.setVisible(true);
        } else{
            telaModelos.dispose();
            telaModelos.setVisible(true);
        }
    }//GEN-LAST:event_MenuItemCadastrarModeloActionPerformed

    private void MenuItemCadastrarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemCadastrarMarcaActionPerformed
        if(telaMarcas == null){
            telaMarcas = new FrmMarcas();
            telaMarcas.setVisible(true);
        } else{
            telaMarcas.dispose();
            telaMarcas.setVisible(true);
        }
    }//GEN-LAST:event_MenuItemCadastrarMarcaActionPerformed

    private void MenuItemFecharSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemFecharSistemaActionPerformed
        dispose();
    }//GEN-LAST:event_MenuItemFecharSistemaActionPerformed

    private void MenuItemFazerLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemFazerLogoffActionPerformed
        telaLogin = new FrmLogin();
        telaLogin.setVisible(true);
        dispose();
    }//GEN-LAST:event_MenuItemFazerLogoffActionPerformed

    private void MenuItemCadastrarRotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemCadastrarRotaActionPerformed
        if(telaRotas == null){
            telaRotas = new FrmRotas();
            telaRotas.setVisible(true);
        } else{
            telaRotas.dispose();
            telaRotas.setVisible(true);
        }
    }//GEN-LAST:event_MenuItemCadastrarRotaActionPerformed

    private void MenuItemRegistrarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemRegistrarVendaActionPerformed
        if(telaVendas == null){
            telaVendas = new FrmVenderPassagem();
            telaVendas.setVisible(true);
        } else{
            telaVendas.dispose();
            telaVendas.setVisible(true);
        }
    }//GEN-LAST:event_MenuItemRegistrarVendaActionPerformed


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
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuItemCadastrarCliente;
    private javax.swing.JMenuItem MenuItemCadastrarFuncionario;
    private javax.swing.JMenuItem MenuItemCadastrarMarca;
    private javax.swing.JMenuItem MenuItemCadastrarModelo;
    private javax.swing.JMenuItem MenuItemCadastrarOnibus;
    private javax.swing.JMenuItem MenuItemCadastrarRota;
    private javax.swing.JMenuItem MenuItemFazerLogoff;
    private javax.swing.JMenuItem MenuItemFecharSistema;
    private javax.swing.JMenuItem MenuItemRegistrarVenda;
    private javax.swing.JMenu MenuOnibus;
    private javax.swing.JMenu MenuPessoa;
    private javax.swing.JMenu MenuRota;
    private javax.swing.JMenu MenuSair;
    private javax.swing.JMenu MenuVenda;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JLabel lblFundoMenu;
    // End of variables declaration//GEN-END:variables
}
