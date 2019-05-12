package de.softwartechnik.catalin.gui.swing.view.bookings;

import de.softwartechnik.catalin.core.model.Booking;
import de.softwartechnik.catalin.gui.swing.model.CatalinGUIViewBookingsTableModel;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.util.List;

public class CatalinGUIViewBookingsTable extends JTable {

    public CatalinGUIViewBookingsTable(List<Booking> bookings) {

        getTableHeader().setReorderingAllowed(true);
        getTableHeader().setResizingAllowed(true);

        TableModel model = new CatalinGUIViewBookingsTableModel(bookings);
        setModel(model);
    }
}
