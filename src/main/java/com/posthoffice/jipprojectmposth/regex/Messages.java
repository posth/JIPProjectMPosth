package com.posthoffice.jipprojectmposth.regex;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {

    private static String BUNDLE_NAME = "messages";
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    public Messages() {

        checkIfFrenchLocale();
    }

    /**
     * The only other language internationalized by the program is French.  
     * This method checks if it is a French set-up computer. If not, it defaults
     * to the eng_US.
     */
    public void checkIfFrenchLocale() {

        Locale currentLocale = Locale.getDefault();

        Locale frLocale = new Locale("fr");

        if (currentLocale.equals(frLocale)) {
            Messages.BUNDLE_NAME = "messages_fr";
        }
    }

    public static String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
}
