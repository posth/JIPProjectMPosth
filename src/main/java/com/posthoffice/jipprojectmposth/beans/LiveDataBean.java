package com.posthoffice.jipprojectmposth.beans;

import java.util.Objects;

public class LiveDataBean {

    private int selectedPatientID;
    private PatientBean selectedPatientBean;
    private int selectedPatientRow;

    public LiveDataBean() {
        super();
        this.selectedPatientID = -1;
        this.selectedPatientRow = -1;
    }

    public int getSelectedPatientID() {
        return selectedPatientID;
    }

    public void setSelectedPatientID(int selectedPatientID) {
        this.selectedPatientID = selectedPatientID;
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
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.selectedPatientID;
        hash = 23 * hash + Objects.hashCode(this.selectedPatientBean);
        hash = 23 * hash + this.selectedPatientRow;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LiveDataBean other = (LiveDataBean) obj;
        if (this.selectedPatientID != other.selectedPatientID) {
            return false;
        }
        if (!Objects.equals(this.selectedPatientBean, other.selectedPatientBean)) {
            return false;
        }
        if (this.selectedPatientRow != other.selectedPatientRow) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LiveDataBean{" + "selectedPatientID=" + selectedPatientID + ", selectedPatientBean="
                + selectedPatientBean + ", selectedPatientRow=" + selectedPatientRow + ", patientDBManager=";
    }

}
