package com.posthoffice.jipprojectmposth.presentation;

import com.posthoffice.jipprojectmposth.beans.LiveDataBean;
import com.posthoffice.jipprojectmposth.model.InpatientDBTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class InpatientTable extends javax.swing.JPanel {

    private InpatientDBTableModel inpatientModel;

    private int selectedRow = -1;
    private LiveDataBean liveDataBean;

    public InpatientTable() {

        this.inpatientModel = new InpatientDBTableModel();

        initComponents();
    }

    public InpatientTable(InpatientDBTableModel inpatientModel, LiveDataBean liveDataBean) {

        this.inpatientModel = inpatientModel;

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

            liveDataBean.setSelectedInpatientRow(selectedRow);
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        inpatientTable = new InpatientCustomTable(inpatientModel);

        inpatientTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel rowSM = inpatientTable.getSelectionModel();
        rowSM.addListSelectionListener(new RowListener());
        jScrollPane1.setViewportView(inpatientTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable inpatientTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
