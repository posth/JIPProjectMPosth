package com.posthoffice.jipprojectmposth.model;

import com.posthoffice.jipprojectmposth.beans.InpatientBean;
import com.posthoffice.jipprojectmposth.beans.MedicationBean;
import com.posthoffice.jipprojectmposth.beans.PatientBean;
import com.posthoffice.jipprojectmposth.beans.ReceiptDataBean;
import com.posthoffice.jipprojectmposth.regex.Messages;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

public class ReceiptTableModel extends AbstractTableModel {

    private PatientBean patientBean;
    private String[] RECEIPTCOLUMNS = {Messages.getString("category"), Messages.getString("admissiondate"), Messages.getString("price")};
    private ArrayList<ReceiptDataBean> data = new ArrayList<>();

    public ReceiptTableModel() {
        super();
        this.patientBean = new PatientBean();
    }

    public ReceiptTableModel(PatientBean selectedPatient) {
        super();
        this.patientBean = selectedPatient;

        loadInpatientData();
        loadMedicationData();
        //loadSurgicalData();

    }

    public void addReceiptDataBean(ReceiptDataBean receiptBean) {
        data.add(receiptBean);
        this.fireTableDataChanged();
    }

    public void addBlankRow() {
        ReceiptDataBean blank = new ReceiptDataBean("", "", "");
        addReceiptDataBean(blank);
    }

    public void loadInpatientData() {

        ArrayList<InpatientBean> inpatientList = patientBean.getInpatientList();

        for (int i = 0; i <= inpatientList.size() - 1; i++) {

            InpatientBean temp = inpatientList.get(i);

            String dailyRate = Messages.getString("inpatient") + " | " + Messages.getString("dailyrate");

            Timestamp dateOfStay = temp.getDateOfStay();
            SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy");

            String date = format.format(new Date(dateOfStay.getTime()));

            String dailyRateprice = "$" + temp.getDailyRate() + "";

            ReceiptDataBean tempReceipt = new ReceiptDataBean(dailyRate, date, dailyRateprice);

            addReceiptDataBean(tempReceipt);

        }

        addBlankRow();

        for (int i = 0; i <= inpatientList.size() - 1; i++) {

            InpatientBean temp = inpatientList.get(i);

            Timestamp dateOfStay = temp.getDateOfStay();
            SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy");

            String date = format.format(new Date(dateOfStay.getTime()));

            String roomSupplies = Messages.getString("inpatient") + " | " + Messages.getString("supplies");
            String roomSuppliesPrice = "$" + temp.getRoomSupplies() + "";

            ReceiptDataBean tempReceipt = new ReceiptDataBean(roomSupplies, date, roomSuppliesPrice);

            addReceiptDataBean(tempReceipt);
        }

        addBlankRow();

        for (int i = 0; i <= inpatientList.size() - 1; i++) {

            InpatientBean temp = inpatientList.get(i);

            Timestamp dateOfStay = temp.getDateOfStay();
            SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy");

            String date = format.format(new Date(dateOfStay.getTime()));

            String roomServices = Messages.getString("inpatient") + " | " + Messages.getString("supplies");
            String roomServicesPrice = "$" + temp.getRoomServices() + "";

            ReceiptDataBean tempReceipt = new ReceiptDataBean(roomServices, date, roomServicesPrice);

            addReceiptDataBean(tempReceipt);
        }

        addBlankRow();

    }

    public void loadMedicationData() {

        ArrayList<MedicationBean> medicationList = patientBean.getMedicationList();

        for (int i = 0; i <= medicationList.size() - 1; i++) {

            MedicationBean temp = medicationList.get(i);

            String costPerUnit = Messages.getString("medication") + " | " + Messages.getString("unitcost");

            Timestamp dateOfMed = temp.getDateOfMed();
            SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy");

            String date = format.format(new Date(dateOfMed.getTime()));

            String costPerUnitprice = "$" + temp.getCostPerUnit() + "";

            ReceiptDataBean tempReceipt = new ReceiptDataBean(costPerUnit, date, costPerUnitprice);

            addReceiptDataBean(tempReceipt);
            
            String numberOfUnits = temp.getNumberOfUnits() + " (" + temp.getMedication() + ")" + " " + Messages.getString("units");
            String totalPrice = "Total " + Messages.getString("medication") + Messages.getString("price") + ":";
  
            BigDecimal unitNumberBD = temp.getNumberOfUnits();
            BigDecimal unitPriceBD = temp.getCostPerUnit();
            
            String medicationTotal = "$" + unitNumberBD.multiply(unitPriceBD) + "";
                   
            ReceiptDataBean numberUnits = new ReceiptDataBean(numberOfUnits, totalPrice, medicationTotal);
            
            addReceiptDataBean(numberUnits);

        }

        addBlankRow();

    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return RECEIPTCOLUMNS.length;
    }

    @Override
    public String getColumnName(int col) {
        return RECEIPTCOLUMNS[col];
    }

    @Override
    public Object getValueAt(int row, int col) {

        switch (col) {
            case 0:
                return data.get(row).getCategory();
            case 1:
                return data.get(row).getDate();
            case 2:
                return data.get(row).getPrice();
        }
        // What kind of exception to catch here?
        return null;
    }
}
