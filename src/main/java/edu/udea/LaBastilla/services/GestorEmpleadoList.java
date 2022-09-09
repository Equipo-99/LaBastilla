package edu.udea.LaBastilla.services;

import edu.udea.LaBastilla.enums.Enum_RoleName;
import edu.udea.LaBastilla.model.Employee;
import org.springframework.stereotype.Service;


import java.util.ArrayList;


@Service
public class GestorEmpleadoList {
    private ArrayList<Employee> employees;

    public GestorEmpleadoList(ArrayList<Employee> empleados) {
        this.employees = new ArrayList<>();
        this.employees.add(new Employee("PersonaUno", "personauno@gmail.com",
                 null, Enum_RoleName.Administrador));
        this.employees.add(new Employee("PersonaDos", "personados@gmail.com",
                 null, Enum_RoleName.Operario));
    }

    public Employee getEmployee (String nombreEmpleado) throws Exception {
        for (Employee employee: this.employees){
            if (employee.getName().equals(nombreEmpleado)){
                return employee;
            }
        }
        throw new Exception("El usuario no existe");
    }

    public String setEmployee (Employee employee) throws Exception {

        try {
            getEmployee(employee.getName());
        } catch (Exception e) {
            this.employees.add(employee);
            return "Usuario creado exitosamente";
        }
        throw new Exception("El usuario ya existe");
    }

    public Employee updateEmployeeAll(Employee employeeUpdated, String id) throws Exception {
        try {
            Employee employeeDB = getEmployee(id);

            employeeDB.setId(employeeUpdated.getId());
            employeeDB.setName(employeeUpdated.getName());
            employeeDB.setEmail(employeeUpdated.getEmail());
            //employeeDB.setEnterprise(employeeUpdated.getEnterprise());
            employeeDB.setRole(employeeUpdated.getRole());
            //employeeDB.setTransactions(employeeUpdated.getTransactions());
            employeeDB.setCreatedAt(employeeUpdated.getCreatedAt());
            employeeDB.setUpdatedAt(employeeUpdated.getUpdatedAt());
            return employeeDB;
        } catch (Exception e) {
            throw new Exception("El usuario no existe. Falló la actualización de datos");
        }
    }

    public Employee updateEmployee(Employee employeeUpdated, String id) throws Exception {
        try {
            Employee employeeDB = getEmployee(id);
            if (employeeUpdated.getName() != null && !employeeUpdated.getName().equals("")){
                employeeDB.setName(employeeUpdated.getName());
            }
            if (employeeUpdated.getEmail() != null && !employeeUpdated.getEmail().equals("")){
                employeeDB.setEmail(employeeUpdated.getEmail());
            }
            if (employeeUpdated.getRole() != null){
                employeeDB.setRole(employeeUpdated.getRole());
            }
            //if (employeeUpdated.getTransactions() != null){
            //    employeeDB.setTransactions(employeeUpdated.getTransactions());
            //}
            if (employeeUpdated.getCreatedAt() != null){
                employeeDB.setCreatedAt(employeeUpdated.getCreatedAt());
            }
            if (employeeUpdated.getUpdatedAt() != null){
                employeeDB.setUpdatedAt(employeeUpdated.getUpdatedAt());
            }
            return employeeDB;
        } catch (Exception e) {
            throw new Exception("El usuario no existe. Falló la actualización de datos");
        }
    }

    public String deleteEmpleado(String id) throws Exception {
        try {
            Employee employee = getEmployee(id);
            this.employees.remove(employee);
            return "Usuario eliminado exitosamente";
        } catch (Exception e) {
            throw new Exception("El usuario no existe. Falló la eliminación de usuario");
        }
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
}
