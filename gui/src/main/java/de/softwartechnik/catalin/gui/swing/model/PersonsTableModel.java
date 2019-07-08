package de.softwartechnik.catalin.gui.swing.model;

import de.softwartechnik.catalin.core.model.Person;
import de.softwartechnik.catalin.gui.service.LanguageService;

import javax.inject.Inject;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class PersonsTableModel extends DefaultTableModel {

    private static final String[] COLUMNS = {"persons.tablemodel.id",
            "persons.tablemodel.firstName",
            "persons.tablemodel.lastName",
            "persons.tablemodel.birthday"};
    private final LanguageService languageService;

    @Inject
    public PersonsTableModel(List<Person> persons,LanguageService languageService) {
        this.languageService = languageService;
        for (String column : COLUMNS) {
            addColumn(languageService.translate(column));
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
