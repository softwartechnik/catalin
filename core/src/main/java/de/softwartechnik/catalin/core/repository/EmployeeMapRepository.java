package de.softwartechnik.catalin.core.repository;

import de.softwartechnik.catalin.core.model.Airline;
import de.softwartechnik.catalin.core.model.Employee;
import de.softwartechnik.catalin.core.repository.map.AbstractMapRepository;

import javax.inject.Inject;

public class EmployeeMapRepository extends AbstractMapRepository<Employee> implements EmployeeRepository {

    /**
     * The class of the entity.
     */
    private static final Class<Employee> ENTITY_CLAZZ = Employee.class;

    @Inject
    public EmployeeMapRepository() {
        super(ENTITY_CLAZZ);
    }
}
