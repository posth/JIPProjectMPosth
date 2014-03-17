package com.posthoffice.jipprojectmposth.presentation;

import com.posthoffice.jipprojectmposth.model.InpatientDBTableModel;
import com.posthoffice.jipprojectmposth.model.MedicationDBTableModel;
import com.posthoffice.jipprojectmposth.model.SurgicalDBTableModel;

public class TabbedChildrenTables extends javax.swing.JPanel {

    private InpatientDBTableModel inpatientModel;
    private MedicationDBTableModel medicationModel;
    private SurgicalDBTableModel surgicalModel;
    
    public TabbedChildrenTables() {
        this.inpatientModel = new InpatientDBTableModel();
        this.medicationModel = new MedicationDBTableModel();
        this.surgicalModel = new SurgicalDBTableModel();
        initComponents();
    }
    
    public TabbedChildrenTables(InpatientDBTableModel inpatientModel, MedicationDBTableModel medicationModel, SurgicalDBTableModel surgicalModel) {       
        this.inpatientModel = inpatientModel;
        this.medicationModel = medicationModel;
        this.surgicalModel = surgicalModel;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        inpatientTable2 = new com.posthoffice.jipprojectmposth.presentation.InpatientTable(inpatientModel);
        medicationTable1 = new com.posthoffice.jipprojectmposth.presentation.MedicationTable(medicationModel);
        surgicalTable1 = new com.posthoffice.jipprojectmposth.presentation.SurgicalTable(surgicalModel);

        jTabbedPane1.addTab("Inpatient Data", inpatientTable2);
        jTabbedPane1.addTab("Medication Data", medicationTable1);
        jTabbedPane1.addTab("Surgical Data", surgicalTable1);

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
    private com.posthoffice.jipprojectmposth.presentation.MedicationTable medicationTable1;
    private com.posthoffice.jipprojectmposth.presentation.SurgicalTable surgicalTable1;
    // End of variables declaration//GEN-END:variables
}
