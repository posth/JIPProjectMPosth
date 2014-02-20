package com.posthoffice.jipprojectmposth;

import com.posthoffice.jipprojectmposth.beans.SurgicalBean;
import com.posthoffice.jipprojectmposth.database.PatientDBInit;
import com.posthoffice.jipprojectmposth.database.SurgicalDBManagement;

import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SurgicalDBManagementTest {

    private final SurgicalDBManagement SurgicalDBManagement = new SurgicalDBManagement();
    private final SurgicalBean surgical = new SurgicalBean();

    @Before
    public void initDB() throws SQLException {
        PatientDBInit.initDB();
    }

    @Test
    public void readSurgicalTest() throws SQLException {

        int patientID = 1;

        ArrayList<SurgicalBean> surgicalList = SurgicalDBManagement.readSurgical(patientID);
        assertEquals(surgicalList.size(), 1);

    }

    @Test
    public void createSurgicalTest() throws SQLException {

        surgical.setPatientID(1);

        int test = SurgicalDBManagement.createSurgical(surgical);
        assertEquals(test, 1);

    }

    @Test
    public void deleteSurgicalTest() throws SQLException {

        surgical.setPatientID(1);

        SurgicalDBManagement.deleteSurgical(surgical);

        int patientID = surgical.getPatientID();

        ArrayList<SurgicalBean> surgicalList = SurgicalDBManagement.readSurgical(patientID);

        assertEquals(surgicalList.size(), 0);

    }

    @Test
    public void updateSurgicalTest() throws SQLException {

        int patientID = 1;

        ArrayList<SurgicalBean> surgicalList = SurgicalDBManagement.readSurgical(patientID);
        SurgicalBean testBean = surgicalList.get(0);

        testBean.setSurgery("Nose Reconstruction");

        SurgicalDBManagement.updateSurgical(testBean);

        ArrayList<SurgicalBean> surgicalList2 = SurgicalDBManagement.readSurgical(patientID);
        SurgicalBean updatedTestBean = surgicalList2.get(0);

        assertEquals(testBean, updatedTestBean);

    }

}
