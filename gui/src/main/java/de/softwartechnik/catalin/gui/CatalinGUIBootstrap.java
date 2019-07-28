package de.softwartechnik.catalin.gui;

import de.softwartechnik.catalin.core.config.CatalinCoreConfig;
import de.softwartechnik.catalin.core.config.CatalinCoreConfigBuilder;
import de.softwartechnik.catalin.core.config.CatalinPersistenceMode;
import java.util.Locale;

public class CatalinGUIBootstrap {

  private static final CatalinCoreConfig CATALIN_CORE_CONFIG = new CatalinCoreConfigBuilder()
      .setPersistenceMode(CatalinPersistenceMode.SQLITE)
      .createCatalinCoreConfig();

  public static void main(String[] args) {

    Locale.setDefault(Locale.ENGLISH);

    CatalinGUIFactory factory = new CatalinGuiceGUIFactory();

    CatalinGUI catalinGUI = factory.createCatalinGUI(CATALIN_CORE_CONFIG, CatalinGUIs.SWING);
    catalinGUI.initialize();
  }
}
