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
        jScrollPane1 = new javax.swing.JScrollPane();
        formTabbedPane = new javax.swing.JTabbedPane();
        patientForm2 = new com.posthoffice.jipprojectmposth.presentation.PatientForm();
        inpatientForm3 = new com.posthoffice.jipprojectmposth.presentation.InpatientForm();
        surgicalForm1 = new com.posthoffice.jipprojectmposth.presentation.SurgicalForm();
        medicationForm2 = new com.posthoffice.jipprojectmposth.presentation.MedicationForm();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Forms", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 24))); // NOI18N

        formTabbedPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        formTabbedPane.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        patientForm2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        formTabbedPane.addTab("Patient", patientForm2);
        formTabbedPane.addTab("Inpatient", inpatientForm3);
        formTabbedPane.addTab("Surgical", surgicalForm1);
        formTabbedPane.addTab("Medication", medicationForm2);

        jScrollPane1.setViewportView(formTabbedPane);
        formTabbedPane.getAccessibleContext().setAccessibleName("Forms");

        saveButton.setText("Save");

        cancelButton.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTabbedPane formTabbedPane;
    private com.posthoffice.jipprojectmposth.presentation.InpatientForm inpatientForm1;
    private com.posthoffice.jipprojectmposth.presentation.InpatientForm inpatientForm2;
    private com.posthoffice.jipprojectmposth.presentation.InpatientForm inpatientForm3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.posthoffice.jipprojectmposth.presentation.MedicationForm medicationForm1;
    private com.posthoffice.jipprojectmposth.presentation.MedicationForm medicationForm2;
    private com.posthoffice.jipprojectmposth.presentation.PatientForm patientForm1;
    private com.posthoffice.jipprojectmposth.presentation.PatientForm patientForm2;
    private javax.swing.JButton saveButton;
    private com.posthoffice.jipprojectmposth.presentation.SurgicalForm surgicalForm1;
    // End of variables declaration//GEN-END:variables
}
