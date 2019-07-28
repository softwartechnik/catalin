package de.softwartechnik.catalin.gui;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.softwartechnik.catalin.core.config.CatalinCoreConfig;
import de.softwartechnik.catalin.gui.module.CatalinGUIModule;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class CatalinGuiceGUIFactory implements CatalinGUIFactory {

  private static final String PROPERTIES_PATH_NAME = "config.properties";
  private static final Path PROPERTIES_PATH = Paths.get(PROPERTIES_PATH_NAME);

  @Override
  public CatalinGUI createCatalinGUI(CatalinCoreConfig coreConfig, CatalinGUIs gui) {

    Properties properties = new Properties();

    if (!Files.exists(PROPERTIES_PATH)) {
      try (InputStream resourceAsStream = getClass().getClassLoader()
          .getResourceAsStream(PROPERTIES_PATH_NAME)) {
        byte[] buffer = new byte[resourceAsStream.available()];
        resourceAsStream.read(buffer);
        Files.write(PROPERTIES_PATH, buffer);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    try (InputStream inputStream = Files.newInputStream(PROPERTIES_PATH)) {
      properties.load(inputStream);
      System.out.println(properties.get("language"));
    } catch (IOException e) {
      e.printStackTrace();
    }

    Injector injector = Guice.createInjector(new CatalinGUIModule(properties, coreConfig));
    return injector.getInstance(CatalinGUI.class);
  }
}
