package de.softwartechnik.catalin.gui.swing.controller;

import de.softwartechnik.catalin.gui.swing.model.BookingsTableModel;

import javax.swing.*;

public class CatalinRowFilter<BookingsTableModel, Object> extends RowFilter {

    private String searchWord;

    public CatalinRowFilter(String searchWord) {
        this.searchWord = searchWord;
    }

    @Override
    public boolean include(Entry entry) {
        if (searchWord.isEmpty()) {
            return true;
        }

        Object value = (Object) entry.getValue(0);
        return value.toString().equalsIgnoreCase(searchWord);
    }
    }

