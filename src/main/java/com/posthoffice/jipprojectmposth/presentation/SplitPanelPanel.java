package com.posthoffice.jipprojectmposth.presentation;

import com.posthoffice.jipprojectmposth.beans.LiveDataBean;
import com.posthoffice.jipprojectmposth.database.InpatientDBManagement;
import com.posthoffice.jipprojectmposth.database.MedicationDBManagement;
import com.posthoffice.jipprojectmposth.database.PatientDBManagement;
import com.posthoffice.jipprojectmposth.database.SurgicalDBManagement;
import com.posthoffice.jipprojectmposth.model.InpatientDBTableModel;
import com.posthoffice.jipprojectmposth.model.MedicationDBTableModel;
import com.posthoffice.jipprojectmposth.model.PatientDBTableModel;
import com.posthoffice.jipprojectmposth.model.SurgicalDBTableModel;

public class SplitPanelPanel extends javax.swing.JPanel {

    private PatientDBTableModel patientModel;
    private InpatientDBTableModel inpatientModel;
    private MedicationDBTableModel medicationModel;
    private SurgicalDBTableModel surgicalModel;  
    
    private PatientDBManagement patientDBManager;
    private InpatientDBManagement inpatientDBManager;
    private MedicationDBManagement medicationDBManager;
    private SurgicalDBManagement surgicalDBManager;
    
    private LiveDataBean liveDataBean;

    public SplitPanelPanel(PatientDBTableModel patientModel, InpatientDBTableModel inpatientModel, 
            MedicationDBTableModel medicationModel, SurgicalDBTableModel surgicalModel, LiveDataBean liveDataBean,
            PatientDBManagement patientDBManager, InpatientDBManagement inpatientDBManager, MedicationDBManagement medicationDBManager, 
            SurgicalDBManagement surgicalDBManager) {

        this.inpatientModel = inpatientModel;
        this.medicationModel = medicationModel;
        this.surgicalModel = surgicalModel;
        this.patientModel = patientModel;    
        
        this.patientDBManager = patientDBManager;
        this.inpatientDBManager = inpatientDBManager;
        this.medicationDBManager = medicationDBManager;
        this.surgicalDBManager = surgicalDBManager;
        
        this.liveDataBean = liveDataBean;
        
        initComponents();
    }
    
    public SplitPanelPanel() {
              
        this.inpatientModel = new InpatientDBTableModel();
        this.medicationModel = new MedicationDBTableModel();
        this.surgicalModel = new SurgicalDBTableModel();
        this.patientModel = new PatientDBTableModel(inpatientModel, medicationModel, surgicalModel);
        
        this.patientDBManager = new PatientDBManagement();
        this.inpatientDBManager = new InpatientDBManagement();
        this.medicationDBManager = new MedicationDBManagement();
        this.surgicalDBManager = new SurgicalDBManagement();
        
        this.liveDataBean = new LiveDataBean();
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabbedChildrenTables1 = new com.posthoffice.jipprojectmposth.presentation.TabbedChildrenTables(inpatientModel, medicationModel, surgicalModel, liveDataBean);
        jScrollPane3 = new javax.swing.JScrollPane();
        patientTable1 = new com.posthoffice.jipprojectmposth.presentation.PatientTable(patientDBManager, patientModel, liveDataBean);

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
