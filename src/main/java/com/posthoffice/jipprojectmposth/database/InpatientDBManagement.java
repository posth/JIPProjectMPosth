package com.posthoffice.jipprojectmposth.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.posthoffice.jipprojectmposth.beans.InpatientBean;
import java.sql.Date;


public class InpatientDBManagement {

    private static final String url = "jdbc:mysql://localhost:3306/PATIENTDB";
    private static final String user = "root";
    private static final String password = "concordia";

    final Logger logger = LoggerFactory.getLogger(InpatientDBManagement.class);

    public InpatientDBManagement() {
        super();
    }

    public ArrayList<InpatientBean> read(int patientID) throws SQLException {

        String preparedQuery = "SELECT * FROM INPATIENT WHERE PATIENTID = ?";

        ArrayList<InpatientBean> inpatientList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user,
                password);
                PreparedStatement pStatement = connection.prepareStatement(preparedQuery);) {
            pStatement.setInt(1, patientID);
            try (ResultSet resultSet = pStatement.executeQuery()) {

                while (resultSet.next()) {

                    InpatientBean temp = new InpatientBean();

                    temp.setPatientID(resultSet.getInt("ID"));
                    temp.setiD(resultSet.getInt("PATIENTID"));
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

    public int create(InpatientBean inpatient) throws SQLException {

        int result;

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
        }
        return result;
    }
}
