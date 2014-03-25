package com.posthoffice.jipprojectmposth.presentation;

import com.posthoffice.jipprojectmposth.beans.LiveDataBean;
import com.posthoffice.jipprojectmposth.model.InpatientDBTableModel;
import com.posthoffice.jipprojectmposth.model.MedicationDBTableModel;
import com.posthoffice.jipprojectmposth.model.SurgicalDBTableModel;

public class TabbedChildrenTables extends javax.swing.JPanel {

    private InpatientDBTableModel inpatientModel;
    private MedicationDBTableModel medicationModel;
    private SurgicalDBTableModel surgicalModel;
    private LiveDataBean liveDataBean;

    public TabbedChildrenTables(InpatientDBTableModel inpatientModel, MedicationDBTableModel medicationModel, SurgicalDBTableModel surgicalModel, LiveDataBean liveDataBean) {
        this.inpatientModel = inpatientModel;
        this.medicationModel = medicationModel;
        this.surgicalModel = surgicalModel;
        this.liveDataBean = liveDataBean;
        initComponents();
    }
    
    public TabbedChildrenTables() {
        this.inpatientModel = new InpatientDBTableModel();
        this.medicationModel = new MedicationDBTableModel();
        this.surgicalModel = new SurgicalDBTableModel();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        inpatientTable2 = new com.posthoffice.jipprojectmposth.presentation.InpatientTable(inpatientModel, liveDataBean);
        medicationTable1 = new com.posthoffice.jipprojectmposth.presentation.MedicationTable(medicationModel, liveDataBean);
        surgicalTable1 = new com.posthoffice.jipprojectmposth.presentation.SurgicalTable(surgicalModel, liveDataBean);

        jTabbedPane1.addTab("Inpatient Data", inpatientTable2);

        jTabbedPane1.addTab("Medication Data", medicationTable1);
        medicationTable1.getAccessibleContext().setAccessibleParent(jTabbedPane1);

        jTabbedPane1.addTab("Surgical Data", surgicalTable1);
        surgicalTable1.getAccessibleContext().setAccessibleParent(surgicalTable1);

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
