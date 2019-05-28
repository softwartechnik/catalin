package de.softwartechnik.catalin.gui;

import de.softwartechnik.catalin.gui.swing.CatalinSwingGUI;

public enum CatalinGUIs {

    SWING(CatalinSwingGUI.class);

    private final Class<? extends CatalinGUI> implementation;

    CatalinGUIs(Class<? extends CatalinGUI> implementation) {
        this.implementation = implementation;
    }

    public Class<? extends CatalinGUI> getImplementation() {
        return implementation;
    }
}
