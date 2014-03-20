package com.posthoffice.jipprojectmposth.presentation;

import com.posthoffice.jipprojectmposth.beans.LiveDataBean;
import com.posthoffice.jipprojectmposth.database.InpatientDBManagement;
import com.posthoffice.jipprojectmposth.model.InpatientDBTableModel;
import com.posthoffice.jipprojectmposth.model.MedicationDBTableModel;
import com.posthoffice.jipprojectmposth.model.PatientDBTableModel;
import com.posthoffice.jipprojectmposth.model.SurgicalDBTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

public class JIPFramePresentation extends javax.swing.JFrame implements ActionListener {

    public static final String URL = "jdbc:mysql://localhost:3306/PATIENTDB";
    public static final String USER = "root";
    public static final String PASSWORD = "Johnny23";

    private PatientDBTableModel patientModel;
    private InpatientDBTableModel inpatientModel;
    private MedicationDBTableModel medicationModel;
    private SurgicalDBTableModel surgicalModel;
    
    private InpatientDBManagement inpatientDBManager;

    private LiveDataBean liveDataBean;

    public JIPFramePresentation() {

        inpatientModel = new InpatientDBTableModel();
        medicationModel = new MedicationDBTableModel();
        surgicalModel = new SurgicalDBTableModel();
        patientModel = new PatientDBTableModel(inpatientModel, medicationModel, surgicalModel);

        inpatientDBManager = new InpatientDBManagement(inpatientModel);
        
        liveDataBean = new LiveDataBean(inpatientDBManager);

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar = createToolBar();
        splitPanelPanel1 = new com.posthoffice.jipprojectmposth.presentation.SplitPanelPanel(patientModel, inpatientModel, medicationModel, surgicalModel, liveDataBean);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Patient Management System");

        jToolBar.setRollover(true);
        getContentPane().add(jToolBar, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(splitPanelPanel1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");

        jMenuItem1.setText("Exit");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                JIPFramePresentation jipPresentation = new JIPFramePresentation();
                jipPresentation.setVisible(true);
                jipPresentation.setExtendedState(jipPresentation.getExtendedState() | JFrame.MAXIMIZED_BOTH);
            }
        });
    }

    private JToolBar createToolBar() {

        JToolBar toolBar = new JToolBar();

        JButton newPatientButton = makeToolBarButton("New Patient", "NewPatient", "Add a new patient");
        JButton deletePatientButton = makeToolBarButton("Delete Patient", "DeletePatient", "Delete existing patient");

        JButton newInpatientButton = makeToolBarButton("New Inpatient", "NewInpatient", "Add new inpatient data to existing patient");
        JButton deleteInpatientButton = makeToolBarButton("Delete Inpatient", "DeleteInpatient", "Delete inpatient data from existing patient");

        JButton newMedicationButton = makeToolBarButton("New Medication", "NewMedication", "Add new medication data to existing patient");
        JButton deleteMedicationButton = makeToolBarButton("Delete Medication", "DeleteMedication", "Delete medication data from existing patient");

        JButton newSurgicalButton = makeToolBarButton("New Surgical", "NewSurgical", "Add new surgical data to existing patient");
        JButton deleteSurgicalButton = makeToolBarButton("Delete Surgical", "DeleteSurgical", "Delete surgical data from existing patient");

        toolBar.add(newPatientButton);
        toolBar.add(deletePatientButton);
        toolBar.add(newInpatientButton);
        toolBar.add(deleteInpatientButton);
        toolBar.add(newMedicationButton);
        toolBar.add(deleteMedicationButton);
        toolBar.add(newSurgicalButton);
        toolBar.add(deleteSurgicalButton);

        toolBar.setFloatable(true);

        return toolBar;
    }

    private JButton makeToolBarButton(String buttonName, String actionCommand, String toolTipText) {

        ToolBarEventHandler toolBarEventHandler = new ToolBarEventHandler();

        JButton button = new JButton();

        button.setText(buttonName);
        button.setActionCommand(actionCommand);
        button.setToolTipText(toolTipText);
        button.addActionListener(toolBarEventHandler);

        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    class ToolBarEventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) (e.getSource());

            switch (source.getActionCommand()) {

                case "NewPatient":
                    createPatientForm();
                    break;

                case "DeletePatient":
                    deletePatientForm();
                    break;

                case "NewInpatient":
                    createInpatientForm();
                    break;

                case "DeleteInpatient":
                    deleteInpatientForm();
                    break;

                case "NewMedication":
                    createMedicationForm();
                    break;

                case "DeleteMedication":
                    deleteMedicationForm();
                    break;

                case "NewSurgical":
                    createSurgicalForm();
                    break;

                case "DeleteSurgical":
                    deleteSurgicalForm();
                    break;
            }

        }
    }

    public void createPatientForm() {

        JFrame patientFormFrame = new JFrame("New Patient");
        PatientForm patientForm = new PatientForm(liveDataBean);
        JScrollPane patientFormScroll = new JScrollPane(patientForm);

        patientFormFrame.getContentPane().add(patientFormScroll);
        patientFormFrame.pack();
        patientFormFrame.setLocationRelativeTo(null);
        patientFormFrame.setVisible(true);
        patientFormFrame.setResizable(false);

    }

    public void deletePatientForm() {
        //to do based on selectedRow
    }

    public void createInpatientForm() {

        if (!(liveDataBean.getSelectedPatientRow() == -1)) {

            JFrame inpatientFormFrame = new JFrame(liveDataBean.getSelectedPatientLastName() + ", "
                    + liveDataBean.getSelectedPatientFirstName() + " | ID Number: " + liveDataBean.getSelectedPatientID());

            InpatientForm inpatientForm = new InpatientForm(liveDataBean);
            JScrollPane inpatientFormScroll = new JScrollPane(inpatientForm);

            inpatientFormFrame.getContentPane().add(inpatientFormScroll);
            inpatientFormFrame.pack();
            inpatientFormFrame.setLocationRelativeTo(null);
            inpatientFormFrame.setVisible(true);
            inpatientFormFrame.setResizable(false);
        } else {
            JFrame dialogue = new JFrame();
            JOptionPane.showMessageDialog(dialogue, "Please select a patient", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void deleteInpatientForm() {
        //to do based on selected patient and selected inpatient rows

    }

    public void createMedicationForm() {

        if (!(liveDataBean.getSelectedPatientRow() == -1)) {

            JFrame medicationFormFrame = new JFrame(liveDataBean.getSelectedPatientLastName() + ", "
                    + liveDataBean.getSelectedPatientFirstName() + " | ID Number: " + liveDataBean.getSelectedPatientID());

            MedicationForm medicationForm = new MedicationForm();
            JScrollPane medicationFormScroll = new JScrollPane(medicationForm);

            medicationFormFrame.getContentPane().add(medicationFormScroll);
            medicationFormFrame.pack();
            medicationFormFrame.setLocationRelativeTo(null);
            medicationFormFrame.setVisible(true);
            medicationFormFrame.setResizable(false);
        } else {
            JFrame dialogue = new JFrame();
            JOptionPane.showMessageDialog(dialogue, "Please select a patient", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void deleteMedicationForm() {
        //to do based on selected patient and selected medication rows

    }

    public void createSurgicalForm() {

        if (!(liveDataBean.getSelectedPatientRow() == -1)) {

            JFrame surgicalFormFrame = new JFrame(liveDataBean.getSelectedPatientLastName() + ", "
                    + liveDataBean.getSelectedPatientFirstName() + " | ID Number: " + liveDataBean.getSelectedPatientID());

            SurgicalForm surgicalForm = new SurgicalForm();
            JScrollPane surgicalFormScroll = new JScrollPane(surgicalForm);

            surgicalFormFrame.getContentPane().add(surgicalFormScroll);
            surgicalFormFrame.pack();
            surgicalFormFrame.setLocationRelativeTo(null);
            surgicalFormFrame.setVisible(true);
            surgicalFormFrame.setResizable(false);
        } else {
            JFrame dialogue = new JFrame();
            JOptionPane.showMessageDialog(dialogue, "Please select a patient", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void deleteSurgicalForm() {
        //to do based on selected patient and selected surgical rows
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JToolBar jToolBar;
    private com.posthoffice.jipprojectmposth.presentation.SplitPanelPanel splitPanelPanel1;
    // End of variables declaration//GEN-END:variables
}
