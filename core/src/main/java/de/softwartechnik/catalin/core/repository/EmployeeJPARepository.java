package de.softwartechnik.catalin.core.repository;

import de.softwartechnik.catalin.core.model.Employee;
import de.softwartechnik.catalin.core.model.Person;
import de.softwartechnik.catalin.core.repository.jpa.AbstractJPARepository;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;

public class EmployeeJPARepository extends AbstractJPARepository<Employee> implements EmployeeRepository {

    /**
     * The class of the entity.
     */
    private static final Class<Employee> ENTITY_CLAZZ = Employee.class;

    @Inject
    public EmployeeJPARepository(Provider<EntityManager> entityManagerProvider) {
        super(ENTITY_CLAZZ, entityManagerProvider);
    }
}
