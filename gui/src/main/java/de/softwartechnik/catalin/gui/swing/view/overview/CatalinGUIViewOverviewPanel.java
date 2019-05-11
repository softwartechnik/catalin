package de.softwartechnik.catalin.gui.swing.view.overview;

import javax.swing.*;
import java.awt.*;

public class CatalinGUIViewOverviewPanel extends JPanel {

    private static final String TEXT_WELCOME = "WELCOME";

    public CatalinGUIViewOverviewPanel() {

        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel(TEXT_WELCOME);
        add(welcomeLabel, BorderLayout.CENTER);
    }
}
