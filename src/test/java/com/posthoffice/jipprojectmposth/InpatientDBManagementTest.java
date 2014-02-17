package com.posthoffice.jipprojectmposth;

import com.posthoffice.jipprojectmposth.database.InpatientDBManagement;
import com.posthoffice.jipprojectmposth.beans.InpatientBean;
import com.posthoffice.jipprojectmposth.database.PatientDBInit;

import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class InpatientDBManagementTest{

    private final InpatientDBManagement InpatientDBManagement = new InpatientDBManagement();
    private final InpatientBean inpatient = new InpatientBean();
    
    private PatientDBInit patientDBInit;
    
    @Before
    public void initDB() throws SQLException {
        patientDBInit = new PatientDBInit();
        patientDBInit.initDB();
    }

    @Test
    public void selectInpatientData() throws SQLException {

        ArrayList<InpatientBean> inpatientList = InpatientDBManagement.read(1);
        assertEquals(inpatientList.size(), 3);

    }

    @Test
    public void insertInpatientData() throws SQLException {

        int test = InpatientDBManagement.create(inpatient);
        assertEquals(test, 1);

    }

}
