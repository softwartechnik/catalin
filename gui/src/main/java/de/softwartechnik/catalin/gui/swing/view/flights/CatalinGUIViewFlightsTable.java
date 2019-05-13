package de.softwartechnik.catalin.gui.swing.view.flights;

import de.softwartechnik.catalin.core.model.Flight;
import de.softwartechnik.catalin.gui.swing.model.CatalinGUIViewFlightsTableModel;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.util.List;

public class CatalinGUIViewFlightsTable extends JTable {

    CatalinGUIViewFlightsTableModel model = new CatalinGUIViewFlightsTableModel();

    public CatalinGUIViewFlightsTable() {

        getTableHeader().setReorderingAllowed(true);
        getTableHeader().setResizingAllowed(true);
        setModel(model);
    }

    public void setFlights(List<Flight> flights) {

        model.clear();
        model.addEntities(flights);
    }
}
