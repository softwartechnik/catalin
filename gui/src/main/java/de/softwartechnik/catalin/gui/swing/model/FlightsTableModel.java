package de.softwartechnik.catalin.gui.swing.model;

import de.softwartechnik.catalin.core.model.Flight;
import de.softwartechnik.catalin.gui.service.LanguageService;
import java.util.List;
import javax.inject.Inject;
import javax.swing.table.DefaultTableModel;

public class FlightsTableModel extends DefaultTableModel {

  private static final String[] COLUMNS = {"flights.tablemodel.id",
      "flights.tablemodel.title",
      "flights.tablemodel.departure",
      "flights.tablemodel.destination",
      "flights.tablemodel.airplane"};
  private final LanguageService languageService;

  @Inject
  public FlightsTableModel(List<Flight> flights, LanguageService languageService) {
    this.languageService = languageService;
    for (String column : COLUMNS) {
      addColumn(languageService.translate(column));
    }

    flights.forEach(this::addFlight);
  }

  public void addFlight(Flight flight) {

    addRow(convert(flight));
  }

  public void removeFlight(int rowNum) {

    removeRow(rowNum);
  }

  private Object[] convert(Flight flight) {

    return new Object[]{flight.getId(), flight.getTitle(), flight.getSource().getName(),
        flight.getDestination().getName(), flight.getPlane().getName()};
  }
}
