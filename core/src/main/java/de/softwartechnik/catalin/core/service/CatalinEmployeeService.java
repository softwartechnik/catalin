package de.softwartechnik.catalin.core.service;

import de.softwartechnik.catalin.core.model.Employee;
import de.softwartechnik.catalin.core.repository.EmployeeRepository;
import java.util.List;
import javax.inject.Inject;

public class CatalinEmployeeService implements EmployeeService {

  private final EmployeeRepository employeeRepository;

  @Inject
  public CatalinEmployeeService(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public Employee getEmployee(long id) {

    return employeeRepository.find(id);
  }

  @Override
  public List<Employee> getEmployees() {

    return employeeRepository.findAll();
  }
}
