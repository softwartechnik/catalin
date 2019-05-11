package de.softwartechnik.catalin.gui.swing.model;

import de.softwartechnik.catalin.core.model.Flight;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CatalinGUIViewFlightsTableModel extends AbstractTableModel {

    private static final String[] COLUMNS = { "Id", "Titel", "Start", "Ziel", "Flugzeug" };
    private final List<Flight> flights;

    public CatalinGUIViewFlightsTableModel(List<Flight> flights) {

        this.flights = flights;
    }

    @Override
    public int getRowCount() {

        return flights.size();
    }

    @Override
    public int getColumnCount() {

        return COLUMNS.length;
    }

    @Override
    public String getColumnName(int column) {

        return COLUMNS[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        // Get flight
        Flight flight = flights.get(rowIndex);

        switch (columnIndex) {
            case 0: {
                return flight.getId();
            }
            case 1: {
                return flight.getTitle();
            }
            case 2: {
                return flight.getSource().getName();
            }
            case 3: {
                return flight.getDestination().getName();
            }
            case 4: {
                return flight.getPlane().getName();
            }
            default: {
                throw new IllegalStateException();
            }
        }
    }
}
