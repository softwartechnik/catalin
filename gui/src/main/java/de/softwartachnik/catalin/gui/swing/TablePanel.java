package de.softwartachnik.catalin.gui.swing;

import javax.swing.*;

public class TablePanel extends JScrollPane {

    public TablePanel(String[] columns, String[][] items){

        JTable table = new JTable(new MyTableModel(columns, items));
        this.add(table);
        this.setViewportView(table);
    }
}
