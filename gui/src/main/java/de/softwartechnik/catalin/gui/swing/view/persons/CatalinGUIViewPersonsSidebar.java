package de.softwartechnik.catalin.gui.swing.view.persons;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CatalinGUIViewPersonsSidebar extends JPanel {

    private final JTextField textFieldFirstName;
    private final JTextField textFieldLastName;
    private final JFormattedTextField textFieldDate;

    private final JButton buttonAdd;

    public CatalinGUIViewPersonsSidebar() {

        textFieldFirstName = new JTextField("Vorname");
        textFieldLastName = new JTextField("Nachname");
        textFieldDate = new JFormattedTextField(new SimpleDateFormat());
        textFieldDate.setValue(new Date());
        buttonAdd = new JButton("Speichern");

        add(textFieldFirstName);
        add(textFieldLastName);
        add(textFieldDate);
        add(buttonAdd);
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
