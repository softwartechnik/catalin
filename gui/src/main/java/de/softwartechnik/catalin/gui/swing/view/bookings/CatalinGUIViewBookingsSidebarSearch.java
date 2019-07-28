package de.softwartechnik.catalin.gui.swing.view.bookings;

import de.softwartechnik.catalin.gui.service.LanguageService;
import java.awt.FlowLayout;
import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CatalinGUIViewBookingsSidebarSearch extends JPanel {

  private final LanguageService languageService;
  private JTextField searchfield;
  private JButton searchbutton;

  @Inject
  public CatalinGUIViewBookingsSidebarSearch(LanguageService languageService) {
    this.languageService = languageService;

    setLayout(new FlowLayout());

    searchfield = new JTextField();
    searchfield.setColumns(25);
    searchbutton = new JButton(languageService.translate("bookings.sidebar.search"));

    add(searchfield);
    add(searchbutton);
  }

  public JButton getSearchbutton() {
    return searchbutton;
  }

  public JTextField getSearchfield() {
    return searchfield;
  }
}
