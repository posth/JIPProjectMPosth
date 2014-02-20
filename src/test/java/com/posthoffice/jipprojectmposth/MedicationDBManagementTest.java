
package com.posthoffice.jipprojectmposth;

import com.posthoffice.jipprojectmposth.beans.MedicationBean;
import com.posthoffice.jipprojectmposth.database.MedicationDBManagement;
import com.posthoffice.jipprojectmposth.database.PatientDBInit;

import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class MedicationDBManagementTest {
    
    private final MedicationDBManagement MedicationDBManagement = new MedicationDBManagement();
    private final MedicationBean medication = new MedicationBean();

    @Before
    public void initDB() throws SQLException {
        PatientDBInit.initDB();
    }

    @Test
    public void readMedicationTest() throws SQLException {

        int patientID = 1;

        ArrayList<MedicationBean> medicationList = MedicationDBManagement.readMedication(patientID);
        assertEquals(medicationList.size(), 1);

    }

    @Test
    public void createMedicationTest() throws SQLException {
        
        medication.setPatientID(1);

        int test = MedicationDBManagement.createMedication(medication);
        assertEquals(test, 1);

    }

    @Test
    public void deleteMedicationTest() throws SQLException {

        medication.setPatientID(1);

        MedicationDBManagement.deleteMedication(medication);

        int patientID = medication.getPatientID();

        ArrayList<MedicationBean> medicationList = MedicationDBManagement.readMedication(patientID);

        assertEquals(medicationList.size(), 0);

    }

    @Test
    public void updateMedicationTest() throws SQLException {

        int patientID = 1;

        ArrayList<MedicationBean> medicationList = MedicationDBManagement.readMedication(patientID);
        MedicationBean testBean = medicationList.get(0);

        testBean.setMedication("Rib-Eye Steak");

        MedicationDBManagement.updateMedication(testBean);

        ArrayList<MedicationBean> medicationList2 = MedicationDBManagement.readMedication(patientID);
        MedicationBean updatedTestBean = medicationList2.get(0);

        assertEquals(testBean, updatedTestBean);

    }
    
}
