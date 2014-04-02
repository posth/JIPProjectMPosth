package com.posthoffice.jipprojectmposth;

import com.posthoffice.jipprojectmposth.beans.LiveDataBean;
import com.posthoffice.jipprojectmposth.beans.PatientBean;
import com.posthoffice.jipprojectmposth.database.InpatientDBManagement;
import com.posthoffice.jipprojectmposth.database.MedicationDBManagement;
import com.posthoffice.jipprojectmposth.database.PatientDBInit;
import com.posthoffice.jipprojectmposth.database.PatientDBManagement;
import com.posthoffice.jipprojectmposth.database.SurgicalDBManagement;
import com.posthoffice.jipprojectmposth.model.PatientDBTableModel;
import com.posthoffice.jipprojectmposth.properties.DBConnectionBean;
import com.posthoffice.jipprojectmposth.properties.PropertiesManager;
import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class PatientDBManagementTest {

    private PatientDBManagement patientDBManagement;
    private PatientBean patient = new PatientBean();
    private DBConnectionBean dbConnectionBean = new DBConnectionBean();
    private LiveDataBean liveDataBean = new LiveDataBean();
    
    private PatientDBTableModel patientModel = new PatientDBTableModel();
    private InpatientDBManagement inpatientDB = new InpatientDBManagement();
    private MedicationDBManagement medicationDB = new MedicationDBManagement();
    private SurgicalDBManagement surgicalDB = new SurgicalDBManagement();

    @Before
    public void initDB() throws SQLException {
        PatientDBInit.initDB();
    }

    @Test
    public void readPatientTest() throws SQLException, IOException {

        PropertiesManager prop = new PropertiesManager();
        this.dbConnectionBean = prop.loadProperties();

        liveDataBean.setURL(dbConnectionBean.getUrl());
        liveDataBean.setUSER(dbConnectionBean.getUser());
        liveDataBean.setPASSWORD(dbConnectionBean.getPassword());


        patientDBManagement = new PatientDBManagement(patientModel, inpatientDB, medicationDB, surgicalDB, liveDataBean);

        ArrayList<PatientBean> patientList = patientDBManagement.readPatient();
        assertEquals(patientList.size(), 5);

    }
//    @Test
//    public void createPatientTest() throws SQLException {
//
//        int test = PatientDBManagement.createPatient(patient);
//        assertEquals(test, 1);
//
//    }
//
//    @Test
//    public void deletePatientTest() throws SQLException {
//
//        int patientID = 1;
//        patient.setPatientID(patientID);
//
//        PatientDBManagement.deletePatient(patient);
//
//        ArrayList<PatientBean> patientList = PatientDBManagement.readPatient();
//
//        assertEquals(patientList.size(), 4);
//
//    }
//
//    @Test
//    public void updatePatientTest() throws SQLException {
//
//        ArrayList<PatientBean> patientList = PatientDBManagement.readPatient();
//        
//        PatientBean testBean = patientList.get(0);
//        testBean.setDiagnosis("Kryptonite");
//
//        PatientDBManagement.updatePatient(testBean);
//
//        ArrayList<PatientBean> patientList2 = PatientDBManagement.readPatient();
//        PatientBean updatedTestBean = patientList2.get(0);
//
//        assertEquals(testBean, updatedTestBean);
//
//    }
}
