package sumptus.oldView;

import sumptus.view.AreaTableModel;
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

        editAreaFrame = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        editArea = new javax.swing.JTextField();
        saveEditAreaButton = new javax.swing.JButton();
        editId = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableAreas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        createNewAreaButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Editar Área");

        editArea.setText("jTextField1");

        saveEditAreaButton.setText("Salvar");
        saveEditAreaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveEditAreaButtonActionPerformed(evt);
            }
        });

        editId.setEditable(false);
        editId.setText("jTextField1");
        editId.setFocusable(false);

        javax.swing.GroupLayout editAreaFrameLayout = new javax.swing.GroupLayout(editAreaFrame.getContentPane());
        editAreaFrame.getContentPane().setLayout(editAreaFrameLayout);
        editAreaFrameLayout.setHorizontalGroup(
            editAreaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editAreaFrameLayout.createSequentialGroup()
                .addGroup(editAreaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(editAreaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(editAreaFrameLayout.createSequentialGroup()
                            .addGap(246, 246, 246)
                            .addComponent(saveEditAreaButton))
                        .addGroup(editAreaFrameLayout.createSequentialGroup()
                            .addGap(142, 142, 142)
                            .addComponent(jLabel2)))
                    .addGroup(editAreaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(editId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editArea, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        editAreaFrameLayout.setVerticalGroup(
            editAreaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editAreaFrameLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(editId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveEditAreaButton)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setMaximumSize(new java.awt.Dimension(400, 400));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1112, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(437, 437, 437)
                            .addComponent(jLabel1)
                            .addGap(278, 278, 278)
                            .addComponent(createNewAreaButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(deleteButton)))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 688, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(createNewAreaButton)
                        .addComponent(deleteButton)
                        .addComponent(jLabel1))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
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
                    String saida = areaDAO.delete(area.getId());
                    JOptionPane.showMessageDialog(rootPane, saida);
                    refresh();
                } catch (Exception ex) {
                }
            }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void tableAreasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAreasMouseClicked
        if(evt.getClickCount() == 2) {
            area = areas.get(tableAreas.getSelectedRow());
            editArea.setText(area.getName());
            editId.setText(area.getId().toString());
            editAreaFrame.setSize(400, 400);
            editAreaFrame.setVisible(true);
        }
    }//GEN-LAST:event_tableAreasMouseClicked

    private void saveEditAreaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveEditAreaButtonActionPerformed
        // TODO add your handling code here:
        area.setId(Integer.parseInt(editId.getText()));
        area.setName(editArea.getText());
        try {
            areaDAO.update(area);
            editAreaFrame.setVisible(false);
            refresh();
        } catch (SQLException ex) {
            Logger.getLogger(AreaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveEditAreaButtonActionPerformed
    
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
    private javax.swing.JTextField editArea;
    private javax.swing.JFrame editAreaFrame;
    private javax.swing.JTextField editId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton saveEditAreaButton;
    private javax.swing.JTable tableAreas;
    // End of variables declaration//GEN-END:variables
    private AreaDAO areaDAO;
    private Area area;
    private List<Area> areas;
    private AreaTableModel areaTbModel;
}
