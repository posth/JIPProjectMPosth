package com.posthoffice.jipprojectmposth.properties;

import static java.nio.file.Files.newInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.Paths.get;
import java.util.Properties;

public class PropertiesManager {

    public PropertiesManager() {
        super();
    }

    public DBConnectionBean loadProperties() throws IOException {

        Properties prop = new Properties();

        String propFileName = "config";
        String path = "src/main/resources/";

        Path txtFile = get(path, propFileName + ".properties");

        DBConnectionBean dBConnectionBean = new DBConnectionBean();

        if (Files.exists(txtFile)) {
            try (InputStream propFileStream = newInputStream(txtFile);) {
                prop.load(propFileStream);
            }

            dBConnectionBean.setUrl(prop.getProperty("URL"));
            dBConnectionBean.setUser(prop.getProperty("USER"));
            dBConnectionBean.setPassword(prop.getProperty("PASSWORD"));
        }

        return dBConnectionBean;

    }

}
