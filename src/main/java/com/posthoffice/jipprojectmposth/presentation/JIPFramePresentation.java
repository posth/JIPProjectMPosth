package com.posthoffice.jipprojectmposth.presentation;

import com.posthoffice.jipprojectmposth.regex.Messages;
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
import com.posthoffice.jipprojectmposth.model.ReceiptTableModel;
import com.posthoffice.jipprojectmposth.model.SurgicalDBTableModel;
import com.posthoffice.jipprojectmposth.properties.DBConnectionBean;
import com.posthoffice.jipprojectmposth.properties.PropertiesManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.TableColumn;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class JIPFramePresentation extends javax.swing.JFrame implements ActionListener {

    private PatientDBTableModel patientModel;
    private InpatientDBTableModel inpatientModel;
    private MedicationDBTableModel medicationModel;
    private SurgicalDBTableModel surgicalModel;
    private InpatientDBManagement inpatientDBManager;
    private MedicationDBManagement medicationDBManager;
    private SurgicalDBManagement surgicalDBManager;
    private PatientDBManagement patientDBManager;
    private LiveDataBean liveDataBean;
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public JIPFramePresentation() {

        inpatientModel = new InpatientDBTableModel();
        medicationModel = new MedicationDBTableModel();
        surgicalModel = new SurgicalDBTableModel();
        patientModel = new PatientDBTableModel(inpatientModel, medicationModel, surgicalModel);

        liveDataBean = new LiveDataBean();

        try {
            getConnectionDetails();
        } catch (IOException ex) {
            Logger.getLogger(JIPFramePresentation.class.getName()).log(Level.SEVERE, null, ex);
        }

        inpatientDBManager = new InpatientDBManagement(inpatientModel, liveDataBean);
        medicationDBManager = new MedicationDBManagement(medicationModel, liveDataBean);
        surgicalDBManager = new SurgicalDBManagement(surgicalModel, liveDataBean);
        patientDBManager = new PatientDBManagement(patientModel, inpatientDBManager, medicationDBManager, surgicalDBManager, liveDataBean);

        setIcon();

        initComponents();
    }

    /**
     * Getting the database connection details from the properties file.
     *
     * @throws IOException
     */
    public void getConnectionDetails() throws IOException {

        PropertiesManager prop = new PropertiesManager();
        DBConnectionBean dBBean = prop.loadProperties();

        liveDataBean.setURL(dBBean.getUrl());
        liveDataBean.setUSER(dBBean.getUser());
        liveDataBean.setPASSWORD(dBBean.getPassword());
    }

    /**
     * Setting an icon to the JFrame.
     */
    public void setIcon() {

        URL iconURL = getClass().getResource("/images/icon.png");

        ImageIcon frameIcon = new ImageIcon(iconURL);
        this.setIconImage(frameIcon.getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar = createToolBar();
        splitPanelPanel1 = new com.posthoffice.jipprojectmposth.presentation.SplitPanelPanel(patientModel, inpatientModel, medicationModel, surgicalModel, liveDataBean,
            patientDBManager, inpatientDBManager, medicationDBManager, surgicalDBManager);
        jMenuBar1 = createMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(Messages.getString("title"));

        jToolBar.setRollover(true);
        getContentPane().add(jToolBar, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(splitPanelPanel1, java.awt.BorderLayout.CENTER);
        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Placing ActionCommands and ActionListeners to the JMenuItems in the
     * MenuBar
     *
     * @return
     */
    public JMenuBar createMenuBar() {

        JMenuBar menuBar;
        JMenu menuMain, menuEdit, menuNew, menuDelete;
        JMenuItem newPatient, newInpatient, newMedication, newSurgical,
                deletePatient, deleteInpatient, deleteMedication, deleteSurgical,
                itemExit, itemPrint, save;

        menuBar = new JMenuBar();

        menuMain = new JMenu(Messages.getString("file"));
        menuBar.add(menuMain);

        menuEdit = new JMenu(Messages.getString("edit"));
        menuBar.add(menuEdit);

        menuNew = new JMenu(Messages.getString("new"));

        newPatient = new JMenuItem(Messages.getString("patient"));
        newPatient.setActionCommand("NewPatient");
        newPatient.addActionListener(this);

        newInpatient = new JMenuItem(Messages.getString("inpatient"));
        newInpatient.setActionCommand("NewInpatient");
        newInpatient.addActionListener(this);

        newMedication = new JMenuItem(Messages.getString("medication"));
        newMedication.setActionCommand("NewMedication");
        newMedication.addActionListener(this);

        newSurgical = new JMenuItem(Messages.getString("surgical"));
        newSurgical.setActionCommand("NewSurgical");
        newSurgical.addActionListener(this);

        menuNew.add(newPatient);
        menuNew.add(newInpatient);
        menuNew.add(newMedication);
        menuNew.add(newSurgical);

        menuDelete = new JMenu(Messages.getString("delete"));

        deletePatient = new JMenuItem(Messages.getString("patient"));
        deletePatient.setActionCommand("DeletePatient");
        deletePatient.addActionListener(this);

        deleteInpatient = new JMenuItem(Messages.getString("inpatient"));
        deleteInpatient.setActionCommand("DeleteInpatient");
        deleteInpatient.addActionListener(this);

        deleteMedication = new JMenuItem(Messages.getString("medication"));
        deleteMedication.setActionCommand("DeleteMedication");
        deleteMedication.addActionListener(this);

        deleteSurgical = new JMenuItem(Messages.getString("surgical"));
        deleteSurgical.setActionCommand("DeleteSurgical");
        deleteSurgical.addActionListener(this);

        menuDelete.add(deletePatient);
        menuDelete.add(deleteInpatient);
        menuDelete.add(deleteMedication);
        menuDelete.add(deleteSurgical);

        itemPrint = new JMenuItem(Messages.getString("print"));
        itemPrint.setActionCommand("Print");
        itemPrint.addActionListener(this);

        itemExit = new JMenuItem(Messages.getString("exit"));
        itemExit.setActionCommand("Exit");
        itemExit.addActionListener(this);

        save = new JMenuItem(Messages.getString("save"));
        save.setActionCommand("Save");
        save.addActionListener(this);

        menuEdit.add(menuNew);
        menuEdit.add(menuDelete);

        menuMain.add(itemPrint);
        menuMain.add(save);
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

            case "Print":
                printForm();
                break;

            case "Exit":
                JIPFramePresentation.this.dispose();
                break;

            case "Save":
                try {
                    saveEditedData();
                } catch (SQLException ex) {
                    Logger.getLogger(JIPFramePresentation.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

        }
    }

    /**
     * Adding buttons to the ToolBar for Creating and Deleting Patients,
     * Inpatient, Medication, and Surgical data
     *
     * @return
     */
    private JToolBar createToolBar() {

        JToolBar toolBar = new JToolBar();

        JButton newPatientButton = makeToolBarButton("new_patient", Messages.getString("newPatient"), "NewPatient", Messages.getString("newPatientMessage"));
        JButton deletePatientButton = makeToolBarButton("delete_patient", Messages.getString("deletePatient"), "DeletePatient", Messages.getString("deletePatientMessage"));

        JButton newInpatientButton = makeToolBarButton("new_inpatient", Messages.getString("newInpatient"), "NewInpatient", Messages.getString("newInpatientMessage"));
        JButton deleteInpatientButton = makeToolBarButton("delete_inpatient", Messages.getString("deleteInpatient"), "DeleteInpatient", Messages.getString("deleteInpatientMessage"));

        JButton newMedicationButton = makeToolBarButton("new_medication", Messages.getString("newMedication"), "NewMedication", Messages.getString("newMedicationMessage"));
        JButton deleteMedicationButton = makeToolBarButton("delete_medication", Messages.getString("deleteMedication"), "DeleteMedication", Messages.getString("deleteMedicationMessage"));

        JButton newSurgicalButton = makeToolBarButton("new_surgical", Messages.getString("newSurgical"), "NewSurgical", Messages.getString("newSurgicalMessage"));
        JButton deleteSurgicalButton = makeToolBarButton("delete_surgical", Messages.getString("deleteSurgical"), "DeleteSurgical", Messages.getString("deleteSurgicalMessage"));

        JButton newPrintButton = makeToolBarButton("print", Messages.getString("print"), "Print", Messages.getString("printMessage"));

        JButton newSaveButton = makeToolBarButton("save", Messages.getString("save"), "Save", Messages.getString("save"));


        toolBar.add(newPatientButton);
        toolBar.add(deletePatientButton);
        toolBar.add(newInpatientButton);
        toolBar.add(deleteInpatientButton);
        toolBar.add(newMedicationButton);
        toolBar.add(deleteMedicationButton);
        toolBar.add(newSurgicalButton);
        toolBar.add(deleteSurgicalButton);
        toolBar.add(newPrintButton);
        toolBar.add(newSaveButton);

        toolBar.setFloatable(true);

        return toolBar;
    }

    private JButton makeToolBarButton(String imageName, String buttonName, String actionCommand, String toolTipText) {

        ToolBarEventHandler toolBarEventHandler = new ToolBarEventHandler();

        String imgLocation = "/images/" + imageName + "_48.png";
        URL imageURL = JIPFramePresentation.class.getResource(imgLocation);

        JButton button = new JButton();

        //button.setText(buttonName);
        button.setActionCommand(actionCommand);
        button.setToolTipText(toolTipText);
        button.addActionListener(toolBarEventHandler);

        if (imageURL != null) {
            button.setIcon(new ImageIcon(imageURL, buttonName));
        } else {
            button.setText(buttonName);
            System.err.println("Resource not found: " + imgLocation);
        }

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

                case "Print":
                    printForm();
                    break;

                case "Save":
                    try {
                        saveEditedData();
                    } catch (SQLException ex) {
                        Logger.getLogger(JIPFramePresentation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            }

        }
    }

    /**
     * The save button. Primarily used when editing a cell. When pushed, it
     * updates the database with whichever new values have been added.
     */
    public void saveEditedData() throws SQLException {
        patientDBManager.updateDB();
        inpatientDBManager.updateDB();
        medicationDBManager.updateDB();
        surgicalDBManager.updateDB();
    }

    /**
     * Method which is called from the ToolBar or MenuBar to Print a Patient's
     * information.
     */
    public void printForm() {

        if (!(liveDataBean.getSelectedPatientRow() == -1)) {

            PatientBean selectedBean = liveDataBean.getSelectedPatientBean();

            MessageFormat header = new MessageFormat(Messages.getString("print") + " for " + selectedBean.getLastName() + ", " + selectedBean.getFirstName());
            MessageFormat footer = new MessageFormat("Page {0, number, integer}");

            ReceiptTableModel receiptModel = new ReceiptTableModel(selectedBean);

            JTable receiptTable = new ReceiptTable(receiptModel);

            TableColumn column = receiptTable.getColumnModel().getColumn(0);
            TableColumn column1 = receiptTable.getColumnModel().getColumn(1);
            TableColumn column2 = receiptTable.getColumnModel().getColumn(2);
            column.setMinWidth(150);
            column1.setMinWidth(125);
            column2.setMinWidth(125);

            receiptTable.setSize(receiptTable.getPreferredSize());

            try {
                receiptTable.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            } catch (PrinterException ex) {
                logger.error("Cannot Print:", ex.getMessage());
            }


        } else {
            JFrame dialogue = new JFrame();
            JOptionPane.showMessageDialog(dialogue, Messages.getString("optionSelectPatient"), Messages.getString("error"), JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Method that is called from the ToolBar or MenuBar to display a form to
     * add a new Patient to the database.
     */
    public void createPatientForm() {

        JFrame patientFormFrame = new JFrame(Messages.getString("newPatient"));
        PatientForm patientForm = new PatientForm(patientDBManager, patientFormFrame);
        JScrollPane patientFormScroll = new JScrollPane(patientForm);

        URL iconURL = getClass().getResource("/images/new_patient_48.png");
        ImageIcon frameIcon = new ImageIcon(iconURL);
        patientFormFrame.setIconImage(frameIcon.getImage());

        patientFormFrame.getContentPane().add(patientFormScroll);
        patientFormFrame.pack();
        patientFormFrame.setLocationRelativeTo(null);
        patientFormFrame.setVisible(true);
        patientFormFrame.setResizable(false);

    }

    /**
     * Method that is called from the ToolBar or MenuBar to delete Inpatient
     * Data from a specific Patient selected from the PatientTable.
     *
     * @throws SQLException
     */
    public void deletePatientForm() throws SQLException {

        if (!(liveDataBean.getSelectedPatientRow() == -1)) {

            PatientBean selectedPatient = liveDataBean.getSelectedPatientBean();

            String optionPaneMessage = Messages.getString("optionDeleteMessage") + " " + selectedPatient.getLastName()
                    + ", " + selectedPatient.getFirstName() + "?";

            int selectedOption = JOptionPane.showConfirmDialog(null, optionPaneMessage, Messages.getString("deletePatient"), JOptionPane.YES_NO_OPTION);

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
            JOptionPane.showMessageDialog(dialogue, Messages.getString("optionSelectPatient"), Messages.getString("error"), JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Method that is called from the ToolBar or MenuBar to add Inpatient Data
     * to a specific Patient selected from the PatientTable.
     */
    public void createInpatientForm() {

        PatientBean tempPatient = liveDataBean.getSelectedPatientBean();

        if (!(liveDataBean.getSelectedPatientRow() == -1)) {

            JFrame inpatientFormFrame = new JFrame(Messages.getString("inpatientForm") + " " + tempPatient.getLastName() + ", "
                    + tempPatient.getFirstName() + " | ID: " + tempPatient.getPatientID());

            InpatientForm inpatientForm = new InpatientForm(patientDBManager, inpatientDBManager, liveDataBean, inpatientFormFrame);
            JScrollPane inpatientFormScroll = new JScrollPane(inpatientForm);

            URL iconURL = getClass().getResource("/images/new_inpatient_48.png");
            ImageIcon frameIcon = new ImageIcon(iconURL);
            inpatientFormFrame.setIconImage(frameIcon.getImage());

            inpatientFormFrame.getContentPane().add(inpatientFormScroll);
            inpatientFormFrame.pack();
            inpatientFormFrame.setLocationRelativeTo(null);
            inpatientFormFrame.setVisible(true);
            inpatientFormFrame.setResizable(false);
        } else {
            JFrame dialogue = new JFrame();
            JOptionPane.showMessageDialog(dialogue, Messages.getString("optionSelectPatient"), Messages.getString("error"), JOptionPane.ERROR_MESSAGE);

        }

    }

    /**
     * Method that is called from the ToolBar or MenuBar to delete Inpatient
     * Data from a specific Patient selected from the PatientTable.
     *
     * @throws SQLException
     */
    public void deleteInpatientForm() throws SQLException {

        if (!(liveDataBean.getSelectedPatientRow() == -1)) {

            PatientBean selectedPatient = liveDataBean.getSelectedPatientBean();

            if (!(liveDataBean.getSelectedInpatientRow() == -1)) {

                String optionPaneMessage = Messages.getString("deleteInpatientOptionMessage") + " " + selectedPatient.getLastName()
                        + ", " + selectedPatient.getFirstName() + "?";

                int selectedOption = JOptionPane.showConfirmDialog(null, optionPaneMessage, Messages.getString("deleteInpatient"), JOptionPane.YES_NO_OPTION);

                if (selectedOption == JOptionPane.YES_OPTION) {

                    InpatientBean selectedInpatient = inpatientModel.getinPatientData(liveDataBean.getSelectedInpatientRow());

                    inpatientDBManager.deleteInpatient(selectedInpatient);

                    patientDBManager.updatePatient(selectedPatient);

                    inpatientModel.deleteRow(liveDataBean.getSelectedInpatientRow());

                    liveDataBean.setSelectedInpatientRow(-1);

                }
            } else {
                JFrame dialogue = new JFrame();
                JOptionPane.showMessageDialog(dialogue, Messages.getString("deleteInpatientError"), Messages.getString("error"), JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JFrame dialogue = new JFrame();
            JOptionPane.showMessageDialog(dialogue, Messages.getString("optionSelectPatient"), Messages.getString("error"), JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Method that is called from the ToolBar or MenuBar to add Medication Data
     * to a specific Patient selected from the PatientTable.
     */
    public void createMedicationForm() {

        PatientBean tempPatient = liveDataBean.getSelectedPatientBean();

        if (!(liveDataBean.getSelectedPatientRow() == -1)) {

            JFrame medicationFormFrame = new JFrame(Messages.getString("medicationForm") + " " + tempPatient.getLastName() + ", "
                    + tempPatient.getFirstName() + " | ID: " + tempPatient.getPatientID());

            MedicationForm medicationForm = new MedicationForm(patientDBManager, medicationDBManager, liveDataBean, medicationFormFrame);
            JScrollPane medicationFormScroll = new JScrollPane(medicationForm);

            URL iconURL = getClass().getResource("/images/new_medication_48.png");
            ImageIcon frameIcon = new ImageIcon(iconURL);
            medicationFormFrame.setIconImage(frameIcon.getImage());

            medicationFormFrame.getContentPane().add(medicationFormScroll);
            medicationFormFrame.pack();
            medicationFormFrame.setLocationRelativeTo(null);
            medicationFormFrame.setVisible(true);
            medicationFormFrame.setResizable(false);
        } else {
            JFrame dialogue = new JFrame();
            JOptionPane.showMessageDialog(dialogue, Messages.getString("optionSelectPatient"), Messages.getString("error"), JOptionPane.ERROR_MESSAGE);

        }

    }

    /**
     * Method that is called from the ToolBar or MenuBar to delete Medication
     * Data from a specific Patient selected from the PatientTable.
     *
     * @throws SQLException
     */
    public void deleteMedicationForm() throws SQLException {

        if (!(liveDataBean.getSelectedPatientRow() == -1)) {

            PatientBean selectedPatient = liveDataBean.getSelectedPatientBean();

            if (!(liveDataBean.getSelectedMedicationRow() == -1)) {

                String optionPaneMessage = Messages.getString("deleteMedicationOptionMessage") + " " + selectedPatient.getLastName()
                        + ", " + selectedPatient.getFirstName() + "?";

                int selectedOption = JOptionPane.showConfirmDialog(null, optionPaneMessage, Messages.getString("deleteMedication"), JOptionPane.YES_NO_OPTION);

                if (selectedOption == JOptionPane.YES_OPTION) {

                    MedicationBean selectedMedication = medicationModel.getMedicationData(liveDataBean.getSelectedMedicationRow());

                    medicationDBManager.deleteMedication(selectedMedication);

                    patientDBManager.updatePatient(selectedPatient);

                    medicationModel.deleteRow(liveDataBean.getSelectedMedicationRow());

                    liveDataBean.setSelectedMedicationRow(-1);

                }
            } else {
                JFrame dialogue = new JFrame();
                JOptionPane.showMessageDialog(dialogue, Messages.getString("deleteMedicationError"), Messages.getString("error"), JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JFrame dialogue = new JFrame();
            JOptionPane.showMessageDialog(dialogue, Messages.getString("optionSelectPatient"), Messages.getString("error"), JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Method that is called from the ToolBar or MenuBar to add Surgical Data to
     * a specific Patient selected from the PatientTable.
     */
    public void createSurgicalForm() {

        PatientBean tempPatient = liveDataBean.getSelectedPatientBean();

        if (!(liveDataBean.getSelectedPatientRow() == -1)) {

            JFrame surgicalFormFrame = new JFrame(Messages.getString("surgicalForm") + " " + tempPatient.getLastName() + ", "
                    + tempPatient.getFirstName() + " | ID: " + liveDataBean.getSelectedPatientID());

            SurgicalForm surgicalForm = new SurgicalForm(patientDBManager, surgicalDBManager, liveDataBean, surgicalFormFrame);
            JScrollPane surgicalFormScroll = new JScrollPane(surgicalForm);

            URL iconURL = getClass().getResource("/images/new_surgical_48.png");
            ImageIcon frameIcon = new ImageIcon(iconURL);
            surgicalFormFrame.setIconImage(frameIcon.getImage());

            surgicalFormFrame.getContentPane().add(surgicalFormScroll);
            surgicalFormFrame.pack();
            surgicalFormFrame.setLocationRelativeTo(null);
            surgicalFormFrame.setVisible(true);
            surgicalFormFrame.setResizable(false);
        } else {
            JFrame dialogue = new JFrame();
            JOptionPane.showMessageDialog(dialogue, Messages.getString("optionSelectPatient"), Messages.getString("error"), JOptionPane.ERROR_MESSAGE);

        }
    }

    /**
     * Method that is called from the ToolBar or MenuBar to delete Surgical Data
     * from a specific Patient selected from the PatientTable.
     *
     * @throws SQLException
     */
    public void deleteSurgicalForm() throws SQLException {

        if (!(liveDataBean.getSelectedPatientRow() == -1)) {

            PatientBean selectedPatient = liveDataBean.getSelectedPatientBean();

            if (!(liveDataBean.getSelectedSurgicalRow() == -1)) {

                String optionPaneMessage = Messages.getString("deleteSurgicalOptionMessage") + " " + selectedPatient.getLastName()
                        + ", " + selectedPatient.getFirstName() + "?";

                int selectedOption = JOptionPane.showConfirmDialog(null, optionPaneMessage, Messages.getString("deleteSurgical"), JOptionPane.YES_NO_OPTION);

                if (selectedOption == JOptionPane.YES_OPTION) {

                    SurgicalBean selectedSurgical = surgicalModel.getSurgicalData(liveDataBean.getSelectedSurgicalRow());

                    surgicalDBManager.deleteSurgical(selectedSurgical);

                    patientDBManager.updatePatient(selectedPatient);

                    surgicalModel.deleteRow(liveDataBean.getSelectedSurgicalRow());

                    liveDataBean.setSelectedSurgicalRow(-1);

                }
            } else {
                JFrame dialogue = new JFrame();
                JOptionPane.showMessageDialog(dialogue, Messages.getString("deleteSurgicalError"), Messages.getString("error"), JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JFrame dialogue = new JFrame();
            JOptionPane.showMessageDialog(dialogue, Messages.getString("optionSelectPatient"), Messages.getString("error"), JOptionPane.ERROR_MESSAGE);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JToolBar jToolBar;
    private com.posthoffice.jipprojectmposth.presentation.SplitPanelPanel splitPanelPanel1;
    // End of variables declaration//GEN-END:variables
}
