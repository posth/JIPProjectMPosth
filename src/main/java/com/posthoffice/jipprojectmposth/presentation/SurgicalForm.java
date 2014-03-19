package com.posthoffice.jipprojectmposth.presentation;

import com.posthoffice.jipprojectmposth.beans.SurgicalBean;
import com.posthoffice.jipprojectmposth.regex.Messages;
import com.posthoffice.jipprojectmposth.regex.RegexFormatter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

public class SurgicalForm extends javax.swing.JPanel {
    
    private String nameRegEx = ".+";
    private String moneyRegEx = "^[+-]?[0-9]{1,3}(?:[0-9]*(?:[.,][0-9]{2})?|(?:,[0-9]{3})*(?:\\.[0-9]{2})?|(?:\\.[0-9]{3})*(?:,[0-9]{2})?)$";

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
        saveButton = new javax.swing.JButton();
        dateOfSurgeryTextField = new javax.swing.JFormattedTextField(new SimpleDateFormat("yyyy/mm/dd"));
        surgeryTextField = new javax.swing.JFormattedTextField(new RegexFormatter(nameRegEx));
        roomFeeTextField = new javax.swing.JFormattedTextField(new RegexFormatter(moneyRegEx));
        surgeonsFeeTextField = new javax.swing.JFormattedTextField(new RegexFormatter(moneyRegEx));
        suppliesTextField = new javax.swing.JFormattedTextField(new RegexFormatter(moneyRegEx));

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

        saveButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        dateOfSurgeryTextField.setToolTipText("yyyy/mm/dd");

        roomFeeTextField.setToolTipText("$ #,###.##");

        surgeonsFeeTextField.setToolTipText("$ #,###.##");

        suppliesTextField.setToolTipText("$ #,###.##");

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
                                .addComponent(dateOfSurgeryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateOfSurgeryTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(surgeryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(surgeryTextField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(roomFeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(roomFeeTextField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(surgeonsFeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(surgeonsFeeTextField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(suppliesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(suppliesTextField))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateOfSurgeryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(dateOfSurgeryTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(surgeryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(surgeryTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roomFeeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(roomFeeTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(surgeonsFeeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(surgeonsFeeTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(suppliesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(suppliesTextField))
                .addGap(18, 18, 18)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
       
        SurgicalBean tempSurgical = new SurgicalBean();
        
        SimpleDateFormat dateOfSurgery = (SimpleDateFormat) dateOfSurgeryTextField.getValue();
        
        String surgery = surgeryTextField.getText();
        
        String roomFeeAsString = roomFeeTextField.getText();
        BigDecimal roomFee = new BigDecimal(roomFeeAsString.replaceAll(",", ""));
        
        String surgeonsFeeAsString = surgeonsFeeTextField.getText();
        BigDecimal surgeonsFee = new BigDecimal(surgeonsFeeAsString.replaceAll(",", ""));
        
        String supupliesAsString = suppliesTextField.getText();
        BigDecimal supplies = new BigDecimal(supupliesAsString.replaceAll(",", ""));
        
    }//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateOfSurgeryLabel;
    private javax.swing.JFormattedTextField dateOfSurgeryTextField;
    private javax.swing.JLabel roomFeeLabel;
    private javax.swing.JFormattedTextField roomFeeTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel suppliesLabel;
    private javax.swing.JFormattedTextField suppliesTextField;
    private javax.swing.JLabel surgeonsFeeLabel;
    private javax.swing.JFormattedTextField surgeonsFeeTextField;
    private javax.swing.JLabel surgeryLabel;
    private javax.swing.JFormattedTextField surgeryTextField;
    // End of variables declaration//GEN-END:variables
}
