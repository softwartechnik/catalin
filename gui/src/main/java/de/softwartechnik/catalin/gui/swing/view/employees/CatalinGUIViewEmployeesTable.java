package de.softwartechnik.catalin.gui.swing.view.employees;

import javax.swing.*;

public class CatalinGUIViewEmployeesTable extends JTable {

    public CatalinGUIViewEmployeesTable() {

        getTableHeader().setReorderingAllowed(true);
        getTableHeader().setResizingAllowed(true);
    }
}
