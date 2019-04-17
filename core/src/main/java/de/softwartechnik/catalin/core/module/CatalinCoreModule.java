package de.softwartechnik.catalin.core.module;

import com.google.inject.AbstractModule;
import de.softwartechnik.catalin.core.repository.PersonJPARepository;
import de.softwartechnik.catalin.core.repository.PersonRepository;
import de.softwartechnik.catalin.core.service.CatalinPersonService;
import de.softwartechnik.catalin.core.service.PersonService;

/**
 * The central guice module.
 */
public class CatalinCoreModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(PersonRepository.class).to(PersonJPARepository.class);
        bind(PersonService.class).to(CatalinPersonService.class).asEagerSingleton();
    }
}
