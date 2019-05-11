package de.softwartechnik.catalin.core.module.persistence;

import com.google.inject.AbstractModule;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;
import de.softwartechnik.catalin.core.repository.AirlineJPARepository;
import de.softwartechnik.catalin.core.repository.AirlineRepository;
import de.softwartechnik.catalin.core.repository.AirportJPARepository;
import de.softwartechnik.catalin.core.repository.AirportRepository;
import de.softwartechnik.catalin.core.repository.BookingExtraJPARepository;
import de.softwartechnik.catalin.core.repository.BookingExtraRepository;
import de.softwartechnik.catalin.core.repository.BookingJPARepository;
import de.softwartechnik.catalin.core.repository.BookingRepository;
import de.softwartechnik.catalin.core.repository.EmployeeJPARepository;
import de.softwartechnik.catalin.core.repository.EmployeeRepository;
import de.softwartechnik.catalin.core.repository.FlightJPARepository;
import de.softwartechnik.catalin.core.repository.FlightRepository;
import de.softwartechnik.catalin.core.repository.PersonJPARepository;
import de.softwartechnik.catalin.core.repository.PersonRepository;
import de.softwartechnik.catalin.core.repository.PlaneJPARepository;
import de.softwartechnik.catalin.core.repository.PlaneRepository;
import de.softwartechnik.catalin.core.service.AirlineService;
import de.softwartechnik.catalin.core.service.CatalinAirlineService;
import de.softwartechnik.catalin.core.service.CatalinPersonService;
import de.softwartechnik.catalin.core.service.PersonService;

import javax.inject.Inject;

public class SQLPersistenceModule extends AbstractModule {

    @Override
    protected void configure() {

        install(new JpaPersistModule("catalinPersistence"));

        bind(HibernateInitializer.class).asEagerSingleton();

        bind(PersonRepository.class).to(PersonJPARepository.class);
        bind(AirlineRepository.class).to(AirlineJPARepository.class);
        bind(AirportRepository.class).to(AirportJPARepository.class);
        bind(BookingRepository.class).to(BookingJPARepository.class);
        bind(BookingExtraRepository.class).to(BookingExtraJPARepository.class);
        bind(EmployeeRepository.class).to(EmployeeJPARepository.class);
        bind(FlightRepository.class).to(FlightJPARepository.class);
        bind(PlaneRepository.class).to(PlaneJPARepository.class);
    }

    private static class HibernateInitializer {

        @Inject
        public HibernateInitializer(PersistService persistService) {
            persistService.start();
        }
    }
}
