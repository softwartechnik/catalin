package de.softwartechnik.catalin.gui.swing.view.persons;

import de.softwartechnik.catalin.core.model.Person;
import de.softwartechnik.catalin.gui.swing.model.CatalinGUIViewFlightsTableModel;
import de.softwartechnik.catalin.gui.swing.model.CatalinGUIViewPersonsTableModel;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.util.List;

public class CatalinGUIViewPersonsTable extends JTable {

    public CatalinGUIViewPersonsTable(List<Person> persons) {

        getTableHeader().setReorderingAllowed(true);
        getTableHeader().setResizingAllowed(true);

        TableModel model = new CatalinGUIViewPersonsTableModel(persons);
        setModel(model);
    }
}
