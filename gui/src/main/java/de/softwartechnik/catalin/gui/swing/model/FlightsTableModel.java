package de.softwartechnik.catalin.gui.swing.model;

import de.softwartechnik.catalin.core.model.Flight;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class FlightsTableModel extends DefaultTableModel {

    private static final String[] COLUMNS = { "Id", "Titel", "Start", "Ziel", "Flugzeug" };

    public FlightsTableModel(List<Flight> flights) {

        for (String column : COLUMNS) {
            addColumn(column);
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

        return new Object[] { flight.getId(), flight.getTitle(), flight.getSource().getName(), flight.getDestination().getName(), flight.getPlane().getName() };
    }
}
