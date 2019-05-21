package de.softwartechnik.catalin.gui.swing.model;

import de.softwartechnik.catalin.core.model.Person;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class PersonsTableModel extends DefaultTableModel {

    private static final String[] COLUMNS = {"Id", "Vorname", "Nachname", "Geburtstag"};

    public PersonsTableModel(List<Person> persons) {

        for (String column : COLUMNS) {
            addColumn(column);
        }

        persons.forEach(this::addPerson);
    }

    public void addPerson(Person person) {

        Object[] convert = convert(person);
        addRow(convert);
    }

    public void removePerson(int rowNum) {

        removeRow(rowNum);
    }

    private Object[] convert(Person person) {

        return new Object[]{person.getId(), person.getFirstName(), person.getLastName(), person.getBirthday().toString()};
    }
}
