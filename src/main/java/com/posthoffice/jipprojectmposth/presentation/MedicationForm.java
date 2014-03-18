package com.posthoffice.jipprojectmposth.presentation;

import com.posthoffice.jipprojectmposth.regex.Messages;

public class MedicationForm extends javax.swing.JPanel {

    public MedicationForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        medicationLabel = new javax.swing.JLabel(Messages.getString("medication"));
        dateOfMedLabel = new javax.swing.JLabel(Messages.getString("dateofmed"));
        unitsLabel = new javax.swing.JLabel(Messages.getString("units"));
        unitCostLabel = new javax.swing.JLabel(Messages.getString("unitcost"));
        unitsTextField = new javax.swing.JTextField();
        unitCostTextField = new javax.swing.JTextField();
        medicationTextField = new javax.swing.JTextField();
        dateOfMedTextField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();

        medicationLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medicationLabel.setMaximumSize(new java.awt.Dimension(80, 20));
        medicationLabel.setMinimumSize(new java.awt.Dimension(80, 20));
        medicationLabel.setPreferredSize(new java.awt.Dimension(80, 20));

        dateOfMedLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dateOfMedLabel.setMaximumSize(new java.awt.Dimension(80, 20));
        dateOfMedLabel.setMinimumSize(new java.awt.Dimension(80, 20));
        dateOfMedLabel.setPreferredSize(new java.awt.Dimension(80, 20));

        unitsLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        unitsLabel.setMaximumSize(new java.awt.Dimension(80, 20));
        unitsLabel.setMinimumSize(new java.awt.Dimension(80, 20));
        unitsLabel.setPreferredSize(new java.awt.Dimension(80, 20));

        unitCostLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        saveButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dateOfMedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateOfMedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(medicationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(medicationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(unitCostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(unitCostTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(unitsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(unitsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
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
                .addGap(18, 18, 18)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateOfMedLabel;
    private javax.swing.JTextField dateOfMedTextField;
    private javax.swing.JLabel medicationLabel;
    private javax.swing.JTextField medicationTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel unitCostLabel;
    private javax.swing.JTextField unitCostTextField;
    private javax.swing.JLabel unitsLabel;
    private javax.swing.JTextField unitsTextField;
    // End of variables declaration//GEN-END:variables
}
