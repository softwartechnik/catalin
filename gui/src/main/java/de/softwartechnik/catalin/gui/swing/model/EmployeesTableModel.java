package de.softwartechnik.catalin.gui.swing.model;

import de.softwartechnik.catalin.core.model.Employee;

import javax.swing.table.DefaultTableModel;
import java.util.Arrays;
import java.util.List;

public class EmployeesTableModel extends DefaultTableModel {

    private static final String[] COLUMNS = { "Id", "Vorname", "Nachname" };

    public EmployeesTableModel(List<Employee> employees) {

        Arrays.stream(COLUMNS).forEach(this::addColumn);
        employees.forEach(this::addEmployee);
    }

    public void addEmployee(Employee employee) {

        addRow(convert(employee));
    }

    public void removeEmployee(int rowNum) {

        removeRow(rowNum);
    }

    private Object[] convert(Employee employee) {

        return new Object[] { employee.getId(), employee.getFirstName(), employee.getLastName() };
    }
}
