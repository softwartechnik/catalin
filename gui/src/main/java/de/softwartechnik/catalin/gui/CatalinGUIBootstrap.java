package de.softwartechnik.catalin.gui;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.softwartechnik.catalin.core.config.CatalinCoreConfig;
import de.softwartechnik.catalin.core.config.CatalinCoreConfigBuilder;
import de.softwartechnik.catalin.core.config.CatalinPersistenceMode;
import de.softwartechnik.catalin.gui.module.CatalinGUIModule;

public class CatalinGUIBootstrap {

    private static final CatalinCoreConfig CATALIN_CORE_CONFIG = new CatalinCoreConfigBuilder()
            .setPersistenceMode(CatalinPersistenceMode.SQLITE)
            .createCatalinCoreConfig();

    public static void main(String[] args) {
        CatalinGUIFactory factory = new CatalinGuiceGUIFactory();

        CatalinGUI catalinGUI = factory.createCatalinGUI(CATALIN_CORE_CONFIG, CatalinGUIs.SWING);
        catalinGUI.initialize();
    }
}
