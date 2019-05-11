package de.softwartechnik.catalin.core.config;

public class CatalinCoreConfig {

    private final CatalinPersistenceMode persistenceMode;

    public CatalinCoreConfig(CatalinPersistenceMode persistenceMode) {
        this.persistenceMode = persistenceMode;
    }

    public CatalinPersistenceMode getPersistenceMode() {
        return persistenceMode;
    }
}
