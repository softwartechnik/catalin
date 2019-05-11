package de.softwartechnik.catalin.gui.swing;

import javax.swing.*;

class WelcomePanel extends JPanel {

    private static final String TEXT_WELCOME = "Herzlich Willkommen";

    WelcomePanel() {
        JLabel welcome = new JLabel(TEXT_WELCOME);
        add(welcome);
    }
}
