package de.softwartechnik.catalin.gui.swing.view;

import de.softwartechnik.catalin.core.model.Booking;
import de.softwartechnik.catalin.gui.swing.view.bookings.CatalinGUIViewBookingsPanel;

import javax.inject.Inject;
import javax.swing.*;
import java.util.List;

public class CatalinGUIBookingsView extends AbstractCatalinGUIView {


    private final CatalinGUIViewBookingsPanel bookingsPanel;

    @Inject
    public CatalinGUIBookingsView(CatalinGUIViewBookingsPanel bookingsPanel) {
        this.bookingsPanel = bookingsPanel;
    }

    @Override
    public JComponent getComponent() {

        return bookingsPanel;
    }

    public void setBookings(List<Booking> bookings) {

        bookingsPanel.getBookingsTable().setBookings(bookings);
    }
}
