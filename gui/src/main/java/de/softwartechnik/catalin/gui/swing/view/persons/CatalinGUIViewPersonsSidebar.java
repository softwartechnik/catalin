package de.softwartechnik.catalin.gui.swing.view.persons;

import de.softwartechnik.catalin.gui.service.LanguageService;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CatalinGUIViewPersonsSidebar extends JPanel {

  private final JTextField textFieldFirstName;
  private final JTextField textFieldLastName;
  private final JFormattedTextField textFieldDate;

  private final JButton buttonAdd;
  private final JButton buttonEdit;

  private final LanguageService languageService;

  @Inject
  public CatalinGUIViewPersonsSidebar(LanguageService languageService) {
    this.languageService = languageService;

    textFieldFirstName = new JTextField(languageService.translate("persons.sidebar.firstName"));
    textFieldLastName = new JTextField(languageService.translate("persons.sidebar.lastName"));
    textFieldDate = new JFormattedTextField(new SimpleDateFormat());
    textFieldDate.setValue(new Date());
    buttonAdd = new JButton(languageService.translate("persons.sidebar.save"));
    buttonEdit = new JButton(languageService.translate("persons.sidebar.edit"));

    add(textFieldFirstName);
    add(textFieldLastName);
    add(textFieldDate);
    add(buttonAdd);
    add(buttonEdit);
  }

  public JButton getButtonEdit() {
    return buttonEdit;
  }

  public JButton getButtonAdd() {
    return buttonAdd;
  }

  public JFormattedTextField getTextFieldDate() {
    return textFieldDate;
  }

  public JTextField getTextFieldFirstName() {
    return textFieldFirstName;
  }

  public JTextField getTextFieldLastName() {
    return textFieldLastName;
  }
}
