//Aquí inician los import
package edu.udea.LaBastilla.controller;
import edu.udea.LaBastilla.model.Employee;
import edu.udea.LaBastilla.model.ObjetoRespuesta;
import edu.udea.LaBastilla.services.ServicesEmployeeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
//Aquí finalizan los import


/*CLASE DE CONTROLADOR PARA EL MODELO EMPLEADO. SE CUENTA CON LOS
 * CONTROLADORES GET (PARA TODOS LOS EMPELADOS Y PARA UNO SOLO), POST
 * PUT, PATCH Y DELETE*/


@RestController
public class ControllerEmployee {

    //Controlador AUTOWIRED para conectar, a través de la interfaz, con la case empleado
    @Autowired
    private ServicesEmployeeInterface servicesEmployee;

    //Controlador GET para obtener los datos de todos los empleados registrados
    @GetMapping("/users")
    public ResponseEntity<List<Employee>> getEmpleados(){
        return new ResponseEntity<>(servicesEmployee.getEmployees(), HttpStatus.OK);
    }

    //Controlador GET para obtener los datos de un empleado dada su ID
    @GetMapping("/user/{id}")
    public ResponseEntity<Object> getEmpleadoPath(@PathVariable Long id){
        try {
            Employee employee = servicesEmployee.getEmployee(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } 
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Controlador POST para crear un empleado
    @PostMapping("/users")
    public ResponseEntity<String> postEmpleado(@RequestBody Employee employee){
        try {
            String mensaje = servicesEmployee.setEmployee(employee);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        } 
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    //Controlador PATCH para actualizar algunos atributos del empleado dada su ID
    @PatchMapping("/user/{id}")
    public ResponseEntity<ObjetoRespuesta> patchEmpleado(@RequestBody Employee employeeUpdated, @PathVariable Long id){
        try {
            Employee employeeDB = servicesEmployee.updateEmployee(employeeUpdated, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualización exitosa", employeeDB), HttpStatus.OK);
        } 
        catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Controlador DELETE para eliminar un empleado dada su ID
    @DeleteMapping("/user/{id}")
    public ResponseEntity<ObjetoRespuesta> deleteEmpleado(@PathVariable Long id){
        try {
            String mensaje = servicesEmployee.deleteEmployee(id);
            return new ResponseEntity<>(new ObjetoRespuesta(mensaje, null), HttpStatus.OK);
        } 
        catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
