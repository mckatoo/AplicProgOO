/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.gui;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import loja.banco.tabelas.notas.NotaFiscalBean;
import loja.banco.tabelas.notas.NotaFiscalDAO;
import loja.table_model.NotasTableModel;

/**
 *
 * @author mckatoo
 */
public class NotasGUI extends javax.swing.JFrame {

    /**
     * Creates new form NotasGUI
     */
    NotasTableModel model = new NotasTableModel();

    public NotasGUI() {
        initComponents();
        jTableNotas.setModel(model);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnPesquisar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        txtSerie = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        rbAtivas = new javax.swing.JRadioButton();
        rbCanceladas = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDataInicial = new javax.swing.JFormattedTextField();
        txtDataFinal = new javax.swing.JFormattedTextField();
        rbTodas = new javax.swing.JRadioButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableNotas = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Notas Fiscais"));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnPesquisar.setText("Pesquisar");

        btnCancelar.setText("Cancelar Nota");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Número:");

        jLabel2.setText("Série:");

        jLabel3.setText("Cliente:");

        buttonGroup1.add(rbAtivas);
        rbAtivas.setText("Ativas");

        buttonGroup1.add(rbCanceladas);
        rbCanceladas.setText("Canceladas");

        jLabel4.setText("Data Inicial:");

        jLabel5.setText("Data Final:");

        txtDataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        txtDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        buttonGroup1.add(rbTodas);
        rbTodas.setSelected(true);
        rbTodas.setText("Todas");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbAtivas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(rbTodas)
                .addGap(119, 119, 119)
                .addComponent(rbCanceladas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCliente)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtSerie, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(txtNumero, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(19, 19, 19)
                                .addComponent(txtDataFinal))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataInicial)))))
                .addGap(196, 196, 196))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbAtivas)
                            .addComponent(rbCanceladas)
                            .addComponent(rbTodas))))
                .addGap(5, 5, 5))
        );

        jTableNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(jTableNotas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        getContentPane().add(jPanel1);

        jMenu1.setText("Arquivo");

        jMenuItem4.setText("Configurações");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        menuSair.setText("Sair");
        menuSair.setName("menuSair"); // NOI18N
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        jMenu1.add(menuSair);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Utilidades");

        jMenuItem1.setText("Clientes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Itens");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Pneus");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSairActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ClientesGUI clienteGUI = new ClientesGUI();
//        notaGUI.setExtendedState(JFrame.MAXIMIZED_BOTH);
        clienteGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        ConfiguracoesGUI configGUI = new ConfiguracoesGUI();
        configGUI.setVisible(true);
        configGUI.setAlwaysOnTop(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        PneusGUI pneuGUI = new PneusGUI();
//        pneuGUI.setExtendedState(JFrame.MAXIMIZED_BOTH);
        pneuGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ItensGUI itemGUI = new ItensGUI();
//        itemGUI.setExtendedState(JFrame.MAXIMIZED_BOTH);
        itemGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NotasGUI().setVisible(true);
            }
        });
    }

    private void preencherTable() {
        NotaFiscalDAO notasDAO = new NotaFiscalDAO();

        try {
            for (NotaFiscalBean nota : notasDAO.listarTodos()) {
                model.addRow(nota);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotasGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableNotas;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JRadioButton rbAtivas;
    private javax.swing.JRadioButton rbCanceladas;
    private javax.swing.JRadioButton rbTodas;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JFormattedTextField txtDataFinal;
    private javax.swing.JFormattedTextField txtDataInicial;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtSerie;
    // End of variables declaration//GEN-END:variables
}
