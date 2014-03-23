package com.posthoffice.jipprojectmposth.presentation;

import com.posthoffice.jipprojectmposth.beans.InpatientBean;
import com.posthoffice.jipprojectmposth.beans.LiveDataBean;
import com.posthoffice.jipprojectmposth.beans.PatientBean;
import com.posthoffice.jipprojectmposth.database.InpatientDBManagement;
import com.posthoffice.jipprojectmposth.database.PatientDBManagement;
import com.posthoffice.jipprojectmposth.model.PatientDBTableModel;
import com.posthoffice.jipprojectmposth.regex.Messages;
import com.posthoffice.jipprojectmposth.regex.RegexFormatter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InpatientForm extends javax.swing.JPanel {

    private String nameRegEx = ".+";
    private String moneyRegEx = "^[+-]?[0-9]{1,3}(?:[0-9]*(?:[.,][0-9]{2})?|(?:,[0-9]{3})*(?:\\.[0-9]{2})?|(?:\\.[0-9]{3})*(?:,[0-9]{2})?)$";
    private LiveDataBean liveDataBean;

    public InpatientForm() {
        initComponents();
    }

    public InpatientForm(LiveDataBean liveDataBean) {
        this.liveDataBean = liveDataBean;
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
        saveButton = new javax.swing.JButton();
        dateOfStayTextField = new javax.swing.JFormattedTextField(new SimpleDateFormat("yyyy/MM/dd"));
        roomNumberTextField = new javax.swing.JFormattedTextField(new RegexFormatter(nameRegEx));
        dailyRateTextField = new javax.swing.JFormattedTextField(new RegexFormatter(moneyRegEx));
        suppliesTextField = new javax.swing.JFormattedTextField(new RegexFormatter(moneyRegEx));
        servicesTextField = new javax.swing.JFormattedTextField(new RegexFormatter(moneyRegEx));

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

        saveButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        dateOfStayTextField.setToolTipText("yyyy/mm/dd");

        dailyRateTextField.setToolTipText("$ #,###.##");

        suppliesTextField.setToolTipText("$ #,###.##");
        suppliesTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppliesTextFieldActionPerformed(evt);
            }
        });

        servicesTextField.setToolTipText("$ #,###.##");

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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(servicesTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(suppliesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(suppliesTextField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dailyRateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dailyRateTextField))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(roomNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateOfStayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dateOfStayTextField)
                                    .addComponent(roomNumberTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateOfStayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(dateOfStayTextField))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roomNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(roomNumberTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dailyRateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(dailyRateTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(suppliesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(suppliesTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(servicesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(servicesTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

        InpatientBean tempInpatient = new InpatientBean();

        Date dateOfStay = (Date) dateOfStayTextField.getValue();
        Timestamp dateOfStayTimestamp = new Timestamp(dateOfStay.getTime());

        String roomNumber = roomNumberTextField.getText();

        String dailyRateAsString = dailyRateTextField.getText();
        BigDecimal dailyRate = new BigDecimal(dailyRateAsString.replaceAll(",", ""));

        String suppliesAsString = suppliesTextField.getText();
        BigDecimal supplies = new BigDecimal(suppliesAsString.replaceAll(",", ""));

        String servicesAsString = servicesTextField.getText();
        BigDecimal services = new BigDecimal(servicesAsString.replaceAll(",", ""));

        tempInpatient.setDateOfStay(dateOfStayTimestamp);
        tempInpatient.setRoomNumber(roomNumber);
        tempInpatient.setDailyRate(dailyRate);
        tempInpatient.setRoomSupplies(supplies);
        tempInpatient.setRoomServices(services);

        tempInpatient.setPatientID(liveDataBean.getSelectedPatientID());

        InpatientDBManagement inpatientFormAddition = liveDataBean.getInpatientDBManager();

        try {
            inpatientFormAddition.createInpatient(tempInpatient);
        } catch (SQLException ex) {
            Logger.getLogger(InpatientForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PatientDBManagement testPatientDB = liveDataBean.getPatientDBManager();
        
        try {
            testPatientDB.updatePatient(liveDataBean.getSelectedPatientBean());
            
       PatientDBTableModel patientModelTest = liveDataBean.getPatientModel();   

        } catch (SQLException ex) {
            Logger.getLogger(InpatientForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void suppliesTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppliesTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suppliesTextFieldActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dailyRateLabel;
    private javax.swing.JFormattedTextField dailyRateTextField;
    private javax.swing.JLabel dateOfStayLabel;
    private javax.swing.JFormattedTextField dateOfStayTextField;
    private javax.swing.JLabel roomNumberLabel;
    private javax.swing.JFormattedTextField roomNumberTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel servicesLabel;
    private javax.swing.JFormattedTextField servicesTextField;
    private javax.swing.JLabel suppliesLabel;
    private javax.swing.JFormattedTextField suppliesTextField;
    // End of variables declaration//GEN-END:variables
}
