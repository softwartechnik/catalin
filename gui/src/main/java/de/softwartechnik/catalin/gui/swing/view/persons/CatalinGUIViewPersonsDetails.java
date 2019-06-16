package de.softwartechnik.catalin.gui.swing.view.persons;

import de.softwartechnik.catalin.core.model.Person;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.*;
import javax.swing.SpringLayout;


public class CatalinGUIViewPersonsDetails extends JFrame {

    JPanel details;
    private final JButton save = new JButton("Änderungen speichern");

    private final JLabel VORNAME = new JLabel("Vorname:");
    private final JLabel NACHNAME = new JLabel("Nachname:");
    private final JLabel GEB = new JLabel("Geburtstag:");

    private final JTextField tf_vorname = new JTextField();
    private final JTextField tf_nachname = new JTextField();
    private final JTextField tf_datum = new JTextField();

    Person currentPerson;
    public CatalinGUIViewPersonsDetails(Person person){
        this.currentPerson = person;
        setupPanel();
        setup();

        add(details);
        setVisible(true);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void setupPanel(){
        details = new JPanel();
        details.setLayout(new FlowLayout(FlowLayout.CENTER));

        tf_vorname.setText(currentPerson.getFirstName());
        tf_nachname.setText(currentPerson.getLastName());
        tf_datum.setText(currentPerson.getBirthday().toString());

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

    public JTextField getTf_vorname() {
        return tf_vorname;
    }

    public JTextField getTf_nachname() {
        return tf_nachname;
    }

    public JTextField getTf_datum() {
        return tf_datum;
    }

    public JButton getSave() {
        return save;
    }
}
