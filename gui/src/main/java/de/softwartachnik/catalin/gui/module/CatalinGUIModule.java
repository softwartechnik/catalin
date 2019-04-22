package de.softwartachnik.catalin.gui.module;

import com.google.inject.AbstractModule;
import de.softwartachnik.catalin.gui.CatalinGUI;
import de.softwartachnik.catalin.gui.swing.CatalinSwingGUI;
import de.softwartechnik.catalin.core.module.CatalinCoreModule;

public class CatalinGUIModule extends AbstractModule {

    @Override
    protected void configure() {

        // Install core module
        install(new CatalinCoreModule());

        bind(CatalinGUI.class).to(CatalinSwingGUI.class);
    }
}
