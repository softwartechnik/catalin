package de.softwartechnik.catalin.gui.swing.view.employees;

import javax.swing.JTable;

public class CatalinGUIViewEmployeesTable extends JTable {

  public CatalinGUIViewEmployeesTable() {

    getTableHeader().setReorderingAllowed(true);
    getTableHeader().setResizingAllowed(true);
  }

  @Override
  public boolean isCellEditable(int row, int column) {
    return false;
  }
}
