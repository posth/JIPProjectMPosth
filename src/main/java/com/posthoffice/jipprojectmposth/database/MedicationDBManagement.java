package com.posthoffice.jipprojectmposth.database;

import com.posthoffice.jipprojectmposth.beans.MedicationBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MedicationDBManagement {

    private static final String url = "jdbc:mysql://localhost:3306/PATIENTDB";
    private static final String user = "root";
    private static final String password = "Johnny23";

    final Logger logger = LoggerFactory.getLogger(MedicationDBManagement.class);

    public MedicationDBManagement() {
        super();
    }

    //works
    public ArrayList<MedicationBean> readMedication(int patientID) throws SQLException {

        String preparedQuery = "SELECT * FROM MEDICATION WHERE PATIENTID = ?";

        ArrayList<MedicationBean> medicationList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user,
                password);
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

    //works
    public int createMedication(MedicationBean medication) throws SQLException {

        int result;

        String preparedQuery = "INSERT INTO MEDICATION(PATIENTID, DATEOFMED, MED, UNITCOST, UNITS) VALUES (?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url, user,
                password); PreparedStatement ps = connection.prepareStatement(preparedQuery);) {

            ps.setInt(1, medication.getPatientID());
            ps.setTimestamp(2, medication.getDateOfMed());
            ps.setString(3, medication.getMedication());
            ps.setBigDecimal(4, medication.getCostPerUnit());
            ps.setBigDecimal(5, medication.getNumberOfUnits());

            result = ps.executeUpdate();
        }
        return result;
    }

    public int updateMedication(MedicationBean medication) throws SQLException {

        int result;

        String preparedQuery = "UPDATE MEDICATION SET DATEOFMED = ?, MED = ?, UNITCOST = ?, UNITS = ? WHERE PATIENTID = ?";

        try (Connection connection = DriverManager.getConnection(url, user,
                password); PreparedStatement ps = connection.prepareStatement(preparedQuery);) {

            ps.setTimestamp(1, medication.getDateOfMed());
            ps.setString(2, medication.getMedication());
            ps.setBigDecimal(3, medication.getCostPerUnit());
            ps.setBigDecimal(4, medication.getNumberOfUnits());
            ps.setInt(5, medication.getPatientID());

            result = ps.executeUpdate();
        }

        return result;
    }

    public int deleteMedication(MedicationBean medication) throws SQLException {

        int result;

        String preparedQuery = "DELETE FROM MEDICATION WHERE PATIENTID = ?";

        try (Connection connection = DriverManager.getConnection(url, user,
                password); PreparedStatement ps = connection.prepareStatement(preparedQuery);) {
            ps.setInt(1, medication.getPatientID());

            result = ps.executeUpdate();
        }

        return result;
    }

}
