package de.softwartachnik.catalin.gui.module;

import com.google.inject.AbstractModule;
import de.softwartachnik.catalin.gui.CatalinGUI;
import de.softwartachnik.catalin.gui.CatalinGUIBootstrap;
import de.softwartachnik.catalin.gui.swing.CatalinSwingGUI;
import de.softwartechnik.catalin.core.config.CatalinCoreConfig;
import de.softwartechnik.catalin.core.module.CatalinCoreModule;

public class CatalinGUIModule extends AbstractModule {

    private final CatalinCoreConfig catalinCoreConfig;

    public CatalinGUIModule(CatalinCoreConfig catalinCoreConfig) {
        this.catalinCoreConfig = catalinCoreConfig;
    }

    @Override
    protected void configure() {

        // Install core module
        install(new CatalinCoreModule(catalinCoreConfig));

        bind(CatalinGUI.class).to(CatalinSwingGUI.class);
    }
}
