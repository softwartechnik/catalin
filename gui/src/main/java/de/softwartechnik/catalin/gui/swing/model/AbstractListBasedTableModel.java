package de.softwartechnik.catalin.gui.swing.model;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public abstract class AbstractListBasedTableModel<ContentType> extends AbstractTableModel {

    private final List<ContentType> content;

    public AbstractListBasedTableModel(List<ContentType> content) {
        this.content = content;
    }

    @Override
    public int getRowCount() {

        return content.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        ContentType entity = content.get(rowIndex);
        return getEntityProperty(entity, columnIndex);
    }

    abstract Object getEntityProperty(ContentType entity, int columnIndex);

    @Override
    public abstract String getColumnName(int index);
}
