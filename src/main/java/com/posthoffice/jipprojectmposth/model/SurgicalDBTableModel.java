package com.posthoffice.jipprojectmposth.model;

import com.posthoffice.jipprojectmposth.beans.SurgicalBean;
import com.posthoffice.jipprojectmposth.regex.Messages;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SurgicalDBTableModel extends AbstractTableModel {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private ArrayList<SurgicalBean> data = new ArrayList<>();

    private String[] SURGICALCOLUMNNAMES = {Messages.getString("patientid"), Messages.getString("dateofsurgery"), Messages.getString("surgery"),
        Messages.getString("roomfee"), Messages.getString("surgeonsfee"), Messages.getString("supplies")};

    public SurgicalDBTableModel() {
        super();
        logger.info("Medication Database Table Model Instantiated");
    }

    public void addSurgicalBean(SurgicalBean s) {
        data.add(s);
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return SURGICALCOLUMNNAMES.length;
    }

    @Override
    public String getColumnName(int col) {
        return SURGICALCOLUMNNAMES[col];
    }

    public boolean getUpdateStatus(int row) {
        return data.get(row).getUpdate();
    }

    public void clearUpdate(int row) {
        data.get(row).setUpdate(false);
    }
    
    public SurgicalBean getSurgicalData(int row) {
        return data.get(row);
    }

    public void deleteRow(int selectedRow) {
        data.remove(selectedRow);

        this.fireTableDataChanged();
    }

    public void loadSurgicalList(ArrayList<SurgicalBean> surgicalList) {

        int surgicalListLength = surgicalList.size();

        data.clear();

        for (int i = 0; i <= surgicalListLength - 1; i++) {
            SurgicalBean temp = surgicalList.get(i);
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
                data.get(row).setDateOfSurgery((Timestamp) value);
                break;
            case 2:
                data.get(row).setSurgery((String) value);
                break;
            case 3:
                data.get(row).setRoomFee((BigDecimal) value);
                break;
            case 4:
                data.get(row).setSurgeonsFee((BigDecimal) value);
                break;
            case 5:
                data.get(row).setSupplies((BigDecimal) value);
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
                return data.get(row).getDateOfSurgery();
            case 2:
                return data.get(row).getSurgery();
            case 3:
                return data.get(row).getRoomFee();
            case 4:
                return data.get(row).getSurgeonsFee();
            case 5:
                return data.get(row).getSupplies();
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
