package view;
/**
 * princiapl continue aqui
 * @author debian
 */
import connection.Conexao;
import controller.AplicacaoVacinaController;
import controller.PacienteController;
import model.beans.Paciente;
import controller.ProfissionalDeSaudeController;
import controller.VacinaController;
import java.sql.Connection;
import javax.swing.JOptionPane;
import model.beans.AplicacaoVacina;
import model.beans.ProfissionalDeSaude;
import model.beans.Vacina;
import model.table.AplicacaoVacinaTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
//branch exame
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
    getListaPacientes(); 

    cmbPacientes.setSelectedItem(paciente); 

    getAplicacaoVacina();
        
    }
    //problema no main
    public CadastroAplicacaoVacina() {
    this(new Paciente()); }

    
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
    tableModelAplicacaoVacina = new AplicacaoVacinaTableModel(
        aplicacaoVacinaController.getAplicacaoVacina(this.paciente.getId())
    );
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
        jlPaciente = new javax.swing.JLabel();
        jlLocalAplic = new javax.swing.JLabel();
        txtLocalAplic = new javax.swing.JTextField();
        jLabelData = new javax.swing.JLabel();
        jtfData = new javax.swing.JFormattedTextField();
        cmbPacientes = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTabela = new javax.swing.JTable();
        jLabelAplicacoes = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setForeground(new java.awt.Color(204, 255, 255));

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

        jlPaciente.setText("Paciente:");

        jlLocalAplic.setText("Local de Aplicação:");

        txtLocalAplic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocalAplicActionPerformed(evt);
            }
        });
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
        jtfData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDataActionPerformed(evt);
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
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelData)
                        .addGap(18, 18, 18)
                        .addComponent(jtfData, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlProfissional)
                            .addComponent(jlPaciente)
                            .addComponent(jllVacina)
                            .addComponent(jlLocalAplic))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbProfissional, 0, 541, Short.MAX_VALUE)
                            .addComponent(cmbVacina, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbPacientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtLocalAplic))))
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
                    .addComponent(txtLocalAplic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelData)
                    .addComponent(jtfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
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
        jLabelAplicacoes.setText("Aplicações-Vacinas");

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

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnImprimir.setText("imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnSalvar)
                        .addGap(57, 57, 57)
                        .addComponent(btnExcluir)
                        .addGap(71, 71, 71)
                        .addComponent(btnCancelar)
                        .addGap(35, 35, 35)
                        .addComponent(btnImprimir)
                        .addGap(43, 43, 43)
                        .addComponent(btnSair))
                    .addComponent(jLabelAplicacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabelAplicacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir)
                    .addComponent(btnCancelar)
                    .addComponent(btnSair)
                    .addComponent(btnImprimir))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
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


    Paciente pacienteSelecionado = (Paciente) cmbPacientes.getSelectedItem();
    Paciente pacienteParaAplicacao = new Paciente();
    pacienteParaAplicacao.setId(pacienteSelecionado.getId());
    pacienteParaAplicacao.setNome(pacienteSelecionado.getNome());
    pacienteParaAplicacao.setCpf(pacienteSelecionado.getCpf());
    pacienteParaAplicacao.setSexo(pacienteSelecionado.getSexo());
    pacienteParaAplicacao.setTelefone(pacienteSelecionado.getTelefone());
    pacienteParaAplicacao.setDataNascimento(pacienteSelecionado.getDataNascimento());
    pacienteParaAplicacao.setAlergias(pacienteSelecionado.getAlergias());

    // Obter o profissional selecionado e criar uma nova instância
    ProfissionalDeSaude profSelecionado = (ProfissionalDeSaude) cmbProfissional.getSelectedItem();
    ProfissionalDeSaude profissionalParaAplicacao = new ProfissionalDeSaude();
    profissionalParaAplicacao.setId(profSelecionado.getId());
    profissionalParaAplicacao.setNome(profSelecionado.getNome());
    profissionalParaAplicacao.setCpf(profSelecionado.getCpf());
    profissionalParaAplicacao.setRegistroProfissional(profSelecionado.getRegistroProfissional());

    // Obter a vacina selecionada e criar uma nova instância
    Vacina vacinaSelecionada = (Vacina) cmbVacina.getSelectedItem();
    Vacina vacinaParaAplicacao = new Vacina();
    vacinaParaAplicacao.setId(vacinaSelecionada.getId());
    vacinaParaAplicacao.setNome(vacinaSelecionada.getNome());
    vacinaParaAplicacao.setFabricante(vacinaSelecionada.getFabricante());
    vacinaParaAplicacao.setDosesNecessarias(vacinaSelecionada.getDosesNecessarias());

    boolean sucesso = aplicacaoVacinaController.create(
        pacienteParaAplicacao,
        profissionalParaAplicacao,
        vacinaParaAplicacao,
        jtfData.getText(),
        txtLocalAplic.getText()
    );

    if (sucesso) {
        this.paciente = pacienteParaAplicacao; 
        this.getAplicacaoVacina(); 
        JOptionPane.showMessageDialog(this, "Aplicação registrada");
    } else {
        JOptionPane.showMessageDialog(this, "Erro ao registrar aplicação.", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

    int linhaSelecionada = tbTabela.getSelectedRow();
    
    if (linhaSelecionada >= 0) {

           AplicacaoVacina aplicacao = tableModelAplicacaoVacina.getAplicacaoVacina(linhaSelecionada);
        if (aplicacao != null) {
            int idAplicacao = aplicacao.getId();
            if (aplicacaoVacinaController.delete(idAplicacao)) {
                JOptionPane.showMessageDialog(this, "Aplicação deletada");
            } else {
                JOptionPane.showMessageDialog(this, "erro deletar a aplicação", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            this.getAplicacaoVacina();  
        }
    } else {
        JOptionPane.showMessageDialog(this, "Selecione uma aplicação para excluir", "Atenção", JOptionPane.WARNING_MESSAGE);
    }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        btnSalvar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnCancelar.setEnabled(false);
        limpaCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
        InterfacePrincipal main = new InterfacePrincipal();
        main.setVisible(true);
    }//GEN-LAST:event_btnSairActionPerformed

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
        Paciente selecionado = (Paciente) cmbPacientes.getSelectedItem();
    if (selecionado != null) {
        this.paciente = selecionado;
        getAplicacaoVacina(); 
    }
        
    }//GEN-LAST:event_cmbPacientesActionPerformed

    private void cmbVacinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVacinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbVacinaActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
        Connection con = Conexao.getConnection();
        
        String src = "src/reports/aplicacao.jasper";
        
        JasperPrint jasperPrint = null;
        
        try{
            jasperPrint = JasperFillManager.fillReport(src, null, con);
        }catch(JRException ex){
            System.out.println("Erro ao gerar relatorio de vacinas do aplicação Vacinas: " + ex);
        }
        JasperViewer view = new JasperViewer(jasperPrint, false);
        view.setVisible(true);      
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void jtfDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDataActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jtfDataActionPerformed

    private void txtLocalAplicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocalAplicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocalAplicActionPerformed

//        public static void main(String args[]) {
//    /* Set the Nimbus look and feel */
//    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//     */
//    try {
//        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//            if ("Nimbus".equals(info.getName())) {
//                javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                break;
//            }
//        }
//    } catch (ClassNotFoundException ex) {
//        java.util.logging.Logger.getLogger(CadastroAplicacaoVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//    } catch (InstantiationException ex) {
//        java.util.logging.Logger.getLogger(CadastroAplicacaoVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//    } catch (IllegalAccessException ex) {
//        java.util.logging.Logger.getLogger(CadastroAplicacaoVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//        java.util.logging.Logger.getLogger(CadastroAplicacaoVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//    }
//    //</editor-fold>
//
//    /* Create and display the form */
//    java.awt.EventQueue.invokeLater(new Runnable() {
//        public void run() {
//            // probelma no main
//            Paciente pacienteFake = new Paciente();
//            pacienteFake.setId(1); 
//            pacienteFake.setNome("Paciente de Teste");
//            new CadastroAplicacaoVacina(pacienteFake).setVisible(true);
//        }
//    });
//}

    public static void main(String[] args) {
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (Exception ex) {
        java.util.logging.Logger.getLogger(CadastroAplicacaoVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }

    java.awt.EventQueue.invokeLater(() -> {
        new CadastroAplicacaoVacina().setVisible(true);
    });
}

    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cmbPacientes;
    private javax.swing.JComboBox cmbProfissional;
    private javax.swing.JComboBox cmbVacina;
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
