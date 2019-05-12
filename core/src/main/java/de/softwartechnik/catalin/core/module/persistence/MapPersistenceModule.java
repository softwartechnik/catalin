package de.softwartechnik.catalin.core.module.persistence;

import com.google.inject.AbstractModule;
import de.softwartechnik.catalin.core.repository.AirlineMapRepository;
import de.softwartechnik.catalin.core.repository.AirlineRepository;
import de.softwartechnik.catalin.core.repository.AirportMapRepository;
import de.softwartechnik.catalin.core.repository.AirportRepository;
import de.softwartechnik.catalin.core.repository.BookingExtraMapRepository;
import de.softwartechnik.catalin.core.repository.BookingExtraRepository;
import de.softwartechnik.catalin.core.repository.BookingMapRepository;
import de.softwartechnik.catalin.core.repository.BookingRepository;
import de.softwartechnik.catalin.core.repository.EmployeeMapRepository;
import de.softwartechnik.catalin.core.repository.EmployeeRepository;
import de.softwartechnik.catalin.core.repository.FlightMapRepository;
import de.softwartechnik.catalin.core.repository.FlightRepository;
import de.softwartechnik.catalin.core.repository.PersonMapRepository;
import de.softwartechnik.catalin.core.repository.PersonRepository;
import de.softwartechnik.catalin.core.repository.PlaneMapRepository;
import de.softwartechnik.catalin.core.repository.PlaneRepository;
import de.softwartechnik.catalin.core.repository.TerminalMapRepository;
import de.softwartechnik.catalin.core.repository.TerminalRepository;

public class MapPersistenceModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(PersonRepository.class).to(PersonMapRepository.class).asEagerSingleton();
        bind(AirlineRepository.class).to(AirlineMapRepository.class).asEagerSingleton();
        bind(AirportRepository.class).to(AirportMapRepository.class).asEagerSingleton();
        bind(BookingRepository.class).to(BookingMapRepository.class).asEagerSingleton();
        bind(BookingExtraRepository.class).to(BookingExtraMapRepository.class).asEagerSingleton();
        bind(EmployeeRepository.class).to(EmployeeMapRepository.class).asEagerSingleton();
        bind(FlightRepository.class).to(FlightMapRepository.class).asEagerSingleton();
        bind(PlaneRepository.class).to(PlaneMapRepository.class).asEagerSingleton();
        bind(TerminalRepository.class).to(TerminalMapRepository.class).asEagerSingleton();
    }
}
