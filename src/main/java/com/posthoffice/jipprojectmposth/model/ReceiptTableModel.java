package com.posthoffice.jipprojectmposth.model;

import com.posthoffice.jipprojectmposth.beans.InpatientBean;
import com.posthoffice.jipprojectmposth.beans.MedicationBean;
import com.posthoffice.jipprojectmposth.beans.PatientBean;
import com.posthoffice.jipprojectmposth.beans.ReceiptDataBean;
import com.posthoffice.jipprojectmposth.beans.SurgicalBean;
import com.posthoffice.jipprojectmposth.regex.Messages;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ReceiptTableModel extends AbstractTableModel {

    private PatientBean patientBean;
    private String[] RECEIPTCOLUMNS = {Messages.getString("category"), Messages.getString("admissiondate"), Messages.getString("price")};
    private ArrayList<ReceiptDataBean> data = new ArrayList<>();
    private BigDecimal inpatientSum = BigDecimal.ZERO;
    private BigDecimal medicationSum = BigDecimal.ZERO;
    private BigDecimal surgicalSum = BigDecimal.ZERO;

    public ReceiptTableModel() {
        super();
        this.patientBean = new PatientBean();
    }

    /**
     * This constructor is called from the Frame. It loads all the relevant
     * financial data from each Patient using ReceiptDataBeans.
     *
     * @param selectedPatient
     */
    public ReceiptTableModel(PatientBean selectedPatient) {
        super();
        this.patientBean = selectedPatient;

        loadPatientData();
        loadInpatientData();
        loadMedicationData();
        loadSurgicalData();

        loadTotalSum();

    }

    public void addReceiptDataBean(ReceiptDataBean receiptBean) {
        data.add(receiptBean);
        this.fireTableDataChanged();
    }

    /**
     * Used for aesthetic purposes on the receipt, separating Inpatient,
     * Medication, and Surgical financial statements.
     */
    public void addBlankRow() {
        ReceiptDataBean blank = new ReceiptDataBean("", "", "");
        addReceiptDataBean(blank);
    }

    /**
     * Adding the total BigDecimal sum of what an individual patient owes the
     * hospital.
     */
    public void loadTotalSum() {

        addBlankRow();

        BigDecimal totalSum = surgicalSum.add(inpatientSum.add(medicationSum));

        BigDecimal totalSumRounded = totalSum.setScale(2, BigDecimal.ROUND_HALF_UP);

        ReceiptDataBean totalSumRow = new ReceiptDataBean("", Messages.getString("patient") + " total " + Messages.getString("price"), "$" + totalSumRounded + "");

        addReceiptDataBean(totalSumRow);
    }

    /**
     * Places patient information at the top of the receipt. Places the Name,
     * ID, and time spent in the hospital.
     */
    public void loadPatientData() {

        ReceiptDataBean patientColumnTitles = new ReceiptDataBean(Messages.getString("patient"), Messages.getString("admissiondate"), Messages.getString("releaseDate"));
        addReceiptDataBean(patientColumnTitles);

        String patientName = patientBean.getFirstName() + " " + patientBean.getLastName() + " ID: " + patientBean.getPatientID();

        Timestamp admissionDate = patientBean.getAdmissionDate();
        SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy");
        String admissionDateString = format.format(new Date(admissionDate.getTime()));

        Timestamp releaseDate = patientBean.getReleaseDate();
        String releaseDateString = format.format(new Date(releaseDate.getTime()));

        ReceiptDataBean temp1 = new ReceiptDataBean(patientName, admissionDateString, releaseDateString);

        addReceiptDataBean(temp1);

        addBlankRow();
    }

    /**
     * Places all the financial Inpatient data onto the receipt. It also
     * calculates the total Inpatient sum from the Daily Rate, Services, and
     * Supplies owed to the hospital.
     */
    public void loadInpatientData() {

        ArrayList<InpatientBean> inpatientList = patientBean.getInpatientList();

        ReceiptDataBean inpatientColumnTitles = new ReceiptDataBean(Messages.getString("inpatient"), Messages.getString("dateofstay"), Messages.getString("price"));
        addReceiptDataBean(inpatientColumnTitles);

        for (int i = 0; i <= inpatientList.size() - 1; i++) {

            InpatientBean temp = inpatientList.get(i);

            String dailyRate = Messages.getString("dailyrate");

            Timestamp dateOfStay = temp.getDateOfStay();
            SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy");

            String date = format.format(new Date(dateOfStay.getTime()));

            String dailyRateprice = "$" + temp.getDailyRate() + "";

            ReceiptDataBean tempReceipt = new ReceiptDataBean(dailyRate, date, dailyRateprice);

            addReceiptDataBean(tempReceipt);

            BigDecimal dailyRateBD = temp.getDailyRate();
            inpatientSum = inpatientSum.add(dailyRateBD);

        }

        for (int i = 0; i <= inpatientList.size() - 1; i++) {

            InpatientBean temp = inpatientList.get(i);

            Timestamp dateOfStay = temp.getDateOfStay();
            SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy");

            String date = format.format(new Date(dateOfStay.getTime()));

            String roomSupplies = Messages.getString("supplies");
            String roomSuppliesPrice = "$" + temp.getRoomSupplies() + "";

            ReceiptDataBean tempReceipt = new ReceiptDataBean(roomSupplies, date, roomSuppliesPrice);

            addReceiptDataBean(tempReceipt);

            BigDecimal suppliesBD = temp.getRoomSupplies();
            inpatientSum = inpatientSum.add(suppliesBD);
        }


        for (int i = 0; i <= inpatientList.size() - 1; i++) {

            InpatientBean temp = inpatientList.get(i);

            Timestamp dateOfStay = temp.getDateOfStay();
            SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy");

            String date = format.format(new Date(dateOfStay.getTime()));

            String roomServices = Messages.getString("services");
            String roomServicesPrice = "$" + temp.getRoomServices() + "";

            ReceiptDataBean tempReceipt = new ReceiptDataBean(roomServices, date, roomServicesPrice);

            addReceiptDataBean(tempReceipt);

            BigDecimal servicesBD = temp.getRoomServices();
            inpatientSum = inpatientSum.add(servicesBD);
        }

        ReceiptDataBean totalInpatientPrice = new ReceiptDataBean("", "", "Total: $" + inpatientSum + "");
        addReceiptDataBean(totalInpatientPrice);

        addBlankRow();

    }

    /**
     * Places all the financial Medication data onto the receipt. 
     * It also places the financial sum of the medication data owed by multiplying 
     * the Units by Unit Cost.
     */
    public void loadMedicationData() {

        ArrayList<MedicationBean> medicationList = patientBean.getMedicationList();

        ReceiptDataBean inpatientColumnTitles = new ReceiptDataBean(Messages.getString("medication"), Messages.getString("dateofmed"), Messages.getString("price"));
        addReceiptDataBean(inpatientColumnTitles);

        for (int i = 0; i <= medicationList.size() - 1; i++) {

            MedicationBean temp = medicationList.get(i);

            String costPerUnit = Messages.getString("unitcost");

            Timestamp dateOfMed = temp.getDateOfMed();
            SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy");

            String date = format.format(new Date(dateOfMed.getTime()));

            String costPerUnitprice = "$" + temp.getCostPerUnit() + "";

            ReceiptDataBean tempReceipt = new ReceiptDataBean(costPerUnit, date, costPerUnitprice);

            addReceiptDataBean(tempReceipt);

            String numberOfUnits = temp.getNumberOfUnits() + " (" + temp.getMedication() + ")" + " " + Messages.getString("units");

            BigDecimal unitNumberBD = temp.getNumberOfUnits();
            BigDecimal unitPriceBD = temp.getCostPerUnit();

            medicationSum = unitNumberBD.multiply(unitPriceBD);
            BigDecimal medicationSumRounded = medicationSum.setScale(2, BigDecimal.ROUND_HALF_UP);

            String medicationTotal = "Total " + "$" + medicationSumRounded + "";

            ReceiptDataBean numberUnits = new ReceiptDataBean(numberOfUnits, "", medicationTotal);

            addReceiptDataBean(numberUnits);

        }

        addBlankRow();

    }

    /**
     * Places all the financial Surgical data onto the receipt. It also
     * calculates the total Surgical sum by adding the Room Fee, Surgeon's Fee,
     * and Supplies.
     */
    public void loadSurgicalData() {

        ArrayList<SurgicalBean> surgicalList = patientBean.getSurgicalList();

        ReceiptDataBean inpatientColumnTitles = new ReceiptDataBean(Messages.getString("surgical"), Messages.getString("dateofsurgery"), Messages.getString("price"));
        addReceiptDataBean(inpatientColumnTitles);

        for (int i = 0; i <= surgicalList.size() - 1; i++) {

            SurgicalBean temp = surgicalList.get(i);

            String roomFee = Messages.getString("roomfee");

            Timestamp dateOfSurgery = temp.getDateOfSurgery();
            SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy");

            String date = format.format(new Date(dateOfSurgery.getTime()));

            String roomFeeprice = "$" + temp.getRoomFee() + "";

            ReceiptDataBean tempReceipt = new ReceiptDataBean(roomFee, date, roomFeeprice);

            addReceiptDataBean(tempReceipt);

            BigDecimal roomFeeBD = temp.getRoomFee();
            surgicalSum = surgicalSum.add(roomFeeBD);

        }

        for (int i = 0; i <= surgicalList.size() - 1; i++) {

            SurgicalBean temp = surgicalList.get(i);

            Timestamp dateOfSurgery = temp.getDateOfSurgery();
            SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy");

            String date = format.format(new Date(dateOfSurgery.getTime()));

            String surgeonsFee = Messages.getString("surgeonsfee");
            String surgeonsFeePrice = "$" + temp.getSurgeonsFee() + "";

            ReceiptDataBean tempReceipt = new ReceiptDataBean(surgeonsFee, date, surgeonsFeePrice);

            addReceiptDataBean(tempReceipt);

            BigDecimal surgeonsFeeBD = temp.getSurgeonsFee();
            surgicalSum = surgicalSum.add(surgeonsFeeBD);
        }

        for (int i = 0; i <= surgicalList.size() - 1; i++) {

            SurgicalBean temp = surgicalList.get(i);

            Timestamp dateOfSurgery = temp.getDateOfSurgery();
            SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy");

            String date = format.format(new Date(dateOfSurgery.getTime()));

            String supplies = Messages.getString("supplies");
            String suppliesPrice = "$" + temp.getSupplies() + "";

            ReceiptDataBean tempReceipt = new ReceiptDataBean(supplies, date, suppliesPrice);

            addReceiptDataBean(tempReceipt);

            BigDecimal suppliesBD = temp.getSupplies();
            surgicalSum = surgicalSum.add(suppliesBD);
        }

        ReceiptDataBean totalSurgicalPrice = new ReceiptDataBean("", "", "Total: $" + surgicalSum + "");
        addReceiptDataBean(totalSurgicalPrice);

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
        
        return null;
    }
}
