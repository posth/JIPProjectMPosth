package com.posthoffice.jipprojectmposth.presentation;

import com.posthoffice.jipprojectmposth.model.InpatientDBTableModel;

public class TabbedChildrenTables extends javax.swing.JPanel {

    private InpatientDBTableModel inpatientModel;

    public TabbedChildrenTables() {
        initComponents();
    }

    public TabbedChildrenTables(InpatientDBTableModel inpatientModel) {
        this.inpatientModel = inpatientModel;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        inpatientTable2 = new com.posthoffice.jipprojectmposth.presentation.InpatientTable(inpatientModel);

        jTabbedPane1.addTab("Inpatient Data", inpatientTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 931, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.posthoffice.jipprojectmposth.presentation.InpatientTable inpatientTable2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
