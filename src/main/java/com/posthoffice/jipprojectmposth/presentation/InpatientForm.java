package com.posthoffice.jipprojectmposth.presentation;

import com.posthoffice.jipprojectmposth.regex.Messages;

public class InpatientForm extends javax.swing.JPanel {

    public InpatientForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateOfStayLabel = new javax.swing.JLabel(Messages.getString("dateofstay"));
        roomNumberLabel = new javax.swing.JLabel(Messages.getString("roomnumber"));
        dailyRateLabel = new javax.swing.JLabel(Messages.getString("dailyrate"));
        suppliesLabel = new javax.swing.JLabel(Messages.getString("supplies"));
        servicesLabel = new javax.swing.JLabel(Messages.getString("services"));
        dateOfStayTextField = new javax.swing.JTextField();
        servicesTextField = new javax.swing.JTextField();
        roomNumberTextField = new javax.swing.JTextField();
        dailyRateTextField = new javax.swing.JTextField();
        suppliesTextField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();

        dateOfStayLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dateOfStayLabel.setMaximumSize(new java.awt.Dimension(80, 20));
        dateOfStayLabel.setMinimumSize(new java.awt.Dimension(80, 20));
        dateOfStayLabel.setPreferredSize(new java.awt.Dimension(80, 20));

        roomNumberLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomNumberLabel.setMaximumSize(new java.awt.Dimension(80, 20));
        roomNumberLabel.setMinimumSize(new java.awt.Dimension(80, 20));
        roomNumberLabel.setPreferredSize(new java.awt.Dimension(80, 20));

        dailyRateLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dailyRateLabel.setMaximumSize(new java.awt.Dimension(80, 20));
        dailyRateLabel.setMinimumSize(new java.awt.Dimension(80, 20));
        dailyRateLabel.setPreferredSize(new java.awt.Dimension(80, 20));

        suppliesLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        suppliesLabel.setMaximumSize(new java.awt.Dimension(80, 20));
        suppliesLabel.setMinimumSize(new java.awt.Dimension(80, 20));
        suppliesLabel.setPreferredSize(new java.awt.Dimension(80, 20));

        servicesLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        servicesLabel.setMaximumSize(new java.awt.Dimension(80, 20));
        servicesLabel.setMinimumSize(new java.awt.Dimension(80, 20));
        servicesLabel.setPreferredSize(new java.awt.Dimension(80, 20));

        dateOfStayTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateOfStayTextFieldActionPerformed(evt);
            }
        });

        servicesTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicesTextFieldActionPerformed(evt);
            }
        });

        roomNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomNumberTextFieldActionPerformed(evt);
            }
        });

        dailyRateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dailyRateTextFieldActionPerformed(evt);
            }
        });

        suppliesTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppliesTextFieldActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(servicesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(servicesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(suppliesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(suppliesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dailyRateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dailyRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(roomNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(roomNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dateOfStayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(dateOfStayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateOfStayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateOfStayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dailyRateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dailyRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(suppliesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suppliesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(servicesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(servicesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void dateOfStayTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateOfStayTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateOfStayTextFieldActionPerformed

    private void servicesTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicesTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_servicesTextFieldActionPerformed

    private void roomNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomNumberTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomNumberTextFieldActionPerformed

    private void dailyRateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dailyRateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dailyRateTextFieldActionPerformed

    private void suppliesTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppliesTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suppliesTextFieldActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dailyRateLabel;
    private javax.swing.JTextField dailyRateTextField;
    private javax.swing.JLabel dateOfStayLabel;
    private javax.swing.JTextField dateOfStayTextField;
    private javax.swing.JLabel roomNumberLabel;
    private javax.swing.JTextField roomNumberTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel servicesLabel;
    private javax.swing.JTextField servicesTextField;
    private javax.swing.JLabel suppliesLabel;
    private javax.swing.JTextField suppliesTextField;
    // End of variables declaration//GEN-END:variables
}
