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
    private ArrayList<InpatientBean> inpatientList;
    private ArrayList<MedicationBean> medicationList;
    private ArrayList<SurgicalBean> surgicalList;
    private boolean update;

    public PatientBean(int patientID, String lastName, String firstName, String diagnosis, Timestamp admissionDate, Timestamp releaseDate,
            ArrayList<InpatientBean> inpatientList, ArrayList<MedicationBean> medicationList,
            ArrayList<SurgicalBean> surgicalList) {
        super();
        this.patientID = patientID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.diagnosis = diagnosis;
        this.admissionDate = admissionDate;
        this.releaseDate = releaseDate;
        this.inpatientList = inpatientList;
        this.medicationList = medicationList;
        this.surgicalList = surgicalList;
        this.update = false;
    }

    public PatientBean() {
        super();
        this.patientID = -1;
        this.lastName = "";
        this.firstName = "";
        this.diagnosis = "";
        this.admissionDate = new Timestamp(new Date().getTime());
        this.releaseDate = new Timestamp(new Date().getTime());
        this.inpatientList = new ArrayList<>();
        this.medicationList = new ArrayList<>();
        this.surgicalList = new ArrayList<>();
        this.update = false;
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
        return inpatientList;
    }

    public void setInpatientList(ArrayList<InpatientBean> inpatientList) {
        this.inpatientList = inpatientList;
    }

    public ArrayList<MedicationBean> getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(ArrayList<MedicationBean> medicationList) {
        this.medicationList = medicationList;
    }

    public ArrayList<SurgicalBean> getSurgicalList() {
        return surgicalList;
    }

    public void setSurgicalList(ArrayList<SurgicalBean> surgicalList) {
        this.surgicalList = surgicalList;
    }

    public boolean getUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
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
                + inpatientList + ", MedicationList=" + medicationList
                + ", SurgicalList=" + surgicalList + '}';
    }

}
