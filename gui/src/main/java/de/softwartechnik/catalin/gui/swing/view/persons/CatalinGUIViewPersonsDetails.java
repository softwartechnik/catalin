package de.softwartechnik.catalin.gui.swing.view.persons;

import de.softwartechnik.catalin.gui.service.LanguageService;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CatalinGUIViewPersonsDetails extends JFrame implements Observer {

  private final JButton save;
  private final JLabel VORNAME;
  private final JLabel NACHNAME;
  private final JLabel GEB;
  private final JTextField tf_vorname = new JTextField();
  private final JTextField tf_nachname = new JTextField();
  private final JTextField tf_datum = new JTextField();
  private final LanguageService languageService;
  private JPanel details;
  private CatalinGUIViewPersonsDetailsModel detailsModel;

  @Inject
  public CatalinGUIViewPersonsDetails(CatalinGUIViewPersonsDetailsModel detailsModel,
      LanguageService languageService) {
    this.languageService = languageService;
    this.detailsModel = detailsModel;

    save = new JButton(languageService.translate("person.details.save"));
    VORNAME = new JLabel(languageService.translate("person.details.firstName"));
    NACHNAME = new JLabel(languageService.translate("person.details.lastName"));
    GEB = new JLabel(languageService.translate("person.details.birthday"));

    setupPanel();
    setup();

    add(details);
    setVisible(true);

    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
  }

  private void setupPanel() {
    details = new JPanel();
    details.setLayout(new FlowLayout(FlowLayout.CENTER));

    details.add(VORNAME);
    details.add(tf_vorname);
    details.add(NACHNAME);
    details.add(tf_nachname);
    details.add(GEB);
    details.add(tf_datum);
    details.add(save);
  }

  private void setup() {
    setSize(400, 300);
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    this.setLocation(dim.width / 2 - this.getSize().width / 2,
        dim.height / 2 - this.getSize().height / 2);
  }

  public JButton getSave() {
    return save;
  }

  @Override
  public void update(Observable observable, Object arg) {

    if (!(observable instanceof CatalinGUIViewPersonsDetailsModel)) {
      throw new IllegalStateException("Shit hit the fen.");
    }

    CatalinGUIViewPersonsDetailsModel model = (CatalinGUIViewPersonsDetailsModel) observable;

    tf_vorname.setText(model.getFirstName());
    tf_nachname.setText(model.getLastName());
    tf_datum.setText(new SimpleDateFormat().format(model.getBirthday()));
  }

  public String getInputFirstName() {

    return tf_vorname.getText();
  }

  public String getInputLastName() {

    return tf_nachname.getText();
  }

  public Date getInputBirthday() {

    try {
      return new SimpleDateFormat().parse(tf_datum.getText());
    } catch (ParseException e) {
      e.printStackTrace();
    }

    return new Date();
  }
}
