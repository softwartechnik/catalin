package de.softwartechnik.catalin.gui.swing.model;

import de.softwartechnik.catalin.core.model.Person;

import java.util.List;

public class CatalinGUIViewPersonsTableModel extends AbstractListBasedTableModel<Person> {

    private static final String[] COLUMNS = { "Id", "Vorname", "Nachname", "Geburtstag" };

    public CatalinGUIViewPersonsTableModel() {
        super();
    }

    @Override
    Object getEntityProperty(Person entity, int columnIndex) {
        switch (columnIndex) {
            case 0: {
                return entity.getId();
            }
            case 1: {
                return entity.getFirstName();
            }
            case 2: {
                return entity.getLastName();
            }
            case 3: {
                return entity.getBirthday();
            }
            default: {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override
    public int getColumnCount() {
        return COLUMNS.length;
    }

    @Override
    public String getColumnName(int index) {
        return COLUMNS[index];
    }
}
