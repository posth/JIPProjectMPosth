package com.posthoffice.jipprojectmposth.presentation;

import com.posthoffice.jipprojectmposth.database.InpatientDBManagement;
import com.posthoffice.jipprojectmposth.model.InpatientDBTableModel;

public class InpatientTable extends javax.swing.JPanel {

    private InpatientDBTableModel inpatientModel = null;
    private InpatientDBManagement inpatientDBManager = null;
    private int selectedRow = -1;

    public InpatientTable() {

        inpatientModel = new InpatientDBTableModel();

        inpatientDBManager = new InpatientDBManagement(inpatientModel);
        inpatientDBManager.fillTableModel(null);

        initComponents();
    }


    public void setInpatientModel(InpatientDBTableModel inpatientModel) {
        this.inpatientModel = inpatientModel;
        System.out.println("Setting model");
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        inpatientTable = new javax.swing.JTable();

        inpatientTable.setModel(inpatientModel);
        jScrollPane1.setViewportView(inpatientTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable inpatientTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
