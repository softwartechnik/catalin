package de.softwartechnik.catalin.gui.swing.view.flights;

import javax.inject.Inject;
import javax.swing.*;

public class CatalinGUIViewFlightsTable extends JTable {

    @Inject
    public CatalinGUIViewFlightsTable() {

        getTableHeader().setReorderingAllowed(true);
        getTableHeader().setResizingAllowed(true);
    }
}
