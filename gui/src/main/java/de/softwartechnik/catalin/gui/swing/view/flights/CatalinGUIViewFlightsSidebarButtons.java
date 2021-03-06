package de.softwartechnik.catalin.gui.swing.view.flights;

import de.softwartechnik.catalin.gui.service.LanguageService;
import java.awt.FlowLayout;
import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CatalinGUIViewFlightsSidebarButtons extends JPanel {

  private final JButton deleteButton;

  private final LanguageService languageService;

  @Inject
  public CatalinGUIViewFlightsSidebarButtons(LanguageService languageService) {
    this.languageService = languageService;
    setLayout(new FlowLayout());

    deleteButton = new JButton(languageService.translate("flights.sidebar.delete"));
    add(deleteButton);
  }

  public JButton getDeleteButton() {
    return deleteButton;
  }
}
