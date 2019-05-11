package de.softwartechnik.catalin.gui.swing.view.flights;

import de.softwartechnik.catalin.core.model.Flight;
import de.softwartechnik.catalin.gui.swing.model.CatalinGUIViewFlightsTableModel;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.util.List;

public class CatalinGUIViewFlightsTable extends JTable {

    public CatalinGUIViewFlightsTable(List<Flight> flights) {

        getTableHeader().setReorderingAllowed(true);
        getTableHeader().setResizingAllowed(true);

        TableModel model = new CatalinGUIViewFlightsTableModel(flights);
        setModel(model);
    }
}
