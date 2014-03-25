package com.posthoffice.jipprojectmposth.beans;

import com.posthoffice.jipprojectmposth.presentation.InpatientTable;
import com.posthoffice.jipprojectmposth.presentation.PatientTable;
import java.util.Objects;
import javax.swing.JTable;

public class LiveDataBean {

    private int selectedPatientID;
    private PatientBean selectedPatientBean;
    private int selectedPatientRow;

    private int selectedInpatientRow;
    private InpatientBean selectedInpatientBean;

    public LiveDataBean() {
        super();
        this.selectedPatientID = -1;
        this.selectedPatientRow = -1;
        this.selectedInpatientRow = -1;
    }

    public InpatientBean getSelectedInpatientBean() {
        return selectedInpatientBean;
    }

    public void setSelectedInpatientBean(InpatientBean selectedInpatientBean) {
        this.selectedInpatientBean = selectedInpatientBean;
    }

    public int getSelectedInpatientRow() {
        return selectedInpatientRow;
    }

    public void setSelectedInpatientRow(int selectedInpatientRow) {
        this.selectedInpatientRow = selectedInpatientRow;
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
        int hash = 7;
        hash = 71 * hash + this.selectedPatientID;
        hash = 71 * hash + Objects.hashCode(this.selectedPatientBean);
        hash = 71 * hash + this.selectedPatientRow;
        hash = 71 * hash + this.selectedInpatientRow;
        hash = 71 * hash + Objects.hashCode(this.selectedInpatientBean);
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
        if (this.selectedInpatientRow != other.selectedInpatientRow) {
            return false;
        }
        if (!Objects.equals(this.selectedInpatientBean, other.selectedInpatientBean)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LiveDataBean{" + "selectedPatientID=" + selectedPatientID + ", selectedPatientBean="
                + selectedPatientBean + ", selectedPatientRow=" + selectedPatientRow + ", selectedInpatientRow="
                + selectedInpatientRow + ", selectedInpatientBean=" + selectedInpatientBean + '}';
    }

}
