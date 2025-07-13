package view;

import controller.VacinaController;
import javax.swing.JOptionPane;
import model.beans.Vacina;
import model.beans.Vacina;
import model.table.VacinaTableModel;
import model.table.VacinaTableModel;

public class CadastroVacina extends javax.swing.JFrame {

    private boolean alterar = true;
    private int idVacina = 0;
    private Vacina vacina;
    
    VacinaTableModel tableModel;
    VacinaController vacinaController = new VacinaController();
    
    public CadastroVacina() {
        initComponents();
        
        if (vacina != null){
            preencheCampos(vacina);
            this.vacina = vacina;
        }else {
            txtNome.requestFocus();
        }
        
        tableModel = new VacinaTableModel(vacinaController.read());
        
        tbTabela.setModel(tableModel);
    }
    
    public void preencheCampos(Vacina vacina){
        this.idVacina = vacina.getId();
        txtNome.setText(vacina.getNome());
        txtFabricante.setText(vacina.getFabricante());
        txtDosesNec.setText(String.valueOf(vacina.getDosesNecessarias()));
        btnCdastrar.setEnabled(false);
        btnExcluir.setEnabled(true);
        this.alterar = true;
    }
    
    public void limpaCampos(){
        txtNome.setText("");
        txtFabricante.setText("");
        txtDosesNec.setText("");
    }
    
    private void getListaVacinas(){
        tableModel = new VacinaTableModel(vacinaController.read());
        tbTabela.setModel(tableModel);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelVacina = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        jlFabricante = new javax.swing.JLabel();
        jlDosesNec = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtFabricante = new javax.swing.JTextField();
        txtDosesNec = new javax.swing.JTextField();
        jcbBusca = new javax.swing.JComboBox<>();
        txtBusca = new javax.swing.JTextField();
        btnCdastrar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPanelTabela = new javax.swing.JScrollPane();
        tbTabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelVacina.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelVacina.setText("Vacina");

        jlNome.setText("Nome:");

        jlFabricante.setText("Fabricante:");

        jlDosesNec.setText("Doses Necessárias:");

        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomeKeyTyped(evt);
            }
        });

        txtFabricante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFabricanteKeyTyped(evt);
            }
        });

        txtDosesNec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDosesNecKeyTyped(evt);
            }
        });

        jcbBusca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Fabricante", "Doses" }));
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

        btnCdastrar.setText("Cadastrar");
        btnCdastrar.setEnabled(false);
        btnCdastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCdastrarActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar");
        btnAtualizar.setEnabled(false);
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

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
        jScrollPanelTabela.setViewportView(tbTabela);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(416, 416, 416)
                        .addComponent(jLabelVacina, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlDosesNec)
                            .addComponent(jlFabricante)
                            .addComponent(jlNome)
                            .addComponent(jcbBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCdastrar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNome)
                            .addComponent(txtFabricante)
                            .addComponent(txtDosesNec)
                            .addComponent(txtBusca)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAtualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExcluir))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jScrollPanelTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabelVacina, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlFabricante)
                    .addComponent(txtFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDosesNec)
                    .addComponent(txtDosesNec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCdastrar)
                    .addComponent(btnAtualizar)
                    .addComponent(btnExcluir)
                    .addComponent(btnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(jScrollPanelTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCdastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCdastrarActionPerformed
        if (vacinaController.create(txtNome.getText(), txtFabricante.getText(), Integer.parseInt(txtDosesNec.getText()))){
            JOptionPane.showMessageDialog(this, "Vacina salva com sucesso!");
        }else {
            JOptionPane.showMessageDialog(this, "Não foi possível salvar a vacina", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        this.getListaVacinas();
        limpaCampos();
    }//GEN-LAST:event_btnCdastrarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        if (vacinaController.update(idVacina, txtNome.getText(), txtFabricante.getText(), Integer.parseInt(txtDosesNec.getText()))){
            JOptionPane.showMessageDialog(this, "Vacina atualizada com sucesso!");
        }else{
            JOptionPane.showMessageDialog(this, "Não foi possível atualizar a vacina!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        this.getListaVacinas();
        limpaCampos();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        btnCdastrar.setEnabled(true);
        btnAtualizar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnExcluir.setEnabled(false);
        alterar = false;
        limpaCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyTyped
        if (alterar){
            btnCdastrar.setEnabled(true);
            btnAtualizar.setEnabled(true);
            btnExcluir.setEnabled(false);
            btnCancelar.setEnabled(true);
        }
    }//GEN-LAST:event_txtNomeKeyTyped

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (vacinaController.delete(idVacina)){
            JOptionPane.showMessageDialog(this, "Vacina deletada com sucesso!");
        }else {
            JOptionPane.showMessageDialog(this, "Não foi possível deletar a vacina!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        this.getListaVacinas();
        limpaCampos();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jcbBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbBuscaActionPerformed
        txtBusca.setText("");
        if (jcbBusca.getSelectedIndex() == 0){
            tableModel = new VacinaTableModel(vacinaController.read());
            tbTabela.setModel(tableModel);
        }
        txtBusca.requestFocus();
    }//GEN-LAST:event_jcbBuscaActionPerformed

    private void tbTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTabelaMouseClicked
        tableModel = (VacinaTableModel) tbTabela.getModel();
        Vacina vacina = tableModel.getVacina(tbTabela.getSelectedRow());
        idVacina = vacina.getId();
        txtNome.setText(vacina.getNome());
        txtFabricante.setText(vacina.getFabricante());
        txtDosesNec.setText(String.valueOf(vacina.getDosesNecessarias()));
        btnExcluir.setEnabled(true);
        btnCdastrar.setEnabled(false);
        btnCdastrar.setEnabled(true);
        btnCancelar.setEnabled(true);
        this.alterar = true;
    }//GEN-LAST:event_tbTabelaMouseClicked

    private void txtBuscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyTyped
        String chave = txtBusca.getText(); //CORRIGIR!!
        if (chave.equals("")){
            chave = String.valueOf(evt.getKeyChar());
        }else if (evt.getKeyChar() != '\b'){
            chave = chave + evt.getKeyChar();
        }
        switch(jcbBusca.getSelectedIndex()){
            case 0:
                tableModel = new VacinaTableModel(vacinaController.getVacinasNome(chave));
                break;
            case 1:
                tableModel = new VacinaTableModel(vacinaController.getVacinasFabricante(chave));
                break;
            case 2:
                tableModel = new VacinaTableModel(vacinaController.getVacinasDoses(Integer.parseInt(chave)));
                break;
        }
        tbTabela.setModel(tableModel);
    }//GEN-LAST:event_txtBuscaKeyTyped

    private void txtFabricanteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFabricanteKeyTyped
        if (alterar){
            btnCdastrar.setEnabled(true);
            btnAtualizar.setEnabled(true);
            btnExcluir.setEnabled(false);
            btnCancelar.setEnabled(true);
        }
    }//GEN-LAST:event_txtFabricanteKeyTyped

    private void txtDosesNecKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDosesNecKeyTyped
       if (alterar){
            btnCdastrar.setEnabled(true);
            btnAtualizar.setEnabled(true);
            btnExcluir.setEnabled(false);
            btnCancelar.setEnabled(true);
        }
    }//GEN-LAST:event_txtDosesNecKeyTyped

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
            java.util.logging.Logger.getLogger(CadastroVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroVacina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCdastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabelVacina;
    private javax.swing.JScrollPane jScrollPanelTabela;
    private javax.swing.JComboBox<String> jcbBusca;
    private javax.swing.JLabel jlDosesNec;
    private javax.swing.JLabel jlFabricante;
    private javax.swing.JLabel jlNome;
    private javax.swing.JTable tbTabela;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextField txtDosesNec;
    private javax.swing.JTextField txtFabricante;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
