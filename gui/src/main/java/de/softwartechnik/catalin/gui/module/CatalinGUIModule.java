package de.softwartechnik.catalin.gui.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import de.softwartechnik.catalin.gui.CatalinGUI;
import de.softwartechnik.catalin.gui.swing.CatalinSwingGUI;
import de.softwartechnik.catalin.core.config.CatalinCoreConfig;
import de.softwartechnik.catalin.core.module.CatalinCoreModule;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.ResourceBundle;

public class CatalinGUIModule extends AbstractModule {

    private static final String RESOURCE_BUNDLE_NAME = "catalin";
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

    @Provides
    @Singleton
    @Named("i18n")
    public ResourceBundle provideI18nResourceBundle() {

        return ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME);
    }
}
