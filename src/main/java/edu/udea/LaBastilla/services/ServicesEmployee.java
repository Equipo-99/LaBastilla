package edu.udea.LaBastilla.services;

import edu.udea.LaBastilla.model.Employee;
import edu.udea.LaBastilla.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServicesEmployee implements ServicesEmployeeInterface {
    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployee(Long id) throws Exception {
        Optional<Employee> employeeDB = repository.findById(id);
        if (employeeDB.isPresent()){
            return employeeDB.get();
        }
        throw new Exception("Usuario no existe");
    }

    @Override
    public String setEmployee(Employee newEmployee) {
        repository.save(newEmployee);
        return "Usuario creado exitosamente";
    }

    @Transactional
    @Override
    public Employee updateEmployeeAll(Employee employeeUpdated, Long id) {
        return repository.save(employeeUpdated);
    }

    @Override
    public Employee updateEmployee(Employee employeeUpdated, Long id) throws Exception {
        Employee employeeDB = getEmployee(id);

        if (employeeUpdated.getName() != null && !employeeUpdated.getName().equals("")){
            employeeDB.setName(employeeUpdated.getName());
        }
        if (employeeUpdated.getEmail() != null && !employeeUpdated.getEmail().equals("")){
            employeeDB.setEmail(employeeUpdated.getEmail());
        }
        //if (employeeUpdated.getEnterprise() != null){
        //    employeeDB.setEnterprise(employeeUpdated.getEnterprise());
        //}
        if (employeeUpdated.getRole() != null) {
            employeeDB.setRole(employeeUpdated.getRole());
        }
        employeeDB.setUpdatedAt(new Date());
        return repository.save(employeeDB);
    }

    @Override
    public String deleteEmployee(Long id) {
        repository.deleteById(id);
        return "Usuario eliminado exitosamente";
    }
}
