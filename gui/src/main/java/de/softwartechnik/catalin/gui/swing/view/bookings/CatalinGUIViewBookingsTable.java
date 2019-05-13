package de.softwartechnik.catalin.gui.swing.view.bookings;

import de.softwartechnik.catalin.core.model.Booking;
import de.softwartechnik.catalin.gui.swing.model.CatalinGUIViewBookingsTableModel;

import javax.swing.*;
import java.util.List;

public class CatalinGUIViewBookingsTable extends JTable {

    CatalinGUIViewBookingsTableModel model = new CatalinGUIViewBookingsTableModel();

    public CatalinGUIViewBookingsTable() {

        getTableHeader().setReorderingAllowed(true);
        getTableHeader().setResizingAllowed(true);

        setModel(model);
    }

    public void setBookings(List<Booking> bookings) {

        model.clear();
        model.addEntities(bookings);
    }
}
