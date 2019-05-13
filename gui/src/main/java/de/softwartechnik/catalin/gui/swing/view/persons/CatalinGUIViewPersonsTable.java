package de.softwartechnik.catalin.gui.swing.view.persons;

import javax.inject.Inject;
import javax.swing.*;

public class CatalinGUIViewPersonsTable extends JTable {

    @Inject
    public CatalinGUIViewPersonsTable() {

        getTableHeader().setReorderingAllowed(true);
        getTableHeader().setResizingAllowed(true);
    }
}
