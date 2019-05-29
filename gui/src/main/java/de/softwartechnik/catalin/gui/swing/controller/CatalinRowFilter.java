package de.softwartechnik.catalin.gui.swing.controller;

import de.softwartechnik.catalin.gui.swing.model.BookingsTableModel;

import javax.swing.*;

public class CatalinRowFilter {

    public RowFilter getCatalinRowFilter(String searchWord) {

        RowFilter<BookingsTableModel, Object> rowFilter = new RowFilter<BookingsTableModel, Object>() {
            @Override
            public boolean include(Entry<? extends BookingsTableModel, ?> entry) {

                if (searchWord.isEmpty()) {
                    return true;
                }

                Object value = entry.getValue(0);
                return value.toString().equalsIgnoreCase(searchWord);
            }
        };

        return rowFilter;
    }
}
