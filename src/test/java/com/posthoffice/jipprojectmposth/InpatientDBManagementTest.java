package com.posthoffice.jipprojectmposth;

import com.posthoffice.jipprojectmposth.database.InpatientDBManagement;
import com.posthoffice.jipprojectmposth.beans.InpatientBean;
import com.posthoffice.jipprojectmposth.beans.LiveDataBean;
import com.posthoffice.jipprojectmposth.database.PatientDBInit;
import com.posthoffice.jipprojectmposth.model.InpatientDBTableModel;
import com.posthoffice.jipprojectmposth.properties.DBConnectionBean;
import com.posthoffice.jipprojectmposth.properties.PropertiesManager;
import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class InpatientDBManagementTest {

    private InpatientDBManagement inpatientDBManager;
    private InpatientDBTableModel inpatientModel;
    private LiveDataBean liveDataBean;
    private DBConnectionBean dbConnectionBean;

    @Before
    public void initDB() throws SQLException, IOException {

        inpatientModel = new InpatientDBTableModel();

        PropertiesManager prop = new PropertiesManager();

        dbConnectionBean = prop.loadProperties();

        liveDataBean = new LiveDataBean();

        liveDataBean.setURL(dbConnectionBean.getUrl());
        liveDataBean.setUSER(dbConnectionBean.getUser());
        liveDataBean.setPASSWORD(dbConnectionBean.getPassword());
        
        inpatientDBManager = new InpatientDBManagement(inpatientModel, liveDataBean);       

        PatientDBInit.initDB();
    }

    @Test
    public void readInpatientTest() throws SQLException {

        int patientID = 1;

        ArrayList<InpatientBean> inpatientList = inpatientDBManager.readInpatient(patientID);
        assertEquals(inpatientList.size(), 3);

    }

    @Test
    public void createInpatientTest() throws SQLException {
        
        InpatientBean inpatient = new InpatientBean();
        
        inpatient.setPatientID(1);

        int test = inpatientDBManager.createInpatient(inpatient);
        assertEquals(test, 1);

    }

    @Test
    public void deleteInpatientTest() throws SQLException {
        
        InpatientBean inpatient = new InpatientBean();

        inpatient.setPatientID(1);
        inpatient.setiD(1);

        inpatientDBManager.deleteInpatient(inpatient);

        int patientID = inpatient.getPatientID();

        ArrayList<InpatientBean> inpatientList = inpatientDBManager.readInpatient(patientID);

        assertEquals(inpatientList.size(), 2);

    }

    @Test
    public void updateInpatientTest() throws SQLException {

        int patientID = 1;

        ArrayList<InpatientBean> inpatientList = inpatientDBManager.readInpatient(patientID);
        InpatientBean testBean = inpatientList.get(0);

        testBean.setRoomNumber("A2");

        inpatientDBManager.updateInpatient(testBean);

        ArrayList<InpatientBean> inpatientList2 = inpatientDBManager.readInpatient(patientID);
        InpatientBean updatedTestBean = inpatientList2.get(0);

        assertEquals(testBean, updatedTestBean);

    }
}
