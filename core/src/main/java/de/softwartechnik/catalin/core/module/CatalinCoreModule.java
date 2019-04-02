package de.softwartechnik.catalin.core.module;

import com.google.inject.AbstractModule;
import de.softwartechnik.catalin.core.service.LocalPersonService;
import de.softwartechnik.catalin.core.service.PersonService;

public class CatalinCoreModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(PersonService.class).to(LocalPersonService.class).asEagerSingleton();
    }
}
