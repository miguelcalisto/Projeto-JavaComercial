package view;

import controller.AplicacaoVacinaController;
import controller.PacienteController;
import model.beans.Paciente;
import controller.ProfissionalDeSaudeController;
import controller.VacinaController;
import javax.swing.JOptionPane;
import model.beans.AplicacaoVacina;
import model.beans.ProfissionalDeSaude;
import model.beans.Vacina;
import model.table.AplicacaoVacinaTableModel;

public class CadastroAplicacaoVacina extends javax.swing.JFrame {
    
    public Paciente paciente;
    private boolean alterar = false;
    private int idAplicacaoVacina = 0;
    
    AplicacaoVacinaController aplicacaoVacinaController = new AplicacaoVacinaController();
    AplicacaoVacinaTableModel tableModelAplicacaoVacina;
    
    public CadastroAplicacaoVacina(Paciente paciente) {
         initComponents();
    this.paciente = paciente;

    getListaProfissionais();
    getListaVacinas();
    getListaPacientes(); // ← Popula o cmbPacientes antes de selecionar

    cmbPacientes.setSelectedItem(paciente); // ← Agora sim

    getAplicacaoVacina();
        
    }
    
    public void limpaCampos(){
        cmbProfissional.setSelectedIndex(-1);
        cmbVacina.setSelectedIndex(-1);
        txtLocalAplic.setText("");
        jtfData.setText("");
    }

    private void getListaProfissionais(){
        cmbProfissional.removeAllItems();
        ProfissionalDeSaudeController profissionalController = new ProfissionalDeSaudeController();
        
        for (ProfissionalDeSaude p : profissionalController.read()){
            cmbProfissional.addItem(p);
        }
    }
    
    private void getListaVacinas(){
        cmbVacina.removeAllItems();
        VacinaController vacinaController = new VacinaController();
        
        for (Vacina v : vacinaController.read()){
            cmbVacina.addItem(v);
        }
    }
    
    private void getListaPacientes() {
    cmbPacientes.removeAllItems();
    for (Paciente p : new PacienteController().read()) {
        cmbPacientes.addItem(p);
    }
}

    
    private void getAplicacaoVacina(){
        tableModelAplicacaoVacina = new AplicacaoVacinaTableModel(aplicacaoVacinaController.getAplicacaoVacina(this.paciente.getId()));
        
        tbTabela.setModel(tableModelAplicacaoVacina);
        
        limpaCampos();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlProfissional = new javax.swing.JLabel();
        cmbProfissional = new javax.swing.JComboBox();
        jllVacina = new javax.swing.JLabel();
        cmbVacina = new javax.swing.JComboBox();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jlPaciente = new javax.swing.JLabel();
        jlLocalAplic = new javax.swing.JLabel();
        txtLocalAplic = new javax.swing.JTextField();
        jLabelData = new javax.swing.JLabel();
        jtfData = new javax.swing.JFormattedTextField();
        btnCancelar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        cmbPacientes = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTabela = new javax.swing.JTable();
        jLabelAplicacoes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jlProfissional.setText("Profissional:");

        cmbProfissional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProfissionalActionPerformed(evt);
            }
        });

        jllVacina.setText("Vacina:");

        cmbVacina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVacinaActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jlPaciente.setText("Paciente:");

        jlLocalAplic.setText("Local de Aplicação:");

        txtLocalAplic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLocalAplicKeyTyped(evt);
            }
        });

        jLabelData.setText("Data de Aplicação:");

        try {
            jtfData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        cmbPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPacientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlProfissional)
                            .addComponent(jlPaciente)
                            .addComponent(jllVacina)
                            .addComponent(jlLocalAplic))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbProfissional, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbVacina, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtLocalAplic, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelData)
                                .addGap(18, 18, 18)
                                .addComponent(jtfData, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                            .addComponent(cmbPacientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnSalvar)
                        .addGap(40, 40, 40)
                        .addComponent(btnExcluir)
                        .addGap(36, 36, 36)
                        .addComponent(btnCancelar)
                        .addGap(40, 40, 40)
                        .addComponent(jButtonSair)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPaciente)
                    .addComponent(cmbPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlProfissional)
                    .addComponent(cmbProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbVacina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jllVacina))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlLocalAplic)
                    .addComponent(txtLocalAplic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelData)
                    .addComponent(jtfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir)
                    .addComponent(btnCancelar)
                    .addComponent(jButtonSair))
                .addGap(41, 41, 41))
        );

        tbTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbTabela);

        jLabelAplicacoes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelAplicacoes.setText("Aplicações");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(327, 327, 327)
                        .addComponent(jLabelAplicacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabelAplicacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        getListaProfissionais();
        getListaVacinas();
    }//GEN-LAST:event_formWindowOpened

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
//        ProfissionalDeSaude profissional = (ProfissionalDeSaude) cmbProfissional.getSelectedItem();
//        Vacina vacina = (Vacina) cmbVacina.getSelectedItem();
//        aplicacaoVacinaController.create(this.paciente, profissional, vacina, jtfData.getText(), txtLocalAplic.getText());
//        this.getAplicacaoVacina();

//   Paciente pacienteSelecionado = (Paciente) cmbPacientes.getSelectedItem();
//    ProfissionalDeSaude profissional = (ProfissionalDeSaude) cmbProfissional.getSelectedItem();
//    Vacina vacina = (Vacina) cmbVacina.getSelectedItem();
//
//    aplicacaoVacinaController.create(pacienteSelecionado, profissional, vacina, jtfData.getText(), txtLocalAplic.getText());
//    
//    this.paciente = pacienteSelecionado; // Atualiza o atributo da classe, se necessário
//    this.getAplicacaoVacina();


Paciente pacienteSelecionado = (Paciente) cmbPacientes.getSelectedItem();
Paciente pacienteParaAplicacao = new Paciente();
pacienteParaAplicacao.setId(pacienteSelecionado.getId());
pacienteParaAplicacao.setNome(pacienteSelecionado.getNome());
pacienteParaAplicacao.setCpf(pacienteSelecionado.getCpf());
pacienteParaAplicacao.setSexo(pacienteSelecionado.getSexo());
pacienteParaAplicacao.setTelefone(pacienteSelecionado.getTelefone());
pacienteParaAplicacao.setDataNascimento(pacienteSelecionado.getDataNascimento());
pacienteParaAplicacao.setAlergias(pacienteSelecionado.getAlergias());

ProfissionalDeSaude profSelecionado = (ProfissionalDeSaude) cmbProfissional.getSelectedItem();
ProfissionalDeSaude profissionalParaAplicacao = new ProfissionalDeSaude();
profissionalParaAplicacao.setId(profSelecionado.getId());
profissionalParaAplicacao.setNome(profSelecionado.getNome());
profissionalParaAplicacao.setCpf(profSelecionado.getCpf());
profissionalParaAplicacao.setRegistroProfissional(profSelecionado.getRegistroProfissional());

Vacina vacinaSelecionada = (Vacina) cmbVacina.getSelectedItem();
Vacina vacinaParaAplicacao = new Vacina();
vacinaParaAplicacao.setId(vacinaSelecionada.getId());
vacinaParaAplicacao.setNome(vacinaSelecionada.getNome());
vacinaParaAplicacao.setFabricante(vacinaSelecionada.getFabricante());
vacinaParaAplicacao.setDosesNecessarias(vacinaSelecionada.getDosesNecessarias());

aplicacaoVacinaController.create(pacienteParaAplicacao, profissionalParaAplicacao, vacinaParaAplicacao, jtfData.getText(), txtLocalAplic.getText());

this.paciente = pacienteParaAplicacao;
this.getAplicacaoVacina();

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
//        ProfissionalDeSaude profissional = (ProfissionalDeSaude) cmbProfissional.getSelectedItem();
//        Vacina vacina = (Vacina) cmbVacina.getSelectedItem();
//        if (aplicacaoVacinaController.delete(vacina.getId(), profissional.getId(), paciente.getId())){
//            JOptionPane.showMessageDialog(this, "Aplicacao deletada com sucesso!");
//        }else{
//            JOptionPane.showMessageDialog(this, "Não foi possível deletar a aplicação", "Erro", JOptionPane.ERROR_MESSAGE);
//        }
//        this.getAplicacaoVacina();
    int linhaSelecionada = tbTabela.getSelectedRow();
    
    if (linhaSelecionada >= 0) {

           AplicacaoVacina aplicacao = tableModelAplicacaoVacina.getAplicacaoVacina(linhaSelecionada);
        if (aplicacao != null) {
            int idAplicacao = aplicacao.getId();
            if (aplicacaoVacinaController.delete(idAplicacao)) {
                JOptionPane.showMessageDialog(this, "Aplicação deletada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Não foi possível deletar a aplicação", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            this.getAplicacaoVacina();  // Atualiza a lista/tabela
        }
    } else {
        JOptionPane.showMessageDialog(this, "Selecione uma aplicação para excluir", "Aviso", JOptionPane.WARNING_MESSAGE);
    }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        btnSalvar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnCancelar.setEnabled(false);
        limpaCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        this.dispose();
        InterfacePrincipal main = new InterfacePrincipal();
        main.setVisible(true);
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void txtLocalAplicKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocalAplicKeyTyped
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
    }//GEN-LAST:event_txtLocalAplicKeyTyped

    private void tbTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTabelaMouseClicked
        btnExcluir.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnSalvar.setEnabled(false);
            int linhaSelecionada = tbTabela.getSelectedRow();
    if (linhaSelecionada >= 0) {
        AplicacaoVacina aplicacao = tableModelAplicacaoVacina.getAplicacaoVacina(linhaSelecionada);

        cmbProfissional.setSelectedItem(aplicacao.getResponsavel());
        cmbVacina.setSelectedItem(aplicacao.getVacina());
        cmbPacientes.setSelectedItem(aplicacao.getPaciente());
        txtLocalAplic.setText(aplicacao.getLocalAplicacao());
        jtfData.setText(aplicacao.getDataAplicacao());

        btnExcluir.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnSalvar.setEnabled(false);
    }
    }//GEN-LAST:event_tbTabelaMouseClicked

    private void cmbProfissionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProfissionalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbProfissionalActionPerformed

    private void cmbPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPacientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPacientesActionPerformed

    private void cmbVacinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVacinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbVacinaActionPerformed

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
        java.util.logging.Logger.getLogger(CadastroAplicacaoVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(CadastroAplicacaoVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(CadastroAplicacaoVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(CadastroAplicacaoVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            // Aqui você pode trocar o "pacienteFake" por um paciente real quando for integrar
            Paciente pacienteFake = new Paciente();
            pacienteFake.setId(1); // ID válido do banco
            pacienteFake.setNome("Paciente de Teste");
            new CadastroAplicacaoVacina(pacienteFake).setVisible(true);
        }
    });
}

    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cmbPacientes;
    private javax.swing.JComboBox cmbProfissional;
    private javax.swing.JComboBox cmbVacina;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabelAplicacoes;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlLocalAplic;
    private javax.swing.JLabel jlPaciente;
    private javax.swing.JLabel jlProfissional;
    private javax.swing.JLabel jllVacina;
    private javax.swing.JFormattedTextField jtfData;
    private javax.swing.JTable tbTabela;
    private javax.swing.JTextField txtLocalAplic;
    // End of variables declaration//GEN-END:variables
}
