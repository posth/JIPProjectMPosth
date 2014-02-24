package com.posthoffice.jipprojectmposth.database;

import com.posthoffice.jipprojectmposth.beans.PatientBean;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PatientDAO {

    public ArrayList<PatientBean> readPatient(int patientID) throws SQLException;

    public int createPatient(PatientBean patientBean) throws SQLException;

    public int deletePatient(PatientBean patientBean) throws SQLException;

    public int  updatePatient(PatientBean patientBean) throws SQLException;

}
