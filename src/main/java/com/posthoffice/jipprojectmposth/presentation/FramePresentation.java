package com.posthoffice.jipprojectmposth.presentation;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class FramePresentation {

    public FramePresentation() {
        initComponents();
    }

    private void initComponents() {

        initJFrame();
    }

    private void initJFrame() {

        JFrame frame = new JFrame("JIP Program");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        
        FormsPresentation forms = new FormsPresentation();
        frame.getContentPane().add(forms, BorderLayout.EAST);

        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                FramePresentation frame = new FramePresentation();

            }
        });
    }

}
