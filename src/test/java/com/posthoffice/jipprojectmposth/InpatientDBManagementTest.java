package com.posthoffice.jipprojectmposth;

import com.posthoffice.jipprojectmposth.database.InpatientDBManagement;
import com.posthoffice.jipprojectmposth.beans.InpatientBean;
import com.posthoffice.jipprojectmposth.database.PatientDBInit;

import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class InpatientDBManagementTest {

    private final InpatientDBManagement InpatientDBManagement = new InpatientDBManagement();
    private final InpatientBean inpatient = new InpatientBean();

    @Before
    public void initDB() throws SQLException {
        PatientDBInit.initDB();
    }

    @Test
    public void readInpatientTest() throws SQLException {

        int patientID = 1;

        ArrayList<InpatientBean> inpatientList = InpatientDBManagement.readInpatient(patientID);
        assertEquals(inpatientList.size(), 3);

    }

    @Test
    public void createInpatientTest() throws SQLException {

        int test = InpatientDBManagement.createInpatient(inpatient);
        assertEquals(test, 1);

    }

    @Test
    public void deleteInpatientTest() throws SQLException {

        inpatient.setPatientID(1);

        InpatientDBManagement.deleteInpatient(inpatient);

        int patientID = inpatient.getPatientID();

        ArrayList<InpatientBean> inpatientList = InpatientDBManagement.readInpatient(patientID);

        assertEquals(inpatientList.size(), 0);

    }

    @Test
    public void updateInpatientTest() throws SQLException {

        int patientID = 1;

        ArrayList<InpatientBean> inpatientList = InpatientDBManagement.readInpatient(patientID);
        InpatientBean testBean = inpatientList.get(0);

        testBean.setRoomNumber("A2");

        InpatientDBManagement.updateInpatient(testBean);

        ArrayList<InpatientBean> inpatientList2 = InpatientDBManagement.readInpatient(patientID);
        InpatientBean updatedTestBean = inpatientList2.get(0);

        assertEquals(testBean, updatedTestBean);

    }
}
