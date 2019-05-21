package de.softwartechnik.catalin.gui.swing.model;

import com.google.common.base.Joiner;
import de.softwartechnik.catalin.core.model.Booking;
import de.softwartechnik.catalin.core.model.BookingExtra;

import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.stream.Collectors;

public class BookingsTableModel extends DefaultTableModel {

    private static final String[] COLUMNS = {"Id", "Vorname", "Nachname", "FlugId", "Start Flughafen", "Start Terminal", "Ziel Flughafen", "Ziel Terminal", "Extras"};

    public BookingsTableModel(List<Booking> bookings) {
        for (String column : COLUMNS) {
            addColumn(column);
        }

        bookings.forEach(this::addBooking);
    }

    public void addBooking(Booking booking) {

        Object[] convert = convert(booking);
        addRow(convert);
    }

    public void removeBooking(int rowNum) {

        removeRow(rowNum);
    }

    private Object[] convert(Booking booking) {

        return new Object[]{
                booking.getId(),
                booking.getPerson().getFirstName(),
                booking.getPerson().getLastName(),
                booking.getFlight().getId(),
                booking.getFlight().getSource().getAirport().getName(),
                booking.getFlight().getSource().getName(),
                booking.getFlight().getDestination().getAirport().getName(),
                booking.getFlight().getDestination().getName(),
                Joiner.on(", ").join(booking.getExtras().stream().map(BookingExtra::getName).collect(Collectors.toList()))
        };
    }
}
