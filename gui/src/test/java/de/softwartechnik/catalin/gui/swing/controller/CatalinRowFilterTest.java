package de.softwartechnik.catalin.gui.swing.controller;

import de.softwartechnik.catalin.core.model.CatalinModel;
import de.softwartechnik.catalin.core.repository.map.AbstractMapRepository;
import de.softwartechnik.catalin.gui.swing.model.BookingsTableModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class CatalinRowFilterTest {

    private static final String SEARCH = "3";
    CatalinRowFilter rowFilter;
    @BeforeEach
    void setUp() {
      rowFilter = new CatalinRowFilter(SEARCH);
    }

    @Test
    void include() {
    }
}