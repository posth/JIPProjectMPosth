package com.posthoffice.jipprojectmposth.model;

import com.posthoffice.jipprojectmposth.beans.PatientBean;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PatientDBTableModel {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private final ArrayList<String> columnNames = new ArrayList<>();
    private final ArrayList<PatientBean> data = new ArrayList<>();
    
    public PatientDBTableModel() {
        super();
        logger.info("Patient Database Table Model Instantiated");
    }

}
