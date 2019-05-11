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

public class MapPersistenceModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(PersonRepository.class).to(PersonMapRepository.class);
        bind(AirlineRepository.class).to(AirlineMapRepository.class);
        bind(AirportRepository.class).to(AirportMapRepository.class);
        bind(BookingRepository.class).to(BookingMapRepository.class);
        bind(BookingExtraRepository.class).to(BookingExtraMapRepository.class);
        bind(EmployeeRepository.class).to(EmployeeMapRepository.class);
        bind(FlightRepository.class).to(FlightMapRepository.class);
        bind(PlaneRepository.class).to(PlaneMapRepository.class);
    }
}
