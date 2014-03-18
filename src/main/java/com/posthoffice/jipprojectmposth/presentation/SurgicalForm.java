package com.posthoffice.jipprojectmposth.presentation;

import com.posthoffice.jipprojectmposth.regex.Messages;

public class SurgicalForm extends javax.swing.JPanel {

    public SurgicalForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        surgeryLabel = new javax.swing.JLabel(Messages.getString("surgery"));
        dateOfSurgeryLabel = new javax.swing.JLabel(Messages.getString("dateofsurgery"));
        surgeonsFeeLabel = new javax.swing.JLabel(Messages.getString("surgeonsfee"));
        roomFeeLabel = new javax.swing.JLabel(Messages.getString("roomfee"));
        suppliesLabel = new javax.swing.JLabel(Messages.getString("supplies"));
        surgeonsFeeTextField = new javax.swing.JTextField();
        surgeryTextField = new javax.swing.JTextField();
        dateOfSurgeryTextField = new javax.swing.JTextField();
        suppliesTextField = new javax.swing.JTextField();
        roomFeeTextField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();

        surgeryLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        surgeryLabel.setMaximumSize(new java.awt.Dimension(80, 20));
        surgeryLabel.setMinimumSize(new java.awt.Dimension(80, 20));
        surgeryLabel.setPreferredSize(new java.awt.Dimension(80, 20));

        dateOfSurgeryLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dateOfSurgeryLabel.setMaximumSize(new java.awt.Dimension(80, 20));
        dateOfSurgeryLabel.setMinimumSize(new java.awt.Dimension(80, 20));
        dateOfSurgeryLabel.setPreferredSize(new java.awt.Dimension(80, 20));

        surgeonsFeeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        surgeonsFeeLabel.setMaximumSize(new java.awt.Dimension(80, 20));
        surgeonsFeeLabel.setMinimumSize(new java.awt.Dimension(80, 20));
        surgeonsFeeLabel.setPreferredSize(new java.awt.Dimension(80, 20));

        roomFeeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomFeeLabel.setMaximumSize(new java.awt.Dimension(80, 20));
        roomFeeLabel.setMinimumSize(new java.awt.Dimension(80, 20));
        roomFeeLabel.setPreferredSize(new java.awt.Dimension(80, 20));

        suppliesLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        suppliesLabel.setMaximumSize(new java.awt.Dimension(80, 20));
        suppliesLabel.setMinimumSize(new java.awt.Dimension(80, 20));
        suppliesLabel.setPreferredSize(new java.awt.Dimension(80, 20));

        surgeonsFeeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surgeonsFeeTextFieldActionPerformed(evt);
            }
        });

        surgeryTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surgeryTextFieldActionPerformed(evt);
            }
        });

        dateOfSurgeryTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateOfSurgeryTextFieldActionPerformed(evt);
            }
        });

        suppliesTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppliesTextFieldActionPerformed(evt);
            }
        });

        roomFeeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomFeeTextFieldActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dateOfSurgeryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateOfSurgeryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(surgeryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(surgeryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(roomFeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(roomFeeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(surgeonsFeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(surgeonsFeeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(suppliesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(suppliesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateOfSurgeryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateOfSurgeryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(surgeryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(surgeryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomFeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomFeeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(surgeonsFeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(surgeonsFeeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(suppliesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suppliesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void surgeonsFeeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surgeonsFeeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_surgeonsFeeTextFieldActionPerformed

    private void surgeryTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surgeryTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_surgeryTextFieldActionPerformed

    private void dateOfSurgeryTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateOfSurgeryTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateOfSurgeryTextFieldActionPerformed

    private void suppliesTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppliesTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suppliesTextFieldActionPerformed

    private void roomFeeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomFeeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomFeeTextFieldActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateOfSurgeryLabel;
    private javax.swing.JTextField dateOfSurgeryTextField;
    private javax.swing.JLabel roomFeeLabel;
    private javax.swing.JTextField roomFeeTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel suppliesLabel;
    private javax.swing.JTextField suppliesTextField;
    private javax.swing.JLabel surgeonsFeeLabel;
    private javax.swing.JTextField surgeonsFeeTextField;
    private javax.swing.JLabel surgeryLabel;
    private javax.swing.JTextField surgeryTextField;
    // End of variables declaration//GEN-END:variables
}
