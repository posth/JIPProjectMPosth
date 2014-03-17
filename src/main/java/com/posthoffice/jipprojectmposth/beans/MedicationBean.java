package com.posthoffice.jipprojectmposth.beans;

import java.util.Date;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class MedicationBean {

    private int patientID;
    private int iD;
    private Timestamp dateOfMed;
    private String medication;
    private BigDecimal costPerUnit;
    private BigDecimal numberOfUnits;
    private boolean update;
    
    public MedicationBean(int patientID, Timestamp dateOfMed, String medication, BigDecimal costPerUnit, BigDecimal numberOfUnits) {
        
        super();
        this.patientID = patientID;
        this.dateOfMed = dateOfMed;
        this.medication = medication;
        this.costPerUnit = costPerUnit;
        this.numberOfUnits = numberOfUnits;
        this.update = false;
    }

    public MedicationBean() {
        super();
        this.patientID = -1;
        this.dateOfMed = new Timestamp(new Date().getTime());
        this.medication = "";
        this.costPerUnit = new BigDecimal("0");
        this.numberOfUnits = new BigDecimal("0");
        this.update = false;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public Timestamp getDateOfMed() {
        return dateOfMed;
    }

    public void setDateOfMed(Timestamp dateOfMed) {
        this.dateOfMed = dateOfMed;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public BigDecimal getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(BigDecimal costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    public BigDecimal getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(BigDecimal numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.patientID;
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
        final MedicationBean other = (MedicationBean) obj;
        if (this.patientID != other.patientID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MedicationBean{" + "patientID=" + patientID + ", iD=" + iD
                + ", dateOfMed=" + dateOfMed + ", medication=" + medication
                + ", costPerUnit=" + costPerUnit + ", numberOfUnits="
                + numberOfUnits + '}';
    }

}
