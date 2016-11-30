/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumptus.view;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import sumptus.dao.AreaDAO;
import sumptus.dao.DataBase;
import sumptus.dao.OutlayDAO;
import sumptus.dao.PayFormDAO;
import sumptus.model.Area;
import sumptus.model.Outlay;
import sumptus.model.PayForm;
import sumptus.model.User;

/**
 *
 * @author jessicadagostini
 */
public class UserOutlaysFrame extends javax.swing.JFrame {

    private User userLogged;
    private OutlayDAO outlayDAO;
    private List<Outlay> outlays;
    private OutlayTableModel outlayTbModel;
    private AreaDAO areaDAO;
    private List<Area> areas;
    private PayFormDAO pformDAO;
    private List<PayForm> pforms;
    private Outlay outlay;
    private Area area;
    private PayForm pform;

    /**
     * Creates new form UserOutlays
     */
    public UserOutlaysFrame(User userLogged) {
        initComponents();
        this.userLogged = userLogged;
        initOutlays();
        Locale locale = new Locale("pt", "BR");
    }

    private UserOutlaysFrame() {
        initComponents();
    }

    public void initOutlays() {
        try {
            outlayDAO = new OutlayDAO(DataBase.connection());
            outlays = outlayDAO.findByUser(userLogged.getId());
            outlayTbModel = new OutlayTableModel(outlays);
            outlaysTable.setModel(outlayTbModel);
            LocalDate today = LocalDate.now();
            String diaDaSemana = today.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
            String mes = today.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());
            welcomeLabel.setText("Olá " + userLogged.getName() + "! Hoje é " + diaDaSemana + ", " + today.getDayOfMonth() + " de " + mes + " de " + today.getYear());
        } catch (SQLException ex) {
            Logger.getLogger(UserOutlaysFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        outlaysPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        outlaysTable = new javax.swing.JTable();
        welcomeLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        outlayMenu = new javax.swing.JMenu();
        addOutlayMenuItem = new javax.swing.JMenuItem();
        editOutlayMenuItem = new javax.swing.JMenuItem();
        areaMenu = new javax.swing.JMenu();
        listAllAreasMenuItem = new javax.swing.JMenuItem();
        pformMenu = new javax.swing.JMenu();
        listAllPformsMenuItem = new javax.swing.JMenuItem();
        userMenu = new javax.swing.JMenu();
        editUserMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sumptus - Painel Principal");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jScrollPane1.setPreferredSize(new java.awt.Dimension(1080, 520));

        outlaysTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(outlaysTable);

        welcomeLabel.setText("jLabel7");

        javax.swing.GroupLayout outlaysPanelLayout = new javax.swing.GroupLayout(outlaysPanel);
        outlaysPanel.setLayout(outlaysPanelLayout);
        outlaysPanelLayout.setHorizontalGroup(
            outlaysPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(outlaysPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomeLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        outlaysPanelLayout.setVerticalGroup(
            outlaysPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, outlaysPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        outlayMenu.setText("Gastos");

        addOutlayMenuItem.setText("Adicionar");
        addOutlayMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOutlayMenuItemActionPerformed(evt);
            }
        });
        outlayMenu.add(addOutlayMenuItem);

        editOutlayMenuItem.setText("Editar");
        editOutlayMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editOutlayMenuItemActionPerformed(evt);
            }
        });
        outlayMenu.add(editOutlayMenuItem);

        menuBar.add(outlayMenu);

        areaMenu.setText("Areas");

        listAllAreasMenuItem.setText("Listar Todos");
        listAllAreasMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listAllAreasMenuItemActionPerformed(evt);
            }
        });
        areaMenu.add(listAllAreasMenuItem);

        menuBar.add(areaMenu);

        pformMenu.setText("Formas Pagamentos");

        listAllPformsMenuItem.setText("Listar Todos");
        listAllPformsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listAllPformsMenuItemActionPerformed(evt);
            }
        });
        pformMenu.add(listAllPformsMenuItem);

        menuBar.add(pformMenu);

        userMenu.setText("Usuários");

        editUserMenuItem.setText("Editar usuário");
        editUserMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUserMenuItemActionPerformed(evt);
            }
        });
        userMenu.add(editUserMenuItem);

        menuBar.add(userMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(outlaysPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(outlaysPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listAllAreasMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listAllAreasMenuItemActionPerformed
        // TODO add your handling code here:
        System.out.println("Entrou ActionPerformed");
        AreaFrame areas = new AreaFrame();
        areas.setVisible(true);
    }//GEN-LAST:event_listAllAreasMenuItemActionPerformed

    private void addOutlayMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOutlayMenuItemActionPerformed
        OutlayDialog outlay = new OutlayDialog(userLogged);
        outlay.setVisible(true);        
    }//GEN-LAST:event_addOutlayMenuItemActionPerformed

    private void listAllPformsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listAllPformsMenuItemActionPerformed
        // TODO add your handling code here:
        PayFormFrame pforms = new PayFormFrame();
        pforms.setVisible(true);
    }//GEN-LAST:event_listAllPformsMenuItemActionPerformed

    private void editUserMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUserMenuItemActionPerformed
        // TODO add your handling code here
        UserEditFrame edit = new UserEditFrame();
        edit.setUser(userLogged);
        edit.setVisible(true);
    }//GEN-LAST:event_editUserMenuItemActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        initOutlays();
    }//GEN-LAST:event_formWindowActivated

    private void editOutlayMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editOutlayMenuItemActionPerformed
        // TODO add your handling code here:
        Integer id = outlaysTable.getSelectedRow();
        outlay = outlays.get(id);
        System.out.println(outlay.getId());
        OutlayDialog outlayDialog = new OutlayDialog(outlay);
        outlayDialog.setVisible(true);
        
    }//GEN-LAST:event_editOutlayMenuItemActionPerformed
   

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
            java.util.logging.Logger.getLogger(UserOutlaysFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserOutlaysFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserOutlaysFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserOutlaysFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserOutlaysFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addOutlayMenuItem;
    private javax.swing.JMenu areaMenu;
    private javax.swing.JMenuItem editOutlayMenuItem;
    private javax.swing.JMenuItem editUserMenuItem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem listAllAreasMenuItem;
    private javax.swing.JMenuItem listAllPformsMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu outlayMenu;
    private javax.swing.JPanel outlaysPanel;
    private javax.swing.JTable outlaysTable;
    private javax.swing.JMenu pformMenu;
    private javax.swing.JMenu userMenu;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
