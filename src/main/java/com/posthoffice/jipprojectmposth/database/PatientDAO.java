package com.posthoffice.jipprojectmposth.database;

import com.posthoffice.jipprojectmposth.beans.PatientBean;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PatientDAO {

    public ArrayList<PatientBean> readPatient(String sql) throws SQLException;

    public int createPatient(PatientBean patientBean) throws SQLException;

    public int deletePatient(PatientBean patientBean) throws SQLException;

    public void  updatePatient(PatientBean patientBean) throws SQLException;

}
