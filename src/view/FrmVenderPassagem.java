package view;

import bll.VendaBLL;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.FormaPagamento;
import model.Funcionario;
import model.Rota;
import model.Venda;

public class FrmVenderPassagem extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    VendaBLL vendaBLL = new VendaBLL();
    Venda venda = new Venda();

    DecimalFormat df = new DecimalFormat("####");

    Vector<Rota> vetorRotas;
    Vector<Funcionario> vetorFuncionarios;
    Vector<Cliente> vetorClientes;
    Vector<FormaPagamento> vetorFormasPagamento;

    public FrmVenderPassagem() {
        criarTabela();
        consultar();
        initComponents();
        preencherCbxs();
    }

    private void criarTabela() {
        tblPassagensVendidas = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Rota");
        modelo.addColumn("Assento");
        modelo.addColumn("Funcionário");
        modelo.addColumn("Cliente");
        modelo.addColumn("Passageiro");
        modelo.addColumn("Valor");
        modelo.addColumn("Forma de Pagamento");
        modelo.addColumn("Situação");
    }

    private void consultar() {
        modelo.setNumRows(0);
        List<Venda> lista = vendaBLL.consultar();

        if (lista.size() > 0) {
            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[]{
                    lista.get(i).getCodigo(),
                    lista.get(i).getIdRota().toRota(),
                    lista.get(i).getAssento(),
                    lista.get(i).getIdFuncionario().getNome(),
                    lista.get(i).getIdCliente().getNome(),
                    lista.get(i).getNomePassageiro(),
                    lista.get(i).getValor(),
                    lista.get(i).getIdFormaDePagamento().getFormaPagamento(),
                    lista.get(i).getSituacao()
                });
            }
        } else {
            modelo.setNumRows(0);
        }
    }

    private void preencheCampos(int id) {
        venda = vendaBLL.consultaPorId(id);
        cbxRotas.setSelectedItem(venda.getIdRota());
        cbxAssentos.setSelectedItem(venda.getAssento());
        cbxFuncionarios.setSelectedItem(venda.getIdFuncionario());
        CbxClientes.setSelectedItem(venda.getIdFuncionario());
        txtNomePassageiro.setText(venda.getNomePassageiro());
        txtValor.setText(String.valueOf(venda.getValor()));
        cbxFormasPagamento.setSelectedItem(venda.getIdFormaDePagamento());
        cbxSituacao.setSelectedItem(venda.getSituacao());
        
    }

    private void limparCampos() {
        cbxRotas.setSelectedIndex(0);
        cbxAssentos.setSelectedIndex(0);
        cbxFuncionarios.setSelectedIndex(0);
        CbxClientes.setSelectedIndex(0);
        txtNomePassageiro.setText("");
        txtValor.setText("");
        cbxFormasPagamento.setSelectedIndex(0);
        cbxSituacao.setSelectedIndex(0);
    }

    private void preencherCbxs() {
        vetorRotas = vendaBLL.listarRotas();
        vetorFuncionarios = vendaBLL.listarFuncionarios();
        vetorClientes = vendaBLL.listarClientes();
        vetorFormasPagamento = vendaBLL.listarFormasPagamento();

        cbxRotas.setModel(new DefaultComboBoxModel(vetorRotas));
        cbxFuncionarios.setModel(new DefaultComboBoxModel(vetorFuncionarios));
        CbxClientes.setModel(new DefaultComboBoxModel(vetorClientes));
        cbxFormasPagamento.setModel(new DefaultComboBoxModel(vetorFormasPagamento));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTipo = new javax.swing.ButtonGroup();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPassagensVendidas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxRotas = new javax.swing.JComboBox<>();
        txtValor = new javax.swing.JTextField();
        cbxSituacao = new javax.swing.JComboBox<>();
        CbxClientes = new javax.swing.JComboBox<>();
        cbxAssentos = new javax.swing.JComboBox<>();
        cbxFormasPagamento = new javax.swing.JComboBox<>();
        txtNomePassageiro = new javax.swing.JTextField();
        cbxFuncionarios = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        btnAdicionarCliente = new javax.swing.JButton();
        btnAdicionarRota = new javax.swing.JButton();
        btnAdicionarFuncionario = new javax.swing.JButton();
        btnAdicionarFormaPagamento = new javax.swing.JButton();
        rbVender = new javax.swing.JRadioButton();
        rbReservar = new javax.swing.JRadioButton();
        lblFundoCadastro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar venda de passagem");
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
        btnSalvar.setBounds(530, 480, 55, 40);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_excluir.png"))); // NOI18N
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir);
        btnExcluir.setBounds(600, 480, 55, 40);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_editar.png"))); // NOI18N
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar);
        btnEditar.setBounds(670, 480, 55, 40);

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_limpar.png"))); // NOI18N
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar);
        btnLimpar.setBounds(740, 480, 55, 40);

        tblPassagensVendidas.setModel(modelo);
        tblPassagensVendidas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblPassagensVendidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPassagensVendidasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPassagensVendidas);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 230, 890, 240);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Rota");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 60, 27, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Cliente");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 160, 60, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Nome passageiro");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(490, 160, 130, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Assento");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(490, 60, 60, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Valor");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(490, 110, 29, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Forma de pagamento");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(650, 60, 130, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Funcionário");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(40, 110, 90, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Situação");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(650, 110, 90, 20);

        cbxRotas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxRotasItemStateChanged(evt);
            }
        });
        getContentPane().add(cbxRotas);
        cbxRotas.setBounds(40, 80, 380, 28);

        txtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorKeyTyped(evt);
            }
        });
        getContentPane().add(txtValor);
        txtValor.setBounds(490, 130, 110, 28);

        cbxSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Pagamento Efetuado", "Pagamento Incompleto" }));
        getContentPane().add(cbxSituacao);
        cbxSituacao.setBounds(650, 130, 220, 28);

        getContentPane().add(CbxClientes);
        CbxClientes.setBounds(40, 180, 380, 28);

        getContentPane().add(cbxAssentos);
        cbxAssentos.setBounds(490, 80, 130, 28);

        getContentPane().add(cbxFormasPagamento);
        cbxFormasPagamento.setBounds(650, 80, 180, 28);

        txtNomePassageiro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomePassageiroKeyTyped(evt);
            }
        });
        getContentPane().add(txtNomePassageiro);
        txtNomePassageiro.setBounds(490, 180, 380, 28);

        getContentPane().add(cbxFuncionarios);
        cbxFuncionarios.setBounds(40, 130, 380, 28);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText(" R$");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(600, 130, 30, 30);

        btnAdicionarCliente.setText("+");
        btnAdicionarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdicionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionarCliente);
        btnAdicionarCliente.setBounds(420, 180, 41, 28);

        btnAdicionarRota.setText("+");
        btnAdicionarRota.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdicionarRota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarRotaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionarRota);
        btnAdicionarRota.setBounds(420, 80, 41, 28);

        btnAdicionarFuncionario.setText("+");
        btnAdicionarFuncionario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdicionarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarFuncionarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionarFuncionario);
        btnAdicionarFuncionario.setBounds(420, 130, 41, 28);

        btnAdicionarFormaPagamento.setText("+");
        btnAdicionarFormaPagamento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdicionarFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarFormaPagamentoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionarFormaPagamento);
        btnAdicionarFormaPagamento.setBounds(830, 80, 41, 28);

        buttonGroupTipo.add(rbVender);
        rbVender.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbVender.setText("Vender Passagem");
        getContentPane().add(rbVender);
        rbVender.setBounds(260, 20, 130, 23);

        buttonGroupTipo.add(rbReservar);
        rbReservar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbReservar.setText("Reservar Passagem");
        getContentPane().add(rbReservar);
        rbReservar.setBounds(460, 20, 140, 23);

        lblFundoCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/tela_cadastro.jpg"))); // NOI18N
        getContentPane().add(lblFundoCadastro);
        lblFundoCadastro.setBounds(0, -20, 960, 560);

        setSize(new java.awt.Dimension(915, 560));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            venda.setIdRota(vetorRotas.get(cbxRotas.getSelectedIndex()));
            venda.setAssento(Integer.parseInt(cbxAssentos.getSelectedItem().toString()));
            venda.setIdFuncionario(vetorFuncionarios.get(cbxFuncionarios.getSelectedIndex()));
            venda.setIdCliente(vetorClientes.get(CbxClientes.getSelectedIndex()));
            venda.setNomePassageiro(txtNomePassageiro.getText());
            venda.setValor(Float.parseFloat(txtValor.getText()));
            venda.setIdFormaDePagamento(vetorFormasPagamento.get(cbxFormasPagamento.getSelectedIndex()));
            venda.setSituacao(cbxSituacao.getSelectedItem().toString());

            if (txtNomePassageiro.getText().isEmpty() || txtValor.getText().isEmpty() || cbxSituacao.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(rootPane, "CAMPO EM BRANCO!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else {
                if(!vendaBLL.verificarAssentosIguais(venda.getCodigo(), venda.getAssento())){
                    if (vendaBLL.salvar(venda)) {
                        JOptionPane.showMessageDialog(rootPane, "Salvo com sucesso!", "Mensagem!!!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Erro ao salvar!", "Mensagem!!!", JOptionPane.WARNING_MESSAGE);
                    }
                    consultar();
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "ASSENTO JÁ ESTÁ RESERVADO!", "ERRO!", JOptionPane.ERROR_MESSAGE);
                }
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "ERRO AO SALVAR!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            if (txtNomePassageiro.getText().isEmpty() || txtValor.getText().isEmpty() || cbxSituacao.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(rootPane, "CAMPO EM BRANCO!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else {
                if (vendaBLL.remover(vendaBLL.consultaPorId(venda.getCodigo()))) {
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
            venda.setIdRota(vetorRotas.get(cbxRotas.getSelectedIndex()));
            venda.setAssento(Integer.parseInt(cbxAssentos.getSelectedItem().toString()));
            venda.setIdFuncionario(vetorFuncionarios.get(cbxFuncionarios.getSelectedIndex()));
            venda.setIdCliente(vetorClientes.get(CbxClientes.getSelectedIndex()));
            venda.setNomePassageiro(txtNomePassageiro.getText());
            venda.setValor(Float.parseFloat(txtValor.getText()));
            venda.setIdFormaDePagamento(vetorFormasPagamento.get(cbxFormasPagamento.getSelectedIndex()));
            venda.setSituacao(cbxSituacao.getSelectedItem().toString());

            if (txtNomePassageiro.getText().isEmpty() || txtValor.getText().isEmpty() || cbxSituacao.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(rootPane, "CAMPO EM BRANCO!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else {
                if (vendaBLL.editar(venda)) {
                    JOptionPane.showMessageDialog(rootPane, "Editado com sucesso!", "Mensagem!!!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao editar!", "Mensagem!!!", JOptionPane.WARNING_MESSAGE);
                }
                consultar();
                limparCampos();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "ERRO AO SALVAR!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
        preencherCbxs();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void tblPassagensVendidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPassagensVendidasMouseClicked
        btnSalvar.setEnabled(false);

        int linha = tblPassagensVendidas.getSelectedRow();
        Integer codigo = (Integer) tblPassagensVendidas.getValueAt(linha, 0);
        preencheCampos((int) codigo);
    }//GEN-LAST:event_tblPassagensVendidasMouseClicked

    FrmClientes telaClientes;
    FrmFuncionarios telaFuncionarios;
    FrmRotas telaRotas;
    FrmFormasPagamento telaFormasPagamento;

    private void btnAdicionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarClienteActionPerformed
        if (telaClientes == null) {
            telaClientes = new FrmClientes();
            telaClientes.setVisible(true);
        } else {
            telaClientes.dispose();
            telaClientes.setVisible(true);
        }
    }//GEN-LAST:event_btnAdicionarClienteActionPerformed

    private void btnAdicionarRotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarRotaActionPerformed
        if (telaRotas == null) {
            telaRotas = new FrmRotas();
            telaRotas.setVisible(true);
        } else {
            telaRotas.dispose();
            telaRotas.setVisible(true);
        }
    }//GEN-LAST:event_btnAdicionarRotaActionPerformed

    private void btnAdicionarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarFuncionarioActionPerformed
        if (telaFuncionarios == null) {
            telaFuncionarios = new FrmFuncionarios();
            telaFuncionarios.setVisible(true);
        } else {
            telaFuncionarios.dispose();
            telaFuncionarios.setVisible(true);
        }
    }//GEN-LAST:event_btnAdicionarFuncionarioActionPerformed

    private void btnAdicionarFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarFormaPagamentoActionPerformed
        if (telaFormasPagamento == null) {
            telaFormasPagamento = new FrmFormasPagamento();
            telaFormasPagamento.setVisible(true);
        } else {
            telaFormasPagamento.dispose();
            telaFormasPagamento.setVisible(true);
        }
    }//GEN-LAST:event_btnAdicionarFormaPagamentoActionPerformed

    private void cbxRotasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxRotasItemStateChanged
        venda.setIdRota(vetorRotas.get(cbxRotas.getSelectedIndex()));
        int id = venda.getIdRota().getCodigo();

        txtValor.setText(String.valueOf(df.format(vendaBLL.precoRota(id))));
        txtValor.setEnabled(true);

        int assentos = vendaBLL.nPoltronas(id);

        for (int i = 1; i <= assentos; i++) {
            cbxAssentos.addItem("" + i);
        }
    }//GEN-LAST:event_cbxRotasItemStateChanged

    private void txtValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorKeyTyped
        Character ch = evt.getKeyChar();
        int comprimentoDeCampo = txtValor.getText().length();
        if (comprimentoDeCampo >= 5) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "LIMITE DE 5 DIGITOS!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }

        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "DIGITE SOMENTE NUMEROS!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtValorKeyTyped

    private void txtNomePassageiroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomePassageiroKeyTyped
        Character ch = evt.getKeyChar();
        int comprimentoDeCampo = txtNomePassageiro.getText().length();
        if (comprimentoDeCampo >= 40) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "LIMITE DE 40 DIGITOS!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }

        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit().beep();

            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "DIGITE SOMENTE LETRAS!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtNomePassageiroKeyTyped

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
            java.util.logging.Logger.getLogger(FrmVenderPassagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVenderPassagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVenderPassagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVenderPassagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVenderPassagem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbxClientes;
    private javax.swing.JButton btnAdicionarCliente;
    private javax.swing.JButton btnAdicionarFormaPagamento;
    private javax.swing.JButton btnAdicionarFuncionario;
    private javax.swing.JButton btnAdicionarRota;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroupTipo;
    private javax.swing.JComboBox<String> cbxAssentos;
    private javax.swing.JComboBox<String> cbxFormasPagamento;
    private javax.swing.JComboBox<String> cbxFuncionarios;
    private javax.swing.JComboBox<String> cbxRotas;
    private javax.swing.JComboBox<String> cbxSituacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFundoCadastro;
    private javax.swing.JRadioButton rbReservar;
    private javax.swing.JRadioButton rbVender;
    private javax.swing.JTable tblPassagensVendidas;
    private javax.swing.JTextField txtNomePassageiro;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
