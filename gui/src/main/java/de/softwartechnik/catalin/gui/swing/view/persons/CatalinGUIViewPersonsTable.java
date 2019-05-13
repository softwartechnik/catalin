package de.softwartechnik.catalin.gui.swing.view.persons;

import de.softwartechnik.catalin.core.model.Person;
import de.softwartechnik.catalin.gui.swing.model.CatalinGUIViewPersonsTableModel;

import javax.inject.Inject;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class CatalinGUIViewPersonsTable extends JTable {

    private static final String[] COLUMNS = { "Id", "Vorname", "Nachname", "Geburtstag" };
    private final DefaultTableModel tableModel;

    @Inject
    public CatalinGUIViewPersonsTable() {

        tableModel = new DefaultTableModel();
        for (String column : COLUMNS) {
            tableModel.addColumn(column);
        }

        getTableHeader().setReorderingAllowed(true);
        getTableHeader().setResizingAllowed(true);

        setModel(tableModel);
    }

    public void setPersons(List<Person> persons) {

        tableModel.setRowCount(0);

        for (Person person : persons) {
            tableModel.addRow(convertPerson(person));
        }

        tableModel.fireTableDataChanged();
    }

    private Object[] convertPerson(Person person) {

        return new Object[] {person.getId(), person.getFirstName(), person.getLastName(), person.getBirthday().toString()};
    }
}
