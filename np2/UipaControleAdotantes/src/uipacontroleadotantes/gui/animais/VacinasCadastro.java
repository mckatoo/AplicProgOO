/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uipacontroleadotantes.gui.animais;

import uipacontroleadotantes.gui.adotantes.*;
import java.awt.Component;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import uipacontroleadotantes.banco.adotantes.AdotantesBean.AdotantesBean;
import uipacontroleadotantes.banco.adotantes.AdotantesBean.AdotantesDAO;

/**
 *
 * @author mckatoo
 */
public class VacinasCadastro extends javax.swing.JInternalFrame {

    /**
     * Creates new form AdotantesCadastro
     */
    AdotantesTableModel model = new AdotantesTableModel();

    public VacinasCadastro() {
        initComponents();
        limparCampos();
        setFrameIcon(new ImageIcon(this.getClass().getResource("/uipacontroleadotantes/assets/seringa-24x24.png")));
        tblAnimais.setModel(model);
        preencherTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        btnCadastrar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAnimais = new javax.swing.JTable();

        setClosable(true);
        setTitle("Cadastro de Vacinas");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setText("Nome:");

        txtNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txtNome.setName(""); // NOI18N
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeKeyReleased(evt);
            }
        });

        jLabel10.setText("Descrição:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(txtNome))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        btnCadastrar.setBackground(new java.awt.Color(255, 51, 102));
        btnCadastrar.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        btnCadastrar.setNextFocusableComponent(btnLimpar);
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnLimpar.setBackground(new java.awt.Color(255, 51, 102));
        btnLimpar.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        btnLimpar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpar.setText("Limpar");
        btnLimpar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnAtualizar.setBackground(new java.awt.Color(255, 51, 102));
        btnAtualizar.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        btnAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnAtualizar.setText("Atualizar");
        btnAtualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        btnAtualizar.setEnabled(false);
        btnAtualizar.setNextFocusableComponent(btnLimpar);
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnPesquisar.setBackground(new java.awt.Color(255, 51, 102));
        btnPesquisar.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        btnPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        btnPesquisar.setNextFocusableComponent(btnLimpar);
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(204, 0, 51));
        btnExcluir.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("Excluir");
        btnExcluir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        btnExcluir.setEnabled(false);
        btnExcluir.setNextFocusableComponent(btnLimpar);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addContainerGap())
        );

        tblAnimais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblAnimais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAnimaisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAnimais);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
        preencherTable();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
//        if (verificarCamposObrigatorios()) {
//            AdotantesBean adotanteBean = new AdotantesBean();
//            adotanteBean.setNome(txtNome.getText());
//            adotanteBean.setTelefone(txtTelefone.getText());
//            adotanteBean.setCelular(txtCelular.getText());
//            adotanteBean.setEndereco(txtIdade.getText());
//            adotanteBean.setBairro(txtBairro.getText());
//            adotanteBean.setCidade(txtCidade.getText());
//            if (cbEspecie.getSelectedIndex() > 0) {
//                adotanteBean.setUF(cbEspecie.getSelectedItem().toString().split(" - ")[0]);
//            }
//            adotanteBean.setCPF(txtCPF.getText());
//            adotanteBean.setRG(txtRG.getText());
//            if (cbSexo.getSelectedIndex() > 0) {
//                char[] sexo = cbSexo.getSelectedItem().toString().split("")[0].toCharArray();
//                adotanteBean.setSexo(sexo);
//            }
//            adotanteBean.setEmail(txtEmail.getText());
//
//            AdotantesDAO adotantesDAO = new AdotantesDAO();
//
//            try {
//                int codAdotante = adotantesDAO.inserir(adotanteBean);
//                adotanteBean.setCodAdotante(codAdotante);
//            } catch (SQLException ex) {
//                Logger.getLogger(AnimaisCadastro.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            limparCampos();
//            model.addRow(adotanteBean);
//        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        preencherTable();
    }//GEN-LAST:event_formComponentShown

    private void tblAnimaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAnimaisMouseClicked
//        if (evt.getClickCount() == 2) {
//            int linha = tblAdotantes.getSelectedRow();
//            limparCampos();
//            txtNome.setText(tblAdotantes.getValueAt(linha, 1).toString());
//            txtTelefone.setText(tblAdotantes.getValueAt(linha, 2).toString());
//            txtCelular.setText(tblAdotantes.getValueAt(linha, 3).toString());
//            txtIdade.setText(tblAdotantes.getValueAt(linha, 4).toString());
//            txtBairro.setText(tblAdotantes.getValueAt(linha, 5).toString());
//            txtCidade.setText(tblAdotantes.getValueAt(linha, 6).toString());
//            if (tblAdotantes.getValueAt(linha, 7) != null) {
//                for (int i = 0; i < cbEspecie.getItemCount(); i++) {
//                    if (cbEspecie.getItemAt(i).split(" - ")[0].equals(tblAdotantes.getValueAt(linha, 7).toString())) {
//                        cbEspecie.setSelectedIndex(i);
//                    }
//                }
//            }
//            txtCPF.setText(tblAdotantes.getValueAt(linha, 8).toString());
//            txtRG.setText(tblAdotantes.getValueAt(linha, 9).toString());
//            if (tblAdotantes.getValueAt(linha, 10) != null) {
//                for (int i = 0; i < cbSexo.getItemCount(); i++) {
//                    if (cbSexo.getItemAt(i).split(" - ")[0].equals(tblAdotantes.getValueAt(linha, 10).toString())) {
//                        cbSexo.setSelectedIndex(i);
//                    }
//                }
//            }
//            txtEmail.setText(tblAdotantes.getValueAt(linha, 11).toString());
//            txtNome.requestFocus();
//            btnAtualizar.setEnabled(true);
//            btnExcluir.setEnabled(true);
//            btnCadastrar.setEnabled(false);
//        }
    }//GEN-LAST:event_tblAnimaisMouseClicked

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        txtNome.setText(txtNome.getText().toUpperCase());
    }//GEN-LAST:event_txtNomeKeyReleased

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
//        if (verificarCamposObrigatorios()) {
//            AdotantesBean adotanteBean = new AdotantesBean();
//            int linha = tblAdotantes.getSelectedRow();
//            if (linha < 0) {
//                return;
//            }
//            int codAdotante = Integer.parseInt(tblAdotantes.getValueAt(linha, 0).toString());
//            adotanteBean.setCodAdotante(codAdotante);
//            adotanteBean.setNome(txtNome.getText());
//            adotanteBean.setTelefone(txtTelefone.getText());
//            adotanteBean.setCelular(txtCelular.getText());
//            adotanteBean.setEndereco(txtIdade.getText());
//            adotanteBean.setBairro(txtBairro.getText());
//            adotanteBean.setCidade(txtCidade.getText());
//            if (cbEspecie.getSelectedIndex() > 0) {
//                adotanteBean.setUF(cbEspecie.getSelectedItem().toString().split(" - ")[0]);
//            }
//            adotanteBean.setCPF(txtCPF.getText());
//            adotanteBean.setRG(txtRG.getText());
//            if (cbSexo.getSelectedIndex() > 0) {
//                char[] sexo = cbSexo.getSelectedItem().toString().split("")[0].toCharArray();
//                adotanteBean.setSexo(sexo);
//            }
//            adotanteBean.setEmail(txtEmail.getText());
//
//            AdotantesDAO adotantesDAO = new AdotantesDAO();
//
//            try {
//                adotantesDAO.alterar(adotanteBean);
//            } catch (SQLException ex) {
//                Logger.getLogger(AnimaisCadastro.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            model.setValueAt(String.valueOf(codAdotante), linha, 0);
//            model.setValueAt(txtNome.getText(), linha, 1);
//            model.setValueAt(txtTelefone.getText(), linha, 2);
//            model.setValueAt(txtCelular.getText(), linha, 3);
//            model.setValueAt(txtIdade.getText(), linha, 4);
//            model.setValueAt(txtBairro.getText(), linha, 5);
//            model.setValueAt(txtCidade.getText(), linha, 6);
//            model.setValueAt(cbEspecie.getSelectedItem().toString().split(" - ")[0], linha, 7);
//            model.setValueAt(txtCPF.getText(), linha, 8);
//            model.setValueAt(txtRG.getText(), linha, 9);
//            model.setValueAt(cbSexo.getSelectedItem().toString().split(" - ")[0], linha, 10);
//            model.setValueAt(txtEmail.getText(), linha, 11);
//
//            limparCampos();
//        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        AdotantesDAO adotantesDAO = new AdotantesDAO();
        limparModel();
        if (!txtNome.getText().equals("")) {
            adotantesDAO.pesquisarPorNome(txtNome.getText()).forEach((adotantes) -> {
                model.addRow(adotantes);
            });
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = tblAnimais.getSelectedRow();
        int codAdotante = Integer.parseInt(tblAnimais.getValueAt(linha, 0).toString());
        String nome = tblAnimais.getValueAt(linha, 1).toString();
        if (codAdotante > 0) {
            int permissao = JOptionPane.showConfirmDialog(null, "TEM CERTEZA QUE DESEJA APAGAR A VACINA " + nome + "?", "EXCLUIR?", JOptionPane.YES_NO_OPTION);
            if (permissao == 0) {
                AdotantesDAO adotantesDAO = new AdotantesDAO();
                try {
                    adotantesDAO.excluir(codAdotante);
                    model.removeRow(linha);
                } catch (SQLException ex) {
                    Logger.getLogger(VacinasCadastro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            limparCampos();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable tblAnimais;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables

    private void limparCampos() {
        Component[] cmps = jPanel1.getComponents();
        for (Component c : cmps) {
            if (c instanceof JTextField) {
                ((JTextField) c).setText("");
            }
            if (c instanceof JFormattedTextField) {
                ((JFormattedTextField) c).setText(null);
            }
            if (c instanceof JComboBox) {
                ((JComboBox) c).setSelectedIndex(0);
            }
        }
        btnCadastrar.setEnabled(true);
        btnAtualizar.setEnabled(false);
        btnExcluir.setEnabled(false);
    }

    private boolean verificarCamposObrigatorios() {
//        if (txtNome.getText().equals("")) {
//            JOptionPane.showMessageDialog(null, "CAMPO NOME VAZIO.");
//            txtNome.requestFocus();
//            return false;
//        }
//        if (txtIdade.getText().equals("")) {
//            JOptionPane.showMessageDialog(null, "CAMPO ENDEREÇO VAZIO.");
//            txtIdade.requestFocus();
//            return false;
//        }
//        if (txtBairro.getText().equals("")) {
//            JOptionPane.showMessageDialog(null, "CAMPO BAIRRO VAZIO.");
//            txtBairro.requestFocus();
//            return false;
//        }
//        if (txtCidade.getText().equals("")) {
//            JOptionPane.showMessageDialog(null, "CAMPO CIDADE VAZIO.");
//            txtCidade.requestFocus();
//            return false;
//        }
//        if (cbEspecie.getSelectedIndex() < 1) {
//            JOptionPane.showMessageDialog(null, "CAMPO ESTADO VAZIO.");
//            cbEspecie.requestFocus();
//            return false;
//        }
//        if (txtRG.getText().equals("")) {
//            JOptionPane.showMessageDialog(null, "CAMPO RG VAZIO.");
//            txtRG.requestFocus();
//            return false;
//        }
//        if (txtCPF.getText().equals("")) {
//            JOptionPane.showMessageDialog(null, "CAMPO CPF VAZIO.");
//            txtCPF.requestFocus();
//            return false;
//        }
        return true;
    }

    private void preencherTable() {
        AdotantesDAO adotantesDAO = new AdotantesDAO();
        limparModel();
        try {
            for (AdotantesBean cliente : adotantesDAO.listarTodos()) {
                model.addRow(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VacinasCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void limparModel() {
        for (int i = model.getRowCount() - 1; i > -1; i--) {
            model.removeRow(i);
        }
    }
}
