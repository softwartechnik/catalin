package de.softwartechnik.catalin.gui.swing.view.persons;

import de.softwartechnik.catalin.core.model.Person;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import javax.swing.SpringLayout;


public class CatalinGUIViewPersonsDetails extends JFrame implements Observer {

    private JPanel details;
    private final JButton save = new JButton("Änderungen speichern");

    private final JLabel VORNAME = new JLabel("Vorname:");
    private final JLabel NACHNAME = new JLabel("Nachname:");
    private final JLabel GEB = new JLabel("Geburtstag:");

    private final JTextField tf_vorname = new JTextField();
    private final JTextField tf_nachname = new JTextField();
    private final JTextField tf_datum = new JTextField();

    private CatalinGUIViewPersonsDetailsModel detailsModel;

    public CatalinGUIViewPersonsDetails(CatalinGUIViewPersonsDetailsModel detailsModel){
        this.detailsModel = detailsModel;
        setupPanel();
        setup();

        add(details);
        setVisible(true);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void setupPanel(){
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

    private void setup(){
        setSize(400, 300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
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
        tf_datum.setText(model.getBirthday().toString());
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
