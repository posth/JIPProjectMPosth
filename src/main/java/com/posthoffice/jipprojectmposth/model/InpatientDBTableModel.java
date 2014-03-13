package com.posthoffice.jipprojectmposth.model;

import com.posthoffice.jipprojectmposth.beans.InpatientBean;
import com.posthoffice.jipprojectmposth.presentation.InpatientTable;
import java.math.BigDecimal;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InpatientDBTableModel extends AbstractTableModel {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private final ArrayList<String> columnNames = new ArrayList<>();
    private ArrayList<InpatientBean> data = new ArrayList<>();
    private String[] inpatientColumnNames = {"Patient ID", "Date of Stay", "Room Number",
        "Daily Rate", "Supplies", "Services"};

    public InpatientDBTableModel() {
        super();
        logger.info("Inpatient Database Table Model Instantiated");
    }

    public int loadColumnNames(ResultSetMetaData rsmd) {

        int colCount = 0;
        try {
            colCount = rsmd.getColumnCount() - 1;

            for (int i = 1; i <= colCount; ++i) {
                columnNames.add(rsmd.getColumnName(i) + 1);
            }
        } catch (SQLException e) {
            logger.error("Error loading column names", e);
        }

        return colCount;
    }

    public void addInpatientBean(InpatientBean p) {
        data.add(p);
        this.fireTableDataChanged();

    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public String getColumnName(int col) {
        return inpatientColumnNames[col];
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

    public void addBlankRow() {
        InpatientBean newInpatient = new InpatientBean();
        data.add(newInpatient);

        this.fireTableDataChanged();
    }

    public void loadInpatientList(ArrayList<InpatientBean> inpatientList) {

        int inpatientListLength = inpatientList.size();
        
        //System.out.println("What's in the Inpatient model arraylist BEFORE: " + data);

        for (int i = 0; i <= inpatientListLength - 1; i++) {
            InpatientBean temp = inpatientList.get(i);
            data.add(temp);
        }

        System.out.println("at load inpatient list method");
        
        //System.out.println("What's in the Inpatient model arraylist AFTER: " + data);

        this.fireTableDataChanged();

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
        // What kind of exception to catch here?
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
