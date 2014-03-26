package com.posthoffice.jipprojectmposth.beans;

import java.util.Objects;

public class LiveDataBean {

    private int selectedPatientID;
    private PatientBean selectedPatientBean;
    private int selectedPatientRow;

    private int selectedInpatientRow;
    private InpatientBean selectedInpatientBean;

    private int selectedMedicationRow;
    private MedicationBean selectedMedicationBean;

    private int selectedSurgicalRow;
    private SurgicalBean selectedSurgicalBean;

    public LiveDataBean() {
        super();
        this.selectedPatientID = -1;
        this.selectedPatientRow = -1;
        this.selectedInpatientRow = -1;
    }

    public int getSelectedSurgicalRow() {
        return selectedSurgicalRow;
    }

    public void setSelectedSurgicalRow(int selectedSurgicalRow) {
        this.selectedSurgicalRow = selectedSurgicalRow;
    }

    public SurgicalBean getSelectedSurgicalBean() {
        return selectedSurgicalBean;
    }

    public void setSelectedSurgicalBean(SurgicalBean selectedSurgicalBean) {
        this.selectedSurgicalBean = selectedSurgicalBean;
    }

    public int getSelectedMedicationRow() {
        return selectedMedicationRow;
    }

    public void setSelectedMedicationRow(int selectedMedicationRow) {
        this.selectedMedicationRow = selectedMedicationRow;
    }

    public MedicationBean getSelectedMedicationBean() {
        return selectedMedicationBean;
    }

    public void setSelectedMedicationBean(MedicationBean selectedMedicationBean) {
        this.selectedMedicationBean = selectedMedicationBean;
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
        hash = 59 * hash + this.selectedPatientID;
        hash = 59 * hash + Objects.hashCode(this.selectedPatientBean);
        hash = 59 * hash + this.selectedPatientRow;
        hash = 59 * hash + this.selectedInpatientRow;
        hash = 59 * hash + Objects.hashCode(this.selectedInpatientBean);
        hash = 59 * hash + this.selectedMedicationRow;
        hash = 59 * hash + Objects.hashCode(this.selectedMedicationBean);
        hash = 59 * hash + this.selectedSurgicalRow;
        hash = 59 * hash + Objects.hashCode(this.selectedSurgicalBean);
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
        if (this.selectedMedicationRow != other.selectedMedicationRow) {
            return false;
        }
        if (!Objects.equals(this.selectedMedicationBean, other.selectedMedicationBean)) {
            return false;
        }
        if (this.selectedSurgicalRow != other.selectedSurgicalRow) {
            return false;
        }
        if (!Objects.equals(this.selectedSurgicalBean, other.selectedSurgicalBean)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LiveDataBean{" + "selectedPatientID=" + selectedPatientID
                + ", selectedPatientBean=" + selectedPatientBean + ", selectedPatientRow="
                + selectedPatientRow + ", selectedInpatientRow=" + selectedInpatientRow
                + ", selectedInpatientBean=" + selectedInpatientBean + ", selectedMedicationRow="
                + selectedMedicationRow + ", selectedMedicationBean=" + selectedMedicationBean
                + ", selectedSurgicalRow=" + selectedSurgicalRow + ", selectedSurgicalBean="
                + selectedSurgicalBean + '}';
    }

}
