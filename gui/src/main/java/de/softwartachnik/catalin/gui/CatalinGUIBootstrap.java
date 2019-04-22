package de.softwartachnik.catalin.gui;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.softwartachnik.catalin.gui.module.CatalinGUIModule;

public class CatalinGUIBootstrap {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new CatalinGUIModule());
        CatalinGUI catalinGUI = injector.getInstance(CatalinGUI.class);

        catalinGUI.initialize();
    }
}
