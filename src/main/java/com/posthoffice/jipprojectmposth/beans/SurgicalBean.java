package com.posthoffice.jipprojectmposth.beans;

import java.util.Date;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class SurgicalBean {

    private int patientID;
    private int iD;
    private Timestamp dateOfSurgery;
    private String surgery;
    private BigDecimal roomFee;
    private BigDecimal surgeonsFee;
    private BigDecimal supplies;
    private boolean update;

    public SurgicalBean(int patientID, int iD, Timestamp dateOfSurgery, String surgery, BigDecimal roomFee, BigDecimal surgeonsFee, BigDecimal supplies) {
        super();
        this.patientID = patientID;
        this.iD = iD;
        this.dateOfSurgery = dateOfSurgery;
        this.surgery = surgery;
        this.roomFee = roomFee;
        this.surgeonsFee = surgeonsFee;
        this.supplies = supplies;
        this.update = false;
    }

    public SurgicalBean() {
        super();
        this.patientID = -1;
        this.iD = -1;
        this.dateOfSurgery = new Timestamp(new Date().getTime());
        this.surgery = "";
        this.roomFee = new BigDecimal("0");
        this.surgeonsFee = new BigDecimal("0");
        this.supplies = new BigDecimal("0");
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

    public Timestamp getDateOfSurgery() {
        return dateOfSurgery;
    }

    public void setDateOfSurgery(Timestamp dateOfSurgery) {
        this.dateOfSurgery = dateOfSurgery;
    }

    public String getSurgery() {
        return surgery;
    }

    public void setSurgery(String surgery) {
        this.surgery = surgery;
    }

    public BigDecimal getRoomFee() {
        return roomFee;
    }

    public void setRoomFee(BigDecimal roomFee) {
        this.roomFee = roomFee;
    }

    public BigDecimal getSurgeonsFee() {
        return surgeonsFee;
    }

    public void setSurgeonsFee(BigDecimal surgeonsFee) {
        this.surgeonsFee = surgeonsFee;
    }

    public BigDecimal getSupplies() {
        return supplies;
    }

    public void setSupplies(BigDecimal supplies) {
        this.supplies = supplies;
    }

    public boolean getUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.iD;
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
        final SurgicalBean other = (SurgicalBean) obj;
        if (this.iD != other.iD) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SurgicalBean{" + "patientID=" + patientID + ", iD=" + iD
                + ", dateOfSurgery=" + dateOfSurgery + ", surgery=" + surgery
                + ", roomFee=" + roomFee + ", surgeonsFee=" + surgeonsFee
                + ", supplies=" + supplies + '}';
    }

}
