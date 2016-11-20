package sumptus.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sumptus.dao.AreaDAO;
import sumptus.dao.DataBase;
import sumptus.model.Area;

public class AreaForm extends javax.swing.JFrame {

    public AreaForm() {
        initComponents();
        initialize();
    }
    
    private void initialize(){
        try {
            areaDAO = new AreaDAO(DataBase.connection());
            areas = areaDAO.findAll();
            areaTbModel = new AreaTableModel(areas);
            tableAreas.setModel(areaTbModel);
        } catch (SQLException ex) {
            Logger.getLogger(AreaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tableAreas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        createNewAreaButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableAreas.setModel(new javax.swing.table.DefaultTableModel(
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
        tableAreas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAreasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableAreas);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Áreas Cadastradas");

        createNewAreaButton.setText("Nova Área");
        createNewAreaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewAreaButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Deletar");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createNewAreaButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createNewAreaButton)
                            .addComponent(deleteButton))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createNewAreaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewAreaButtonActionPerformed
        String newArea = JOptionPane.showInputDialog("Digite a nova área");
        System.out.println(newArea); 
        if(newArea != null){
            try {
                AreaDAO DAO = new AreaDAO(DataBase.connection());
                Area area = new Area();
                area.setName(newArea);
                DAO.create(area);
                JOptionPane.showMessageDialog(null, "Gravado com Sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
                refresh();
            } catch (SQLException ex) {
                Logger.getLogger(AreaForm.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao gravar pessoa", "Erro", JOptionPane.ERROR);
            }
        }
    }//GEN-LAST:event_createNewAreaButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        area = areas.get(tableAreas.getSelectedRow());
            int delete = JOptionPane.showConfirmDialog(rootPane, "Deletar \"" + area.getName() + "\"?", "Confirmação", JOptionPane.YES_NO_OPTION);
            System.out.println("Delete = " + delete);
            if(delete == 0){
                try {
                    areaDAO.delete(area.getId());
                    JOptionPane.showMessageDialog(rootPane, "Area deletada");
                    refresh();
                } catch (SQLException ex) {
                    Logger.getLogger(AreaForm.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(rootPane, "Problemas para deletar a área");
                }
            }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void tableAreasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAreasMouseClicked

    }//GEN-LAST:event_tableAreasMouseClicked
    
    private void refresh(){
        try {
            areas = areaDAO.findAll();
            areaTbModel = new AreaTableModel(areas);
            tableAreas.setModel(areaTbModel);
        } catch (SQLException ex) {
            Logger.getLogger(AreaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AreaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AreaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AreaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AreaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AreaForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createNewAreaButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableAreas;
    // End of variables declaration//GEN-END:variables
    private AreaDAO areaDAO;
    private Area area;
    private List<Area> areas;
    private AreaTableModel areaTbModel;
}
