package com.posthoffice.jipprojectmposth.beans;

public class LiveDataBean {

    private int selectedPatientID;
    private String selectedPatientLastName;
    private String selectedPatientFirstName;
    private PatientBean selectedPatientBean;
    private int selectedPatientRow;

    public LiveDataBean() {
        super();
        this.selectedPatientID = -1;
        this.selectedPatientLastName = "None Selected";
        this.selectedPatientFirstName = "None Selected";
        this.selectedPatientRow = -1;
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
