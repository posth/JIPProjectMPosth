package com.posthoffice.jipprojectmposth.presentation;

import com.posthoffice.jipprojectmposth.beans.LiveDataBean;
import com.posthoffice.jipprojectmposth.beans.PatientBean;
import com.posthoffice.jipprojectmposth.database.PatientDBManagement;
import com.posthoffice.jipprojectmposth.model.InpatientDBTableModel;
import com.posthoffice.jipprojectmposth.model.MedicationDBTableModel;
import com.posthoffice.jipprojectmposth.model.PatientDBTableModel;
import com.posthoffice.jipprojectmposth.model.SurgicalDBTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PatientTable extends javax.swing.JPanel {

    private PatientDBTableModel patientModel;
    private PatientDBManagement patientDBManager;

    private int selectedRow = -1;
    private LiveDataBean liveDataBean;

    public PatientTable() {

        InpatientDBTableModel t = new InpatientDBTableModel();
        MedicationDBTableModel m = new MedicationDBTableModel();
        SurgicalDBTableModel s = new SurgicalDBTableModel();
        patientModel = new PatientDBTableModel(t, m, s);

        LiveDataBean b = new LiveDataBean();

        initComponents();
    }

    public PatientTable(PatientDBManagement patientDBManager, PatientDBTableModel patientModel, LiveDataBean liveDataBean) {
        this.patientDBManager = patientDBManager;

        this.patientModel = patientModel;
        this.liveDataBean = liveDataBean;

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

            patientModel.setChildrenTableModels(selectedRow);

            //getting the bean from model through the selected row of the table
            PatientBean temp = (patientModel.getPatientData(selectedRow));

            //setting selected values of the patient into the livedata bean
            liveDataBean.setSelectedPatientRow(selectedRow);
            liveDataBean.setSelectedPatientBean(temp);
            liveDataBean.setSelectedPatientID(temp.getPatientID());
            System.out.println("live data bean selected patient is " + liveDataBean);

        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable patientTable;
    // End of variables declaration//GEN-END:variables
}
