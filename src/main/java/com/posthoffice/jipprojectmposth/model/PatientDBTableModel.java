package com.posthoffice.jipprojectmposth.model;

import com.posthoffice.jipprojectmposth.beans.InpatientBean;
import com.posthoffice.jipprojectmposth.beans.LiveDataBean;
import com.posthoffice.jipprojectmposth.beans.MedicationBean;
import com.posthoffice.jipprojectmposth.beans.PatientBean;
import com.posthoffice.jipprojectmposth.beans.SurgicalBean;
import com.posthoffice.jipprojectmposth.regex.Messages;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PatientDBTableModel extends AbstractTableModel {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private final ArrayList<String> columnNames = new ArrayList<>();
    private final ArrayList<PatientBean> data = new ArrayList<>();

    private InpatientDBTableModel inpatientModel;
    private MedicationDBTableModel medicationModel;
    private SurgicalDBTableModel surgicalModel;
 

    private final String[] patientColumnNames = {Messages.getString("idnumber"), Messages.getString("lastname"), Messages.getString("firstname"), Messages.getString("diagnosis"),
        Messages.getString("admissiondate")};

    public PatientDBTableModel(InpatientDBTableModel inpatientModel, MedicationDBTableModel medicationModel, SurgicalDBTableModel surgicalModel) {
        super();
        this.inpatientModel = inpatientModel;
        this.medicationModel = medicationModel;
        this.surgicalModel = surgicalModel;
        logger.info("Patient Database Table Model Instantiated");
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

    public void addPatientBean(PatientBean p) {
        data.add(p);
        this.fireTableDataChanged();

    }
    
    public void deletePatientBean(PatientBean p) {
        data.remove(p);
        this.fireTableDataChanged();
    }

    public void loadData(ArrayList<PatientBean> patientList) {

        int patientListSize = patientList.size();

        for (int i = 0; i <= patientListSize - 1; i++) {

            PatientBean temp = patientList.get(i);

            data.add(temp);

        }

    }

    public void setChildrenTableModels(int selectedRow) {

        PatientBean patientBean = getPatientData(selectedRow);

        logger.info("The Patient Bean taken from the Patient Model upon user selection" + patientBean);

        //getting the list of each child bean from the patient bean to send them to each children's table model
        ArrayList<InpatientBean> inpatientList = patientBean.getInpatientList();
        ArrayList<MedicationBean> medicationList = patientBean.getMedicationList();
        ArrayList<SurgicalBean> surgicalList = patientBean.getSurgicalList();

        logger.info("The Inpatient List as taken from the Patient Model class" + inpatientList);

        //sending arraylists to the seperate children table models 
        inpatientModel.loadInpatientList(inpatientList);
        medicationModel.loadMedicationList(medicationList);
        surgicalModel.loadSurgicalList(surgicalList);
        
        System.out.println("The inpatient bean list from table model selection is " + inpatientList);

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
        return patientColumnNames[col];
    }

    public boolean getUpdateStatus(int row) {
        return data.get(row).getUpdate();
    }

    public void clearUpdate(int row) {
        data.get(row).setUpdate(false);
    }

    public PatientBean getPatientData(int row) {
        return data.get(row);
    }

    public void deleteRow(int selectedRow) {
        data.remove(selectedRow);

        this.fireTableDataChanged();
    }

    public void addBlankRow() {
        PatientBean newPatient = new PatientBean();
        data.add(newPatient);

        this.fireTableDataChanged();
    }

    @Override
    public void setValueAt(Object value, int row, int col) {

        switch (col) {
            case 0:
                data.get(row).setPatientID((int) value);
                break;
            case 1:
                data.get(row).setLastName((String) value);
                break;
            case 2:
                data.get(row).setFirstName((String) value);
                break;
            case 3:
                data.get(row).setDiagnosis((String) value);
                break;
            case 4:
                data.get(row).setAdmissionDate((Timestamp) value);
                break;
            case 5:
                data.get(row).setReleaseDate((Timestamp) value);
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
                return data.get(row).getLastName();
            case 2:
                return data.get(row).getFirstName();
            case 3:
                return data.get(row).getDiagnosis();
            case 4:
                return data.get(row).getAdmissionDate();
            case 5:
                return data.get(row).getReleaseDate();
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
