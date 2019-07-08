package de.softwartechnik.catalin.gui.swing.view.overview;

import de.softwartechnik.catalin.gui.service.LanguageService;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.*;

public class CatalinGUIViewOverviewPanel extends JPanel {

    private final LanguageService languageService;

    @Inject
    public CatalinGUIViewOverviewPanel(LanguageService languageService) {
        this.languageService = languageService;

        final String TEXT_WELCOME = languageService.translate("overview.welcome");
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel(TEXT_WELCOME);
        add(welcomeLabel, BorderLayout.CENTER);
    }
}
