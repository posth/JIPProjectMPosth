package com.posthoffice.jipprojectmposth.beans;

import java.util.Date;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class InpatientBean {

    private int patientID;
    private int iD;
    private Timestamp dateOfStay;
    private String roomNumber;
    private BigDecimal dailyRate;
    private BigDecimal roomSupplies;
    private BigDecimal roomServices;

    public InpatientBean() {
        super();
        this.patientID = 1;
        this.dateOfStay = new Timestamp(new Date().getTime());
        this.roomNumber = "A1";
        this.dailyRate = new BigDecimal("0");
        this.roomSupplies = new BigDecimal("0");
        this.roomServices = new BigDecimal("0");
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

    public Timestamp getDateOfStay() {
        return dateOfStay;
    }

    public void setDateOfStay(Timestamp dateOfStay) {
        this.dateOfStay = dateOfStay;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public BigDecimal getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(BigDecimal dailyRate) {
        this.dailyRate = dailyRate;
    }

    public BigDecimal getRoomSupplies() {
        return roomSupplies;
    }

    public void setRoomSupplies(BigDecimal roomSupplies) {
        this.roomSupplies = roomSupplies;
    }

    public BigDecimal getRoomServices() {
        return roomServices;
    }

    public void setRoomServices(BigDecimal roomServices) {
        this.roomServices = roomServices;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.patientID;
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
        final InpatientBean other = (InpatientBean) obj;
        if (this.patientID != other.patientID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InpatientBean{" + "patientID=" + patientID + ", iD=" + iD
                + ", dateOfStay=" + dateOfStay + ", roomNumber=" + roomNumber
                + ", dailyRate=" + dailyRate + ", roomSupplies=" + roomSupplies
                + ", roomServices=" + roomServices + '}';
    }

}
