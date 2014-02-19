package com.posthoffice.jipprojectmposth;

import com.posthoffice.jipprojectmposth.database.InpatientDBManagement;
import com.posthoffice.jipprojectmposth.beans.InpatientBean;
import com.posthoffice.jipprojectmposth.database.PatientDBInit;
import java.math.BigDecimal;

import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class InpatientDBManagementTest {

    private final InpatientDBManagement InpatientDBManagement = new InpatientDBManagement();
    private final InpatientBean inpatient = new InpatientBean();

    private PatientDBInit patientDBInit;

    @Before
    public void initDB() throws SQLException {
        PatientDBInit.initDB();
    }

    @Test
    public void readInpatientTest() throws SQLException {

        inpatient.setPatientID(1);

        ArrayList<InpatientBean> inpatientList = InpatientDBManagement.readInpatient(inpatient);
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

        ArrayList<InpatientBean> inpatientList = InpatientDBManagement.readInpatient(inpatient);

        assertEquals(inpatientList.size(), 0);

    }

    @Test
    public void updateInpatientData() throws SQLException {

        inpatient.setPatientID(1);
        
        InpatientDBManagement.readInpatient(inpatient);
        
        inpatient.setDateOfStay();
        inpatient.setRoomNumber();
        inpatient.setDailyRate();
        inpatient.setRoomSupplies();
        inpatient.setRoomServices();

    }
}
