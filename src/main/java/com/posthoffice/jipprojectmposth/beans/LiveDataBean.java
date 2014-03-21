package com.posthoffice.jipprojectmposth.beans;

import com.posthoffice.jipprojectmposth.database.InpatientDBManagement;
import com.posthoffice.jipprojectmposth.database.PatientDBManagement;
import com.posthoffice.jipprojectmposth.model.PatientDBTableModel;

public class LiveDataBean {

    private int selectedPatientID;
    private String selectedPatientLastName;
    private String selectedPatientFirstName;
    private PatientBean selectedPatientBean;
    private int selectedPatientRow;
    private PatientDBManagement patientDBManager;
    private InpatientDBManagement inpatientDBManager;
    private PatientDBTableModel patientModel;

    public LiveDataBean() {
        super();
        this.selectedPatientID = -1;
        this.selectedPatientLastName = "None Selected";
        this.selectedPatientFirstName = "None Selected";
        this.selectedPatientRow = -1;
    }

    public LiveDataBean(InpatientDBManagement inpatientDBManager, PatientDBTableModel patientModel) {
        super();
        this.selectedPatientID = -1;
        this.selectedPatientLastName = "None Selected";
        this.selectedPatientFirstName = "None Selected";
        this.selectedPatientRow = -1;
        this.inpatientDBManager = inpatientDBManager;
        this.patientModel = patientModel;
    }

    public PatientDBTableModel getPatientModel() {
        return patientModel;
    }

    public void setPatientModel(PatientDBTableModel patientModel) {
        this.patientModel = patientModel;
    }

    public InpatientDBManagement getInpatientDBManager() {
        return inpatientDBManager;
    }

    public void setInpatientDBManager(InpatientDBManagement inpatientDBManager) {
        this.inpatientDBManager = inpatientDBManager;
    }

    public PatientDBManagement getPatientDBManager() {
        return patientDBManager;
    }

    public void setPatientDBManager(PatientDBManagement patientDBManager) {
        this.patientDBManager = patientDBManager;
    }

    public int getSelectedPatientID() {
        return selectedPatientID;
    }

    public void setSelectedPatientID(int selectedPatientID) {
        this.selectedPatientID = selectedPatientID;
    }

    public String getSelectedPatientLastName() {
        return selectedPatientLastName;
    }

    public void setSelectedPatientLastName(String selectedPatientLastName) {
        this.selectedPatientLastName = selectedPatientLastName;
    }

    public String getSelectedPatientFirstName() {
        return selectedPatientFirstName;
    }

    public void setSelectedPatientFirstName(String selectedPatientFirstName) {
        this.selectedPatientFirstName = selectedPatientFirstName;
    }

    public PatientBean getSelectedPatientBean() {
        return selectedPatientBean;
    }

    public void setSelectedPatientBean(PatientBean selectedPatientBean) {
        this.selectedPatientBean = selectedPatientBean;
    }

    public int getSelectedPatientRow() {
        return selectedPatientRow;
    }

    public void setSelectedPatientRow(int selectedPatientRow) {
        this.selectedPatientRow = selectedPatientRow;
    }

    @Override
    public String toString() {
        return "LiveDataBean{" + "selectedPatientID=" + selectedPatientID + ", selectedPatientLastName=" + selectedPatientLastName + ", selectedPatientFirstName=" + selectedPatientFirstName + ", selectedPatientBean=" + selectedPatientBean + ", selectedPatientRow=" + selectedPatientRow + '}';
    }

}
