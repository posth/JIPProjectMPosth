package com.posthoffice.jipprojectmposth.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.posthoffice.jipprojectmposth.beans.InpatientBean;
import com.posthoffice.jipprojectmposth.model.InpatientDBTableModel;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class InpatientDBManagement {

    private static final String url = "jdbc:mysql://localhost:3306/PATIENTDB";
    private static final String user = "root";
    private static final String password = "Johnny23";
    private InpatientDBTableModel inpatientDBTableModel = null;
    private final boolean DEBUG = false;
    final Logger logger = LoggerFactory.getLogger(InpatientDBManagement.class);

    public InpatientDBManagement() {
        super();
    }

    public InpatientDBManagement(InpatientDBTableModel inpatientDBTableModel) {
        super();
        logger.info("Inpatient Database instantiated");
        this.inpatientDBTableModel = inpatientDBTableModel;
    }

    public boolean fillTableModel(String criteria) {

        boolean retVal = true;
        String sql = "SELECT * FROM INPATIENT";
        
        if (criteria != null) {
            sql += criteria;
        }

        try (Connection connection = DriverManager.getConnection(url, user,
                password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);) {

            if (resultSet.next()) {
                ResultSetMetaData rsmd = resultSet.getMetaData();
                inpatientDBTableModel.loadColumnNames(rsmd);         
            } else {
                retVal = false;
            }
        } catch (SQLException sqlex) {
            logger.error("Error filling table.", sqlex);
            retVal = false;
        }
        return retVal;
    }

    public ArrayList<InpatientBean> readInpatient(int patientID) throws SQLException {

        String preparedQuery = "SELECT * FROM INPATIENT WHERE PATIENTID = ?";

        ArrayList<InpatientBean> inpatientList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user,password);             
                PreparedStatement pStatement = connection.prepareStatement(preparedQuery);) {
            pStatement.setInt(1, patientID);
            try (ResultSet resultSet = pStatement.executeQuery()) {

                while (resultSet.next()) {

                    InpatientBean temp = new InpatientBean();

                    temp.setPatientID(resultSet.getInt("PATIENTID"));
                    //temp.setiD(resultSet.getInt("ID"));
                    temp.setDateOfStay(resultSet.getTimestamp("DATEOFSTAY"));
                    temp.setRoomNumber(resultSet.getString("ROOMNUMBER"));
                    temp.setDailyRate(resultSet.getBigDecimal("DAILYRATE"));
                    temp.setRoomSupplies(resultSet.getBigDecimal("SUPPLIES"));
                    temp.setRoomServices(resultSet.getBigDecimal("SERVICES"));

                    inpatientList.add(temp);
                }
            }

        }
        logger.info("The Inpatient List from the Inpatient DB Management class is " + inpatientList);
        
        return inpatientList;
    }

    //works
    public int createInpatient(InpatientBean inpatient) throws SQLException {

        int result;

        String primaryKeySQL = "SELECT LAST_INSERT_ID()";

        String preparedQuery = "INSERT INTO INPATIENT(PATIENTID, DATEOFSTAY, ROOMNUMBER, DAILYRATE, SUPPLIES, SERVICES) VALUES (?,?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url, user,
                password); PreparedStatement ps = connection.prepareStatement(preparedQuery);) {

            ps.setInt(1, inpatient.getPatientID());
            ps.setTimestamp(2, inpatient.getDateOfStay());
            ps.setString(3, inpatient.getRoomNumber());
            ps.setBigDecimal(4, inpatient.getDailyRate());
            ps.setBigDecimal(5, inpatient.getRoomSupplies());
            ps.setBigDecimal(6, inpatient.getRoomServices());

            result = ps.executeUpdate();

            try (Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery(primaryKeySQL);) {
                if (rs.next()) {
                    long key = rs.getLong(1);
                    inpatient.setPatientID((int) key);
                    //temporary fix of casting to int,
                }

                inpatientDBTableModel.addInpatientBean(inpatient);
            }
        }
        return result;
    }

    public int updateInpatient(InpatientBean inpatient) throws SQLException {

        int result;

        String preparedQuery = "UPDATE INPATIENT SET DATEOFSTAY = ?, ROOMNUMBER = ?, DAILYRATE = ?, SUPPLIES = ?, SERVICES = ? WHERE PATIENTID = ?";

        try (Connection connection = DriverManager.getConnection(url, user,
                password); PreparedStatement ps = connection.prepareStatement(preparedQuery);) {

            ps.setTimestamp(1, inpatient.getDateOfStay());
            ps.setString(2, inpatient.getRoomNumber());
            ps.setBigDecimal(3, inpatient.getDailyRate());
            ps.setBigDecimal(4, inpatient.getRoomSupplies());
            ps.setBigDecimal(5, inpatient.getRoomServices());
            ps.setInt(6, inpatient.getPatientID());

            result = ps.executeUpdate();
        }

        return result;
    }

    //works
    public int deleteInpatient(InpatientBean inpatient) throws SQLException {

        int result;

        String preparedQuery = "DELETE FROM INPATIENT WHERE PATIENTID = ?";

        try (Connection connection = DriverManager.getConnection(url, user,
                password); PreparedStatement ps = connection.prepareStatement(preparedQuery);) {
            ps.setInt(1, inpatient.getPatientID());

            result = ps.executeUpdate();
        }

        return result;
    }
}
