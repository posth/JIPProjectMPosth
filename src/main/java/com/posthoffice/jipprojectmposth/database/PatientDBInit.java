package com.posthoffice.jipprojectmposth.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientDBInit {

    private static final String url = "jdbc:mysql://localhost:3306/PATIENTDB";
    private static final String user = "root";
    private static final String password = "Johnny23";

    /**
     * This class and its method is used to add test Patient data into the database
     * to ensure the program is running correctly.
     * @throws SQLException 
     */
    public static void initDB() throws SQLException {

        try (Connection connection = DriverManager.getConnection(url, user, password);
                Statement stmt = connection.createStatement();) {
            stmt.executeUpdate(dropPatientDB);
            stmt.executeUpdate(createPatientDB);
            stmt.executeUpdate(usePatientDB);

            stmt.executeUpdate(createPatientTable);
            stmt.executeUpdate(createInpatientTable);
            stmt.executeUpdate(createSurgicalTable);
            stmt.executeUpdate(createMedicationTable);

            stmt.executeUpdate(insertPatientData);
            stmt.executeUpdate(insertInpatientData);
            stmt.executeUpdate(insertSurgicalData);
            stmt.executeUpdate(insertMedicationData);

        }
    }

    static final String dropPatientDB = "DROP DATABASE PATIENTDB";
    static final String createPatientDB = "CREATE DATABASE PATIENTDB";
    static final String usePatientDB = "USE PATIENTDB";

    static final String createPatientTable = "CREATE TABLE PATIENT ("
            + "PATIENTID int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,"
            + "LASTNAME varchar(30) NOT NULL DEFAULT '',"
            + "FIRSTNAME varchar(30) NOT NULL DEFAULT '',"
            + "DIAGNOSIS varchar(60) NOT NULL DEFAULT '',"
            + "ADMISSIONDATE timestamp,"
            + "RELEASERATE timestamp"
            + ") ENGINE=InnoDB";

    static final String createInpatientTable = "CREATE TABLE INPATIENT ("
            + "ID int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,"
            + "PATIENTID int(11),"
            + "DATEOFSTAY timestamp,"
            + "ROOMNUMBER varchar(5) NOT NULL DEFAULT '',"
            + "DAILYRATE decimal(10,2),"
            + "SUPPLIES decimal(10,2),"
            + "SERVICES decimal(10,2),"
            + "KEY PATIENTID (PATIENTID),"
            + "CONSTRAINT patient_1 FOREIGN KEY (PATIENTID) REFERENCES PATIENT (PATIENTID)"
            + ") ENGINE=InnoDB";

    static final String createSurgicalTable = "CREATE TABLE SURGICAL ("
            + "ID int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,"
            + "PATIENTID int(11),"
            + "DATEOFSURGERY timestamp,"
            + "SURGERY varchar(25) NOT NULL DEFAULT '',"
            + "ROOMFEE decimal(10,2),"
            + "SURGEONFEE decimal(10,2),"
            + "SUPPLIES decimal(10,2),"
            + "KEY PATIENTID (PATIENTID),"
            + "CONSTRAINT patient_2 FOREIGN KEY (PATIENTID) REFERENCES PATIENT (PATIENTID)"
            + ") ENGINE=InnoDB";

    static final String createMedicationTable = "CREATE TABLE MEDICATION ("
            + "ID int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,"
            + "PATIENTID int(11),"
            + "DATEOFMED timestamp,"
            + "MED varchar(45) NOT NULL DEFAULT '',"
            + "UNITCOST decimal(10,2),"
            + "UNITS decimal(10,2) ,"
            + "KEY PATIENTID (PATIENTID),"
            + "CONSTRAINT patient_3 FOREIGN KEY (PATIENTID) REFERENCES PATIENT (PATIENTID)"
            + ") ENGINE=InnoDB";

    static final String insertPatientData = "INSERT INTO PATIENT (LASTNAME, FIRSTNAME, DIAGNOSIS, ADMISSIONDATE, RELEASERATE) values "
            + "(\"Wayne\",\"Bruce\",\"Asthma\",\"2014-01-23 9:00:00\",\"2014-01-25 13:00:00\"),"
            + "(\"Allen\",\"Barry\",\"Kidney Stones\",\"2014-02-18 9:00:00\",\"2014-02-21 13:00:00\"),"
            + "(\"Kent\",\"Clark\",\"Tonsilitis\",\"2014-05-02 9:00:00\",\"2014-05-07 13:00:00\"),"
            + "(\"Stark\",\"Tony\",\"Appendicitis\",\"2014-07-14 9:00:00\",\"2014-07-15 13:00:00\"),"
            + "(\"Banner\",\"Bruce\",\"Gall Bladder Disease\",\"2014-11-09 9:00:00\",\"2014-11-12 13:00:00\")";

    static final String insertInpatientData = "INSERT INTO INPATIENT(PATIENTID,DATEOFSTAY,ROOMNUMBER,DAILYRATE,SUPPLIES,SERVICES) values "
            + "(1, \"2014-01-23 9:00:00\",\"A1\",\"250.00\",\"75.24\",\"12.95\"),"
            + "(1, \"2014-01-24 9:00:00\",\"A1\",\"250.00\",\"90.15\",\"58.12\"),"
            + "(1, \"2014-01-25 9:00:00\",\"A1\",\"250.00\",\"120.23\",\"87.05\"),"
            + "(2, \"2014-02-18 9:00:00\",\"B2\",\"150.00\",\"120.23\",\"87.05\"),"
            + "(2, \"2014-02-19 9:00:00\",\"B2\",\"150.00\",\"120.23\",\"87.05\"),"
            + "(2, \"2014-02-20 9:00:00\",\"B2\",\"150.00\",\"120.23\",\"87.05\"),"
            + "(2, \"2014-02-21 9:00:00\",\"B2\",\"150.00\",\"120.23\",\"87.05\"),"
            + "(3, \"2014-05-02 9:00:00\",\"C3\",\"150.00\",\"120.23\",\"87.05\"),"
            + "(3, \"2014-05-03 9:00:00\",\"C3\",\"150.00\",\"120.23\",\"87.05\"),"
            + "(3, \"2014-05-04 9:00:00\",\"C3\",\"150.00\",\"120.23\",\"87.05\"),"
            + "(3, \"2014-05-05 9:00:00\",\"C3\",\"150.00\",\"120.23\",\"87.05\"),"
            + "(3, \"2014-05-06 9:00:00\",\"C3\",\"150.00\",\"120.23\",\"87.05\"),"
            + "(3, \"2014-05-07 9:00:00\",\"C3\",\"150.00\",\"120.23\",\"87.05\"),"
            + "(3, \"2014-05-07 9:00:00\",\"C3\",\"150.00\",\"120.23\",\"87.05\"),"
            + "(4, \"2014-07-14 9:00:00\",\"D4\",\"150.00\",\"120.23\",\"87.05\"),"
            + "(4, \"2014-07-15 9:00:00\",\"C4\",\"150.00\",\"120.23\",\"87.05\"),"
            + "(5, \"2014-11-09 9:00:00\",\"E5\",\"150.00\",\"120.23\",\"87.05\"),"
            + "(5, \"2014-11-10 9:00:00\",\"E5\",\"150.00\",\"120.23\",\"87.05\"),"
            + "(5, \"2014-11-11 9:00:00\",\"E5\",\"150.00\",\"120.23\",\"87.05\"),"
            + "(5, \"2014-11-12 9:00:00\",\"E5\",\"150.00\",\"120.23\",\"87.05\")";

    static final String insertSurgicalData = "INSERT INTO SURGICAL(PATIENTID,DATEOFSURGERY,SURGERY,ROOMFEE,SURGEONFEE,SUPPLIES) values "
            + "(1, \"2014-01-24 11:00:00\",\"Lung Transplant\", 2500.12, 4200.00, 934.23),"
            + "(2, \"2014-02-19 07:00:00\",\"Kidney Transplant\", 2500.12, 4200.00, 934.23),"
            + "(3, \"2014-05-03 21:00:00\",\"Tonsil Transplant\", 2500.12, 4200.00, 934.23),"
            + "(4, \"2014-07-14 14:00:00\",\"Appendix Transplant\", 2500.12, 4200.00, 934.23),"
            + "(5, \"2014-11-11 10:00:00\",\"Gall Bladder Transplant\", 2500.12, 4200.00, 934.23)";

    static final String insertMedicationData = "INSERT INTO MEDICATION(PATIENTID,DATEOFMED,MED,UNITCOST,UNITS) values "
            + "(1, \"2014-01-24 11:00:00\", \"Snickers\", 1.25, 5.0),"
            + "(2, \"2014-02-19 07:00:00\", \"M and M\", 1.10, 15.0),"
            + "(3, \"2014-05-03 21:00:00\", \"O Henry\", 2.49, 11.0),"
            + "(4, \"2014-07-14 14:00:00\", \"Caramilk\", 4.23, 3.0),"
            + "(5, \"2014-11-11 10:00:00\", \"Aero Bar\", 9.43, 19.0)";

}
