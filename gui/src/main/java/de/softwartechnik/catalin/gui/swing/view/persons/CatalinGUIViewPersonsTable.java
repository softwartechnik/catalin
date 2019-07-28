package de.softwartechnik.catalin.gui.swing.view.persons;

import javax.inject.Inject;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class CatalinGUIViewPersonsTable extends JTable {

  @Inject
  public CatalinGUIViewPersonsTable() {

    getTableHeader().setReorderingAllowed(true);
    getTableHeader().setResizingAllowed(true);
    setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
  }

  @Override
  public boolean isCellEditable(int row, int column) {
    return false;
  }

}

