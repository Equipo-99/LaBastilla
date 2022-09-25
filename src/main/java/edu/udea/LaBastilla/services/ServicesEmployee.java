//Aquí inician los import
package edu.udea.LaBastilla.services;
import edu.udea.LaBastilla.model.Employee;
import edu.udea.LaBastilla.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;
//Aquí finalizan los import

/*CLASE DE SERVICIOS PARA EL EMPLEADO, SE CONECTA CON LA INTERFAZ */

@Service
public class ServicesEmployee implements ServicesEmployeeInterface {

    //Variable de conexión al repositorio del empleado
    @Autowired
    private EmployeeRepository repository;    

    //Método para obtener todos los empleados con JPA
    @Override
    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    //Método para obtener un empleado dado su ID con JPA
    @Override
    public Employee getEmployee(Long id) throws Exception {
        Optional<Employee> employeeDB = repository.findById(id);
        if (employeeDB.isPresent())
            return employeeDB.get();
        throw new Exception("Usuario no existe");
    }

    //Método para crear un nuevo empleado con JPA
    @Override
    public String setEmployee(Employee newEmployee) {
        repository.save(newEmployee);
        return "Usuario creado exitosamente";
    }

    //Método para actualizar algunos de los atributos del empleado dada su ID con JPA
    @Override
    public Employee updateEmployee(Employee employeeUpdated, Long id) throws Exception {
        Employee employeeDB = getEmployee(id);

        if (employeeUpdated.getName() != null && !employeeUpdated.getName().equals(""))
            employeeDB.setName(employeeUpdated.getName());
        
        if (employeeUpdated.getEmail() != null && !employeeUpdated.getEmail().equals(""))
            employeeDB.setEmail(employeeUpdated.getEmail());

        if (employeeUpdated.getProfile() != null)
            employeeDB.setProfile(employeeUpdated.getProfile());
        
        if (employeeUpdated.getEnterprise() != null)
            employeeDB.setEnterprise(employeeUpdated.getEnterprise());
        
        if (employeeUpdated.getRole() != null) 
            employeeDB.setRole(employeeUpdated.getRole());
        
        employeeDB.setUpdatedAt(new Date());
        return repository.save(employeeDB);
    }

    //Método para eliminar un empleado dada su ID con JPA
    @Override
    public String deleteEmployee(Long id) {
        repository.deleteById(id);
        return "Usuario eliminado exitosamente";
    }
}
