package com.posthoffice.jipprojectmposth.presentation;

import com.posthoffice.jipprojectmposth.beans.LiveDataBean;
import com.posthoffice.jipprojectmposth.model.MedicationDBTableModel;

public class MedicationTable extends javax.swing.JPanel {

    private MedicationDBTableModel medicationModel;
    
    private int selectedRow = -1;
    private LiveDataBean liveDataBean;

    public MedicationTable() {
        medicationModel = new MedicationDBTableModel();
        initComponents();
    }

    public MedicationTable(MedicationDBTableModel medicationModel, LiveDataBean liveDataBean) {
        this.medicationModel = medicationModel;
        this.liveDataBean = liveDataBean;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        medicationTable = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        medicationTable.setModel(medicationModel);
        jScrollPane1.setViewportView(medicationTable);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable medicationTable;
    // End of variables declaration//GEN-END:variables
}
