package de.softwartechnik.catalin.gui.swing.model;

import com.google.common.base.Joiner;
import de.softwartechnik.catalin.core.model.Booking;
import de.softwartechnik.catalin.core.model.BookingExtra;

import java.util.List;
import java.util.stream.Collectors;

public class CatalinGUIViewBookingsTableModel extends AbstractListBasedTableModel<Booking> {

    private static final String[] COLUMNS = { "Id", "Vorname", "Nachname", "FlugId", "Start Flughafen", "Start Terminal", "Ziel Flughafen", "Ziel Terminal", "Extras" };

    public CatalinGUIViewBookingsTableModel() {
        super();
    }

    @Override
    Object getEntityProperty(Booking booking, int columnIndex) {

        switch (columnIndex) {
            case 0: {
                return booking.getId();
            }
            case 1: {
                return booking.getPerson().getFirstName();
            }
            case 2: {
                return booking.getPerson().getLastName();
            }
            case 3: {
                return booking.getFlight().getId();
            }
            case 4: {
                return booking.getFlight().getSource().getAirport().getName();
            }
            case 5: {
                return booking.getFlight().getSource().getName();
            }
            case 6: {
                return booking.getFlight().getDestination().getAirport().getName();
            }
            case 7: {
                return booking.getFlight().getDestination().getName();
            }
            case 8: {
                return Joiner.on(", ").join(booking.getExtras()
                        .stream()
                        .map(BookingExtra::getName)
                        .collect(Collectors.toList()));
            }
            default: {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override
    public int getColumnCount() {
        return COLUMNS.length;
    }

    @Override
    public String getColumnName(int index) {
        return COLUMNS[index];
    }
}
