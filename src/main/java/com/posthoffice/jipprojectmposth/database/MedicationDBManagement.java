package com.posthoffice.jipprojectmposth.database;

import com.posthoffice.jipprojectmposth.beans.LiveDataBean;
import com.posthoffice.jipprojectmposth.beans.MedicationBean;
import com.posthoffice.jipprojectmposth.model.MedicationDBTableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Statement;

public class MedicationDBManagement {

    private MedicationDBTableModel medicationDBTableModel = null;
    
    private final boolean DEBUG = false;
    final Logger logger = LoggerFactory.getLogger(MedicationDBManagement.class);
    
    private LiveDataBean liveDataBean;
    
    private String URL;
    private String USER;
    private String PASSWORD;

    public MedicationDBManagement() {
        super();

        this.liveDataBean = new LiveDataBean();

        this.URL = "";
        this.USER = "";
        this.PASSWORD = "";
    }

    public MedicationDBManagement(MedicationDBTableModel medicationDBTableModel, LiveDataBean liveDataBean) {

        super();

        this.medicationDBTableModel = medicationDBTableModel;

        this.liveDataBean = liveDataBean;

        this.URL = liveDataBean.getURL();
        this.USER = liveDataBean.getUSER();
        this.PASSWORD = liveDataBean.getPASSWORD();
    }

    /**
     * Method is called when the Save button from the frame is called. Any
     * information changed in the Medication table will be recorded.
     */
    public void updateDB() {

        MedicationBean medication;

        int result = 0;

        try (Connection connection = DriverManager.getConnection(URL, USER,
                PASSWORD);) {

            for (int theRows = 0; theRows < medicationDBTableModel.getRowCount(); ++theRows) {
                if (medicationDBTableModel.getUpdateStatus(theRows)) {
                    medication = medicationDBTableModel.getMedicationData(theRows);
                    if (DEBUG) {
                        System.out.println("Updating row: " + theRows);
                    }
                    if (medication.getiD() > 0) {
                        result = updateMedication(medication);
                    } else {
                        result = createMedication(medication);
                    }
                }
                if (DEBUG) {
                    if (result == 1) {
                        System.out.println("\nUpdate successful\n");
                    } else {
                        System.out.println("\nUpdate UNsuccessful\n");
                    }
                }

                medicationDBTableModel.clearUpdate(theRows);
            }
        } catch (SQLException sqlex) {
            logger.error("Error updating database", sqlex);
        }

    }

    /**
     * Reading all the Medication Data for one Patient based on the patientID
     * which is the Patient's primary key.
     *
     * @param patientID
     * @return
     * @throws SQLException
     */
    public ArrayList<MedicationBean> readMedication(int patientID) throws SQLException {

        String preparedQuery = "SELECT * FROM MEDICATION WHERE PATIENTID = ?";

        ArrayList<MedicationBean> medicationList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER,
                PASSWORD);
                PreparedStatement pStatement = connection.prepareStatement(preparedQuery);) {
            pStatement.setInt(1, patientID);
            try (ResultSet resultSet = pStatement.executeQuery()) {

                while (resultSet.next()) {

                    MedicationBean temp = new MedicationBean();

                    temp.setPatientID(resultSet.getInt("PATIENTID"));
                    temp.setiD(resultSet.getInt("ID"));
                    temp.setDateOfMed(resultSet.getTimestamp("DATEOFMED"));
                    temp.setMedication(resultSet.getString("MED"));
                    temp.setCostPerUnit(resultSet.getBigDecimal("UNITCOST"));
                    temp.setNumberOfUnits(resultSet.getBigDecimal("UNITS"));

                    medicationList.add(temp);
                }
            }
        }

        return medicationList;
    }

    /**
     * Creating new Medication data by receiving a Medication Bean. It is linked
     * to the Patient through the PATIENTID. However, the primary key for the
     * Medication is ID.
     *
     * @param medication
     * @return
     * @throws SQLException
     */
    public int createMedication(MedicationBean medication) throws SQLException {

        int result;

        String primaryKeySQL = "SELECT LAST_INSERT_ID()";

        String preparedQuery = "INSERT INTO MEDICATION(PATIENTID, DATEOFMED, MED, UNITCOST, UNITS) VALUES (?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(URL, USER,
                PASSWORD); PreparedStatement ps = connection.prepareStatement(preparedQuery);) {

            ps.setInt(1, medication.getPatientID());
            ps.setTimestamp(2, medication.getDateOfMed());
            ps.setString(3, medication.getMedication());
            ps.setBigDecimal(4, medication.getCostPerUnit());
            ps.setBigDecimal(5, medication.getNumberOfUnits());

            result = ps.executeUpdate();

            try (Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery(primaryKeySQL);) {
                if (rs.next()) {
                    long key = rs.getLong(1);
                    medication.setiD((int) key);

                }

                medicationDBTableModel.addMedicationBean(medication);

            }
        }
        return result;
    }

    /**
     * Receives a Medication Bean to add to the database.
     *
     * @param medication
     * @return
     * @throws SQLException
     */
    public int updateMedication(MedicationBean medication) throws SQLException {

        int result;

        String preparedQuery = "UPDATE MEDICATION SET DATEOFMED = ?, MED = ?, UNITCOST = ?, UNITS = ?, PATIENTID = ? WHERE ID = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER,
                PASSWORD); PreparedStatement ps = connection.prepareStatement(preparedQuery);) {

            ps.setTimestamp(1, medication.getDateOfMed());
            ps.setString(2, medication.getMedication());
            ps.setBigDecimal(3, medication.getCostPerUnit());
            ps.setBigDecimal(4, medication.getNumberOfUnits());
            ps.setInt(5, medication.getPatientID());
            ps.setInt(6, medication.getiD());

            result = ps.executeUpdate();
        }

        return result;
    }

    /**
     * Deleting Medication Data using its primary ID key, ID. It receives a
     * Medication Bean and extracts its ID.
     *
     * @param medication
     * @return
     * @throws SQLException
     */
    public int deleteMedication(MedicationBean medication) throws SQLException {

        int result;

        String preparedQuery = "DELETE FROM MEDICATION WHERE ID = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER,
                PASSWORD); PreparedStatement ps = connection.prepareStatement(preparedQuery);) {
            ps.setInt(1, medication.getiD());

            result = ps.executeUpdate();
        }

        return result;
    }
}
