package com.posthoffice.jipprojectmposth.database;

import com.posthoffice.jipprojectmposth.beans.LiveDataBean;
import com.posthoffice.jipprojectmposth.beans.SurgicalBean;
import com.posthoffice.jipprojectmposth.model.SurgicalDBTableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Statement;

public class SurgicalDBManagement {

    private SurgicalDBTableModel surgicalDBTableModel = null;
    private final boolean DEBUG = false;
    final Logger logger = LoggerFactory.getLogger(SurgicalDBManagement.class);
    private LiveDataBean liveDataBean;
    private String URL;
    private String USER;
    private String PASSWORD;

    public SurgicalDBManagement() {
        super();

        this.liveDataBean = new LiveDataBean();

        this.URL = "";
        this.USER = "";
        this.PASSWORD = "";
    }

    public SurgicalDBManagement(SurgicalDBTableModel surgicalDBTableModel, LiveDataBean liveDataBean) {

        super();

        this.surgicalDBTableModel = surgicalDBTableModel;

        this.liveDataBean = liveDataBean;

        this.URL = liveDataBean.getURL();
        this.USER = liveDataBean.getUSER();
        this.PASSWORD = liveDataBean.getPASSWORD();
    }

    /**
     * Method is called when the Save button from the frame is called. Any
     * information changed in the Surgical table will be recorded.
     */
    public void updateDB() {

        SurgicalBean surgical;

        int result = 0;

        try (Connection connection = DriverManager.getConnection(URL, USER,
                PASSWORD);) {

            for (int theRows = 0; theRows < surgicalDBTableModel.getRowCount(); ++theRows) {
                if (surgicalDBTableModel.getUpdateStatus(theRows)) {
                    surgical = surgicalDBTableModel.getSurgicalData(theRows);
                    if (DEBUG) {
                        System.out.println("Updating row: " + theRows);
                    }
                    if (surgical.getiD() > 0) {
                        result = updateSurgical(surgical);
                    } else {
                        result = createSurgical(surgical);
                    }
                }
                if (DEBUG) {
                    if (result == 1) {
                        System.out.println("\nUpdate successful\n");
                    } else {
                        System.out.println("\nUpdate UNsuccessful\n");
                    }
                }

                surgicalDBTableModel.clearUpdate(theRows);
            }
        } catch (SQLException sqlex) {
            logger.error("Error updating database", sqlex);
        }

    }

    /**
     * Reading all the Surgical Data for one Patient based on the patientID
     * which is the Patient's primary key.
     *
     * @param patientID
     * @return
     * @throws SQLException
     */
    public ArrayList<SurgicalBean> readSurgical(int patientID) throws SQLException {

        String preparedQuery = "SELECT * FROM SURGICAL WHERE PATIENTID = ?";

        ArrayList<SurgicalBean> surgicalList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER,
                PASSWORD);
                PreparedStatement pStatement = connection.prepareStatement(preparedQuery);) {
            pStatement.setInt(1, patientID);
            try (ResultSet resultSet = pStatement.executeQuery()) {

                while (resultSet.next()) {

                    SurgicalBean temp = new SurgicalBean();

                    temp.setPatientID(resultSet.getInt("ID"));
                    temp.setiD(resultSet.getInt("PATIENTID"));
                    temp.setDateOfSurgery(resultSet.getTimestamp("DATEOFSURGERY"));
                    temp.setSurgery(resultSet.getString("SURGERY"));
                    temp.setRoomFee(resultSet.getBigDecimal("ROOMFEE"));
                    temp.setSurgeonsFee(resultSet.getBigDecimal("SURGEONFEE"));
                    temp.setSupplies(resultSet.getBigDecimal("SUPPLIES"));

                    surgicalList.add(temp);
                }
            }
        }
        return surgicalList;
    }

    /**
     * Creating new Surgical data by receiving a Surgical Bean. It is linked to
     * the Patient through the PATIENTID. However, the primary key for the
     * Surgical data is ID.
     *
     * @param surgical
     * @return
     * @throws SQLException
     */
    public int createSurgical(SurgicalBean surgical) throws SQLException {

        int result;

        String primaryKeySQL = "SELECT LAST_INSERT_ID()";

        String preparedQuery = "INSERT INTO SURGICAL(PATIENTID, DATEOFSURGERY, SURGERY, ROOMFEE, SURGEONFEE, SUPPLIES) VALUES (?,?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(URL, USER,
                PASSWORD); PreparedStatement ps = connection.prepareStatement(preparedQuery);) {

            ps.setInt(1, surgical.getPatientID());
            ps.setTimestamp(2, surgical.getDateOfSurgery());
            ps.setString(3, surgical.getSurgery());
            ps.setBigDecimal(4, surgical.getRoomFee());
            ps.setBigDecimal(5, surgical.getSurgeonsFee());
            ps.setBigDecimal(6, surgical.getSupplies());

            result = ps.executeUpdate();

            try (Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery(primaryKeySQL);) {
                if (rs.next()) {
                    long key = rs.getLong(1);
                    surgical.setiD((int) key);
                    //temporary fix of casting to int,
                }

                surgicalDBTableModel.addSurgicalBean(surgical);
            }
        }
        return result;
    }

    /**
     * Receives a Surgical Bean to add to the database.
     *
     * @param surgical
     * @return
     * @throws SQLException
     */
    public int updateSurgical(SurgicalBean surgical) throws SQLException {

        int result;

        String preparedQuery = "UPDATE SURGICAL SET DATEOFSURGERY = ?, SURGERY = ?, ROOMFEE = ?, SURGEONFEE = ?, SUPPLIES = ?, PATIENTID = ? WHERE ID = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER,
                PASSWORD); PreparedStatement ps = connection.prepareStatement(preparedQuery);) {

            ps.setTimestamp(1, surgical.getDateOfSurgery());
            ps.setString(2, surgical.getSurgery());
            ps.setBigDecimal(3, surgical.getRoomFee());
            ps.setBigDecimal(4, surgical.getSurgeonsFee());
            ps.setBigDecimal(5, surgical.getSupplies());
            ps.setInt(6, surgical.getPatientID());
            ps.setInt(7, surgical.getiD());

            result = ps.executeUpdate();
        }

        return result;
    }

    /**
     * Deleting Surgical Data using its primary ID key, ID. It receives a
     * Surgical Bean and extracts its ID.
     *
     * @param surgical
     * @return
     * @throws SQLException
     */
    public int deleteSurgical(SurgicalBean surgical) throws SQLException {

        int result;

        String preparedQuery = "DELETE FROM SURGICAL WHERE ID = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER,
                PASSWORD); PreparedStatement ps = connection.prepareStatement(preparedQuery);) {
            ps.setInt(1, surgical.getiD());

            result = ps.executeUpdate();
        }

        return result;
    }
}
