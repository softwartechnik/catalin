package de.softwartechnik.catalin.gui.swing.view;

import de.softwartechnik.catalin.gui.swing.model.EmployeesTableModel;
import de.softwartechnik.catalin.gui.swing.view.employees.CatalinGUIViewEmployeesPanel;

import javax.inject.Inject;
import javax.swing.*;

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

    public EmployeesTableModel getEmployeesModel() {

        return (EmployeesTableModel) employeesPanel.getEmployeesTable().getModel();
    }

    public void setEmployeesModel(EmployeesTableModel employees) {

        employeesPanel.getEmployeesTable().setModel(employees);
    }
}
