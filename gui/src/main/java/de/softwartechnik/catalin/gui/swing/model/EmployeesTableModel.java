package de.softwartechnik.catalin.gui.swing.model;

import de.softwartechnik.catalin.core.model.Employee;
import de.softwartechnik.catalin.gui.service.LanguageService;

import javax.inject.Inject;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class EmployeesTableModel extends DefaultTableModel {

    private static final String[] COLUMNS = {"employees.tablemodel.id", "employees.tablemodel.firstName", "employees.tablemodel.lastName"};
    private final LanguageService languageService;

    @Inject
    public EmployeesTableModel(List<Employee> employees,LanguageService languageService) {
        this.languageService = languageService;
        for (String column : COLUMNS) {
            addColumn(languageService.translate(column));
        }
        employees.forEach(this::addEmployee);
    }

    public void addEmployee(Employee employee) {

        addRow(convert(employee));
    }

    public void removeEmployee(int rowNum) {

        removeRow(rowNum);
    }

    private Object[] convert(Employee employee) {

        return new Object[]{employee.getId(), employee.getFirstName(), employee.getLastName()};
    }
}
