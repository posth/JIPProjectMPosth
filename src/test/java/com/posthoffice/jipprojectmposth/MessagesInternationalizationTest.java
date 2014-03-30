package com.posthoffice.jipprojectmposth;

import java.util.ResourceBundle;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;

public class MessagesInternationalizationTest {

    @Test
    public void checkEnglish() {

        String BUNDLE_NAME = "messages";
        ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

        String testString = RESOURCE_BUNDLE.getString("firstname");

        assertEquals(testString, "First Name");

    }

    @Test
    public void checkFrench() {
        
        String BUNDLE_NAME = "messages_fr";
        ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

        String testString = RESOURCE_BUNDLE.getString("firstname");

        assertEquals(testString, "Prénom");

    }
}
