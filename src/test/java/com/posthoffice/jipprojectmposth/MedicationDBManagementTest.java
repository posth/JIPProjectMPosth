
package com.posthoffice.jipprojectmposth;

import com.posthoffice.jipprojectmposth.beans.LiveDataBean;
import com.posthoffice.jipprojectmposth.beans.MedicationBean;
import com.posthoffice.jipprojectmposth.database.MedicationDBManagement;
import com.posthoffice.jipprojectmposth.database.PatientDBInit;
import com.posthoffice.jipprojectmposth.model.MedicationDBTableModel;
import com.posthoffice.jipprojectmposth.properties.DBConnectionBean;
import com.posthoffice.jipprojectmposth.properties.PropertiesManager;
import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class MedicationDBManagementTest {
    
    private MedicationDBManagement medicationDBManager;
    private MedicationDBTableModel medicationModel;
    private LiveDataBean liveDataBean;
    private DBConnectionBean dbConnectionBean;

    @Before
    public void initDB() throws SQLException, IOException {
        
        medicationModel = new MedicationDBTableModel();
        
        PropertiesManager prop = new PropertiesManager();
        
        dbConnectionBean = prop.loadProperties();
        
        liveDataBean = new LiveDataBean();

        liveDataBean.setURL(dbConnectionBean.getUrl());
        liveDataBean.setUSER(dbConnectionBean.getUser());
        liveDataBean.setPASSWORD(dbConnectionBean.getPassword());
        
        medicationDBManager = new MedicationDBManagement(medicationModel, liveDataBean);
        
        PatientDBInit.initDB();
    }

    @Test
    public void readMedicationTest() throws SQLException {

        int patientID = 1;

        ArrayList<MedicationBean> medicationList = medicationDBManager.readMedication(patientID);
        assertEquals(medicationList.size(), 1);

    }

    @Test
    public void createMedicationTest() throws SQLException {
        
        MedicationBean medication = new MedicationBean();
        
        medication.setPatientID(1);
        medication.setiD(1);

        int test = medicationDBManager.createMedication(medication);
        assertEquals(test, 1);

    }

    @Test
    public void deleteMedicationTest() throws SQLException {
        
        MedicationBean medication = new MedicationBean();

        medication.setPatientID(1);
        medication.setiD(1);

        medicationDBManager.deleteMedication(medication);

        int patientID = medication.getPatientID();

        ArrayList<MedicationBean> medicationList = medicationDBManager.readMedication(patientID);

        assertEquals(medicationList.size(), 0);

    }

    @Test
    public void updateMedicationTest() throws SQLException {

        int patientID = 1;

        ArrayList<MedicationBean> medicationList = medicationDBManager.readMedication(patientID);
        MedicationBean testBean = medicationList.get(0);

        testBean.setMedication("Rib-Eye Steak");

        medicationDBManager.updateMedication(testBean);

        ArrayList<MedicationBean> medicationList2 = medicationDBManager.readMedication(patientID);
        MedicationBean updatedTestBean = medicationList2.get(0);

        assertEquals(testBean, updatedTestBean);

    }
    
}
