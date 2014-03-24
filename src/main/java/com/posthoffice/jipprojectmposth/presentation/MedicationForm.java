package com.posthoffice.jipprojectmposth.presentation;

import com.posthoffice.jipprojectmposth.beans.LiveDataBean;
import com.posthoffice.jipprojectmposth.beans.MedicationBean;
import com.posthoffice.jipprojectmposth.database.MedicationDBManagement;
import com.posthoffice.jipprojectmposth.database.PatientDBManagement;
import com.posthoffice.jipprojectmposth.regex.Messages;
import com.posthoffice.jipprojectmposth.regex.RegexFormatter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class MedicationForm extends javax.swing.JPanel {

    private String nameRegEx = ".+";
    private String moneyRegEx = "^[+-]?[0-9]{1,3}(?:[0-9]*(?:[.,][0-9]{2})?|(?:,[0-9]{3})*(?:\\.[0-9]{2})?|(?:\\.[0-9]{3})*(?:,[0-9]{2})?)$";
    private String digitRegEx = "[0-9]+";
    
    private JFrame medicationFormFrame;
    
    private PatientDBManagement patientDBManager;
    private MedicationDBManagement medicationDBManager;
    
    private LiveDataBean liveDataBean;

    public MedicationForm() {
        
        this.patientDBManager = new PatientDBManagement();
        this.medicationDBManager = new MedicationDBManagement();
        
        this.liveDataBean = new LiveDataBean();
        
        this.medicationFormFrame = new JFrame();
        
        initComponents();
    }
    
    public MedicationForm(PatientDBManagement patientDBManager, MedicationDBManagement medicationDBManager, 
            LiveDataBean liveDataBean, JFrame medicationFormFrame) {
        
        this.patientDBManager = patientDBManager;
        this.medicationDBManager = medicationDBManager;
        
        this.liveDataBean = liveDataBean;
        
        this.medicationFormFrame = medicationFormFrame;
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        medicationLabel = new javax.swing.JLabel(Messages.getString("medication"));
        dateOfMedLabel = new javax.swing.JLabel(Messages.getString("dateofmed"));
        unitsLabel = new javax.swing.JLabel(Messages.getString("units"));
        unitCostLabel = new javax.swing.JLabel(Messages.getString("unitcost"));
        saveButton = new javax.swing.JButton();
        dateOfMedTextField = new javax.swing.JFormattedTextField(new SimpleDateFormat("yyyy/mm/dd"));
        medicationTextField = new javax.swing.JFormattedTextField(new RegexFormatter(nameRegEx));
        costPerUnitTextField = new javax.swing.JFormattedTextField(new RegexFormatter(moneyRegEx));
        unitsTextField = new javax.swing.JFormattedTextField(new RegexFormatter(digitRegEx));

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

        saveButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        dateOfMedTextField.setToolTipText("yyyy/mm/dd");

        costPerUnitTextField.setToolTipText("$ #,###.##");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dateOfMedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateOfMedTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(medicationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(medicationTextField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(unitCostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(costPerUnitTextField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(unitsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(unitsTextField)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateOfMedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(dateOfMedTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(medicationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(medicationTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(unitCostLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(costPerUnitTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(unitsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(unitsTextField))
                .addGap(18, 18, 18)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

        MedicationBean tempMedication = new MedicationBean();

        Date dateOfMed = (Date) dateOfMedTextField.getValue();
        Timestamp dateOfMedTimestamp = new Timestamp(dateOfMed.getTime());
        
        String medication = medicationTextField.getText();
        
        String costPerUnitAsString = costPerUnitTextField.getText();
        BigDecimal costPerUnit = new BigDecimal(costPerUnitAsString.replaceAll(",", ""));
        
        String unitsAsString = unitsTextField.getText();
        BigDecimal units = new BigDecimal(unitsAsString);
        
        tempMedication.setDateOfMed(dateOfMedTimestamp);
        tempMedication.setMedication(medication);
        tempMedication.setCostPerUnit(costPerUnit);
        tempMedication.setNumberOfUnits(units);
        
        tempMedication.setPatientID(liveDataBean.getSelectedPatientID());      
        
        try {
            medicationDBManager.createMedication(tempMedication);
        } catch (SQLException ex) {
            Logger.getLogger(MedicationForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            patientDBManager.updatePatient(liveDataBean.getSelectedPatientBean());
        } catch (SQLException ex) {
            Logger.getLogger(MedicationForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        medicationFormFrame.dispose();
        
    }//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField costPerUnitTextField;
    private javax.swing.JLabel dateOfMedLabel;
    private javax.swing.JFormattedTextField dateOfMedTextField;
    private javax.swing.JLabel medicationLabel;
    private javax.swing.JFormattedTextField medicationTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel unitCostLabel;
    private javax.swing.JLabel unitsLabel;
    private javax.swing.JFormattedTextField unitsTextField;
    // End of variables declaration//GEN-END:variables
}
