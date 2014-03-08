package com.posthoffice.jipprojectmposth.presentation;

import com.posthoffice.jipprojectmposth.database.PatientDBManagement;
import com.posthoffice.jipprojectmposth.model.PatientDBTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PatientTable extends javax.swing.JPanel {

    private PatientDBTableModel patientModel = null;
    private PatientDBManagement patientDBManager = null;
    private int selectedRow = -1;

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
        ListSelectionModel rowSM = patientTable.getSelectionModel();
        rowSM.addListSelectionListener(new RowListener());

        add(jScrollPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    class RowListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {

            if (e.getValueIsAdjusting()) {
                return;
            }

            ListSelectionModel lsm = (ListSelectionModel) e.getSource();
            if (!lsm.isSelectionEmpty()) {
                selectedRow = lsm.getMinSelectionIndex();
            }
            
            patientModel.setChildrenTableModels(patientModel.getPatientData(selectedRow));
            
            
            
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable patientTable;
    // End of variables declaration//GEN-END:variables
}