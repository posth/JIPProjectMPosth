package com.posthoffice.jipprojectmposth.presentation;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

public class JIPFramePresentation extends javax.swing.JFrame implements ActionListener {

    public JIPFramePresentation() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar = createToolBar();
        splitPanelPanel1 = new com.posthoffice.jipprojectmposth.presentation.SplitPanelPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Patient Management System");

        jToolBar.setRollover(true);
        getContentPane().add(jToolBar, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(splitPanelPanel1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");

        newMenuItem.setText("New");
        newMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(newMenuItem);

        saveMenuItem.setText("Save");
        jMenu1.add(saveMenuItem);

        jMenuItem1.setText("Exit");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newMenuItemActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                JIPFramePresentation jipPresentation = new JIPFramePresentation();
                jipPresentation.setVisible(true);
                jipPresentation.setExtendedState(jipPresentation.getExtendedState() | JFrame.MAXIMIZED_BOTH);
            }
        });
    }

    private JToolBar createToolBar() {

        JToolBar toolBar = new JToolBar();
        
        JButton newPatientButton = makeToolBarButton("New Patient", "NewPatient", "Alt + N", KeyEvent.VK_N);       
        JButton deletePatientButton = makeToolBarButton("Delete Patient", "DeletePatient", "Alt + D", KeyEvent.VK_D);

        toolBar.add(newPatientButton);
        toolBar.add(deletePatientButton);
        
        toolBar.setFloatable(true);

        return toolBar;
    }

    private JButton makeToolBarButton(String buttonName, String actionCommand, String toolTipText, int buttonMnemonic) {

        ToolBarEventHandler toolBarEventHandler = new ToolBarEventHandler();

        JButton button = new JButton();

        button.setText(buttonName);
        button.setActionCommand(actionCommand);
        button.setToolTipText(toolTipText);
        button.setMnemonic(buttonMnemonic);
        button.addActionListener(toolBarEventHandler);

        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    class ToolBarEventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) (e.getSource());

            switch (source.getActionCommand()) {

                case "NewPatient":
                    createPatientForm();
                    break;
                    
                case "DeletePatient":
                    deletePatientForm();
                    break;
            }

        }

    }
    
    public void createPatientForm() {
        
        JFrame patientFormFrame = new JFrame("Patient Form");       
        
        TabbedFormPanel patientForm = new TabbedFormPanel();
        
        JScrollPane patientFormScroll = new JScrollPane(patientForm);
        
        patientFormFrame.getContentPane().add(patientFormScroll);
        
        patientFormFrame.pack();
        patientFormFrame.setVisible(true);
        patientFormFrame.setResizable(false);
    }
    
    public void deletePatientForm() {
        
        //to do based on selectedRow
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JToolBar jToolBar;
    private javax.swing.JMenuItem newMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private com.posthoffice.jipprojectmposth.presentation.SplitPanelPanel splitPanelPanel1;
    // End of variables declaration//GEN-END:variables
}
