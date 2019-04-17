package de.softwartechnik.catalin.core.module;

import com.google.inject.AbstractModule;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;
import de.softwartechnik.catalin.core.repository.PersonJPARepository;
import de.softwartechnik.catalin.core.repository.PersonRepository;
import de.softwartechnik.catalin.core.service.CatalinPersonService;
import de.softwartechnik.catalin.core.service.PersonService;

import javax.inject.Inject;

/**
 * The central guice module.
 */
public class CatalinCoreModule extends AbstractModule {

    @Override
    protected void configure() {

        install(new JpaPersistModule("catalinPersistence"));
        bind(HibernateInitializer.class).asEagerSingleton();

        bind(PersonRepository.class).to(PersonJPARepository.class);
        bind(PersonService.class).to(CatalinPersonService.class).asEagerSingleton();
    }

    private static class HibernateInitializer {

        @Inject
        public HibernateInitializer(PersistService persistService) {
            persistService.start();
        }
    }
}
