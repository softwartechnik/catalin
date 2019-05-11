package de.softwartachnik.catalin.gui.swing;

import javax.swing.*;

class TablePanel extends JScrollPane {

    TablePanel(String[] columns, String[][] items) {

        JTable table = new JTable(new MyTableModel(columns, items));

        add(table);
        setViewportView(table);
    }
}
