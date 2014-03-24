package com.posthoffice.jipprojectmposth.model;

import com.posthoffice.jipprojectmposth.beans.MedicationBean;
import com.posthoffice.jipprojectmposth.regex.Messages;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MedicationDBTableModel extends AbstractTableModel {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private ArrayList<MedicationBean> data = new ArrayList<>();

    private String[] MEDICATIONCOLUMNNAMES = {Messages.getString("patientid"), Messages.getString("dateofmed"), Messages.getString("medication"),
        Messages.getString("unitcost"), Messages.getString("units")};

    public MedicationDBTableModel() {
        super();
        logger.info("Medication Database Table Model Instantiated");
    }

    public void addMedicationBean(MedicationBean p) {
        data.add(p);
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return MEDICATIONCOLUMNNAMES.length;
    }

    @Override
    public String getColumnName(int col) {
        return MEDICATIONCOLUMNNAMES[col];
    }

    public boolean getUpdateStatus(int row) {
        return data.get(row).getUpdate();
    }

    public void clearUpdate(int row) {
        data.get(row).setUpdate(false);
    }

    public MedicationBean getMedicationData(int row) {
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

    public void loadMedicationList(ArrayList<MedicationBean> medicationList) {

        int medicationListLength = medicationList.size();

        data.clear();

        for (int i = 0; i <= medicationListLength - 1; i++) {
            MedicationBean temp = medicationList.get(i);
            data.add(temp);
        }

        this.fireTableDataChanged();

    }

    @Override
    public void setValueAt(Object value, int row, int col) {

        switch (col) {
            case 0:
                data.get(row).setPatientID((int) value);
                break;
            case 1:
                data.get(row).setDateOfMed((Timestamp) value);
                break;
            case 2:
                data.get(row).setMedication((String) value);
                break;
            case 3:
                data.get(row).setCostPerUnit((BigDecimal) value);
                break;
            case 4:
                data.get(row).setNumberOfUnits((BigDecimal) value);
                break;
        }

        fireTableCellUpdated(row, col);
        //data.get(row).setUpdate(true);
    }

    @Override
    public Object getValueAt(int row, int col) {

        switch (col) {
            case 0:
                return data.get(row).getPatientID();
            case 1:
                return data.get(row).getDateOfMed();
            case 2:
                return data.get(row).getMedication();
            case 3:
                return data.get(row).getCostPerUnit();
            case 4:
                return data.get(row).getNumberOfUnits();
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
