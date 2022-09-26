//Aquí inician los import
package edu.udea.LaBastilla.services;
import edu.udea.LaBastilla.model.Employee;
import java.util.List;
//Aquí finalizan los import

/*CLASE DE INTERFAZ PARA EL EMPLEADO */

public interface ServicesEmployeeInterface {
    public List<Employee> getEmployees();
    public Employee getEmployee(Long id) throws Exception;
    public Employee getEmployeeByEmail(String email) throws Exception;
    public String setEmployee(Employee newEmployee);
    public Employee updateEmployee(Employee employeeUpdated, Long id) throws Exception;
    public String deleteEmployee(Long id);
}
