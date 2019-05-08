package de.softwartachnik.catalin.gui.swing;

import javax.swing.*;

public class WelcomePanel extends JPanel {

    public static String WELCOMETEXT = "Herzlich Willkommen";
    JLabel welcome;

    public WelcomePanel(){
        welcome = new JLabel(WELCOMETEXT);
        this.add(welcome);
    }
}
