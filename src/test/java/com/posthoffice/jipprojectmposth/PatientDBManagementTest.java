package com.posthoffice.jipprojectmposth;

import com.posthoffice.jipprojectmposth.beans.InpatientBean;
import com.posthoffice.jipprojectmposth.beans.PatientBean;
import com.posthoffice.jipprojectmposth.database.PatientDBInit;
import com.posthoffice.jipprojectmposth.database.PatientDBManagement;

import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class PatientDBManagementTest {

    private final PatientDBManagement PatientDBManagement = new PatientDBManagement();
    private final PatientBean patient = new PatientBean();

    @Before
    public void initDB() throws SQLException {
        PatientDBInit.initDB();
    }

    @Test
    public void readPatientTest() throws SQLException {

        ArrayList<PatientBean> patientList = PatientDBManagement.readPatient();
        assertEquals(patientList.size(), 5);

    }

    @Test
    public void createPatientTest() throws SQLException {

        int test = PatientDBManagement.createPatient(patient);
        assertEquals(test, 1);

    }

    @Test
    public void deletePatientTest() throws SQLException {

        int patientID = 1;
        patient.setPatientID(patientID);

        PatientDBManagement.deletePatient(patient);

        ArrayList<PatientBean> patientList = PatientDBManagement.readPatient();

        assertEquals(patientList.size(), 4);

    }

    @Test
    public void updatePatientTest() throws SQLException {

        ArrayList<PatientBean> patientList = PatientDBManagement.readPatient();
        
        PatientBean testBean = patientList.get(0);
        testBean.setDiagnosis("Kryptonite");

        PatientDBManagement.updatePatient(testBean);

        ArrayList<PatientBean> patientList2 = PatientDBManagement.readPatient();
        PatientBean updatedTestBean = patientList2.get(0);

        assertEquals(testBean, updatedTestBean);

    }

}
