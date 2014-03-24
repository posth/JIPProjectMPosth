package com.posthoffice.jipprojectmposth.presentation;

import com.posthoffice.jipprojectmposth.beans.LiveDataBean;
import com.posthoffice.jipprojectmposth.beans.PatientBean;
import com.posthoffice.jipprojectmposth.database.PatientDBManagement;
import com.posthoffice.jipprojectmposth.regex.Messages;
import com.posthoffice.jipprojectmposth.regex.RegexFormatter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class PatientForm extends javax.swing.JPanel {

    private String nameRegEx = ".+";   
    private LiveDataBean liveDataBean;
    private JFrame patientFormFrame;
    
    private PatientDBManagement patientDBManager;

    public PatientForm() {
        initComponents();
    }
    
    public PatientForm(PatientDBManagement patientDBManager, JFrame patientFormFrame) {
        this.patientDBManager = patientDBManager;
        this.patientFormFrame = patientFormFrame;
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
        saveButton = new javax.swing.JButton();
        lastNameTextField = new JFormattedTextField(new RegexFormatter(nameRegEx));
        admissionDateTextField = new JFormattedTextField(new SimpleDateFormat("yyyy/MM/dd"));
        firstNameTextField = new javax.swing.JFormattedTextField(new RegexFormatter(nameRegEx));
        releaseDateTextField = new javax.swing.JFormattedTextField(new SimpleDateFormat("yyyy/MM/dd"));
        diagnosisTextField = new javax.swing.JFormattedTextField(new RegexFormatter(nameRegEx));

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

        saveButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        lastNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameTextFieldActionPerformed(evt);
            }
        });

        admissionDateTextField.setToolTipText("yyyy/mm/dd");
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

        releaseDateTextField.setToolTipText("yyyy/mm/dd");

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
                                .addComponent(releaseDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(releaseDateTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(admissionDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(admissionDateTextField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(diagnosisLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(diagnosisTextField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(FirstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(firstNameTextField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lastNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lastNameTextField))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lastNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lastNameTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FirstNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(firstNameTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(diagnosisLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(diagnosisTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(admissionDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(admissionDateTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(releaseDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(releaseDateTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

        PatientBean tempPatient = new PatientBean();

        //getting the patient bean values from the formattedtextfield inputs
        String lastName = lastNameTextField.getText();
        String firstName = firstNameTextField.getText();
        String diagnosis = diagnosisTextField.getText();

        //WHAT IF THE USER DOESN'T ENTER A DATE?????
        Date admissionDate = (Date) admissionDateTextField.getValue();
        Timestamp admissionDateTimestamp = new Timestamp(admissionDate.getTime());

        Date releaseDate = (Date) releaseDateTextField.getValue();
        Timestamp releaseDateTimestamp = new Timestamp(releaseDate.getTime());
        
        //placing the values in the bean itself
        tempPatient.setLastName(lastName);
        tempPatient.setFirstName(firstName);
        tempPatient.setDiagnosis(diagnosis);
        tempPatient.setAdmissionDate(admissionDateTimestamp);
        tempPatient.setReleaseDate(releaseDateTimestamp);             
        
        try {
            patientDBManager.createPatient(tempPatient);
        } catch (SQLException ex) {
            Logger.getLogger(PatientForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        patientFormFrame.dispose();
        
    }//GEN-LAST:event_saveButtonActionPerformed

    private void lastNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameTextFieldActionPerformed

    }//GEN-LAST:event_lastNameTextFieldActionPerformed

    private void admissionDateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admissionDateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_admissionDateTextFieldActionPerformed

    private void firstNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameTextFieldActionPerformed

    private MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage()); //$NON-NLS-1$
            System.exit(-1);
        }
        return formatter;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FirstNameLabel;
    private javax.swing.JLabel admissionDateLabel;
    private javax.swing.JFormattedTextField admissionDateTextField;
    private javax.swing.JLabel diagnosisLabel;
    private javax.swing.JFormattedTextField diagnosisTextField;
    private javax.swing.JFormattedTextField firstNameTextField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JFormattedTextField lastNameTextField;
    private javax.swing.JLabel releaseDateLabel;
    private javax.swing.JFormattedTextField releaseDateTextField;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
