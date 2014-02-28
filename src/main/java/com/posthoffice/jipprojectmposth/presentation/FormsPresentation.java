package com.posthoffice.jipprojectmposth.presentation;

import java.awt.BorderLayout;
import javax.swing.*;

public class FormsPresentation extends JPanel {
    
    private JLabel lastNameLabel = new JLabel("Last Name:");
    private JLabel firstNameLabel = new JLabel("First Name:");
    private JLabel diagnosisLabel = new JLabel("Diagnosis:");
    private JLabel admissionDateLabel = new JLabel("Admission Date:");
    private JLabel releaseDateLabel = new JLabel("Release Date:");

    public FormsPresentation() {
        initComponents();
    }
    
    public void initComponents() {
        
        JPanel forms = new JPanel (new BorderLayout());
        
        forms.add(lastNameLabel, BorderLayout.CENTER);
        forms.add(firstNameLabel, BorderLayout.CENTER);
        forms.add(diagnosisLabel, BorderLayout.CENTER);
        forms.add(admissionDateLabel, BorderLayout.CENTER);
        forms.add(releaseDateLabel, BorderLayout.CENTER);
        
        
    }

}
