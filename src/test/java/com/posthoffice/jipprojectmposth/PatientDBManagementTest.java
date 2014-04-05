package com.posthoffice.jipprojectmposth;

import com.posthoffice.jipprojectmposth.beans.LiveDataBean;
import com.posthoffice.jipprojectmposth.beans.PatientBean;
import com.posthoffice.jipprojectmposth.database.InpatientDBManagement;
import com.posthoffice.jipprojectmposth.database.MedicationDBManagement;
import com.posthoffice.jipprojectmposth.database.PatientDBInit;
import com.posthoffice.jipprojectmposth.database.PatientDBManagement;
import com.posthoffice.jipprojectmposth.database.SurgicalDBManagement;
import com.posthoffice.jipprojectmposth.model.InpatientDBTableModel;
import com.posthoffice.jipprojectmposth.model.MedicationDBTableModel;
import com.posthoffice.jipprojectmposth.model.PatientDBTableModel;
import com.posthoffice.jipprojectmposth.model.SurgicalDBTableModel;
import com.posthoffice.jipprojectmposth.properties.DBConnectionBean;
import com.posthoffice.jipprojectmposth.properties.PropertiesManager;
import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class PatientDBManagementTest {

    private DBConnectionBean dbConnectionBean;
    private LiveDataBean liveDataBean;
    private PatientDBTableModel patientModel;
    private InpatientDBTableModel inpatientModel;
    private MedicationDBTableModel medicationModel;
    private SurgicalDBTableModel surgicalModel;
    private InpatientDBManagement inpatientDBManager;
    private MedicationDBManagement medicationDBManager;
    private SurgicalDBManagement surgicalDBManager;
    private PatientDBManagement patientDBManager;

    @Before
    public void initProperties() throws IOException, SQLException {

        inpatientModel = new InpatientDBTableModel();
        medicationModel = new MedicationDBTableModel();
        surgicalModel = new SurgicalDBTableModel();
        patientModel = new PatientDBTableModel(inpatientModel, medicationModel, surgicalModel);

        PropertiesManager prop = new PropertiesManager();

        dbConnectionBean = prop.loadProperties();

        liveDataBean = new LiveDataBean();

        liveDataBean.setURL(dbConnectionBean.getUrl());
        liveDataBean.setUSER(dbConnectionBean.getUser());
        liveDataBean.setPASSWORD(dbConnectionBean.getPassword());

        inpatientDBManager = new InpatientDBManagement(inpatientModel, liveDataBean);
        medicationDBManager = new MedicationDBManagement(medicationModel, liveDataBean);
        surgicalDBManager = new SurgicalDBManagement(surgicalModel, liveDataBean);
        patientDBManager = new PatientDBManagement(patientModel, inpatientDBManager, medicationDBManager, surgicalDBManager, liveDataBean);

        PatientDBInit.initDB();
    }

    @Test
    public void readPatientTest() throws SQLException, IOException {

        ArrayList<PatientBean> patientList = patientDBManager.readPatient();
        assertEquals(patientList.size(), 5);

    }

    @Test
    public void createPatientTest() throws SQLException {

        PatientBean patient = new PatientBean();

        patient.setPatientID(6);

        int test = patientDBManager.createPatient(patient);
        assertEquals(test, 1);

    }

    @Test
    public void deletePatientTest() throws SQLException {

        PatientBean patient = new PatientBean();

        patient.setPatientID(1);

        patientDBManager.deletePatient(patient);

        ArrayList<PatientBean> patientList = patientDBManager.readPatient();

        assertEquals(patientList.size(), 4);

    }

    @Test
    public void updatePatientTest() throws SQLException {

        ArrayList<PatientBean> patientList = patientDBManager.readPatient();

        PatientBean testBean = patientList.get(0);
        testBean.setDiagnosis("Kryptonite");

        patientDBManager.updatePatient(testBean);

        ArrayList<PatientBean> patientList2 = patientDBManager.readPatient();
        PatientBean updatedTestBean = patientList2.get(0);

        assertEquals(testBean, updatedTestBean);

    }
}
