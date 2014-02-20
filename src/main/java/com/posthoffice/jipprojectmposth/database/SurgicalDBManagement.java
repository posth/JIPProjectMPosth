package com.posthoffice.jipprojectmposth.database;

import com.posthoffice.jipprojectmposth.beans.SurgicalBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SurgicalDBManagement {

    private static final String url = "jdbc:mysql://localhost:3306/PATIENTDB";
    private static final String user = "root";
    private static final String password = "Johnny23";

    final Logger logger = LoggerFactory.getLogger(SurgicalDBManagement.class);

    public SurgicalDBManagement() {
        super();
    }

    //works
    //only time primary key is used is when it is read?
    public ArrayList<SurgicalBean> readSurgical(int patientID) throws SQLException {

        String preparedQuery = "SELECT * FROM SURGICAL WHERE PATIENTID = ?";

        ArrayList<SurgicalBean> surgicalList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user,
                password);
                PreparedStatement pStatement = connection.prepareStatement(preparedQuery);) {
            pStatement.setInt(1, patientID);
            try (ResultSet resultSet = pStatement.executeQuery()) {

                while (resultSet.next()) {

                    SurgicalBean temp = new SurgicalBean();

                    temp.setPatientID(resultSet.getInt("ID"));
                    temp.setiD(resultSet.getInt("PATIENTID"));
                    temp.setDateOfSurgery(resultSet.getTimestamp("DATEOFSURGERY"));
                    temp.setSurgery(resultSet.getString("SURGERY"));
                    temp.setRoomFee(resultSet.getBigDecimal("ROOMFEE"));
                    temp.setSurgeonsFee(resultSet.getBigDecimal("SURGEONFEE"));
                    temp.setSupplies(resultSet.getBigDecimal("SUPPLIES"));

                    surgicalList.add(temp);
                }
            }
        }
        return surgicalList;
    }

    //works
    public int createSurgical(SurgicalBean surgical) throws SQLException {

        int result;

        String preparedQuery = "INSERT INTO SURGICAL(PATIENTID, DATEOFSURGERY, SURGERY, ROOMFEE, SURGEONFEE, SUPPLIES) VALUES (?,?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url, user,
                password); PreparedStatement ps = connection.prepareStatement(preparedQuery);) {

            ps.setInt(1, surgical.getPatientID());
            ps.setTimestamp(2, surgical.getDateOfSurgery());
            ps.setString(3, surgical.getSurgery());
            ps.setBigDecimal(4, surgical.getRoomFee());
            ps.setBigDecimal(5, surgical.getSurgeonsFee());
            ps.setBigDecimal(6, surgical.getSupplies());

            result = ps.executeUpdate();
        }
        return result;
    }

    public int updateSurgical(SurgicalBean surgical) throws SQLException {

        int result;

        String preparedQuery = "UPDATE SURGICAL SET DATEOFSURGERY = ?, SURGERY = ?, ROOMFEE = ?, SURGEONFEE = ?, SUPPLIES = ? WHERE PATIENTID = ?";

        try (Connection connection = DriverManager.getConnection(url, user,
                password); PreparedStatement ps = connection.prepareStatement(preparedQuery);) {

            ps.setTimestamp(1, surgical.getDateOfSurgery());
            ps.setString(2, surgical.getSurgery());
            ps.setBigDecimal(3, surgical.getRoomFee());
            ps.setBigDecimal(4, surgical.getSurgeonsFee());
            ps.setBigDecimal(5, surgical.getSupplies());
            ps.setInt(6, surgical.getPatientID());

            result = ps.executeUpdate();
        }

        return result;
    }

    public int deleteSurgical(SurgicalBean surgical) throws SQLException {

        int result;

        String preparedQuery = "DELETE FROM SURGICAL WHERE PATIENTID = ?";

        try (Connection connection = DriverManager.getConnection(url, user,
                password); PreparedStatement ps = connection.prepareStatement(preparedQuery);) {
            ps.setInt(1, surgical.getPatientID());

            result = ps.executeUpdate();
        }

        return result;
    }
}
