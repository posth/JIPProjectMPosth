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
    private String URL;
    private String USER;
    private String PASSWORD;

    public LiveDataBean() {
        super();
        this.selectedPatientID = -1;
        this.selectedPatientRow = -1;
        this.selectedInpatientRow = -1;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getUSER() {
        return USER;
    }

    public void setUSER(String USER) {
        this.USER = USER;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
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
        int hash = 5;
        hash = 97 * hash + this.selectedPatientID;
        hash = 97 * hash + Objects.hashCode(this.selectedPatientBean);
        hash = 97 * hash + this.selectedPatientRow;
        hash = 97 * hash + this.selectedInpatientRow;
        hash = 97 * hash + Objects.hashCode(this.selectedInpatientBean);
        hash = 97 * hash + this.selectedMedicationRow;
        hash = 97 * hash + Objects.hashCode(this.selectedMedicationBean);
        hash = 97 * hash + this.selectedSurgicalRow;
        hash = 97 * hash + Objects.hashCode(this.selectedSurgicalBean);
        hash = 97 * hash + Objects.hashCode(this.URL);
        hash = 97 * hash + Objects.hashCode(this.USER);
        hash = 97 * hash + Objects.hashCode(this.PASSWORD);
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
        if (!Objects.equals(this.URL, other.URL)) {
            return false;
        }
        if (!Objects.equals(this.USER, other.USER)) {
            return false;
        }
        if (!Objects.equals(this.PASSWORD, other.PASSWORD)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LiveDataBean{" + "selectedPatientID=" + selectedPatientID
                + ", selectedPatientBean=" + selectedPatientBean
                + ", selectedPatientRow=" + selectedPatientRow + ", selectedInpatientRow="
                + selectedInpatientRow + ", selectedInpatientBean="
                + selectedInpatientBean + ", selectedMedicationRow="
                + selectedMedicationRow + ", selectedMedicationBean="
                + selectedMedicationBean + ", selectedSurgicalRow="
                + selectedSurgicalRow + ", selectedSurgicalBean=" + selectedSurgicalBean
                + ", URL=" + URL + ", USER=" + USER + ", PASSWORD=" + PASSWORD + '}';
    }
}
