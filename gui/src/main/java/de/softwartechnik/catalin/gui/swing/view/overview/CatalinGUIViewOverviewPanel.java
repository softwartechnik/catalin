package de.softwartechnik.catalin.gui.swing.view.overview;

import de.softwartechnik.catalin.gui.service.LanguageService;
import java.awt.BorderLayout;
import javax.inject.Inject;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
