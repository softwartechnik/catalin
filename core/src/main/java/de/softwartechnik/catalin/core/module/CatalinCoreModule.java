package de.softwartechnik.catalin.core.module;

import com.google.inject.AbstractModule;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;
import de.softwartechnik.catalin.core.config.CatalinCoreConfig;
import de.softwartechnik.catalin.core.config.CatalinPersistenceMode;
import de.softwartechnik.catalin.core.module.persistence.MapPersistenceModule;
import de.softwartechnik.catalin.core.module.persistence.SQLPersistenceModule;
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
import de.softwartechnik.catalin.core.service.AirportService;
import de.softwartechnik.catalin.core.service.BookingService;
import de.softwartechnik.catalin.core.service.CatalinAirlineService;
import de.softwartechnik.catalin.core.service.CatalinAirportService;
import de.softwartechnik.catalin.core.service.CatalinBookingService;
import de.softwartechnik.catalin.core.service.CatalinEmployeeService;
import de.softwartechnik.catalin.core.service.CatalinFlightService;
import de.softwartechnik.catalin.core.service.CatalinPersonService;
import de.softwartechnik.catalin.core.service.EmployeeService;
import de.softwartechnik.catalin.core.service.FlightService;
import de.softwartechnik.catalin.core.service.PersonService;

import javax.inject.Inject;

/**
 * The central guice module.
 */
public class CatalinCoreModule extends AbstractModule {

    private final CatalinCoreConfig coreConfig;

    public CatalinCoreModule(CatalinCoreConfig coreConfig) {
        this.coreConfig = coreConfig;
    }

    @Override
    protected void configure() {

        CatalinPersistenceMode persistenceMode = coreConfig.getPersistenceMode();

        switch (persistenceMode) {
            case SQL: {
                install(new SQLPersistenceModule());
                break;
            }
            default: {
                install(new MapPersistenceModule());
            }
        }

        bind(PersonService.class).to(CatalinPersonService.class).asEagerSingleton();
        bind(AirlineService.class).to(CatalinAirlineService.class).asEagerSingleton();
        bind(FlightService.class).to(CatalinFlightService.class).asEagerSingleton();
        bind(BookingService.class).to(CatalinBookingService.class).asEagerSingleton();
        bind(EmployeeService.class).to(CatalinEmployeeService.class).asEagerSingleton();
        bind(AirportService.class).to(CatalinAirportService.class).asEagerSingleton();
    }
}
