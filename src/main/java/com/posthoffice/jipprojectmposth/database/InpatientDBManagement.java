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
import com.posthoffice.jipprojectmposth.beans.LiveDataBean;
import com.posthoffice.jipprojectmposth.model.InpatientDBTableModel;
import java.sql.Statement;


public class InpatientDBManagement {

    private InpatientDBTableModel inpatientDBTableModel = null;
    private final boolean DEBUG = false;
    final Logger logger = LoggerFactory.getLogger(InpatientDBManagement.class);
    
    private LiveDataBean liveDataBean;
    
    private String URL;
    private String USER;
    private String PASSWORD;

    public InpatientDBManagement() {
        
        super();
        
        this.liveDataBean = new LiveDataBean();
        
        this.URL = "";
        this.USER = "";
        this.PASSWORD = "";
    }

    public InpatientDBManagement(InpatientDBTableModel inpatientDBTableModel, LiveDataBean liveDataBean) {
        
        super();
        
        this.inpatientDBTableModel = inpatientDBTableModel; 
                
        this.liveDataBean = liveDataBean;
        
        this.URL = liveDataBean.getURL();
        this.USER = liveDataBean.getUSER();
        this.PASSWORD = liveDataBean.getPASSWORD();
    }

    public ArrayList<InpatientBean> readInpatient(int patientID) throws SQLException {

        String preparedQuery = "SELECT * FROM INPATIENT WHERE PATIENTID = ?";

        ArrayList<InpatientBean> inpatientList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pStatement = connection.prepareStatement(preparedQuery);) {
            pStatement.setInt(1, patientID);
            try (ResultSet resultSet = pStatement.executeQuery()) {

                while (resultSet.next()) {

                    InpatientBean temp = new InpatientBean();

                    temp.setPatientID(resultSet.getInt("PATIENTID"));
                    temp.setiD(resultSet.getInt("ID"));
                    temp.setDateOfStay(resultSet.getTimestamp("DATEOFSTAY"));
                    temp.setRoomNumber(resultSet.getString("ROOMNUMBER"));
                    temp.setDailyRate(resultSet.getBigDecimal("DAILYRATE"));
                    temp.setRoomSupplies(resultSet.getBigDecimal("SUPPLIES"));
                    temp.setRoomServices(resultSet.getBigDecimal("SERVICES"));

                    inpatientList.add(temp);
                }
            }

        }

        return inpatientList;
    }

    public int createInpatient(InpatientBean inpatient) throws SQLException {

        int result;

        String primaryKeySQL = "SELECT LAST_INSERT_ID()";

        String preparedQuery = "INSERT INTO INPATIENT(PATIENTID, DATEOFSTAY, ROOMNUMBER, DAILYRATE, SUPPLIES, SERVICES) VALUES (?,?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(URL, USER,
                PASSWORD); PreparedStatement ps = connection.prepareStatement(preparedQuery);) {

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
                    inpatient.setiD((int) key);
                    //temporary fix of casting to int,
                }

                inpatientDBTableModel.addInpatientBean(inpatient);
            }
        }
        return result;
    }

    //WILL HAVE TO BE CHANGED TO WORK WITH THE ID AND NOT PATIENT ID
    public int updateInpatient(InpatientBean inpatient) throws SQLException {

        int result;

        String preparedQuery = "UPDATE INPATIENT SET DATEOFSTAY = ?, ROOMNUMBER = ?, DAILYRATE = ?, SUPPLIES = ?, SERVICES = ? WHERE PATIENTID = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER,
                PASSWORD); PreparedStatement ps = connection.prepareStatement(preparedQuery);) {

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

    public int deleteInpatient(InpatientBean inpatient) throws SQLException {

        int result;

        String preparedQuery = "DELETE FROM INPATIENT WHERE ID = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER,
                PASSWORD); PreparedStatement ps = connection.prepareStatement(preparedQuery);) {
            ps.setInt(1, inpatient.getiD());

            result = ps.executeUpdate();
        }

        return result;
    }
}
