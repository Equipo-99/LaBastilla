package edu.udea.LaBastilla.controller;

import edu.udea.LaBastilla.model.Employee;
import edu.udea.LaBastilla.model.ObjetoRespuesta;
import edu.udea.LaBastilla.services.GestorEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorEmpleado {
    @Autowired
    private GestorEmpleado gestorEmpleado;

    @GetMapping("/users")
    public ResponseEntity<ArrayList<Employee>> getEmpleados(){
        return new ResponseEntity<>(gestorEmpleado.getEmployees(), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Object> getEmpleadoPath(@PathVariable String id){
        try {
            Employee employee = gestorEmpleado.getEmployee(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<String> postEmpleado(@RequestBody Employee employee){
        try {
            String mensaje = gestorEmpleado.setEmployee(employee);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<ObjetoRespuesta> putEmpleado(@RequestBody Employee employeeUpdated, @PathVariable String id){
        try {
            Employee employeeDB = gestorEmpleado.updateEmployeeAll(employeeUpdated, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualización exitosa", employeeDB), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/user/{id}")
    public ResponseEntity<ObjetoRespuesta> patchEmpleado(@RequestBody Employee employeeUpdated, @PathVariable String id){
        try {
            Employee employeeDB = gestorEmpleado.updateEmployee(employeeUpdated, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualización exitosa", employeeDB), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<ObjetoRespuesta> deleteEmpleado(@PathVariable String id){
        try {
            String mensaje = gestorEmpleado.deleteEmpleado(id);
            return new ResponseEntity<>(new ObjetoRespuesta(mensaje, null), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
