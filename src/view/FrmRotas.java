package view;

import bll.RotaBLL;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
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
import model.Onibus;
import model.Rota;

public class FrmRotas extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    RotaBLL rotaBLL = new RotaBLL();
    Rota rota = new Rota();

    Vector<Onibus> vetorOnibus;
    Vector<String> vetorCidadePartida;
    Vector<String> vetorCidadeDestino;

    public FrmRotas() {
        criarTabela();
        consultar();
        initComponents();
        preencherCbxs();
        getDataAtual();
    }

    public static Time CriarNovaTime(String hora) {
        if (hora == null) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

        java.sql.Time a = null;
        try {
            a = new java.sql.Time(format.parse(hora).getTime());
        } catch (ParseException e) {
        }
        return a;
    }

    public static String convertTime(Time timeConsult) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            return formatter.format(timeConsult);
        } catch (Exception e) {
            return null;
        }
    }

    public static Date CriarNovaData(String data) {
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

    public static String convertDate(Date dtConsulta) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"));
            return formatter.format(dtConsulta);
        } catch (Exception e) {
            return null;
        }
    }

    private void criarTabela() {
        tblRotas = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Data");
        modelo.addColumn("Horário Partida");
        modelo.addColumn("Horário Destino");
        modelo.addColumn("Cidade Partida");
        modelo.addColumn("Cidade Destino");
        modelo.addColumn("Ônibus");
        modelo.addColumn("Preço");
    }

    private void consultar() {
        modelo.setNumRows(0);
        List<Rota> lista = rotaBLL.consultar();

        if (lista.size() > 0) {
            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[]{
                    lista.get(i).getCodigo(),
                    lista.get(i).getData(),
                    lista.get(i).getHorarioPartida(),
                    lista.get(i).getHorarioDestino(),
                    lista.get(i).getCidadePartida(),
                    lista.get(i).getCidadeDestino(),
                    lista.get(i).getIdOnibus().getIdModelo().getDescricao(),
                    lista.get(i).getPreco()
                });
            }
        } else {
            modelo.setNumRows(0);
        }
    }

    private void preencheCampos(int id) {
        rota = rotaBLL.consultaPorId(id);
        txtData.setText(convertDate(rota.getData()));
        txtHorarioPartida.setText(convertTime(rota.getHorarioPartida()));
        txtHorarioDestino.setText(convertTime(rota.getHorarioDestino()));
        txtPreco.setText(String.valueOf(rota.getPreco()));
        cbxOnibus.setSelectedItem(rota.getIdOnibus());
        
        retornarEstados();

        cbxCidadePartida.setSelectedItem(rota.getCidadePartida());
        cbxCidadeDestino.setSelectedItem(rota.getCidadeDestino());
    }

    private void limparCampos() {
        txtData.setValue("");
        txtHorarioPartida.setValue("");
        txtPreco.setText("");
        txtHorarioDestino.setValue("");
        cbxCidadePartida.setSelectedIndex(0);
        cbxCidadeDestino.setSelectedIndex(0);
        cbxOnibus.setSelectedIndex(0);
        cbxEstado01.setSelectedIndex(0);
        cbxEstado02.setSelectedIndex(0);
        
        btnSalvar.setEnabled(true);
    }

    private void preencherCbxs() {
        vetorOnibus = rotaBLL.listarOnibus();
        cbxOnibus.setModel(new DefaultComboBoxModel(vetorOnibus));
    }

    private void getDataAtual() {
        java.util.Date data = new java.util.Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        txtData.setText(formatador.format(data));
    }

    private void retornarEstados() {
        tblRotas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JTable alvo = (JTable) e.getSource();
                    int linha = alvo.getSelectedRow();

                    String estado01 = alvo.getValueAt(linha, 4).toString();
                    String estado02 = alvo.getValueAt(linha, 5).toString();

                    cbxEstado01.setSelectedItem(rotaBLL.mostrarEstado(estado01));
                    cbxEstado02.setSelectedItem(rotaBLL.mostrarEstado(estado02));
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRotas = new javax.swing.JTable();
        txtData = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtHorarioDestino = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txtHorarioPartida = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbxCidadePartida = new javax.swing.JComboBox<>();
        cbxCidadeDestino = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbxEstado02 = new javax.swing.JComboBox<>();
        cbxEstado01 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbxOnibus = new javax.swing.JComboBox<>();
        btnAdicionarOnibus = new javax.swing.JButton();
        lblFundoCadastro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de rotas");
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
        btnSalvar.setBounds(570, 330, 55, 40);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_excluir.png"))); // NOI18N
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir);
        btnExcluir.setBounds(640, 330, 55, 40);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_editar.png"))); // NOI18N
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar);
        btnEditar.setBounds(710, 330, 55, 40);

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone_limpar.png"))); // NOI18N
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar);
        btnLimpar.setBounds(780, 330, 55, 40);

        tblRotas.setModel(modelo);
        tblRotas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblRotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRotasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblRotas);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 120, 920, 200);

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });
        txtData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDataKeyTyped(evt);
            }
        });
        getContentPane().add(txtData);
        txtData.setBounds(30, 30, 120, 28);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Data");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 10, 100, 20);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Preço");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 60, 70, 20);

        txtPreco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecoKeyTyped(evt);
            }
        });
        getContentPane().add(txtPreco);
        txtPreco.setBounds(30, 80, 100, 28);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText(" R$");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 80, 20, 30);

        try {
            txtHorarioDestino.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHorarioDestino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHorarioDestinoKeyTyped(evt);
            }
        });
        getContentPane().add(txtHorarioDestino);
        txtHorarioDestino.setBounds(180, 80, 100, 28);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Horário Destino");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(180, 60, 100, 20);

        try {
            txtHorarioPartida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHorarioPartida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHorarioPartidaKeyTyped(evt);
            }
        });
        getContentPane().add(txtHorarioPartida);
        txtHorarioPartida.setBounds(180, 30, 100, 28);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Horário Partida");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(180, 10, 90, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText(" Cidade de Partida");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(420, 10, 110, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText(" Cidade de Destino");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(420, 60, 110, 20);

        getContentPane().add(cbxCidadePartida);
        cbxCidadePartida.setBounds(420, 30, 200, 28);

        getContentPane().add(cbxCidadeDestino);
        cbxCidadeDestino.setBounds(420, 80, 200, 28);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText(" Estado");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(310, 60, 50, 20);

        cbxEstado02.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cbxEstado02.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxEstado02ItemStateChanged(evt);
            }
        });
        getContentPane().add(cbxEstado02);
        cbxEstado02.setBounds(310, 80, 100, 28);

        cbxEstado01.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cbxEstado01.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxEstado01ItemStateChanged(evt);
            }
        });
        getContentPane().add(cbxEstado01);
        cbxEstado01.setBounds(310, 30, 100, 28);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText(" Estado");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(310, 10, 50, 20);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Ônibus ");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(650, 10, 50, 20);

        getContentPane().add(cbxOnibus);
        cbxOnibus.setBounds(650, 30, 220, 28);

        btnAdicionarOnibus.setText("+");
        btnAdicionarOnibus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdicionarOnibus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarOnibusActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionarOnibus);
        btnAdicionarOnibus.setBounds(870, 30, 41, 28);

        lblFundoCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/tela_cadastro.jpg"))); // NOI18N
        getContentPane().add(lblFundoCadastro);
        lblFundoCadastro.setBounds(0, 0, 1030, 420);

        setSize(new java.awt.Dimension(945, 412));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            rota.setData(CriarNovaData(txtData.getText()));
            rota.setHorarioPartida(CriarNovaTime(txtHorarioPartida.getText()));
            rota.setHorarioDestino(CriarNovaTime(txtHorarioDestino.getText()));
            rota.setCidadePartida(cbxCidadePartida.getSelectedItem().toString());
            rota.setCidadeDestino(cbxCidadeDestino.getSelectedItem().toString());
            rota.setPreco(Float.parseFloat(txtPreco.getText()));
            rota.setIdOnibus(vetorOnibus.get(cbxOnibus.getSelectedIndex()));

            if (txtData.getText().isEmpty() || txtHorarioPartida.getText().isEmpty() || txtHorarioDestino.getText().isEmpty()
                    || txtPreco.getText().isEmpty() || cbxEstado01.getSelectedIndex() == 0 || cbxEstado02.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(rootPane, "CAMPO EM BRANCO!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else {
                if (rotaBLL.isData(txtData.getText()) && rotaBLL.isHorario(txtHorarioPartida.getText()) && rotaBLL.isHorario(txtHorarioDestino.getText())) {

                    if (rotaBLL.salvar(rota)) {
                        JOptionPane.showMessageDialog(rootPane, "Salvo com sucesso!", "Mensagem!!!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Erro ao salvar!", "Mensagem!!!", JOptionPane.WARNING_MESSAGE);
                    }
                    consultar();
                    limparCampos();
                } else {
                    if (!rotaBLL.isData(txtData.getText())) {
                        JOptionPane.showMessageDialog(rootPane, "DATA INVALIDA!", "Cuidado!", JOptionPane.WARNING_MESSAGE);
                    }
                    if (!rotaBLL.isHorario(txtHorarioPartida.getText())) {
                        JOptionPane.showMessageDialog(rootPane, "HORÁRIO DE PARTIDA INVALIDA!", "Cuidado!", JOptionPane.WARNING_MESSAGE);
                    }
                    if (!rotaBLL.isHorario(txtHorarioDestino.getText())) {
                        JOptionPane.showMessageDialog(rootPane, "HORÁRIO DE DESTINO INVALIDA!", "Cuidado!", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "ERRO AO SALVAR!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            if (txtData.getText().isEmpty() || txtHorarioPartida.getText().isEmpty() || txtHorarioDestino.getText().isEmpty()
                    || txtPreco.getText().isEmpty() || cbxCidadePartida.getSelectedIndex() == 0 || cbxCidadeDestino.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(rootPane, "CAMPO EM BRANCO!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else {
                if (rotaBLL.remover(rotaBLL.consultaPorId(rota.getCodigo()))) {
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
            rota.setData(CriarNovaData(txtData.getText()));
            rota.setHorarioPartida(CriarNovaTime(txtHorarioPartida.getText()));
            rota.setHorarioDestino(CriarNovaTime(txtHorarioDestino.getText()));
            rota.setCidadePartida(cbxCidadePartida.getSelectedItem().toString());
            rota.setCidadeDestino(cbxCidadeDestino.getSelectedItem().toString());
            rota.setPreco(Float.parseFloat(txtPreco.getText()));
            rota.setIdOnibus(vetorOnibus.get(cbxOnibus.getSelectedIndex()));

            if (txtData.getText().isEmpty() || txtHorarioPartida.getText().isEmpty() || txtHorarioDestino.getText().isEmpty()
                    || txtPreco.getText().isEmpty() || cbxEstado01.getSelectedIndex() == 0 || cbxEstado02.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(rootPane, "CAMPO EM BRANCO!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else {
                if (rotaBLL.isData(txtData.getText()) && rotaBLL.isHorario(txtHorarioPartida.getText()) && rotaBLL.isHorario(txtHorarioDestino.getText())) {

                    if (rotaBLL.editar(rota)) {
                        JOptionPane.showMessageDialog(rootPane, "Editado com sucesso!", "Mensagem!!!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Erro ao editar!", "Mensagem!!!", JOptionPane.WARNING_MESSAGE);
                    }
                    consultar();
                    limparCampos();

                } else {
                    if (!rotaBLL.isData(txtData.getText())) {
                        JOptionPane.showMessageDialog(rootPane, "DATA INVALIDA!", "Cuidado!", JOptionPane.WARNING_MESSAGE);
                    }
                    if (!rotaBLL.isHorario(txtHorarioPartida.getText())) {
                        JOptionPane.showMessageDialog(rootPane, "HORÁRIO DE PARTIDA INVALIDA!", "Cuidado!", JOptionPane.WARNING_MESSAGE);
                    }
                    if (!rotaBLL.isHorario(txtHorarioDestino.getText())) {
                        JOptionPane.showMessageDialog(rootPane, "HORÁRIO DE DESTINO INVALIDA!", "Cuidado!", JOptionPane.WARNING_MESSAGE);
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

    private void tblRotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRotasMouseClicked
        btnSalvar.setEnabled(false);

        int linha = tblRotas.getSelectedRow();
        Integer codigo = (Integer) tblRotas.getValueAt(linha, 0);
        preencheCampos((int) codigo);
    }//GEN-LAST:event_tblRotasMouseClicked

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed

    }//GEN-LAST:event_txtDataActionPerformed

    private void txtDataKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();

            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "DIGITE SOMENTE NUMEROS!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtDataKeyTyped

    private void txtHorarioDestinoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHorarioDestinoKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();

            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "DIGITE SOMENTE NUMEROS!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtHorarioDestinoKeyTyped

    private void txtHorarioPartidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHorarioPartidaKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();

            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "DIGITE SOMENTE NUMEROS!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtHorarioPartidaKeyTyped

    FrmOnibus telaOnibus;

    private void btnAdicionarOnibusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarOnibusActionPerformed
        if (telaOnibus == null) {
            telaOnibus = new FrmOnibus();
            telaOnibus.setVisible(true);
        } else {
            telaOnibus.dispose();
            telaOnibus.setVisible(true);
        }
    }//GEN-LAST:event_btnAdicionarOnibusActionPerformed

    private void cbxEstado01ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxEstado01ItemStateChanged
        vetorCidadePartida = rotaBLL.listarCidades(cbxEstado01.getSelectedItem().toString());
        cbxCidadePartida.setModel(new DefaultComboBoxModel(vetorCidadePartida));
    }//GEN-LAST:event_cbxEstado01ItemStateChanged

    private void cbxEstado02ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxEstado02ItemStateChanged
        vetorCidadeDestino = rotaBLL.listarCidades(cbxEstado02.getSelectedItem().toString());
        cbxCidadeDestino.setModel(new DefaultComboBoxModel(vetorCidadeDestino));
    }//GEN-LAST:event_cbxEstado02ItemStateChanged

    private void txtPrecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecoKeyTyped
        Character ch = evt.getKeyChar();
        int comprimentoDeCampo = txtPreco.getText().length();
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
    }//GEN-LAST:event_txtPrecoKeyTyped

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
            java.util.logging.Logger.getLogger(FrmRotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRotas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarOnibus;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxCidadeDestino;
    private javax.swing.JComboBox<String> cbxCidadePartida;
    private javax.swing.JComboBox<String> cbxEstado01;
    private javax.swing.JComboBox<String> cbxEstado02;
    private javax.swing.JComboBox<String> cbxOnibus;
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
    private javax.swing.JTable tblRotas;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JFormattedTextField txtHorarioDestino;
    private javax.swing.JFormattedTextField txtHorarioPartida;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables
}
