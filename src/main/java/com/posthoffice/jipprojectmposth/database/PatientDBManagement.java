package com.posthoffice.jipprojectmposth.database;

import com.posthoffice.jipprojectmposth.beans.PatientBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PatientDBManagement {

    private static final String url = "jdbc:mysql://localhost:3306/PATIENTDB";
    private static final String user = "root";
    private static final String password = "Johnny23";

    final Logger logger = LoggerFactory.getLogger(PatientDBManagement.class);

    public PatientDBManagement() {
        super();
    }

    public int createPatient(PatientBean patient) throws SQLException {

        int result;

        String preparedQuery = "INSERT INTO PATIENT(PATIENTID, LASTNAME, FIRSTNAME, DIAGNOSIS, ADMISSIONDATE, RELEASERATE) VALUES (?,?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url, user,
                password); PreparedStatement ps = connection.prepareStatement(preparedQuery);) {
            ps.setInt(1, patient.getPatientID());
            ps.setString(2, patient.getLastName());
            ps.setString(3, patient.getFirstName());
            ps.setString(4, patient.getDiagnosis());
            ps.setTimestamp(5, patient.getAdmissionDate());
            ps.setTimestamp(6, patient.getReleaseDate());

            result = ps.executeUpdate();
        }
        return result;
    }

    public void updatePatient(PatientBean patient) throws SQLException {

        String preparedQuery = "UPDATE PATIENT (PATIENTID, LASTNAME, FIRSTNAME, DIAGNOSIS, ADMISSIONDATE, RELEASERATE) VALUES (?,?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url, user,
                password); PreparedStatement ps = connection.prepareStatement(preparedQuery);) {

            ps.setInt(1, patient.getPatientID());
            ps.setString(2, patient.getLastName());
            ps.setString(3, patient.getFirstName());
            ps.setString(4, patient.getDiagnosis());
            ps.setTimestamp(5, patient.getAdmissionDate());
            ps.setTimestamp(6, patient.getReleaseDate());

        }
    }

    public int deletePatient(PatientBean patient) throws SQLException {

        int result;

        String preparedQuery = "DELETE * FROM PATIENT WHERE PATIENTID = ?";

        try (Connection connection = DriverManager.getConnection(url, user,
                password); PreparedStatement ps = connection.prepareStatement(preparedQuery);) {
            ps.setInt(1, patient.getPatientID());

            result = ps.executeUpdate();
        }

        return result;
    }

}
