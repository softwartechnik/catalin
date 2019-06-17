package de.softwartechnik.catalin.core.module;

import com.google.inject.AbstractModule;
import de.softwartechnik.catalin.core.config.CatalinCoreConfig;
import de.softwartechnik.catalin.core.config.CatalinPersistenceMode;
import de.softwartechnik.catalin.core.module.persistence.MapPersistenceModule;
import de.softwartechnik.catalin.core.module.persistence.SQLPersistenceModule;
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

/**
 * The central guice module.
 */
public class CatalinCoreModule extends AbstractModule {

    private static final String PERSISTENCE_UNIT_NAME_SQL = "catalinPersistence";
    private static final String PERSISTENCE_UNIT_LITE = "catalinPersistenceLite";

    private final CatalinCoreConfig coreConfig;

    public CatalinCoreModule(CatalinCoreConfig coreConfig) {
        this.coreConfig = coreConfig;
    }

    @Override
    protected void configure() {

        CatalinPersistenceMode persistenceMode = coreConfig.getPersistenceMode();

        switch (persistenceMode) {
            case SQL: {
                install(new SQLPersistenceModule(PERSISTENCE_UNIT_NAME_SQL));
                break;
            }
            case SQLITE: {
                install(new SQLPersistenceModule(PERSISTENCE_UNIT_LITE));
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
