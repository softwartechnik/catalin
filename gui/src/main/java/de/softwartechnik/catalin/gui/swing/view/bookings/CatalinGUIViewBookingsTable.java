package de.softwartechnik.catalin.gui.swing.view.bookings;

import javax.inject.Inject;
import javax.swing.*;

public class CatalinGUIViewBookingsTable extends JTable {

    @Inject
    public CatalinGUIViewBookingsTable() {

        getTableHeader().setReorderingAllowed(true);
        getTableHeader().setResizingAllowed(true);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
