package de.softwartechnik.catalin.core.service;

import de.softwartechnik.catalin.core.model.Employee;

import java.util.List;

public interface EmployeeService {

    /**
     * Get the employee with the given ID.
     *
     * @param id The id.
     * @return The employee.
     */
    Employee getEmployee(long id);

    /**
     * Get all employees.
     *
     * @return The employees.
     */
    List<Employee> getEmployees();
}
