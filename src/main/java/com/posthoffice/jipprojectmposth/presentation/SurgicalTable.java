package com.posthoffice.jipprojectmposth.presentation;

import com.posthoffice.jipprojectmposth.beans.LiveDataBean;
import com.posthoffice.jipprojectmposth.model.SurgicalDBTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class SurgicalTable extends javax.swing.JPanel {

    private SurgicalDBTableModel surgicalModel;

    private int selectedRow = -1;
    private LiveDataBean liveDataBean;

    public SurgicalTable() {

        surgicalModel = new SurgicalDBTableModel();

        initComponents();
    }

    public SurgicalTable(SurgicalDBTableModel surgicalModel, LiveDataBean liveDataBean) {

        this.surgicalModel = surgicalModel;

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

            liveDataBean.setSelectedSurgicalRow(selectedRow);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        surgicalTable = new SurgicalCustomTable(surgicalModel);

        surgicalTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel rowSM = surgicalTable.getSelectionModel();
        rowSM.addListSelectionListener(new RowListener());
        jScrollPane1.setViewportView(surgicalTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable surgicalTable;
    // End of variables declaration//GEN-END:variables
}
