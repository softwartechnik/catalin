package de.softwartachnik.catalin.gui.swing;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {

    private final String[] columns;
    private final String[][] items;

    MyTableModel(String[] columns, String[][] items) {
        this.columns = columns;
        this.items = items;
    }

    public int getColumnCount() {
        return columns.length;
    }

    public int getRowCount() {
        return items.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    public Object getValueAt(int row, int col) {
        return items[row][col];
    }
}
