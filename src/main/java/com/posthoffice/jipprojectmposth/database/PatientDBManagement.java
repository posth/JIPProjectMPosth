package com.posthoffice.jipprojectmposth.database;

import com.posthoffice.jipprojectmposth.beans.InpatientBean;
import com.posthoffice.jipprojectmposth.beans.MedicationBean;
import com.posthoffice.jipprojectmposth.beans.PatientBean;
import com.posthoffice.jipprojectmposth.beans.SurgicalBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PatientDBManagement implements PatientDAO {

    private static final String url = "jdbc:mysql://localhost:3306/PATIENTDB";
    private static final String user = "root";
    private static final String password = "Johnny23";

    final Logger logger = LoggerFactory.getLogger(PatientDBManagement.class);

    public PatientDBManagement() {
        super();
    }

    //works
    @Override
    public int createPatient(PatientBean patient) throws SQLException {

        int result;

        String preparedQuery = "INSERT INTO PATIENT(LASTNAME, FIRSTNAME, DIAGNOSIS, ADMISSIONDATE, RELEASERATE) VALUES (?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url, user,
                password); PreparedStatement ps = connection.prepareStatement(preparedQuery);) {
            ps.setString(1, patient.getLastName());
            ps.setString(2, patient.getFirstName());
            ps.setString(3, patient.getDiagnosis());
            ps.setTimestamp(4, patient.getAdmissionDate());
            ps.setTimestamp(5, patient.getReleaseDate());

            result = ps.executeUpdate();
        }
        return result;
    }

    @Override
    public ArrayList<PatientBean> readPatient(int patientID) throws SQLException {

        String preparedQuery = "SELECT * FROM PATIENT WHERE PATIENTID = ?";

        ArrayList<PatientBean> patientList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user,
                password);
                PreparedStatement pStatement = connection.prepareStatement(preparedQuery);) {

            pStatement.setInt(1, patientID);
            try (ResultSet resultSet = pStatement.executeQuery()) {

                while (resultSet.next()) {

                    PatientBean temp = new PatientBean();

                    InpatientDBManagement inpatient = new InpatientDBManagement();
                    MedicationDBManagement medication = new MedicationDBManagement();
                    SurgicalDBManagement surgical = new SurgicalDBManagement();

                    temp.setPatientID(resultSet.getInt("PATIENTID"));
                    temp.setLastName(resultSet.getString("LASTNAME"));
                    temp.setFirstName(resultSet.getString("FIRSTNAME"));
                    temp.setDiagnosis(resultSet.getString("DIAGNOSIS"));
                    temp.setAdmissionDate(resultSet.getTimestamp("ADMISSIONDATE"));
                    temp.setReleaseDate(resultSet.getTimestamp("RELEASERATE"));

                    temp.setInpatientList(inpatient.readInpatient(patientID));
                    temp.setMedicationList(medication.readMedication(patientID));
                    temp.setSurgicalList(surgical.readSurgical(patientID));

                    patientList.add(temp);
                }
            }
        }

        return patientList;

    }

    @Override
    public int updatePatient(PatientBean patient) throws SQLException {

        int result;

        String preparedQuery = "UPDATE PATIENT SET LASTNAME = ?, FIRSTNAME = ?, DIAGNOSIS = ?, ADMISSIONDATE = ?, RELEASERATE = ? WHERE PATIENTID = ?";

        try (Connection connection = DriverManager.getConnection(url, user,
                password); PreparedStatement ps = connection.prepareStatement(preparedQuery);) {

            ps.setString(1, patient.getLastName());
            ps.setString(2, patient.getFirstName());
            ps.setString(3, patient.getDiagnosis());
            ps.setTimestamp(4, patient.getAdmissionDate());
            ps.setTimestamp(5, patient.getReleaseDate());
            ps.setInt(6, patient.getPatientID());

            result = ps.executeUpdate();
        }

        return result;
    }

    @Override
    public int deletePatient(PatientBean patient) throws SQLException {

        int result;

        String preparedQuery = "DELETE FROM PATIENT WHERE PATIENTID = ?";

        try (Connection connection = DriverManager.getConnection(url, user,
                password); PreparedStatement ps = connection.prepareStatement(preparedQuery);) {
            ps.setInt(1, patient.getPatientID());

            int patientID = patient.getPatientID();

            InpatientDBManagement inpatient = new InpatientDBManagement();
            MedicationDBManagement medication = new MedicationDBManagement();
            SurgicalDBManagement surgical = new SurgicalDBManagement();

            ArrayList<InpatientBean> inpatientList = inpatient.readInpatient(patientID);
            ArrayList<MedicationBean> medicationList = medication.readMedication(patientID);
            ArrayList<SurgicalBean> surgicalList = surgical.readSurgical(patientID);

            //delete each inpatient bean the deleted patient has
            int inpatientListLength = inpatientList.size();
            for (int i = 0; i < inpatientListLength; i++) {
                InpatientBean temp = inpatientList.get(i);
                inpatient.deleteInpatient(temp);
            }

            //delete each medication bean the deleted patient has
            int medicationListLength = medicationList.size();
            for (int i = 0; i < medicationListLength; i++) {
                MedicationBean temp = medicationList.get(i);
                medication.deleteMedication(temp);
            }

            //delete each surgical bean the deleted patient has
            int surgicalListLength = surgicalList.size();
            for (int i = 0; i < surgicalListLength; i++) {
                SurgicalBean temp = surgicalList.get(i);
                surgical.deleteSurgical(temp);
            }

            result = ps.executeUpdate();
        }

        return result;
    }

}
