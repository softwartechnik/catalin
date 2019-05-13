package de.softwartechnik.catalin.gui.swing.view;

import de.softwartechnik.catalin.core.model.Employee;
import de.softwartechnik.catalin.gui.swing.model.EmployeesTableModel;
import de.softwartechnik.catalin.gui.swing.view.employees.CatalinGUIViewEmployeesPanel;

import javax.inject.Inject;
import javax.swing.*;
import java.util.List;

public class CatalinGUIEmployeesView extends AbstractCatalinGUIView {

    private final CatalinGUIViewEmployeesPanel employeesPanel;

    @Inject
    public CatalinGUIEmployeesView(CatalinGUIViewEmployeesPanel employeesPanel) {
        this.employeesPanel = employeesPanel;
    }

    @Override
    public JComponent getComponent() {

        return employeesPanel;
    }

    public void setEmployees(EmployeesTableModel employees) {

        employeesPanel.getEmployeesTable().setModel(employees);
    }

    public EmployeesTableModel getEmployeesModel() {

        return (EmployeesTableModel) employeesPanel.getEmployeesTable().getModel();
    }
}
