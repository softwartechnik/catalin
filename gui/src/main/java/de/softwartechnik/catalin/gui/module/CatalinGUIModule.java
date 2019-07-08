package de.softwartechnik.catalin.gui.module;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import de.softwartechnik.catalin.core.config.CatalinCoreConfig;
import de.softwartechnik.catalin.core.module.CatalinCoreModule;
import de.softwartechnik.catalin.gui.CatalinGUI;
import de.softwartechnik.catalin.gui.service.LanguageService;
import de.softwartechnik.catalin.gui.service.LanguageServiceImpl;
import de.softwartechnik.catalin.gui.swing.CatalinSwingGUI;

import java.util.Properties;

public class CatalinGUIModule extends AbstractModule {

    private final Properties properties;
    private final CatalinCoreConfig catalinCoreConfig;

    public CatalinGUIModule(Properties properties, CatalinCoreConfig catalinCoreConfig) {
        this.properties = properties;
        this.catalinCoreConfig = catalinCoreConfig;
    }

    @Override
    protected void configure() {

        Names.bindProperties(binder(), properties);

        bind(CatalinCoreConfig.class).toInstance(catalinCoreConfig);

        // Install core module
        install(new CatalinCoreModule(catalinCoreConfig));

        bind(CatalinGUI.class).to(CatalinSwingGUI.class);

        bind(LanguageService.class).to(LanguageServiceImpl.class);
    }
}
