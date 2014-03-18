package com.posthoffice.jipprojectmposth.presentation;

import com.posthoffice.jipprojectmposth.beans.PatientBean;
import com.posthoffice.jipprojectmposth.regex.Messages;

public class PatientForm extends javax.swing.JPanel {
    
    private PatientBean patient = new PatientBean();

    public PatientForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lastNameLabel = new javax.swing.JLabel(Messages.getString("lastname"));
        FirstNameLabel = new javax.swing.JLabel(Messages.getString("firstname"));
        diagnosisLabel = new javax.swing.JLabel(Messages.getString("diagnosis"));
        admissionDateLabel = new javax.swing.JLabel(Messages.getString("admissiondate"));
        releaseDateLabel = new javax.swing.JLabel(Messages.getString("releaseDate"));
        lastNameTextField = new javax.swing.JTextField();
        admissionDateTextField = new javax.swing.JTextField();
        firstNameTextField = new javax.swing.JTextField();
        diagnosisTextField = new javax.swing.JTextField();
        releaseDateTextField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();

        lastNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lastNameLabel.setMaximumSize(new java.awt.Dimension(80, 20));
        lastNameLabel.setMinimumSize(new java.awt.Dimension(80, 20));
        lastNameLabel.setPreferredSize(new java.awt.Dimension(80, 20));

        FirstNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        FirstNameLabel.setMaximumSize(new java.awt.Dimension(80, 20));
        FirstNameLabel.setMinimumSize(new java.awt.Dimension(80, 20));
        FirstNameLabel.setPreferredSize(new java.awt.Dimension(80, 20));

        diagnosisLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        diagnosisLabel.setMaximumSize(new java.awt.Dimension(80, 20));
        diagnosisLabel.setMinimumSize(new java.awt.Dimension(80, 20));
        diagnosisLabel.setPreferredSize(new java.awt.Dimension(80, 20));

        admissionDateLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        admissionDateLabel.setMaximumSize(new java.awt.Dimension(80, 20));
        admissionDateLabel.setMinimumSize(new java.awt.Dimension(80, 20));
        admissionDateLabel.setPreferredSize(new java.awt.Dimension(80, 20));

        releaseDateLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        releaseDateLabel.setMaximumSize(new java.awt.Dimension(80, 20));
        releaseDateLabel.setMinimumSize(new java.awt.Dimension(80, 20));
        releaseDateLabel.setPreferredSize(new java.awt.Dimension(80, 20));

        lastNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameTextFieldActionPerformed(evt);
            }
        });

        admissionDateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admissionDateTextFieldActionPerformed(evt);
            }
        });

        firstNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameTextFieldActionPerformed(evt);
            }
        });

        diagnosisTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diagnosisTextFieldActionPerformed(evt);
            }
        });

        releaseDateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                releaseDateTextFieldActionPerformed(evt);
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
                                .addComponent(releaseDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(releaseDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(admissionDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(admissionDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(diagnosisLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(diagnosisTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(FirstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lastNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FirstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diagnosisLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diagnosisTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admissionDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(admissionDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(releaseDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(releaseDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lastNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameTextFieldActionPerformed
        String enteredLastName = lastNameTextField.getText();
        
        
        
    }//GEN-LAST:event_lastNameTextFieldActionPerformed

    private void admissionDateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admissionDateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_admissionDateTextFieldActionPerformed

    private void firstNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameTextFieldActionPerformed
        String enteredFirstName = firstNameTextField.getText();
        
        
    }//GEN-LAST:event_firstNameTextFieldActionPerformed

    private void diagnosisTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diagnosisTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diagnosisTextFieldActionPerformed

    private void releaseDateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_releaseDateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_releaseDateTextFieldActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FirstNameLabel;
    private javax.swing.JLabel admissionDateLabel;
    private javax.swing.JTextField admissionDateTextField;
    private javax.swing.JLabel diagnosisLabel;
    private javax.swing.JTextField diagnosisTextField;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JLabel releaseDateLabel;
    private javax.swing.JTextField releaseDateTextField;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
