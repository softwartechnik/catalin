package de.softwartechnik.catalin.gui.swing.view.persons;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CatalinGUIViewPersonsTable extends JTable{

    @Inject
    public CatalinGUIViewPersonsTable() {

        getTableHeader().setReorderingAllowed(true);
        getTableHeader().setResizingAllowed(true);


    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

}
