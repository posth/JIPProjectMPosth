package com.posthoffice.jipprojectmposth.database;

import com.posthoffice.jipprojectmposth.beans.SurgicalBean;
import com.posthoffice.jipprojectmposth.model.SurgicalDBTableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.posthoffice.jipprojectmposth.presentation.JIPFramePresentation.URL;
import static com.posthoffice.jipprojectmposth.presentation.JIPFramePresentation.USER;
import static com.posthoffice.jipprojectmposth.presentation.JIPFramePresentation.PASSWORD;
import java.sql.Statement;

public class SurgicalDBManagement {

    private SurgicalDBTableModel surgicalDBTableModel = null;
    final Logger logger = LoggerFactory.getLogger(SurgicalDBManagement.class);

    public SurgicalDBManagement() {
        super();
    }
    
    public SurgicalDBManagement(SurgicalDBTableModel surgicalDBTableModel) {
        super();
        this.surgicalDBTableModel = surgicalDBTableModel;
    }

    public ArrayList<SurgicalBean> readSurgical(int patientID) throws SQLException {

        String preparedQuery = "SELECT * FROM SURGICAL WHERE PATIENTID = ?";

        ArrayList<SurgicalBean> surgicalList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER,
                PASSWORD);
                PreparedStatement pStatement = connection.prepareStatement(preparedQuery);) {
            pStatement.setInt(1, patientID);
            try (ResultSet resultSet = pStatement.executeQuery()) {

                while (resultSet.next()) {

                    SurgicalBean temp = new SurgicalBean();

                    temp.setPatientID(resultSet.getInt("ID"));
                    //temp.setiD(resultSet.getInt("PATIENTID"));
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

    public int createSurgical(SurgicalBean surgical) throws SQLException {

        int result;

        String primaryKeySQL = "SELECT LAST_INSERT_ID()";

        String preparedQuery = "INSERT INTO SURGICAL(PATIENTID, DATEOFSURGERY, SURGERY, ROOMFEE, SURGEONFEE, SUPPLIES) VALUES (?,?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(URL, USER,
                PASSWORD); PreparedStatement ps = connection.prepareStatement(preparedQuery);) {

            ps.setInt(1, surgical.getPatientID());
            ps.setTimestamp(2, surgical.getDateOfSurgery());
            ps.setString(3, surgical.getSurgery());
            ps.setBigDecimal(4, surgical.getRoomFee());
            ps.setBigDecimal(5, surgical.getSurgeonsFee());
            ps.setBigDecimal(6, surgical.getSupplies());

            result = ps.executeUpdate();

            try (Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery(primaryKeySQL);) {
                if (rs.next()) {
                    long key = rs.getLong(1);
                    surgical.setiD((int) key);
                    //temporary fix of casting to int,
                }

                surgicalDBTableModel.addSurgicalBean(surgical);
            }
        }
        return result;
    }

    public int updateSurgical(SurgicalBean surgical) throws SQLException {

        int result;

        String preparedQuery = "UPDATE SURGICAL SET DATEOFSURGERY = ?, SURGERY = ?, ROOMFEE = ?, SURGEONFEE = ?, SUPPLIES = ? WHERE PATIENTID = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER,
                PASSWORD); PreparedStatement ps = connection.prepareStatement(preparedQuery);) {

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

        try (Connection connection = DriverManager.getConnection(URL, USER,
                PASSWORD); PreparedStatement ps = connection.prepareStatement(preparedQuery);) {
            ps.setInt(1, surgical.getPatientID());

            result = ps.executeUpdate();
        }

        return result;
    }
}
