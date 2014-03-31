package com.posthoffice.jipprojectmposth.model;

import com.posthoffice.jipprojectmposth.beans.InpatientBean;
import com.posthoffice.jipprojectmposth.beans.PatientBean;
import com.posthoffice.jipprojectmposth.beans.ReceiptDataBean;
import com.posthoffice.jipprojectmposth.regex.Messages;
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

            String roomSupplies = Messages.getString("inpatient") +  " | " + Messages.getString("supplies");
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

            String roomServices = Messages.getString("inpatient") +  " | " + Messages.getString("supplies");
            String roomServicesPrice = "$" + temp.getRoomServices() + "";

            ReceiptDataBean tempReceipt = new ReceiptDataBean(roomServices, date, roomServicesPrice);

            addReceiptDataBean(tempReceipt);
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
