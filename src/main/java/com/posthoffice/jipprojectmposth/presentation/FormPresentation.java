package com.posthoffice.jipprojectmposth.presentation;

public class FormPresentation extends javax.swing.JPanel {

    public FormPresentation() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        diagnosisLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        releaseDateLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        admissionDateLabel = new javax.swing.JLabel();
        firstNameTextField = new javax.swing.JTextField();
        diagnosisTextField = new javax.swing.JTextField();
        admissionDateTextField = new javax.swing.JTextField();
        lastNameTextField = new javax.swing.JTextField();
        releaseDateTextField = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        oKButton1 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setAutoscrolls(true);
        setLayout(new java.awt.BorderLayout());

        diagnosisLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        diagnosisLabel.setText("Diagnosis:");
        add(diagnosisLabel, java.awt.BorderLayout.CENTER);

        firstNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        firstNameLabel.setText("First Name:");
        add(firstNameLabel, java.awt.BorderLayout.PAGE_START);

        releaseDateLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        releaseDateLabel.setText("Release Date:");
        add(releaseDateLabel, java.awt.BorderLayout.PAGE_END);

        lastNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lastNameLabel.setText("Last Name:");
        add(lastNameLabel, java.awt.BorderLayout.LINE_END);

        admissionDateLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        admissionDateLabel.setText("Admission Date:");
        add(admissionDateLabel, java.awt.BorderLayout.LINE_START);

        firstNameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        add(firstNameTextField, java.awt.BorderLayout.CENTER);

        diagnosisTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        add(diagnosisTextField, java.awt.BorderLayout.CENTER);
        add(admissionDateTextField, java.awt.BorderLayout.CENTER);

        lastNameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lastNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameTextFieldActionPerformed(evt);
            }
        });
        add(lastNameTextField, java.awt.BorderLayout.CENTER);

        releaseDateTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        add(releaseDateTextField, java.awt.BorderLayout.CENTER);

        cancelButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cancelButton.setText("Cancel");
        add(cancelButton, java.awt.BorderLayout.CENTER);

        oKButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        oKButton1.setText("OK");
        add(oKButton1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void lastNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel admissionDateLabel;
    private javax.swing.JTextField admissionDateTextField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel diagnosisLabel;
    private javax.swing.JTextField diagnosisTextField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JButton oKButton1;
    private javax.swing.JLabel releaseDateLabel;
    private javax.swing.JTextField releaseDateTextField;
    // End of variables declaration//GEN-END:variables
}
