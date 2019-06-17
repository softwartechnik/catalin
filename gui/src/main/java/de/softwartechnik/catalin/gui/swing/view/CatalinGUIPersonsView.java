package de.softwartechnik.catalin.gui.swing.view;

import de.softwartechnik.catalin.gui.swing.model.PersonsTableModel;
import de.softwartechnik.catalin.gui.swing.view.persons.CatalinGUIViewPersonsPanel;
import de.softwartechnik.catalin.gui.swing.view.persons.CatalinGUIViewPersonsSidebar;
import de.softwartechnik.catalin.gui.swing.view.persons.CatalinGUIViewPersonsTable;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public void setAddButtonListener(ActionListener actionListener) {

        JButton buttonAdd = personsPanel.getSidebar().getButtonAdd();
        buttonAdd.addActionListener(actionListener);
    }

    public void setEditButtonListener(ActionListener actionListener) {
        JButton buttonEdit = personsPanel.getSidebar().getButtonEdit();
        buttonEdit.addActionListener(actionListener);
    }

    public String getFormFirstName() {

        return personsPanel.getSidebar().getTextFieldFirstName().getText();
    }

    public String getFormLastName() {

        return personsPanel.getSidebar().getTextFieldLastName().getText();
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

    public PersonsTableModel getPersonsModel() {

        return (PersonsTableModel) personsPanel.getTable().getModel();
    }

    public void setPersonsModel(PersonsTableModel persons) {
        personsPanel.getTable().setModel(persons);
    }

    public void resetForm() {

        CatalinGUIViewPersonsSidebar sidebar = personsPanel.getSidebar();
        JFormattedTextField textFieldDate = sidebar.getTextFieldDate();
        JTextField textFieldFirstName = sidebar.getTextFieldFirstName();
        JTextField textFieldLastName = sidebar.getTextFieldLastName();

        textFieldDate.setValue(new Date());
        textFieldFirstName.setText("Vorname");
        textFieldLastName.setText("Nachname");
    }

    public long getSelectedPersonId() {

        PersonsTableModel personsModel = getPersonsModel();
        CatalinGUIViewPersonsTable table = personsPanel.getTable();
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {

            return -1;
        }

        Object value = personsModel.getValueAt(selectedRow, 0);

        if (value == null) {

            return -1;
        }

        return Long.valueOf(value.toString());
    }
}
