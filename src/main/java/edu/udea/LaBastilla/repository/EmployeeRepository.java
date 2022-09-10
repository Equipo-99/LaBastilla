//Aquí inician los import
package edu.udea.LaBastilla.repository;
import edu.udea.LaBastilla.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Aquí finalizan los import

/*CLASE DE INTERFAZ PARA EL EMPLEADO */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {}
