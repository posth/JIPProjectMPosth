package com.posthoffice.jipprojectmposth.database;

import com.posthoffice.jipprojectmposth.beans.PatientBean;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PatientDAO {

    public ArrayList<PatientBean> readPatient(int patientID) throws SQLException;

    public int createPatient(Connection connection, PatientBean patient, int theRows) throws SQLException;

    public int deletePatient(int selectedRow) throws SQLException;

    public int  updatePatient(Connection connection, PatientBean patient) throws SQLException;

}
