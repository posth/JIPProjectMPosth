package com.posthoffice.jipprojectmposth.presentation;

import com.posthoffice.jipprojectmposth.beans.LiveDataBean;
import com.posthoffice.jipprojectmposth.model.InpatientDBTableModel;
import com.posthoffice.jipprojectmposth.model.MedicationDBTableModel;
import com.posthoffice.jipprojectmposth.model.PatientDBTableModel;
import com.posthoffice.jipprojectmposth.model.SurgicalDBTableModel;

public class SplitPanelPanel extends javax.swing.JPanel {

    private PatientDBTableModel patientModel;
    private InpatientDBTableModel inpatientModel;
    private MedicationDBTableModel medicationModel;
    private SurgicalDBTableModel surgicalModel;   
    private LiveDataBean liveDataBean;

    public SplitPanelPanel(PatientDBTableModel patientModel, InpatientDBTableModel inpatientModel, 
            MedicationDBTableModel medicationModel, SurgicalDBTableModel surgicalModel, LiveDataBean liveDataBean) {

        this.patientModel = patientModel;
        this.inpatientModel = inpatientModel;
        this.medicationModel = medicationModel;
        this.surgicalModel = surgicalModel;
        this.liveDataBean = liveDataBean;
        initComponents();
    }
    
    public SplitPanelPanel() {
              
        this.inpatientModel = new InpatientDBTableModel();
        this.medicationModel = new MedicationDBTableModel();
        this.surgicalModel = new SurgicalDBTableModel();
        this.patientModel = new PatientDBTableModel(inpatientModel, medicationModel, surgicalModel);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabbedChildrenTables1 = new com.posthoffice.jipprojectmposth.presentation.TabbedChildrenTables(inpatientModel, medicationModel, surgicalModel, liveDataBean);
        jScrollPane3 = new javax.swing.JScrollPane();
        patientTable1 = new com.posthoffice.jipprojectmposth.presentation.PatientTable(patientModel, liveDataBean);

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setResizeWeight(.5d);

        jScrollPane1.setViewportView(tabbedChildrenTables1);

        jSplitPane1.setBottomComponent(jScrollPane1);

        jScrollPane3.setViewportView(patientTable1);

        jSplitPane1.setLeftComponent(jScrollPane3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private com.posthoffice.jipprojectmposth.presentation.PatientTable patientTable1;
    private com.posthoffice.jipprojectmposth.presentation.TabbedChildrenTables tabbedChildrenTables1;
    // End of variables declaration//GEN-END:variables
}
