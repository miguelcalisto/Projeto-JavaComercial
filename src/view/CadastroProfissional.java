package view;

import controller.ProfissionalDeSaudeController;
import javax.swing.JOptionPane;
import model.beans.ProfissionalDeSaude;
import model.table.ProfissionalDeSaudeTableModel;

public class CadastroProfissional extends javax.swing.JFrame {
    
    private boolean alterar = true;
    private int idProfissional = 0;
    private ProfissionalDeSaude profissional;
    
    ProfissionalDeSaudeTableModel tableModel;
    ProfissionalDeSaudeController profissionalController = new ProfissionalDeSaudeController();

    public CadastroProfissional() {
        initComponents();
        
        if (profissional != null){
            preencheCampos(profissional);
            this.profissional = profissional;
        }else {
            txtNome.requestFocus();
        }
        
        tableModel = new ProfissionalDeSaudeTableModel(profissionalController.read());
        
        tbProfissional.setModel(tableModel);
    }
    
    public void preencheCampos(ProfissionalDeSaude profissional){
        this.idProfissional = profissional.getId();
        txtNome.setText(profissional.getNome());
        jftCPF.setText(profissional.getCpf());
        txtRegistro.setText(profissional.getRegistroProfissional());
        btnCadastrar.setEnabled(false);
        btnExcluir.setEnabled(true);
        this.alterar = true;
    }
    
    public void limpaCampos(){
        txtNome.setText("");
        jftCPF.setText("");
        txtRegistro.setText("");
        txtNome.requestFocus();
    }
    
    private void getListaProfissionais(){
        tableModel = new ProfissionalDeSaudeTableModel(profissionalController.read());
        tbProfissional.setModel(tableModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlProfissional = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        jlCPF = new javax.swing.JLabel();
        jlRegistro = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jftCPF = new javax.swing.JFormattedTextField();
        txtRegistro = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProfissional = new javax.swing.JTable();
        btnCadastrar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cbbBusca = new javax.swing.JComboBox<>();
        txtBusca = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CadastroProfissionalSaude");

        jlProfissional.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlProfissional.setText("Cadastro-Profissional");

        jlNome.setText("Nome:");

        jlCPF.setText("CPF:");

        jlRegistro.setText("Registro:");

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

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        tbProfissional.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbProfissional.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProfissionalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbProfissional);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
        );

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

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        cbbBusca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "CPF", "Registro" }));
        cbbBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbBuscaActionPerformed(evt);
            }
        });

        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbbBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jlCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jlRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jftCPF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                            .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRegistro))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(jlProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jlProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCPF)
                    .addComponent(jftCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlRegistro)
                    .addComponent(txtRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if(txtNome.getText().isEmpty() ||
           jftCPF.getText().isEmpty() ||
           txtRegistro.getText().isEmpty()){
        JOptionPane.showMessageDialog(this, "Preencha os campos obrigatórios!");
        return;
        }
        if(profissionalController.create(txtNome.getText(),
                jftCPF.getText(),
                txtRegistro.getText())){
            JOptionPane.showMessageDialog(this, "Profissional salvo com sucesso!");
        }else{
            JOptionPane.showMessageDialog(this, "Nao foi possivel salvar o profissional!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        this.getListaProfissionais();
        limpaCampos();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
       boolean sucesso = profissionalController.update(
        idProfissional,
        jftCPF.getText(),        
        txtRegistro.getText(),   
        txtNome.getText()        
    );

    if (sucesso) {
        JOptionPane.showMessageDialog(this, "Profissional atualizado com sucesso!");
    } else {
        JOptionPane.showMessageDialog(this, "Não foi possível atualizar o profissional!", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    this.getListaProfissionais();
    limpaCampos();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (profissionalController.delete(idProfissional)){
            JOptionPane.showMessageDialog(this, "Profissional deletado com sucesso!");
        }else {
            JOptionPane.showMessageDialog(this, "Não foi possível deletar o profissional!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        this.getListaProfissionais();
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

    private void txtNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyTyped
        if (alterar){
            btnCadastrar.setEnabled(true);
            btnAtualizar.setEnabled(true);
            btnExcluir.setEnabled(false);
            btnCancelar.setEnabled(true);
        }
    }//GEN-LAST:event_txtNomeKeyTyped

    private void cbbBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbBuscaActionPerformed
        txtBusca.setText("");
        if (cbbBusca.getSelectedIndex() == 0){
            tableModel = new ProfissionalDeSaudeTableModel(profissionalController.read());
            tbProfissional.setModel(tableModel);
        }
        txtBusca.requestFocus();
    }//GEN-LAST:event_cbbBuscaActionPerformed

    private void txtBuscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyTyped
        String chave = txtBusca.getText(); 
        if (chave.equals("")){
            chave = String.valueOf(evt.getKeyChar());
        }else if (evt.getKeyChar() != '\b'){
            chave = chave + evt.getKeyChar();
        }
        switch(cbbBusca.getSelectedIndex()){
            case 0:
                tableModel = new ProfissionalDeSaudeTableModel(profissionalController.getProfissionalNome(chave));
                break;
            case 1:
                tableModel = new ProfissionalDeSaudeTableModel(profissionalController.getProfissionalCpf(chave));
                break;
            case 2:
                tableModel = new ProfissionalDeSaudeTableModel(profissionalController.getProfissionalRegistro(chave));
                break;
        }
        tbProfissional.setModel(tableModel);
    }//GEN-LAST:event_txtBuscaKeyTyped

    private void tbProfissionalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProfissionalMouseClicked
        tableModel = (ProfissionalDeSaudeTableModel) tbProfissional.getModel();
        ProfissionalDeSaude profissional = tableModel.getProfissionalSaude(tbProfissional.getSelectedRow());
        idProfissional = profissional.getId();
        txtNome.setText(profissional.getNome());
        jftCPF.setText(profissional.getCpf());
        txtRegistro.setText(profissional.getRegistroProfissional());
        btnExcluir.setEnabled(true);
        btnCadastrar.setEnabled(false);
        btnCadastrar.setEnabled(true);
        btnCancelar.setEnabled(true);
        this.alterar = true;
    }//GEN-LAST:event_tbProfissionalMouseClicked

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
            java.util.logging.Logger.getLogger(CadastroProfissional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroProfissional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroProfissional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroProfissional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroProfissional().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JComboBox<String> cbbBusca;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField jftCPF;
    private javax.swing.JLabel jlCPF;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlProfissional;
    private javax.swing.JLabel jlRegistro;
    private javax.swing.JTable tbProfissional;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRegistro;
    // End of variables declaration//GEN-END:variables
}
