package de.softwartechnik.catalin.gui.swing.model;

import com.google.common.base.Joiner;
import de.softwartechnik.catalin.core.model.Booking;
import de.softwartechnik.catalin.core.model.BookingExtra;
import de.softwartechnik.catalin.gui.service.LanguageService;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.swing.table.DefaultTableModel;


public class BookingsTableModel extends DefaultTableModel {

  private static final String[] COLUMNS = {"bookings.tablemodel.id",
      "bookings.tablemodel.firstName",
      "bookings.tablemodel.lastName",
      "bookings.tablemodel.flightID",
      "bookings.tablemodel.departureAirport",
      "bookings.tablemodel.destinationAirport",
      "bookings.tablemodel.departureTerminal",
      "bookings.tablemodel.destinationTerminal",
      "bookings.tablemodel.extras"};

  private final LanguageService languageService;

  @Inject
  public BookingsTableModel(List<Booking> bookings, LanguageService languageService) {
    this.languageService = languageService;
    for (String column : COLUMNS) {
      addColumn(languageService.translate(column));
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
        Joiner.on(", ").join(
            booking.getExtras().stream().map(BookingExtra::getName).collect(Collectors.toList()))
    };
  }
}
