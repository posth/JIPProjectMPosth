package com.posthoffice.jipprojectmposth;

import com.posthoffice.jipprojectmposth.properties.DBConnectionBean;
import com.posthoffice.jipprojectmposth.properties.PropertiesManager;
import java.io.IOException;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

public class PropertiesAccessTest {

    private PropertiesManager prop = new PropertiesManager();

    @Test
    public void checkURL() throws IOException {

        DBConnectionBean dBBean = prop.loadProperties();

        String URL = dBBean.getUrl();
        assertEquals(URL, "jdbc:mysql://localhost:3306/PATIENTDB");

    }

    @Test
    public void checkUSER() throws IOException {

        DBConnectionBean dBBean = prop.loadProperties();

        String USER = dBBean.getUser();
        assertEquals(USER, "root");

    }

    @Test
    public void checkPASSWORD() throws IOException {

        DBConnectionBean dBBean = prop.loadProperties();

        String PASSWORD = dBBean.getPassword();
        assertEquals(PASSWORD, "Johnny23");

    }
}
