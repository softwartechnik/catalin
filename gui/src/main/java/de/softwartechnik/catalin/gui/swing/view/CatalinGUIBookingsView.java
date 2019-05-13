package de.softwartechnik.catalin.gui.swing.view;

import de.softwartechnik.catalin.core.model.Booking;
import de.softwartechnik.catalin.gui.swing.model.BookingsTableModel;
import de.softwartechnik.catalin.gui.swing.view.bookings.CatalinGUIViewBookingsPanel;
import de.softwartechnik.catalin.gui.swing.view.bookings.CatalinGUIViewBookingsSidebarSearch;

import javax.inject.Inject;
import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionListener;
import java.util.List;

public class CatalinGUIBookingsView extends AbstractCatalinGUIView {

    private TableRowSorter<BookingsTableModel> rowSorter;
    private final CatalinGUIViewBookingsPanel bookingsPanel;

    @Inject
    public CatalinGUIBookingsView(CatalinGUIViewBookingsPanel bookingsPanel) {
        this.bookingsPanel = bookingsPanel;
    }

    @Override
    public JComponent getComponent() {

        return bookingsPanel;
    }

    public void setBookings(BookingsTableModel bookings) {

        rowSorter = new TableRowSorter<>(bookings);
        bookingsPanel.getBookingsTable().setModel(bookings);
        bookingsPanel.getBookingsTable().setRowSorter(rowSorter);
    }

    public BookingsTableModel getBookingsModel() {

        return (BookingsTableModel) bookingsPanel.getBookingsTable().getModel();
    }

    public void setSearchButtonListener(ActionListener actionListener) {

        CatalinGUIViewBookingsSidebarSearch sidebarSearch = bookingsPanel.getSidepanel().getSidebarSearch();
        sidebarSearch.getSearchbutton().addActionListener(actionListener);
    }

    public String getSearchWord() {

        return bookingsPanel.getSidepanel().getSidebarSearch().getSearchfield().getText();
    }

    public void filterTable(RowFilter<BookingsTableModel, Object> rowFilter) {

        rowSorter.setRowFilter(rowFilter);
    }
}
