package de.softwartechnik.catalin.gui.swing;

import de.softwartechnik.catalin.gui.CatalinGUI;
import de.softwartechnik.catalin.gui.swing.controller.CatalinGUIController;

import javax.inject.Inject;

public class CatalinSwingGUI implements CatalinGUI {

    private final CatalinGUIController controller;

    @Inject
    public CatalinSwingGUI(CatalinGUIController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize() {
        controller.showOverview();
    }
}
