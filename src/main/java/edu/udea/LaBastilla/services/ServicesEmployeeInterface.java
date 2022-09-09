package edu.udea.LaBastilla.services;

import edu.udea.LaBastilla.model.Employee;

import java.util.List;

public interface ServicesEmployeeInterface {
    public List<Employee> getEmployees();
    public Employee getEmployee(Long id) throws Exception;
    public String setEmployee(Employee newEmployee);
    public Employee updateEmployeeAll(Employee employeeUpdated, Long id);
    public Employee updateEmployee(Employee employeeUpdated, Long id) throws Exception;
    public String deleteEmployee(Long id);
}
