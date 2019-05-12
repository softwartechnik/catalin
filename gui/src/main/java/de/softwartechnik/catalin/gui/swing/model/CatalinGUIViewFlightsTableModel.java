package de.softwartechnik.catalin.gui.swing.model;

import de.softwartechnik.catalin.core.model.Flight;

import java.util.List;

public class CatalinGUIViewFlightsTableModel extends AbstractListBasedTableModel<Flight> {

    private static final String[] COLUMNS = { "Id", "Titel", "Start", "Ziel", "Flugzeug" };

    public CatalinGUIViewFlightsTableModel(List<Flight> flights) {
        super(flights);
    }

    @Override
    Object getEntityProperty(Flight flight, int columnIndex) {

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
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override
    public int getColumnCount() {

        return COLUMNS.length;
    }

    @Override
    public String getColumnName(int column) {

        return COLUMNS[column];
    }
}
