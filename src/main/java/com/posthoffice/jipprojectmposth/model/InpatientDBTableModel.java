package com.posthoffice.jipprojectmposth.model;

import com.posthoffice.jipprojectmposth.beans.InpatientBean;
import com.posthoffice.jipprojectmposth.regex.Messages;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InpatientDBTableModel extends AbstractTableModel {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private ArrayList<InpatientBean> data = new ArrayList<>();
    private String[] INPATIENTCOLUMNNAMES = {Messages.getString("patientid"), Messages.getString("dateofstay"), Messages.getString("roomnumber"),
        Messages.getString("dailyrate"), Messages.getString("supplies"), Messages.getString("services")};

    public InpatientDBTableModel() {
        super();
        logger.info("Inpatient Database Table Model Instantiated");
    }

    public void addInpatientBean(InpatientBean p) {
        data.add(p);
        this.fireTableDataChanged();
    }

    public boolean getUpdateStatus(int row) {
        return data.get(row).getUpdate();
    }

    public void clearUpdate(int row) {
        data.get(row).setUpdate(false);
    }

    public InpatientBean getinPatientData(int row) {
        return data.get(row);
    }

    public void deleteRow(int selectedRow) {
        data.remove(selectedRow);
        this.fireTableDataChanged();
    }

    public void deleteAllRows() {
        data.clear();
        this.fireTableDataChanged();
    }

    /**
     * Receives an ArrayList of Inpatient Beans which it uses to populate the
     * Inpatient Models data ArrayList. This then populates the InpatientTable.
     * This method is called from the PatientDBTableModel class.
     *
     * @param inpatientList
     */
    public void loadInpatientList(ArrayList<InpatientBean> inpatientList) {

        int inpatientListLength = inpatientList.size();

        data.clear();

        for (int i = 0; i <= inpatientListLength - 1; i++) {
            InpatientBean temp = inpatientList.get(i);
            data.add(temp);
        }

        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return INPATIENTCOLUMNNAMES.length;
    }

    @Override
    public String getColumnName(int col) {
        return INPATIENTCOLUMNNAMES[col];
    }

    @Override
    public void setValueAt(Object value, int row, int col) {

        switch (col) {
            case 0:
                data.get(row).setPatientID((int) value);
                break;
            case 1:
                data.get(row).setDateOfStay((Timestamp) value);
                break;
            case 2:
                data.get(row).setRoomNumber((String) value);
                break;
            case 3:
                data.get(row).setDailyRate((BigDecimal) value);
                break;
            case 4:
                data.get(row).setRoomSupplies((BigDecimal) value);
                break;
            case 5:
                data.get(row).setRoomServices((BigDecimal) value);
                break;
        }

        fireTableCellUpdated(row, col);
        data.get(row).setUpdate(true);
    }

    @Override
    public Object getValueAt(int row, int col) {

        switch (col) {
            case 0:
                return data.get(row).getPatientID();
            case 1:
                return data.get(row).getDateOfStay();
            case 2:
                return data.get(row).getRoomNumber();
            case 3:
                return data.get(row).getDailyRate();
            case 4:
                return data.get(row).getRoomSupplies();
            case 5:
                return data.get(row).getRoomServices();
        }

        return null;
    }

    @Override
    public Class<? extends Object> getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public boolean isCellEditable(int row, int col) {

        boolean retVal = true;

        if (col == 0) {
            retVal = false;
        }
        return retVal;
    }
}
