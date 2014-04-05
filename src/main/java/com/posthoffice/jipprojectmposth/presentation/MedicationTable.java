package com.posthoffice.jipprojectmposth.presentation;

import com.posthoffice.jipprojectmposth.beans.LiveDataBean;
import com.posthoffice.jipprojectmposth.model.MedicationDBTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
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

    class RowListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {;

            if (e.getValueIsAdjusting()) {
                return;
            }

            ListSelectionModel lsm = (ListSelectionModel) e.getSource();

            if (!lsm.isSelectionEmpty()) {
                selectedRow = lsm.getMinSelectionIndex();
            }

            if (lsm.isSelectionEmpty()) {
                selectedRow = -1;
            }

            liveDataBean.setSelectedMedicationRow(selectedRow);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        medicationTable = new MedicationCustomTable(medicationModel);

        setLayout(new java.awt.BorderLayout());

        medicationTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel rowSM = medicationTable.getSelectionModel();
        rowSM.addListSelectionListener(new RowListener());
        jScrollPane1.setViewportView(medicationTable);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable medicationTable;
    // End of variables declaration//GEN-END:variables
}
