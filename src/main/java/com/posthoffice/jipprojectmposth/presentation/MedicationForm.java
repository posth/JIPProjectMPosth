/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.posthoffice.jipprojectmposth.presentation;

/**
 *
 * @author Marc
 */
public class MedicationForm extends javax.swing.JPanel {

    /**
     * Creates new form MedicationForm
     */
    public MedicationForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        medicationLabel = new javax.swing.JLabel();
        patientIDLabel1 = new javax.swing.JLabel();
        dateOfMedLabel = new javax.swing.JLabel();
        unitsLabel = new javax.swing.JLabel();
        unitCostLabel = new javax.swing.JLabel();
        unitsTextField = new javax.swing.JTextField();
        unitCostTextField = new javax.swing.JTextField();
        medicationTextField = new javax.swing.JTextField();
        dateOfMedTextField = new javax.swing.JTextField();
        patientIDTextField4 = new javax.swing.JTextField();

        medicationLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medicationLabel.setText("Medication:");
        medicationLabel.setMaximumSize(new java.awt.Dimension(80, 20));
        medicationLabel.setMinimumSize(new java.awt.Dimension(80, 20));
        medicationLabel.setPreferredSize(new java.awt.Dimension(80, 20));

        patientIDLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        patientIDLabel1.setText("Patient ID:");
        patientIDLabel1.setMaximumSize(new java.awt.Dimension(80, 20));
        patientIDLabel1.setMinimumSize(new java.awt.Dimension(80, 20));
        patientIDLabel1.setPreferredSize(new java.awt.Dimension(80, 20));

        dateOfMedLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dateOfMedLabel.setText("Date of Med:");
        dateOfMedLabel.setMaximumSize(new java.awt.Dimension(80, 20));
        dateOfMedLabel.setMinimumSize(new java.awt.Dimension(80, 20));
        dateOfMedLabel.setPreferredSize(new java.awt.Dimension(80, 20));

        unitsLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        unitsLabel.setText("Units:");
        unitsLabel.setMaximumSize(new java.awt.Dimension(80, 20));
        unitsLabel.setMinimumSize(new java.awt.Dimension(80, 20));
        unitsLabel.setPreferredSize(new java.awt.Dimension(80, 20));

        unitCostLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        unitCostLabel.setText("Unit Cost:");
        unitCostLabel.setMaximumSize(new java.awt.Dimension(80, 20));
        unitCostLabel.setMinimumSize(new java.awt.Dimension(80, 20));
        unitCostLabel.setPreferredSize(new java.awt.Dimension(80, 20));

        unitsTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitsTextFieldActionPerformed(evt);
            }
        });

        unitCostTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitCostTextFieldActionPerformed(evt);
            }
        });

        medicationTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicationTextFieldActionPerformed(evt);
            }
        });

        dateOfMedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateOfMedTextFieldActionPerformed(evt);
            }
        });

        patientIDTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientIDTextField4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(patientIDLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(patientIDTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dateOfMedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateOfMedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(medicationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(medicationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(unitCostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(unitCostTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(unitsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(unitsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patientIDLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientIDTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateOfMedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateOfMedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(medicationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(medicationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unitCostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unitCostTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unitsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unitsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void unitsTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitsTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unitsTextFieldActionPerformed

    private void unitCostTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitCostTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unitCostTextFieldActionPerformed

    private void medicationTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicationTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_medicationTextFieldActionPerformed

    private void dateOfMedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateOfMedTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateOfMedTextFieldActionPerformed

    private void patientIDTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientIDTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientIDTextField4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateOfMedLabel;
    private javax.swing.JTextField dateOfMedTextField;
    private javax.swing.JLabel medicationLabel;
    private javax.swing.JTextField medicationTextField;
    private javax.swing.JLabel patientIDLabel1;
    private javax.swing.JTextField patientIDTextField4;
    private javax.swing.JLabel unitCostLabel;
    private javax.swing.JTextField unitCostTextField;
    private javax.swing.JLabel unitsLabel;
    private javax.swing.JTextField unitsTextField;
    // End of variables declaration//GEN-END:variables
}