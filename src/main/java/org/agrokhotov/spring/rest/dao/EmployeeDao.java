package org.agrokhotov.spring.rest.dao;

import org.agrokhotov.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);
}
