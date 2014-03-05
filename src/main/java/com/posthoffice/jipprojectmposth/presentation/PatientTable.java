package com.posthoffice.jipprojectmposth.presentation;

import com.posthoffice.jipprojectmposth.database.PatientDBManagement;
import com.posthoffice.jipprojectmposth.model.PatientDBTableModel;

public class PatientTable extends javax.swing.JPanel {
    
    private PatientDBTableModel patientModel = null;
    private PatientDBManagement patientDBManager = null;

    public PatientTable() {
        patientModel = new PatientDBTableModel();
        
        patientDBManager = new PatientDBManagement(patientModel);
        patientDBManager.fillTableModel(null);
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        patientTable = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Patient Data", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        setLayout(new java.awt.BorderLayout());

        patientTable.setModel(patientModel);
        patientTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(patientTable);

        add(jScrollPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable patientTable;
    // End of variables declaration//GEN-END:variables
}
