package com.posthoffice.jipprojectmposth.presentation;

import com.posthoffice.jipprojectmposth.beans.InpatientBean;
import com.posthoffice.jipprojectmposth.beans.LiveDataBean;
import com.posthoffice.jipprojectmposth.beans.MedicationBean;
import com.posthoffice.jipprojectmposth.beans.PatientBean;
import com.posthoffice.jipprojectmposth.beans.SurgicalBean;
import com.posthoffice.jipprojectmposth.database.InpatientDBManagement;
import com.posthoffice.jipprojectmposth.database.MedicationDBManagement;
import com.posthoffice.jipprojectmposth.database.PatientDBManagement;
import com.posthoffice.jipprojectmposth.database.SurgicalDBManagement;
import com.posthoffice.jipprojectmposth.model.InpatientDBTableModel;
import com.posthoffice.jipprojectmposth.model.MedicationDBTableModel;
import com.posthoffice.jipprojectmposth.model.PatientDBTableModel;
import com.posthoffice.jipprojectmposth.model.SurgicalDBTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
    private MedicationDBManagement medicationDBManager;
    private SurgicalDBManagement surgicalDBManager;
    private PatientDBManagement patientDBManager;
    private LiveDataBean liveDataBean;

    public JIPFramePresentation() {

        inpatientModel = new InpatientDBTableModel();
        medicationModel = new MedicationDBTableModel();
        surgicalModel = new SurgicalDBTableModel();
        patientModel = new PatientDBTableModel(inpatientModel, medicationModel, surgicalModel);

        inpatientDBManager = new InpatientDBManagement(inpatientModel);
        medicationDBManager = new MedicationDBManagement(medicationModel);
        surgicalDBManager = new SurgicalDBManagement(surgicalModel);
        patientDBManager = new PatientDBManagement(patientModel, inpatientDBManager, medicationDBManager, surgicalDBManager);

        liveDataBean = new LiveDataBean();

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar = createToolBar();
        splitPanelPanel1 = new com.posthoffice.jipprojectmposth.presentation.SplitPanelPanel(patientModel, inpatientModel, medicationModel, surgicalModel, liveDataBean,
            patientDBManager, inpatientDBManager, medicationDBManager, surgicalDBManager);
        jMenuBar1 = createMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Patient Management System");

        jToolBar.setRollover(true);
        getContentPane().add(jToolBar, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(splitPanelPanel1, java.awt.BorderLayout.CENTER);
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

    public JMenuBar createMenuBar() {

        JMenuBar menuBar;
        JMenu menuMain, menuNew, menuDelete;
        JMenuItem newPatient, newInpatient, newMedication, newSurgical,
                deletePatient, deleteInpatient, deleteMedication, deleteSurgical,
                itemExit;

        menuBar = new JMenuBar();

        menuMain = new JMenu("File");
        menuBar.add(menuMain);

        menuNew = new JMenu("New");

        newPatient = new JMenuItem("Patient");
        newPatient.setActionCommand("NewPatient");
        newPatient.addActionListener(this);

        newInpatient = new JMenuItem("Inpatient");
        newInpatient.setActionCommand("NewInpatient");
        newInpatient.addActionListener(this);

        newMedication = new JMenuItem("Medication");
        newMedication.setActionCommand("NewMedication");
        newMedication.addActionListener(this);

        newSurgical = new JMenuItem("Surgical");
        newSurgical.setActionCommand("NewSurgical");
        newSurgical.addActionListener(this);

        menuNew.add(newPatient);
        menuNew.add(newInpatient);
        menuNew.add(newMedication);
        menuNew.add(newSurgical);

        menuDelete = new JMenu("Delete");

        deletePatient = new JMenuItem("Patient");
        deletePatient.setActionCommand("DeletePatient");
        deletePatient.addActionListener(this);

        deleteInpatient = new JMenuItem("Inpatient");
        deleteInpatient.setActionCommand("DeleteInpatient");
        deleteInpatient.addActionListener(this);

        deleteMedication = new JMenuItem("Medication");
        deleteMedication.setActionCommand("DeleteMedication");
        deleteMedication.addActionListener(this);

        deleteSurgical = new JMenuItem("Surgical");
        deleteSurgical.setActionCommand("DeleteSurgical");
        deleteSurgical.addActionListener(this);

        menuDelete.add(deletePatient);
        menuDelete.add(deleteInpatient);
        menuDelete.add(deleteMedication);
        menuDelete.add(deleteSurgical);

        itemExit = new JMenuItem("Exit");
        itemExit.setActionCommand("Exit");
        itemExit.addActionListener(this);

        menuMain.add(menuNew);
        menuMain.add(menuDelete);
        menuMain.add(itemExit);

        return menuBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem) (e.getSource());

        switch (source.getActionCommand()) {

            case "NewPatient":
                createPatientForm();
                break;

            case "NewInpatient":
                createInpatientForm();
                break;

            case "NewMedication":
                createMedicationForm();
                break;

            case "NewSurgical":
                createSurgicalForm();
                break;

            case "DeletePatient":
                try {
                    deletePatientForm();
                } catch (SQLException ex) {
                    Logger.getLogger(JIPFramePresentation.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "DeleteInpatient":
                try {
                    deleteInpatientForm();
                } catch (SQLException ex) {
                    Logger.getLogger(JIPFramePresentation.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "DeleteMedication":
                try {
                    deleteMedicationForm();
                } catch (SQLException ex) {
                    Logger.getLogger(JIPFramePresentation.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "DeleteSurgical":
                try {
                    deleteSurgicalForm();
                } catch (SQLException ex) {
                    Logger.getLogger(JIPFramePresentation.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                
            case "Exit":
                JIPFramePresentation.this.dispose();
                break;


        }
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

    class ToolBarEventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) (e.getSource());

            switch (source.getActionCommand()) {

                case "NewPatient":
                    createPatientForm();
                    break;

                case "DeletePatient":
                    try {
                        deletePatientForm();
                    } catch (SQLException ex) {
                        Logger.getLogger(JIPFramePresentation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

                case "NewInpatient":
                    createInpatientForm();
                    break;

                case "DeleteInpatient":
                    try {
                        deleteInpatientForm();
                    } catch (SQLException ex) {
                        Logger.getLogger(JIPFramePresentation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

                case "NewMedication":
                    createMedicationForm();
                    break;

                case "DeleteMedication":
                    try {
                        deleteMedicationForm();
                    } catch (SQLException ex) {
                        Logger.getLogger(JIPFramePresentation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

                case "NewSurgical":
                    createSurgicalForm();
                    break;

                case "DeleteSurgical":
                    try {
                        deleteSurgicalForm();
                    } catch (SQLException ex) {
                        Logger.getLogger(JIPFramePresentation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            }

        }
    }

    public void createPatientForm() {

        JFrame patientFormFrame = new JFrame("New Patient");
        PatientForm patientForm = new PatientForm(patientDBManager, patientFormFrame);
        JScrollPane patientFormScroll = new JScrollPane(patientForm);

        patientFormFrame.getContentPane().add(patientFormScroll);
        patientFormFrame.pack();
        patientFormFrame.setLocationRelativeTo(null);
        patientFormFrame.setVisible(true);
        patientFormFrame.setResizable(false);

    }

    public void deletePatientForm() throws SQLException {

        if (!(liveDataBean.getSelectedPatientRow() == -1)) {

            PatientBean selectedPatient = liveDataBean.getSelectedPatientBean();

            String optionPaneMessage = "Are you sure you want to delete " + selectedPatient.getLastName()
                    + ", " + selectedPatient.getFirstName() + "?";

            int selectedOption = JOptionPane.showConfirmDialog(null, optionPaneMessage, "Delete Patient", JOptionPane.YES_NO_OPTION);

            if (selectedOption == JOptionPane.YES_OPTION) {

                patientDBManager.deletePatient(selectedPatient);

                patientModel.fireTableDataChanged();
                patientModel.deleteRow(liveDataBean.getSelectedPatientRow());

                inpatientModel.deleteAllRows();
                medicationModel.deleteAllRows();
                surgicalModel.deleteAllRows();

                liveDataBean.setSelectedPatientRow(-1);

            }

        } else {
            JFrame dialogue = new JFrame();
            JOptionPane.showMessageDialog(dialogue, "Please select a patient", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void createInpatientForm() {

        PatientBean tempPatient = liveDataBean.getSelectedPatientBean();

        if (!(liveDataBean.getSelectedPatientRow() == -1)) {

            JFrame inpatientFormFrame = new JFrame("Inpatient Form: " + tempPatient.getLastName() + ", "
                    + tempPatient.getFirstName() + " | ID: " + tempPatient.getPatientID());

            InpatientForm inpatientForm = new InpatientForm(patientDBManager, inpatientDBManager, liveDataBean, inpatientFormFrame);
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

    public void deleteInpatientForm() throws SQLException {

        if (!(liveDataBean.getSelectedPatientRow() == -1)) {

            PatientBean selectedPatient = liveDataBean.getSelectedPatientBean();

            if (!(liveDataBean.getSelectedInpatientRow() == -1)) {

                String optionPaneMessage = "Are you sure you want to delete the Inpatient data from " + selectedPatient.getLastName()
                        + ", " + selectedPatient.getFirstName() + "?";

                int selectedOption = JOptionPane.showConfirmDialog(null, optionPaneMessage, "Delete Inpatient", JOptionPane.YES_NO_OPTION);

                if (selectedOption == JOptionPane.YES_OPTION) {

                    InpatientBean selectedInpatient = inpatientModel.getinPatientData(liveDataBean.getSelectedInpatientRow());

                    inpatientDBManager.deleteInpatient(selectedInpatient);

                    patientDBManager.updatePatient(selectedPatient);

                    inpatientModel.deleteRow(liveDataBean.getSelectedInpatientRow());

                    liveDataBean.setSelectedInpatientRow(-1);

                }
            } else {
                JFrame dialogue = new JFrame();
                JOptionPane.showMessageDialog(dialogue, "Please select the inpatient data to delete", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JFrame dialogue = new JFrame();
            JOptionPane.showMessageDialog(dialogue, "Please select a patient", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void createMedicationForm() {

        PatientBean tempPatient = liveDataBean.getSelectedPatientBean();

        if (!(liveDataBean.getSelectedPatientRow() == -1)) {

            JFrame medicationFormFrame = new JFrame("Medication Form: " + tempPatient.getLastName() + ", "
                    + tempPatient.getFirstName() + " | ID: " + tempPatient.getPatientID());

            MedicationForm medicationForm = new MedicationForm(patientDBManager, medicationDBManager, liveDataBean, medicationFormFrame);
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

    public void deleteMedicationForm() throws SQLException {

        if (!(liveDataBean.getSelectedPatientRow() == -1)) {

            PatientBean selectedPatient = liveDataBean.getSelectedPatientBean();

            if (!(liveDataBean.getSelectedMedicationRow() == -1)) {

                String optionPaneMessage = "Are you sure you want to delete the medication data from " + selectedPatient.getLastName()
                        + ", " + selectedPatient.getFirstName() + "?";

                int selectedOption = JOptionPane.showConfirmDialog(null, optionPaneMessage, "Delete Medication", JOptionPane.YES_NO_OPTION);

                if (selectedOption == JOptionPane.YES_OPTION) {

                    MedicationBean selectedMedication = medicationModel.getMedicationData(liveDataBean.getSelectedMedicationRow());

                    medicationDBManager.deleteMedication(selectedMedication);

                    patientDBManager.updatePatient(selectedPatient);

                    medicationModel.deleteRow(liveDataBean.getSelectedMedicationRow());

                    liveDataBean.setSelectedMedicationRow(-1);

                }
            } else {
                JFrame dialogue = new JFrame();
                JOptionPane.showMessageDialog(dialogue, "Please select the medication data to delete", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JFrame dialogue = new JFrame();
            JOptionPane.showMessageDialog(dialogue, "Please select a patient", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void createSurgicalForm() {

        PatientBean tempPatient = liveDataBean.getSelectedPatientBean();

        if (!(liveDataBean.getSelectedPatientRow() == -1)) {

            JFrame surgicalFormFrame = new JFrame("Surgical Form: " + tempPatient.getLastName() + ", "
                    + tempPatient.getFirstName() + " | ID: " + liveDataBean.getSelectedPatientID());

            SurgicalForm surgicalForm = new SurgicalForm(patientDBManager, surgicalDBManager, liveDataBean, surgicalFormFrame);
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

    public void deleteSurgicalForm() throws SQLException {

        if (!(liveDataBean.getSelectedPatientRow() == -1)) {

            PatientBean selectedPatient = liveDataBean.getSelectedPatientBean();

            if (!(liveDataBean.getSelectedSurgicalRow() == -1)) {

                String optionPaneMessage = "Are you sure you want to delete the surgical data from " + selectedPatient.getLastName()
                        + ", " + selectedPatient.getFirstName() + "?";

                int selectedOption = JOptionPane.showConfirmDialog(null, optionPaneMessage, "Delete Surgical", JOptionPane.YES_NO_OPTION);

                if (selectedOption == JOptionPane.YES_OPTION) {

                    SurgicalBean selectedSurgical = surgicalModel.getSurgicalData(liveDataBean.getSelectedSurgicalRow());

                    surgicalDBManager.deleteSurgical(selectedSurgical);

                    patientDBManager.updatePatient(selectedPatient);

                    surgicalModel.deleteRow(liveDataBean.getSelectedSurgicalRow());

                    liveDataBean.setSelectedSurgicalRow(-1);

                    System.out.println("selected surgical row after deleting is " + liveDataBean.getSelectedSurgicalRow());
                }
            } else {
                JFrame dialogue = new JFrame();
                JOptionPane.showMessageDialog(dialogue, "Please select the surgical data to delete", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JFrame dialogue = new JFrame();
            JOptionPane.showMessageDialog(dialogue, "Please select a patient", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JToolBar jToolBar;
    private com.posthoffice.jipprojectmposth.presentation.SplitPanelPanel splitPanelPanel1;
    // End of variables declaration//GEN-END:variables
}
