package org.agrokhotov.spring.rest.controller;

import org.agrokhotov.spring.rest.entity.Employee;
import org.agrokhotov.spring.rest.exceptions.NoSuchEmployeeException;
import org.agrokhotov.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);

        if (employee == null) {
            throw new NoSuchEmployeeException("no employee with id " + id + " found");
        }

        return employeeService.getEmployee(id);
    }

    @PostMapping("/employees/")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);

        if (employee == null) {
            throw new NoSuchEmployeeException("no employee with id " + id + " found");
        }

        employeeService.deleteEmployee(id);
        return "Employee with id " + id + " was deleted";
    }
}
