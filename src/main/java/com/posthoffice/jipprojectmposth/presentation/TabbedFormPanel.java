package com.posthoffice.jipprojectmposth.presentation;

public class TabbedFormPanel extends javax.swing.JPanel {

    public TabbedFormPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        patientForm1 = new com.posthoffice.jipprojectmposth.presentation.PatientForm();
        inpatientForm1 = new com.posthoffice.jipprojectmposth.presentation.InpatientForm();
        inpatientForm2 = new com.posthoffice.jipprojectmposth.presentation.InpatientForm();
        medicationForm1 = new com.posthoffice.jipprojectmposth.presentation.MedicationForm();
        formTabbedPane = new javax.swing.JTabbedPane();
        patientForm2 = new com.posthoffice.jipprojectmposth.presentation.PatientForm();
        inpatientForm3 = new com.posthoffice.jipprojectmposth.presentation.InpatientForm();
        surgicalForm1 = new com.posthoffice.jipprojectmposth.presentation.SurgicalForm();
        medicationForm2 = new com.posthoffice.jipprojectmposth.presentation.MedicationForm();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Forms", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 24))); // NOI18N

        formTabbedPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        formTabbedPane.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        patientForm2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        formTabbedPane.addTab("Patient", patientForm2);
        formTabbedPane.addTab("Inpatient", inpatientForm3);
        formTabbedPane.addTab("Surgical", surgicalForm1);
        formTabbedPane.addTab("Medication", medicationForm2);

        okButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cancelButton.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(formTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(formTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        formTabbedPane.getAccessibleContext().setAccessibleName("Forms");
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_okButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTabbedPane formTabbedPane;
    private com.posthoffice.jipprojectmposth.presentation.InpatientForm inpatientForm1;
    private com.posthoffice.jipprojectmposth.presentation.InpatientForm inpatientForm2;
    private com.posthoffice.jipprojectmposth.presentation.InpatientForm inpatientForm3;
    private com.posthoffice.jipprojectmposth.presentation.MedicationForm medicationForm1;
    private com.posthoffice.jipprojectmposth.presentation.MedicationForm medicationForm2;
    private javax.swing.JButton okButton;
    private com.posthoffice.jipprojectmposth.presentation.PatientForm patientForm1;
    private com.posthoffice.jipprojectmposth.presentation.PatientForm patientForm2;
    private com.posthoffice.jipprojectmposth.presentation.SurgicalForm surgicalForm1;
    // End of variables declaration//GEN-END:variables
}
