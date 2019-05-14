package de.softwartechnik.catalin.gui;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.softwartechnik.catalin.gui.module.CatalinGUIModule;
import de.softwartechnik.catalin.core.config.CatalinCoreConfig;
import de.softwartechnik.catalin.core.config.CatalinCoreConfigBuilder;
import de.softwartechnik.catalin.core.config.CatalinPersistenceMode;

public class CatalinGUIBootstrap {

    private static final CatalinCoreConfig CATALIN_CORE_CONFIG = new CatalinCoreConfigBuilder()
            .setPersistenceMode(CatalinPersistenceMode.MAP)
            .createCatalinCoreConfig();

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new CatalinGUIModule(CATALIN_CORE_CONFIG));
        CatalinGUI catalinGUI = injector.getInstance(CatalinGUI.class);

        catalinGUI.initialize();
    }
}
