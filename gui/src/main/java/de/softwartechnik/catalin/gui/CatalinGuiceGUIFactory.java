package de.softwartechnik.catalin.gui;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.softwartechnik.catalin.core.config.CatalinCoreConfig;
import de.softwartechnik.catalin.gui.module.CatalinGUIModule;

public class CatalinGuiceGUIFactory implements CatalinGUIFactory {

    @Override
    public CatalinGUI createCatalinGUI(CatalinCoreConfig coreConfig, CatalinGUIs gui) {

        Injector injector = Guice.createInjector(new CatalinGUIModule(coreConfig));
        return injector.getInstance(CatalinGUI.class);
    }
}
