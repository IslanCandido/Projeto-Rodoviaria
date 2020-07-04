package view;

import bll.OnibusBLL;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Modelo;
import model.Onibus;

public class FrmOnibus extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    OnibusBLL onibusBLL = new OnibusBLL();
    Onibus onibus = new Onibus();

    Vector<Modelo> vetorModelos;

    public FrmOnibus() {
        criarTabela();
        consultar(onibusBLL.consultar());
        initComponents();
        preencherCbxs();
    }

    private void criarTabela() {
        tblOnibus = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Placa");
        modelo.addColumn("Renavam");
        modelo.addColumn("Modelo");
        modelo.addColumn("Poltronas");
        modelo.addColumn("Ano fabricação");
        modelo.addColumn("Situação");
    }

    private void consultar(List tipo) {
        modelo.setNumRows(0);
        List<Onibus> lista = tipo;

        if (lista.size() > 0) {
            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[]{
                    lista.get(i).getCodigo(),
                    lista.get(i).getPlaca(),
                    lista.get(i).getRenavam(),
                    lista.get(i).getIdModelo().getDescricao(),
                    lista.get(i).getNumeroDePoltronas(),
                    lista.get(i).getAnoDeFabricação(),
                    lista.get(i).getSituacao()
                });
            }
        } else {
            modelo.setNumRows(0);
        }
    }

    private void preencheCampos(int id) {
        onibus = onibusBLL.consultaPorId(id);
        txtPlaca.setText(onibus.getPlaca());
        txtRenavam.setText(onibus.getRenavam());
        txtNumeroPoltronas.setText(String.valueOf(onibus.getNumeroDePoltronas()));
        txtAnoFabricacao.setText(String.valueOf(onibus.getAnoDeFabricação()));
        cbxSituacao.setSelectedItem(onibus.getSituacao());
        cbxModelos.setSelectedItem(onibus.getIdModelo());
    }

    private void limparCampos() {
        txtPlaca.setValue("");
        txtRenavam.setValue("");
        txtNumeroPoltronas.setText("");
        txtAnoFabricacao.setValue("");
        cbxSituacao.setSelectedIndex(0);
        cbxModelos.setSelectedIndex(0);

        consultar(onibusBLL.consultar());
        btnSalvar.setEnabled(true);
    }

    private void preencherCbxs() {
        vetorModelos = onibusBLL.listarModelos();
        cbxModelos.setModel(new DefaultComboBoxModel(vetorModelos));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOnibus = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRenavam = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNumeroPoltronas = new javax.swing.JTextField();
        txtAnoFabricacao = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxModelos = new javax.swing.JComboBox<>();
        cbxSituacao = new javax.swing.JComboBox<>();
        btnAdicionarModelo = new javax.swing.JButton();
        btnDisponiveis = new javax.swing.JButton();
        btnIndisponiveis = new javax.swing.JButton();
        lblFundoCadastro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de ônibus");
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
        btnSalvar.setBounds(380, 310, 55, 40);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_excluir.png"))); // NOI18N
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir);
        btnExcluir.setBounds(450, 310, 55, 40);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_editar.png"))); // NOI18N
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar);
        btnEditar.setBounds(520, 310, 55, 40);

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_limpar.png"))); // NOI18N
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar);
        btnLimpar.setBounds(590, 310, 55, 40);

        tblOnibus.setModel(modelo);
        tblOnibus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblOnibus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOnibusMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblOnibus);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 120, 690, 180);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Placa");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 10, 40, 20);

        try {
            txtPlaca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("???-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtPlaca);
        txtPlaca.setBounds(30, 30, 170, 28);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Renavam");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 60, 70, 20);

        try {
            txtRenavam.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtRenavam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRenavamKeyTyped(evt);
            }
        });
        getContentPane().add(txtRenavam);
        txtRenavam.setBounds(30, 80, 170, 28);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Modelo");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(380, 10, 60, 20);

        txtNumeroPoltronas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroPoltronasActionPerformed(evt);
            }
        });
        txtNumeroPoltronas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroPoltronasKeyTyped(evt);
            }
        });
        getContentPane().add(txtNumeroPoltronas);
        txtNumeroPoltronas.setBounds(230, 80, 120, 28);

        try {
            txtAnoFabricacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtAnoFabricacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnoFabricacaoKeyTyped(evt);
            }
        });
        getContentPane().add(txtAnoFabricacao);
        txtAnoFabricacao.setBounds(230, 30, 120, 28);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Ano de Fabricação");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(230, 10, 120, 20);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nº Poltronas");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(230, 60, 80, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Situação");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(380, 60, 60, 20);

        getContentPane().add(cbxModelos);
        cbxModelos.setBounds(380, 30, 260, 28);

        cbxSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Disponivel", "Indisponivel" }));
        getContentPane().add(cbxSituacao);
        cbxSituacao.setBounds(380, 80, 300, 28);

        btnAdicionarModelo.setText("+");
        btnAdicionarModelo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdicionarModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarModeloActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionarModelo);
        btnAdicionarModelo.setBounds(640, 30, 41, 28);

        btnDisponiveis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_disponivel.png"))); // NOI18N
        btnDisponiveis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDisponiveis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisponiveisActionPerformed(evt);
            }
        });
        getContentPane().add(btnDisponiveis);
        btnDisponiveis.setBounds(30, 310, 50, 40);

        btnIndisponiveis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_indisponivel.png"))); // NOI18N
        btnIndisponiveis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIndisponiveis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIndisponiveisActionPerformed(evt);
            }
        });
        getContentPane().add(btnIndisponiveis);
        btnIndisponiveis.setBounds(90, 310, 50, 40);

        lblFundoCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/tela_cadastro.jpg"))); // NOI18N
        getContentPane().add(lblFundoCadastro);
        lblFundoCadastro.setBounds(0, 0, 780, 420);

        setSize(new java.awt.Dimension(715, 388));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblOnibusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOnibusMouseClicked
        btnSalvar.setEnabled(false);
        int linha = tblOnibus.getSelectedRow();
        Integer codigo = (Integer) tblOnibus.getValueAt(linha, 0);
        preencheCampos((int) codigo);
    }//GEN-LAST:event_tblOnibusMouseClicked

    private void txtRenavamKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRenavamKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();

            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "DIGITE SOMENTE NUMEROS!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtRenavamKeyTyped

    FrmModelos telaModelos;

    private void btnAdicionarModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarModeloActionPerformed
        if (telaModelos == null) {
            telaModelos = new FrmModelos();
            telaModelos.setVisible(true);
        } else {
            telaModelos.dispose();
            telaModelos.setVisible(true);
        }
    }//GEN-LAST:event_btnAdicionarModeloActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            onibus.setPlaca(txtPlaca.getText().toUpperCase());
            onibus.setRenavam(txtRenavam.getText());
            onibus.setNumeroDePoltronas(Integer.parseInt(txtNumeroPoltronas.getText()));
            onibus.setAnoDeFabricação(Integer.parseInt(txtAnoFabricacao.getText()));
            onibus.setSituacao(cbxSituacao.getSelectedItem().toString());
            onibus.setIdModelo(vetorModelos.get(cbxModelos.getSelectedIndex()));

            if (txtPlaca.getText().isEmpty() || txtRenavam.getText().isEmpty() || txtAnoFabricacao.getText().isEmpty()
                    || txtNumeroPoltronas.getText().isEmpty() || cbxSituacao.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(rootPane, "CAMPO EM BRANCO!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else if(onibus.getAnoDeFabricação() >2020 || onibus.getAnoDeFabricação() < 1970){
                JOptionPane.showMessageDialog(rootPane, "ANO DE FABRICAÇÃO INVALIDA!", "Atenção!", JOptionPane.ERROR_MESSAGE);
            } else if(onibus.getNumeroDePoltronas() > 100 || onibus.getNumeroDePoltronas() <=0){
                JOptionPane.showMessageDialog(rootPane, "NUMEROS DE POLTRONAS INVALIDA!", "Atenção!", JOptionPane.ERROR_MESSAGE);
            } else {
                if (!onibusBLL.verificarPlacaIguais(txtPlaca.getText()) && !onibusBLL.verificarRenavamIguais(txtRenavam.getText())
                        && !onibusBLL.isRenavam(txtRenavam.getText())) {

                    if (onibusBLL.salvar(onibus)) {
                        JOptionPane.showMessageDialog(rootPane, "Salvo com sucesso!", "Mensagem!!!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Erro ao salvar!", "Mensagem!!!", JOptionPane.WARNING_MESSAGE);
                    }
                    consultar(onibusBLL.consultar());
                    limparCampos();

                } else {
                    if (onibusBLL.verificarPlacaIguais(txtPlaca.getText())) {
                        JOptionPane.showMessageDialog(rootPane, "PLACA JÁ FOI CADASTRADA!", "Cuidado!", JOptionPane.ERROR_MESSAGE);
                    }
                    if (onibusBLL.verificarRenavamIguais(txtRenavam.getText())) {
                        JOptionPane.showMessageDialog(rootPane, "RENAVAM JÁ FOI CADASTRADO!", "Atenção!", JOptionPane.ERROR_MESSAGE);
                    }
                    if (onibusBLL.isRenavam(txtRenavam.getText())) {
                        JOptionPane.showMessageDialog(rootPane, "RENAVAM INVALIDO!", "Cuidado!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "ERRO AO SALVAR!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            if (txtPlaca.getText().isEmpty() || txtRenavam.getText().isEmpty() || txtAnoFabricacao.getText().isEmpty()
                    || txtNumeroPoltronas.getText().isEmpty() || cbxSituacao.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(rootPane, "CAMPO EM BRANCO!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else {
                if (onibusBLL.remover(onibusBLL.consultaPorId(onibus.getCodigo()))) {
                    JOptionPane.showMessageDialog(rootPane, "Removido com sucesso!", "Mensagem!!!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao remover!", "Mensagem!!!", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "ERRO AO REMOVER!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
        consultar(onibusBLL.consultar());
        limparCampos();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            onibus.setPlaca(txtPlaca.getText().toUpperCase());
            onibus.setRenavam(txtRenavam.getText());
            onibus.setNumeroDePoltronas(Integer.parseInt(txtNumeroPoltronas.getText()));
            onibus.setAnoDeFabricação(Integer.parseInt(txtAnoFabricacao.getText()));
            onibus.setSituacao(cbxSituacao.getSelectedItem().toString());
            onibus.setIdModelo(vetorModelos.get(cbxModelos.getSelectedIndex()));

            if (txtPlaca.getText().isEmpty() || txtRenavam.getText().isEmpty() || txtAnoFabricacao.getText().isEmpty()
                    || txtNumeroPoltronas.getText().isEmpty() || cbxSituacao.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(rootPane, "CAMPO EM BRANCO!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else if(onibus.getAnoDeFabricação() >2020 || onibus.getAnoDeFabricação() < 1970){
                JOptionPane.showMessageDialog(rootPane, "ANO DE FABRICAÇÃO INVALIDA!", "Atenção!", JOptionPane.ERROR_MESSAGE);
            } else if(onibus.getNumeroDePoltronas() > 100 || onibus.getNumeroDePoltronas() <=0){
                JOptionPane.showMessageDialog(rootPane, "NUMEROS DE POLTRONAS INVALIDA!", "Atenção!", JOptionPane.ERROR_MESSAGE);
            } else {
                if (!onibusBLL.isRenavam(txtRenavam.getText())) {
                    if (onibusBLL.editar(onibus)) {
                        JOptionPane.showMessageDialog(rootPane, "Editado com sucesso!", "Mensagem!!!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Erro ao editar!", "Mensagem!!!", JOptionPane.WARNING_MESSAGE);
                    }
                    consultar(onibusBLL.consultar());
                    limparCampos();

                } else {
                    JOptionPane.showMessageDialog(rootPane, "RENAVAM INVALIDO!", "Cuidado!", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "ERRO AO EDITAR!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
        preencherCbxs();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnDisponiveisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisponiveisActionPerformed
        consultar(onibusBLL.consultarDisponiveis());
    }//GEN-LAST:event_btnDisponiveisActionPerformed

    private void btnIndisponiveisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIndisponiveisActionPerformed
        consultar(onibusBLL.consultarIndisponiveis());
    }//GEN-LAST:event_btnIndisponiveisActionPerformed

    private void txtAnoFabricacaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnoFabricacaoKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();

            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "DIGITE SOMENTE NUMEROS!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtAnoFabricacaoKeyTyped

    private void txtNumeroPoltronasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroPoltronasKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();

            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "DIGITE SOMENTE NUMEROS!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
        
        Character ch = evt.getKeyChar();
        int comprimentoDeCampo = txtNumeroPoltronas.getText().length();
        if (comprimentoDeCampo >= 3) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "LIMITE DE 3 DIGITOS!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtNumeroPoltronasKeyTyped

    private void txtNumeroPoltronasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroPoltronasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroPoltronasActionPerformed

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
            java.util.logging.Logger.getLogger(FrmOnibus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmOnibus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmOnibus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmOnibus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmOnibus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarModelo;
    private javax.swing.JButton btnDisponiveis;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnIndisponiveis;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxModelos;
    private javax.swing.JComboBox<String> cbxSituacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFundoCadastro;
    private javax.swing.JTable tblOnibus;
    private javax.swing.JFormattedTextField txtAnoFabricacao;
    private javax.swing.JTextField txtNumeroPoltronas;
    private javax.swing.JFormattedTextField txtPlaca;
    private javax.swing.JFormattedTextField txtRenavam;
    // End of variables declaration//GEN-END:variables
}
