package de.softwartechnik.catalin.gui.swing.view;

import de.softwartechnik.catalin.core.model.Person;
import de.softwartechnik.catalin.gui.swing.view.persons.CatalinGUIViewPersonsPanel;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CatalinGUIPersonsView extends AbstractCatalinGUIView {

    private final CatalinGUIViewPersonsPanel personsPanel;

    @Inject
    public CatalinGUIPersonsView(CatalinGUIViewPersonsPanel personsPanel) {
        this.personsPanel = personsPanel;
    }

    @Override
    public JComponent getComponent() {

        return personsPanel;
    }

    public void setPersons(List<Person> persons) {

        personsPanel.getTable().setPersons(persons);
    }

    public void setAddButtonListener(ActionListener actionListener) {

        JButton buttonAdd = personsPanel.getSidebar().getButtonAdd();
        buttonAdd.addActionListener(actionListener);
    }

    public String getFormFirstName() {

        return personsPanel.getSidebar().getTextFieldFirstName().getText();
    }

    public String getFormLastName() {

        return personsPanel.getSidebar().getTextFieldFirstName().getText();
    }

    public Date getFormBirthday() {

        String text = personsPanel.getSidebar().getTextFieldDate().getText();

        try {
            return new SimpleDateFormat().parse(text);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
