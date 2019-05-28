package de.softwartechnik.catalin.gui;

import de.softwartechnik.catalin.core.config.CatalinCoreConfig;

public interface CatalinGUIFactory {

    CatalinGUI createCatalinGUI(CatalinCoreConfig coreConfig, CatalinGUIs gui);
}
