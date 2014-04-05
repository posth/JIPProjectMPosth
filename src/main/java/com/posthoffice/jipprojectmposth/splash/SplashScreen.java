package com.posthoffice.jipprojectmposth.splash;

import com.posthoffice.jipprojectmposth.presentation.JIPFramePresentation;
import com.posthoffice.jipprojectmposth.regex.Messages;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class SplashScreen extends JWindow {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
    private final int duration;
    private final String image = "/images/JIPSplash.jpg";

    public SplashScreen(int duration) {

        this.duration = duration;
    }

    public void showSplash() {
        JPanel content = (JPanel) getContentPane();
        setBackground(Color.white);

        JLabel label = new JLabel(createImageIcon(image));
        JLabel copy = new JLabel(Messages.getString("splash"), JLabel.CENTER);
        copy.setFont(new Font("Sans-Serif", Font.TRUETYPE_FONT, 20));
        
        add(label, BorderLayout.CENTER);
        add(copy, BorderLayout.SOUTH);

        Color myColor = new Color(203, 220, 238);
        content.setBorder(BorderFactory.createLineBorder(myColor, 5));

        pack();
        setLocationRelativeTo(null);

        setVisible(true);

    }

    public void showSplashAndExit() {
        showSplash();
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            log.warn("This sleep has been interrupted");
        }

        setVisible(false);
    }

    public ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = SplashScreen.class.getResource(path);

        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            log.error("Couldn't find file: " + path);
            return null;
        }

    }

    public static void main(String[] args) {
        SplashScreen splash = new SplashScreen(4500);
        splash.showSplashAndExit();

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                JIPFramePresentation jipPresentation = new JIPFramePresentation();
                jipPresentation.setVisible(true);
                jipPresentation.setExtendedState(jipPresentation.getExtendedState() | JFrame.MAXIMIZED_BOTH);
            }
        });
    }
}
