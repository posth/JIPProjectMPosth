package com.posthoffice.jipprojectmposth.beans;

import java.sql.Timestamp;
import java.util.Date;
import java.util.ArrayList;

public class PatientBean {

    private int patientID;
    private String lastName;
    private String firstName;
    private String diagnosis;
    private Timestamp admissionDate;
    private Timestamp releaseDate;
    private ArrayList<InpatientBean> InpatientList;
    private ArrayList<MedicationBean> MedicationList;
    private ArrayList<SurgicalBean> SurgicalList;

    public PatientBean() {
        super();
        this.patientID = -1;
        this.lastName = "";
        this.firstName = "";
        this.diagnosis = "";
        this.admissionDate = new Timestamp(new Date().getTime());
        this.releaseDate = new Timestamp(new Date().getTime());
        this.InpatientList = new ArrayList<>();
        this.MedicationList = new ArrayList<>();
        this.SurgicalList = new ArrayList<>();
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Timestamp getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Timestamp admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Timestamp getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Timestamp releaseDate) {
        this.releaseDate = releaseDate;
    }

    public ArrayList<InpatientBean> getInpatientList() {
        return InpatientList;
    }

    public void setInpatientList(ArrayList<InpatientBean> InpatientList) {
        this.InpatientList = InpatientList;
    }

    public ArrayList<MedicationBean> getMedicationList() {
        return MedicationList;
    }

    public void setMedicationList(ArrayList<MedicationBean> MedicationList) {
        this.MedicationList = MedicationList;
    }

    public ArrayList<SurgicalBean> getSurgicalList() {
        return SurgicalList;
    }

    public void setSurgicalList(ArrayList<SurgicalBean> SurgicalList) {
        this.SurgicalList = SurgicalList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.patientID;
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
        final PatientBean other = (PatientBean) obj;
        if (this.patientID != other.patientID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PatientBean{" + "patientID=" + patientID + ", lastName="
                + lastName + ", firstName=" + firstName + ", diagnosis="
                + diagnosis + ", admissionDate=" + admissionDate
                + ", releaseDate=" + releaseDate + ", InpatientList="
                + InpatientList + ", MedicationList=" + MedicationList
                + ", SurgicalList=" + SurgicalList + '}';
    }

}
