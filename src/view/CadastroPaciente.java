package view;
/**
 * princiapl continue aqui
 * @author debian
 */
import connection.Conexao;
import controller.PacienteController;
import java.sql.Connection;
import javax.swing.JOptionPane;
import model.beans.Paciente;
import model.beans.Paciente;
import model.table.PacienteTableModel;
import model.table.PacienteTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class CadastroPaciente extends javax.swing.JFrame {

    private boolean alterar = true;
    private int idPaciente = 0;
    private Paciente paciente;
    
    PacienteTableModel tableModel;
    PacienteController pacienteController = new PacienteController();
     
    public CadastroPaciente() {
        initComponents();
        
        if (paciente != null){
            preencheCampos(paciente);
            this.paciente = paciente;
        }else{
            txtNome.requestFocus();
        }
        
        tableModel = new PacienteTableModel(pacienteController.read());
        
        jTablePacientes.setModel(tableModel);

    }
    
    private void preencheCampos(Paciente paciente){
        this.idPaciente = paciente.getId();
        txtNome.setText(paciente.getNome());
        jtfTelefone.setText(paciente.getTelefone());
        jtfDataNascimento.setText(paciente.getDataNascimento());
        txtAlergias.setText(paciente.getAlergias());
        jftCPF.setText(paciente.getCpf());
        buttonGroupSexo.clearSelection();
        btnCadastrar.setEnabled(false);
        btnCadastrar.setEnabled(false);
        btnExcluir.setEnabled(true);
        this.alterar = true;        
    }
    
    private void limpaCampos(){
        jtfTelefone.setText("");
        jtfDataNascimento.setText("");
        txtAlergias.setText("");
        buttonGroupSexo.clearSelection();
        jftCPF.setText("");
        txtNome.setText("");
        txtNome.requestFocus();
    }
    
    public void getListaPacientes(){
        tableModel = new PacienteTableModel(pacienteController.read());
        jTablePacientes.setModel(tableModel);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupSexo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jlNome = new javax.swing.JLabel();
        jlCPF = new javax.swing.JLabel();
        jlSexo = new javax.swing.JLabel();
        jlAlergias = new javax.swing.JLabel();
        jlNacimento = new javax.swing.JLabel();
        jlTelefone = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtAlergias = new javax.swing.JTextField();
        jftCPF = new javax.swing.JFormattedTextField();
        jtfDataNascimento = new javax.swing.JFormattedTextField();
        jtfTelefone = new javax.swing.JFormattedTextField();
        jrMasculino = new javax.swing.JRadioButton();
        jrFeminino = new javax.swing.JRadioButton();
        btnCadastrar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePacientes = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        jcbBusca = new javax.swing.JComboBox<>();
        txtBusca = new javax.swing.JTextField();
        btnImprimir = new javax.swing.JButton();
        jLabelCadastro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(741, 900));

        jlNome.setText("Nome");

        jlCPF.setText("CPF");

        jlSexo.setText("Sexo");

        jlAlergias.setText("Alergias");

        jlNacimento.setText("Data Nascimento");

        jlTelefone.setText("Telefone");

        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomeKeyTyped(evt);
            }
        });

        try {
            jftCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jtfDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jtfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)  ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        buttonGroupSexo.add(jrMasculino);
        jrMasculino.setText("Masculino");

        buttonGroupSexo.add(jrFeminino);
        jrFeminino.setText("Feminino");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setEnabled(false);
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar");
        btnAtualizar.setEnabled(false);
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jTablePacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTablePacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePacientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePacientes);

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jcbBusca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "CPF", "Sexo" }));
        jcbBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbBuscaActionPerformed(evt);
            }
        });

        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscaKeyTyped(evt);
            }
        });

        btnImprimir.setText("imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnImprimir))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(32, 32, 32))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlNome)
                            .addComponent(jlCPF)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jlNacimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfDataNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(jftCPF)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlSexo)
                                .addGap(82, 82, 82)
                                .addComponent(jrMasculino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jrFeminino))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlTelefone)
                                    .addComponent(jlAlergias))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(jtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlNome))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jftCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlCPF))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlNacimento))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlAlergias))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlTelefone))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrFeminino)
                    .addComponent(jrMasculino)
                    .addComponent(jlSexo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabelCadastro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelCadastro.setText("Cadastro-Paciente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelCadastro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        //validacao dos campos obrigatorios
        if (txtNome.getText().isEmpty() ||
            jftCPF.getText().isEmpty() ||
            jtfTelefone.getText().isEmpty() ||
            jtfDataNascimento.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Prencha todos os campos obrigatórios");
                return;
        }
        String sexo = "";
        if (jrMasculino.isSelected())
            sexo = "Masculino";
        else if (jrFeminino.isSelected())
            sexo = "Feminino";
        else
            JOptionPane.showMessageDialog(this, "Selecione o sexo do paciente!");
        //solucao probelma datas 
        String dataRegex = "^(0[1-9]|[12][0-9]||3[01]/(0[1-9]|1[0-2]/\\d{4}))$";
        if (jtfDataNascimento.getText().matches(dataRegex)){
            JOptionPane.showMessageDialog(this, "Data Invalida!");
            return;
        }
        if (pacienteController.create(jtfTelefone.getText(),
            jtfDataNascimento.getText(),
            txtAlergias.getText(),
            sexo,
            jftCPF.getText(),
            txtNome.getText())){
        this.getListaPacientes();
        limpaCampos();
        JOptionPane.showMessageDialog(this, "Paciente salvo com sucesso!");
        }else{
            JOptionPane.showMessageDialog(this, "Nao foi possivel salvar o paciente!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        String sexo = "";
    if (jrMasculino.isSelected())
        sexo = "Masculino";
    else if (jrFeminino.isSelected())
        sexo = "Feminino";
    else {
        JOptionPane.showMessageDialog(this, "Selecione o sexo do paciente!");
        return; 
    }

    boolean sucesso = pacienteController.update(
        idPaciente,
        jtfTelefone.getText(),
        jtfDataNascimento.getText(), 
        txtAlergias.getText(),
        sexo,
        jftCPF.getText(),
        txtNome.getText()
    );

    if (sucesso) {
        JOptionPane.showMessageDialog(this, "Paciente atualizado com sucesso!");
    } else {
        JOptionPane.showMessageDialog(this, "Não foi possível atualizar o paciente!", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    this.getListaPacientes();
    limpaCampos();

        
  
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (pacienteController.delete(idPaciente)){
            JOptionPane.showMessageDialog(this, "Paciente deletado com sucesso!");
        }else {
            JOptionPane.showMessageDialog(this, "Não foi possível deletar o paciente!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        this.getListaPacientes();
        limpaCampos();
        
 
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        btnCadastrar.setEnabled(true);
        btnAtualizar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnExcluir.setEnabled(false);
        alterar = false;
        limpaCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jcbBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbBuscaActionPerformed
        txtBusca.setText("");
        if (jcbBusca.getSelectedIndex() == 0){
            tableModel = new PacienteTableModel(pacienteController.read());
            jTablePacientes.setModel(tableModel);
        }
        txtBusca.requestFocus();
    }//GEN-LAST:event_jcbBuscaActionPerformed

    private void jTablePacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePacientesMouseClicked
        tableModel = (PacienteTableModel) jTablePacientes.getModel();
        Paciente paciente = tableModel.getPaciente(jTablePacientes.getSelectedRow());
        idPaciente = paciente.getId();
        txtNome.setText(paciente.getNome());
        jftCPF.setText(paciente.getCpf());
        jtfTelefone.setText(paciente.getTelefone());
        jtfDataNascimento.setText(paciente.getDataNascimento());
        txtAlergias.setText(paciente.getAlergias());
        btnExcluir.setEnabled(true);
        btnCadastrar.setEnabled(false);
        btnCadastrar.setEnabled(true);
        btnCancelar.setEnabled(true);
        this.alterar = true;        
    }//GEN-LAST:event_jTablePacientesMouseClicked

    private void txtBuscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyTyped
        String chave = txtBusca.getText(); 
        if (chave.equals("")){
            chave = String.valueOf(evt.getKeyChar());
        }else if (evt.getKeyChar() != '\b'){
            chave = chave + evt.getKeyChar();
        }
        switch(jcbBusca.getSelectedIndex()){
            case 0:
                tableModel = new PacienteTableModel(pacienteController.getPacientesNome(chave));
                break;
            case 1:
                tableModel = new PacienteTableModel(pacienteController.getPacientesCpf(chave));
                break;
        }
        jTablePacientes.setModel(tableModel);
    }//GEN-LAST:event_txtBuscaKeyTyped

    private void txtNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyTyped
        if (alterar){
            btnCadastrar.setEnabled(true);
            btnAtualizar.setEnabled(true);
            btnExcluir.setEnabled(false);
            btnCancelar.setEnabled(true);
        }        
    }//GEN-LAST:event_txtNomeKeyTyped

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
         Connection con = Conexao.getConnection();
        
        String src = "src/reports/Paciente.jasper";
        
        JasperPrint jasperPrint = null;
        
        try{
            jasperPrint = JasperFillManager.fillReport(src, null, con);
        }catch(JRException ex){
            System.out.println("Erro ao gerar relatorio de pacientes: " + ex);
        }
        JasperViewer view = new JasperViewer(jasperPrint, false);
        view.setVisible(true);

    }//GEN-LAST:event_btnImprimirActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
      
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnImprimir;
    private javax.swing.ButtonGroup buttonGroupSexo;
    private javax.swing.JLabel jLabelCadastro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePacientes;
    private javax.swing.JComboBox<String> jcbBusca;
    private javax.swing.JFormattedTextField jftCPF;
    private javax.swing.JLabel jlAlergias;
    private javax.swing.JLabel jlCPF;
    private javax.swing.JLabel jlNacimento;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlSexo;
    private javax.swing.JLabel jlTelefone;
    private javax.swing.JRadioButton jrFeminino;
    private javax.swing.JRadioButton jrMasculino;
    private javax.swing.JFormattedTextField jtfDataNascimento;
    private javax.swing.JFormattedTextField jtfTelefone;
    private javax.swing.JTextField txtAlergias;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
