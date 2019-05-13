package de.softwartechnik.catalin.gui.swing.model;

import de.softwartechnik.catalin.core.model.Person;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractListBasedTableModel<ContentType> extends AbstractTableModel {

    private final List<ContentType> content;

    public AbstractListBasedTableModel(List<ContentType> content) {
        this.content = content;
    }

    public AbstractListBasedTableModel() {
        this(new ArrayList<>());
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

    public void clear() {
        content.clear();
        fireTableDataChanged();
    }

    public void addEntities(List<ContentType> entities) {
        content.addAll(entities);
        fireTableDataChanged();
    }

    public void removeEntity(ContentType entity) {
        content.remove(entity);
        fireTableDataChanged();
    }

    public void removeEntities(List<ContentType> entities) {
        content.removeAll(entities);
        fireTableDataChanged();
    }

    @Override
    public abstract String getColumnName(int index);
}
