package com.posthoffice.jipprojectmposth.database;

import com.posthoffice.jipprojectmposth.beans.InpatientBean;
import com.posthoffice.jipprojectmposth.beans.LiveDataBean;
import com.posthoffice.jipprojectmposth.beans.MedicationBean;
import com.posthoffice.jipprojectmposth.beans.PatientBean;
import com.posthoffice.jipprojectmposth.beans.SurgicalBean;

import com.posthoffice.jipprojectmposth.model.PatientDBTableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PatientDBManagement {

    private PatientDBTableModel patientDBTableModel;

    private InpatientDBManagement inpatientDBManager;
    private MedicationDBManagement medicationDBManager;
    private SurgicalDBManagement surgicalDBManager;

    private final boolean DEBUG = false;
    final Logger logger = LoggerFactory.getLogger(PatientDBManagement.class);
    
    private LiveDataBean liveDataBean;
    
    private String URL;
    private String USER;
    private String PASSWORD;

    public PatientDBManagement() {

        super();

        this.patientDBTableModel = new PatientDBTableModel();

        this.inpatientDBManager = new InpatientDBManagement();
        this.medicationDBManager = new MedicationDBManagement();
        this.surgicalDBManager = new SurgicalDBManagement();
        
        this.liveDataBean = new LiveDataBean();
        
        this.URL = "";
        this.USER = "";
        this.PASSWORD = "";
    }

    public PatientDBManagement(PatientDBTableModel patientDBTableModel, InpatientDBManagement inpatientDBManager, MedicationDBManagement medicationDBManager,
            SurgicalDBManagement surgicalDBManager, LiveDataBean liveDataBean) {

        super();

        logger.info("Patient Database instantiated.");

        this.patientDBTableModel = patientDBTableModel;

        this.inpatientDBManager = inpatientDBManager;
        this.medicationDBManager = medicationDBManager;
        this.surgicalDBManager = surgicalDBManager;
        
        this.liveDataBean = liveDataBean;
        
        this.URL = liveDataBean.getURL();
        this.USER = liveDataBean.getUSER();
        this.PASSWORD = liveDataBean.getPASSWORD();
    }

    /**
     * Is called to read all Patient Data from the database and fills 
     * the PatientDBTableModel class with all the currently stored Patient data.
     * @param criteria
     * @return 
     */
    public boolean fillTableModel(String criteria) {

        boolean retVal = true;
        
        String sql = "SELECT * FROM PATIENT";
        
        if (criteria != null) {
            sql += criteria;
        }

        try (Connection connection = DriverManager.getConnection(URL, USER,
                PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);) {

            if (resultSet.next()) {
                ResultSetMetaData rsmd = resultSet.getMetaData();
                patientDBTableModel.loadColumnNames(rsmd);
                patientDBTableModel.loadData(readPatient());

            } else {
                retVal = false;
            }
        } catch (SQLException sqlex) {
            logger.error("Error filling table.", sqlex);
            retVal = false;
        }

        return retVal;
    }

    /**
     * Method is called when the Save button from the frame is called.  Any information changed
     * in the Patient table will be recorded.
     */
    public void updateDB() {

        PatientBean patient;
        
        int result = 0;

        try (Connection connection = DriverManager.getConnection(URL, USER,
                PASSWORD);) {

            for (int theRows = 0; theRows < patientDBTableModel.getRowCount(); ++theRows) {
                if (patientDBTableModel.getUpdateStatus(theRows)) {
                    patient = patientDBTableModel.getPatientData(theRows);
                    if (DEBUG) {
                        System.out.println("Updating row: " + theRows);
                    }
                    if (patient.getPatientID() > 0) {
                        result = updatePatient(patient);
                    } else {
                        result = createPatient(patient);
                    }
                }
                if (DEBUG) {
                    if (result == 1) {
                        System.out.println("\nUpdate successful\n");
                    } else {
                        System.out.println("\nUpdate UNsuccessful\n");
                    }
                }

                patientDBTableModel.clearUpdate(theRows);
            }
        } catch (SQLException sqlex) {
            logger.error("Error updating database", sqlex);
        }

    }

    /**
     * It receives a Patient Bean to create and auto generates the PATIENTID
     * primary key for each new Patient it receives.
     * @param patient
     * @return
     * @throws SQLException 
     */
    public int createPatient(PatientBean patient) throws SQLException {

        int result;

        String primaryKeySQL = "SELECT LAST_INSERT_ID()";

        String preparedQuery = "INSERT INTO PATIENT(LASTNAME, FIRSTNAME, DIAGNOSIS, ADMISSIONDATE, RELEASERATE) VALUES (?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement ps = connection.prepareStatement(preparedQuery);) {
            ps.setString(1, patient.getLastName());
            ps.setString(2, patient.getFirstName());
            ps.setString(3, patient.getDiagnosis());
            ps.setTimestamp(4, patient.getAdmissionDate());
            ps.setTimestamp(5, patient.getReleaseDate());

            result = ps.executeUpdate();

            try (Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery(primaryKeySQL);) {
                if (rs.next()) {
                    long key = rs.getLong(1);
                    patient.setPatientID((int) key);
                    //temporary fix of casting to int,
                }

                patientDBTableModel.addPatientBean(patient);
            }
        }
        logger.info("Records inserted: " + result);
        return result;
    }

    /**
     * Reads all Patient data from the database and returns an ArrayList of
     * Patient Beans.  This method also populates children data (Inpatient, 
     * Medication, and Surgical) into the Patient Bean.
     * @return ArrayList<PatientBean>
     * @throws SQLException 
     */
    public ArrayList<PatientBean> readPatient() throws SQLException {

        String preparedQuery = "SELECT * FROM PATIENT";

        ArrayList<PatientBean> patientList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER,
                PASSWORD);
                PreparedStatement pStatement = connection.prepareStatement(preparedQuery);) {

            try (ResultSet resultSet = pStatement.executeQuery()) {

                while (resultSet.next()) {

                    PatientBean temp = new PatientBean();

                    int patientID = resultSet.getInt("PATIENTID");

                    temp.setPatientID(resultSet.getInt("PATIENTID"));
                    temp.setLastName(resultSet.getString("LASTNAME"));
                    temp.setFirstName(resultSet.getString("FIRSTNAME"));
                    temp.setDiagnosis(resultSet.getString("DIAGNOSIS"));
                    temp.setAdmissionDate(resultSet.getTimestamp("ADMISSIONDATE"));
                    temp.setReleaseDate(resultSet.getTimestamp("RELEASERATE"));

                    temp.setInpatientList(inpatientDBManager.readInpatient(patientID));
                    temp.setMedicationList(medicationDBManager.readMedication(patientID));
                    temp.setSurgicalList(surgicalDBManager.readSurgical(patientID));

                    patientList.add(temp);
                }
            }
        }

        return patientList;

    }

    /**
     * Receives a Patient Bean to add to the database.
     * @param patient
     * @return
     * @throws SQLException 
     */
    public int updatePatient(PatientBean patient) throws SQLException {

        int result;

        String preparedQuery = "UPDATE PATIENT SET LASTNAME = ?, FIRSTNAME = ?, DIAGNOSIS = ?, ADMISSIONDATE = ?, RELEASERATE = ? WHERE PATIENTID = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement ps = connection.prepareStatement(preparedQuery);) {

            ps.setString(1, patient.getLastName());
            ps.setString(2, patient.getFirstName());
            ps.setString(3, patient.getDiagnosis());
            ps.setTimestamp(4, patient.getAdmissionDate());
            ps.setTimestamp(5, patient.getReleaseDate());
            ps.setInt(6, patient.getPatientID());

            patient.setInpatientList(inpatientDBManager.readInpatient(patient.getPatientID()));

            patient.setMedicationList(medicationDBManager.readMedication(patient.getPatientID()));

            patient.setSurgicalList(surgicalDBManager.readSurgical(patient.getPatientID()));

            result = ps.executeUpdate();

        }

        return result;
    }

    /**
     * Receives a Patient Bean to delete.  This method also deletes all connected
     * children data (Inpatient, Medication, and Surgical) when called.
     * @param patientBean
     * @return
     * @throws SQLException 
     */
    public int deletePatient(PatientBean patientBean) throws SQLException {
        
        int result = 0;        

        String preparedQuery = "DELETE FROM PATIENT WHERE PATIENTID = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER,
                PASSWORD);
                PreparedStatement ps = connection.prepareStatement(preparedQuery);) {

            ps.setInt(1, patientBean.getPatientID());

            int patientID = patientBean.getPatientID();

            ArrayList<InpatientBean> inpatientList = inpatientDBManager.readInpatient(patientID);
            ArrayList<MedicationBean> medicationList = medicationDBManager.readMedication(patientID);
            ArrayList<SurgicalBean> surgicalList = surgicalDBManager.readSurgical(patientID);

            //delete each inpatient bean the deleted patient has
            int inpatientListLength = inpatientList.size();
            for (int i = 0; i < inpatientListLength; i++) {
                InpatientBean temp = inpatientList.get(i);
                inpatientDBManager.deleteInpatient(temp);
            }

            //delete each medication bean the deleted patient has
            int medicationListLength = medicationList.size();
            for (int i = 0; i < medicationListLength; i++) {
                MedicationBean temp = medicationList.get(i);
                medicationDBManager.deleteMedication(temp);
            }

            //delete each surgical bean the deleted patient has
            int surgicalListLength = surgicalList.size();
            for (int i = 0; i < surgicalListLength; i++) {
                SurgicalBean temp = surgicalList.get(i);
                surgicalDBManager.deleteSurgical(temp);
            }

            result = ps.executeUpdate();

        }

        logger.info("Records deleted: " + result);
        return result;
    }
}
