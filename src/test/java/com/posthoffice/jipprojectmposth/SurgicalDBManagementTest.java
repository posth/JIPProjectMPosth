package com.posthoffice.jipprojectmposth;

import com.posthoffice.jipprojectmposth.beans.LiveDataBean;
import com.posthoffice.jipprojectmposth.beans.SurgicalBean;
import com.posthoffice.jipprojectmposth.database.PatientDBInit;
import com.posthoffice.jipprojectmposth.database.SurgicalDBManagement;
import com.posthoffice.jipprojectmposth.model.SurgicalDBTableModel;
import com.posthoffice.jipprojectmposth.properties.DBConnectionBean;
import com.posthoffice.jipprojectmposth.properties.PropertiesManager;
import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SurgicalDBManagementTest {

    private SurgicalDBManagement surgicalDBManager;
    private SurgicalDBTableModel surgicalModel;
    private LiveDataBean liveDataBean;
    private DBConnectionBean dbConnectionBean;

    @Before
    public void initDB() throws SQLException, IOException {
        
        surgicalModel = new SurgicalDBTableModel();
        
        PropertiesManager prop = new PropertiesManager();
        
        dbConnectionBean = prop.loadProperties();
        
        liveDataBean = new LiveDataBean();

        liveDataBean.setURL(dbConnectionBean.getUrl());
        liveDataBean.setUSER(dbConnectionBean.getUser());
        liveDataBean.setPASSWORD(dbConnectionBean.getPassword());  
        
        surgicalDBManager = new SurgicalDBManagement(surgicalModel, liveDataBean);
        
        PatientDBInit.initDB();
    }

    @Test
    public void readSurgicalTest() throws SQLException {

        int patientID = 1;

        ArrayList<SurgicalBean> surgicalList = surgicalDBManager.readSurgical(patientID);
        assertEquals(surgicalList.size(), 1);

    }

    @Test
    public void createSurgicalTest() throws SQLException {
        
        SurgicalBean surgical = new SurgicalBean();

        surgical.setPatientID(1);

        int test = surgicalDBManager.createSurgical(surgical);
        assertEquals(test, 1);

    }

    @Test
    public void deleteSurgicalTest() throws SQLException {
        
        SurgicalBean surgical = new SurgicalBean();

        surgical.setPatientID(1);
        surgical.setiD(1);

        surgicalDBManager.deleteSurgical(surgical);

        int patientID = surgical.getPatientID();

        ArrayList<SurgicalBean> surgicalList = surgicalDBManager.readSurgical(patientID);

        assertEquals(surgicalList.size(), 0);

    }

    @Test
    public void updateSurgicalTest() throws SQLException {

        int patientID = 1;

        ArrayList<SurgicalBean> surgicalList = surgicalDBManager.readSurgical(patientID);
        SurgicalBean testBean = surgicalList.get(0);

        testBean.setSurgery("Nose Reconstruction");

        surgicalDBManager.updateSurgical(testBean);

        ArrayList<SurgicalBean> surgicalList2 = surgicalDBManager.readSurgical(patientID);
        SurgicalBean updatedTestBean = surgicalList2.get(0);

        assertEquals(testBean, updatedTestBean);

    }

}
