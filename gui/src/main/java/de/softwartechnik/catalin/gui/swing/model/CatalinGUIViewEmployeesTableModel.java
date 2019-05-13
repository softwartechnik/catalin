package de.softwartechnik.catalin.gui.swing.model;

import de.softwartechnik.catalin.core.model.Employee;

import java.util.List;

public class CatalinGUIViewEmployeesTableModel extends AbstractListBasedTableModel<Employee> {

    private static final String[] COLUMNS = { "Id", "Vorname", "Nachname" };

    public CatalinGUIViewEmployeesTableModel() {
        super();
    }

    @Override
    Object getEntityProperty(Employee entity, int columnIndex) {

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
