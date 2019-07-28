package de.softwartechnik.catalin.core.config;

public class CatalinCoreConfigBuilder {

  private CatalinPersistenceMode persistenceMode;

  public CatalinCoreConfigBuilder setPersistenceMode(CatalinPersistenceMode persistenceMode) {
    this.persistenceMode = persistenceMode;
    return this;
  }

  public CatalinCoreConfig createCatalinCoreConfig() {
    return new CatalinCoreConfig(persistenceMode);
  }
}
