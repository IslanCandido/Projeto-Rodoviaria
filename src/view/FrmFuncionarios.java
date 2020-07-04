package view;

import bll.FuncionarioBLL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Cargo;
import model.Endereco;
import model.Funcionario;

public class FrmFuncionarios extends javax.swing.JFrame {
    
    DefaultTableModel modelo = new DefaultTableModel();
    FuncionarioBLL funcionarioBLL = new FuncionarioBLL();
    Funcionario funcionario = new Funcionario();
    
    Vector<Endereco> vetorEnderecos;
    Vector<Cargo> vetorCargos;

    public FrmFuncionarios() {
        criarTabela();
        consultar();
        initComponents();
        preencherCbxs();
    }
    
    private Date CriarNovaData(String data) {
        if (data == null) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        java.sql.Date a = null;
        try {
            a = new java.sql.Date(format.parse(data).getTime());
        } catch (ParseException e) {
        }
        return a;
    }

    private String convertDate(Date dtConsulta) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"));
            return formatter.format(dtConsulta);
        } catch (Exception e) {
            return null;
        }
    }
    
        private void criarTabela() {
        tblFuncionarios = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        modelo.addColumn("Email");
        modelo.addColumn("Data nascimento");
        modelo.addColumn("CPF");
        modelo.addColumn("PIS");
        modelo.addColumn("Cargo");
        modelo.addColumn("Endereço");
        modelo.addColumn("Telefone");
        modelo.addColumn("Matricula");        
    }

    private void consultar() {
        modelo.setNumRows(0);
        List<Funcionario> lista = funcionarioBLL.consultar();
        
        if (lista.size() > 0) {
            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[]{
                    lista.get(i).getCodigo(),
                    lista.get(i).getNome(),
                    lista.get(i).getEmail(),
                    lista.get(i).getDtNascimento(),
                    lista.get(i).getCpf(),
                    lista.get(i).getPis(),
                    lista.get(i).getIdCargo().getDescricao(),
                    lista.get(i).getIdEndereco().getBairro(),
                    lista.get(i).getTelefone(),
                    lista.get(i).getMatricula()
                });
            }
        } else {
            modelo.setNumRows(0);
        }
    }

    private void preencheCampos(int id) {
        funcionario = funcionarioBLL.consultaPorId(id);
        txtNome.setText(funcionario.getNome());
        txtCpf.setText(funcionario.getCpf());
        txtEmail.setText(funcionario.getEmail());
        txtDataNascimento.setText(convertDate(funcionario.getDtNascimento()));
        txtPis.setText(funcionario.getPis());
        cbxEnderecos.setSelectedItem(funcionario.getIdEndereco());
        txtTelefone.setText(funcionario.getTelefone());
        cbxCargos.setSelectedItem(funcionario.getIdCargo());
        txtMatricula.setText(funcionario.getMatricula());
        txtSenhaAcesso.setText(funcionario.getSenha());
    }

    private void limparCampos() {
        txtNome.setText("");
        txtCpf.setValue("");
        txtEmail.setText("");
        txtDataNascimento.setValue("");
        cbxEnderecos.setSelectedIndex(0);
        txtTelefone.setValue("");
        cbxCargos.setSelectedIndex(0);
        txtPis.setValue("");
        txtMatricula.setText("");
        txtSenhaAcesso.setText("");
        btnSalvar.setEnabled(true);
    }
    
    private void preencherCbxs() {
        vetorEnderecos = funcionarioBLL.listarEnderecos();
        vetorCargos = funcionarioBLL.listarCargos();

        cbxEnderecos.setModel(new DefaultComboBoxModel(vetorEnderecos));
        cbxCargos.setModel(new DefaultComboBoxModel(vetorCargos));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDataNascimento = new javax.swing.JFormattedTextField();
        cbxEnderecos = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnAdicionarEndereco = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFuncionarios = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPis = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSenhaAcesso = new javax.swing.JPasswordField();
        txtTelefone = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        cbxCargos = new javax.swing.JComboBox<>();
        btnAdicionarCargo = new javax.swing.JButton();
        txtMatricula = new javax.swing.JFormattedTextField();
        lblFundoCadastro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de funcionários");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome completo");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 10, 110, 20);

        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomeKeyTyped(evt);
            }
        });
        getContentPane().add(txtNome);
        txtNome.setBounds(40, 30, 290, 28);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Email");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 60, 30, 20);

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });
        getContentPane().add(txtEmail);
        txtEmail.setBounds(40, 80, 290, 28);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText(" CPF");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(360, 10, 30, 20);

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCpfKeyTyped(evt);
            }
        });
        getContentPane().add(txtCpf);
        txtCpf.setBounds(360, 30, 190, 28);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Data Nascimento");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(360, 60, 100, 20);

        try {
            txtDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataNascimentoActionPerformed(evt);
            }
        });
        txtDataNascimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDataNascimentoKeyTyped(evt);
            }
        });
        getContentPane().add(txtDataNascimento);
        txtDataNascimento.setBounds(360, 80, 110, 28);

        cbxEnderecos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxEnderecosItemStateChanged(evt);
            }
        });
        cbxEnderecos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxEnderecosMouseClicked(evt);
            }
        });
        getContentPane().add(cbxEnderecos);
        cbxEnderecos.setBounds(40, 130, 250, 28);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Endereço");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 110, 70, 20);

        btnAdicionarEndereco.setText("+");
        btnAdicionarEndereco.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdicionarEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarEnderecoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionarEndereco);
        btnAdicionarEndereco.setBounds(290, 130, 41, 28);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Telefone");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(580, 10, 60, 20);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_salvar.png"))); // NOI18N
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(440, 360, 55, 40);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_excluir.png"))); // NOI18N
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir);
        btnExcluir.setBounds(510, 360, 55, 40);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_editar.png"))); // NOI18N
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar);
        btnEditar.setBounds(580, 360, 55, 40);

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_limpar.png"))); // NOI18N
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar);
        btnLimpar.setBounds(650, 360, 55, 40);

        tblFuncionarios.setModel(modelo);
        tblFuncionarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblFuncionarios);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 170, 780, 180);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Matricula");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(650, 60, 80, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText(" PIS");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(500, 60, 30, 20);

        try {
            txtPis.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtPis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPisKeyTyped(evt);
            }
        });
        getContentPane().add(txtPis);
        txtPis.setBounds(500, 80, 120, 28);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText(" Senha de acesso");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(610, 110, 110, 20);

        txtSenhaAcesso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSenhaAcessoKeyTyped(evt);
            }
        });
        getContentPane().add(txtSenhaAcesso);
        txtSenhaAcesso.setBounds(610, 130, 150, 30);

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefoneKeyTyped(evt);
            }
        });
        getContentPane().add(txtTelefone);
        txtTelefone.setBounds(580, 30, 180, 28);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Cargo");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(360, 110, 60, 20);

        getContentPane().add(cbxCargos);
        cbxCargos.setBounds(360, 130, 180, 28);

        btnAdicionarCargo.setText("+");
        btnAdicionarCargo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdicionarCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarCargoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionarCargo);
        btnAdicionarCargo.setBounds(540, 130, 41, 28);

        try {
            txtMatricula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtMatricula);
        txtMatricula.setBounds(650, 80, 110, 28);

        lblFundoCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/tela_cadastro.jpg"))); // NOI18N
        getContentPane().add(lblFundoCadastro);
        lblFundoCadastro.setBounds(0, 0, 840, 420);

        setSize(new java.awt.Dimension(804, 437));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyTyped
        Character ch = evt.getKeyChar();
        int comprimentoDeCampo = txtNome.getText().length();
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
    }//GEN-LAST:event_txtNomeKeyTyped

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        Character ch = evt.getKeyChar();
        int comprimentoDeCampo = txtEmail.getText().length();
        if (comprimentoDeCampo >= 40) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "LIMITE DE 40 DIGITOS!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtEmailKeyTyped

    private void txtCpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCpfKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();

            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "DIGITE SOMENTE NUMEROS!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtCpfKeyTyped

    private void txtDataNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataNascimentoActionPerformed

    }//GEN-LAST:event_txtDataNascimentoActionPerformed

    private void txtDataNascimentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataNascimentoKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();

            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "DIGITE SOMENTE NUMEROS!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtDataNascimentoKeyTyped

    private void cbxEnderecosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxEnderecosItemStateChanged

    }//GEN-LAST:event_cbxEnderecosItemStateChanged

    private void cbxEnderecosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxEnderecosMouseClicked

    }//GEN-LAST:event_cbxEnderecosMouseClicked

    FrmEnderecos telaEnderecos;
    
    private void btnAdicionarEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarEnderecoActionPerformed
        if (telaEnderecos == null) {
            telaEnderecos = new FrmEnderecos();
            telaEnderecos.setVisible(true);
        } else {
            telaEnderecos.dispose();
            telaEnderecos.setVisible(true);
        }
    }//GEN-LAST:event_btnAdicionarEnderecoActionPerformed

    private void tblFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFuncionariosMouseClicked
        btnSalvar.setEnabled(false);
        int linha = tblFuncionarios.getSelectedRow();
        Integer codigo = (Integer) tblFuncionarios.getValueAt(linha, 0);
        preencheCampos((int) codigo);
    }//GEN-LAST:event_tblFuncionariosMouseClicked

    private void txtPisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPisKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();

            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "DIGITE SOMENTE NUMEROS!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtPisKeyTyped

    private void txtSenhaAcessoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaAcessoKeyTyped
        Character ch = evt.getKeyChar();
        int comprimentoDeCampo = txtSenhaAcesso.getText().length();
        if (comprimentoDeCampo >= 12) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, " SENHA MUITO LONGA!\n(Maximo de 12 caracteres)", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtSenhaAcessoKeyTyped

    private void txtTelefoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefoneKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();

            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "DIGITE SOMENTE NUMEROS!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtTelefoneKeyTyped

    FrmCargos telaCargos;
    
    private void btnAdicionarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarCargoActionPerformed
        if (telaCargos == null) {
            telaCargos = new FrmCargos();
            telaCargos.setVisible(true);
        } else {
            telaCargos.dispose();
            telaCargos.setVisible(true);
        }
    }//GEN-LAST:event_btnAdicionarCargoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            funcionario.setNome(txtNome.getText());
            funcionario.setCpf(txtCpf.getText());
            funcionario.setEmail(txtEmail.getText());
            funcionario.setDtNascimento(CriarNovaData(txtDataNascimento.getText()));
            funcionario.setPis(txtPis.getText());
            funcionario.setTelefone(txtTelefone.getText());
            funcionario.setMatricula(txtMatricula.getText());
            funcionario.setSenha(txtSenhaAcesso.getText());
            funcionario.setIdCargo(vetorCargos.get(cbxCargos.getSelectedIndex()));
            funcionario.setIdEndereco(vetorEnderecos.get(cbxEnderecos.getSelectedIndex()));

            if (txtNome.getText().isEmpty() || txtCpf.getText().isEmpty() || txtEmail.getText().isEmpty()
                    || txtDataNascimento.getText().isEmpty() || txtPis.getText().isEmpty()
                    || txtMatricula.getText().isEmpty() || txtSenhaAcesso.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "CAMPO EM BRANCO!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else if(txtSenhaAcesso.getText().length() < 4){
                JOptionPane.showMessageDialog(rootPane, "SENHA MUITO CURTA!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else {
                if (funcionarioBLL.isCpf(txtCpf.getText()) && funcionarioBLL.isData(txtDataNascimento.getText()) && 
                        funcionarioBLL.isEmail(txtEmail.getText()) && funcionarioBLL.isPIS(txtPis.getText()) && 
                        !funcionarioBLL.verificarCpfIgual(txtCpf.getText()) && !funcionarioBLL.verificarPisIgual(txtPis.getText())) {
                    if (funcionarioBLL.salvar(funcionario)) {
                        JOptionPane.showMessageDialog(rootPane, "Salvo com sucesso!", "Mensagem!!!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Erro ao salvar!", "Mensagem!!!", JOptionPane.WARNING_MESSAGE);
                    }
                    consultar();
                    limparCampos();
                } else {
                    if (!funcionarioBLL.isPIS(txtPis.getText())) {
                        JOptionPane.showMessageDialog(rootPane, "PIS INVALIDO!", "Cuidado!", JOptionPane.ERROR_MESSAGE);
                    }
                    if (!funcionarioBLL.isEmail(txtEmail.getText())) {
                        JOptionPane.showMessageDialog(rootPane, "EMAIL INVALIDO!", "Atenção!", JOptionPane.ERROR_MESSAGE);
                    }
                    if (!funcionarioBLL.isCpf(txtCpf.getText())) {
                        JOptionPane.showMessageDialog(rootPane, "CPF INVALIDO!", "Cuidado!", JOptionPane.ERROR_MESSAGE);
                    }
                    if (!funcionarioBLL.isData(txtDataNascimento.getText())) {
                        JOptionPane.showMessageDialog(rootPane, "DATA NASCIMENTO INVALIDO!", "Atenção!", JOptionPane.ERROR_MESSAGE);
                    }
                    if (funcionarioBLL.verificarCpfIgual(txtCpf.getText())) {
                        JOptionPane.showMessageDialog(rootPane, "CPF JÁ FOI CADASTRADO!", "Cuidado!", JOptionPane.ERROR_MESSAGE);
                    }
                    if (funcionarioBLL.verificarPisIgual(txtPis.getText())) {
                        JOptionPane.showMessageDialog(rootPane, "PIS JÁ FOI CADASTRADO!", "Cuidado!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "ERRO AO SALVAR!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            if (txtNome.getText().isEmpty() || txtCpf.getText().isEmpty() || txtEmail.getText().isEmpty()
                    || txtDataNascimento.getText().isEmpty() || txtPis.getText().isEmpty()
                    || txtMatricula.getText().isEmpty() || txtSenhaAcesso.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "CAMPO EM BRANCO!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else {
                if (funcionarioBLL.remover(funcionarioBLL.consultaPorId(funcionario.getCodigo()))) {
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
            funcionario.setNome(txtNome.getText());
            funcionario.setCpf(txtCpf.getText());
            funcionario.setEmail(txtEmail.getText());
            funcionario.setDtNascimento(CriarNovaData(txtDataNascimento.getText()));
            funcionario.setPis(txtPis.getText());
            funcionario.setTelefone(txtTelefone.getText());
            funcionario.setMatricula(txtMatricula.getText());
            funcionario.setSenha(txtSenhaAcesso.getText());
            funcionario.setIdCargo(vetorCargos.get(cbxCargos.getSelectedIndex()));
            funcionario.setIdEndereco(vetorEnderecos.get(cbxEnderecos.getSelectedIndex()));

            if (txtNome.getText().isEmpty() || txtCpf.getText().isEmpty() || txtEmail.getText().isEmpty()
                    || txtDataNascimento.getText().isEmpty() || txtPis.getText().isEmpty()
                    || txtMatricula.getText().isEmpty() || txtSenhaAcesso.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "CAMPO EM BRANCO!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else if(txtSenhaAcesso.getText().length() < 4){
                JOptionPane.showMessageDialog(rootPane, "SENHA MUITO CURTA!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else {
                if (funcionarioBLL.isCpf(txtCpf.getText()) && funcionarioBLL.isData(txtDataNascimento.getText()) && 
                        funcionarioBLL.isEmail(txtEmail.getText()) && funcionarioBLL.isPIS(txtPis.getText())) {
                    if (funcionarioBLL.editar(funcionario)) {
                        JOptionPane.showMessageDialog(rootPane, "Editado com sucesso!", "Mensagem!!!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Erro ao editar!", "Mensagem!!!", JOptionPane.WARNING_MESSAGE);
                    }
                    consultar();
                    limparCampos();
                } else {
                    if (!funcionarioBLL.isPIS(txtPis.getText())) {
                        JOptionPane.showMessageDialog(rootPane, "PIS INVALIDO!", "Cuidado!", JOptionPane.ERROR_MESSAGE);
                    }
                    if (!funcionarioBLL.isEmail(txtEmail.getText())) {
                        JOptionPane.showMessageDialog(rootPane, "EMAIL INVALIDO!", "Atenção!", JOptionPane.ERROR_MESSAGE);
                    }
                    if (!funcionarioBLL.isCpf(txtCpf.getText())) {
                        JOptionPane.showMessageDialog(rootPane, "CPF INVALIDO!", "Cuidado!", JOptionPane.ERROR_MESSAGE);
                    }
                    if (!funcionarioBLL.isData(txtDataNascimento.getText())) {
                        JOptionPane.showMessageDialog(rootPane, "DATA NASCIMENTO INVALIDO!", "Atenção!", JOptionPane.ERROR_MESSAGE);
                    }
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
            java.util.logging.Logger.getLogger(FrmFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmFuncionarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarCargo;
    private javax.swing.JButton btnAdicionarEndereco;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxCargos;
    private javax.swing.JComboBox<String> cbxEnderecos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JTable tblFuncionarios;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JFormattedTextField txtDataNascimento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JFormattedTextField txtMatricula;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtPis;
    private javax.swing.JPasswordField txtSenhaAcesso;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
