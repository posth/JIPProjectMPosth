
package com.posthoffice.jipprojectmposth.database;

import com.posthoffice.jipprojectmposth.beans.InpatientBean;
import com.posthoffice.jipprojectmposth.beans.MedicationBean;
import com.posthoffice.jipprojectmposth.beans.PatientBean;
import com.posthoffice.jipprojectmposth.beans.SurgicalBean;

import java.sql.SQLException;
import java.util.ArrayList;

/*
 * 
 * Any need for this interface?
 * 
 */

public interface PatientDAO {
    
    public ArrayList<PatientBean> readPatient(String sql) throws SQLException;
    public int create(PatientBean patientBean) throws SQLException;
    public int delete(PatientBean patientBean) throws SQLException;
    public int update(PatientBean patientBean) throws SQLException;
      
    public ArrayList<InpatientBean> readInpatient(int patientID) throws SQLException;
    public int create(InpatientBean inpatientBean) throws SQLException;
    public int delete(InpatientBean inpatientBean) throws SQLException;
    public int update(InpatientBean inpatientBean) throws SQLException;
    
    public ArrayList<MedicationBean> readMedication(String sql) throws SQLException;
    public int create(MedicationBean medicationBean) throws SQLException;
    public int delete(MedicationBean medicationBean) throws SQLException;
    public int update(MedicationBean medicationBean) throws SQLException;
       
    public ArrayList<SurgicalBean> read(String sql) throws SQLException;
    public int create(SurgicalBean surgicalBean) throws SQLException;
    public int delete(SurgicalBean surgicalBean) throws SQLException;
    public int update(SurgicalBean surgicalBean) throws SQLException;
}


