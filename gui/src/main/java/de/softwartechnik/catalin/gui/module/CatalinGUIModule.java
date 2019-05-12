package de.softwartechnik.catalin.gui.module;

import com.google.inject.AbstractModule;
import de.softwartechnik.catalin.gui.CatalinGUI;
import de.softwartechnik.catalin.gui.swing.CatalinSwingGUI;
import de.softwartechnik.catalin.core.config.CatalinCoreConfig;
import de.softwartechnik.catalin.core.module.CatalinCoreModule;

public class CatalinGUIModule extends AbstractModule {

    private final CatalinCoreConfig catalinCoreConfig;

    public CatalinGUIModule(CatalinCoreConfig catalinCoreConfig) {
        this.catalinCoreConfig = catalinCoreConfig;
    }

    @Override
    protected void configure() {

        bind(CatalinCoreConfig.class).toInstance(catalinCoreConfig);

        // Install core module
        install(new CatalinCoreModule(catalinCoreConfig));

        bind(CatalinGUI.class).to(CatalinSwingGUI.class);
    }
}
