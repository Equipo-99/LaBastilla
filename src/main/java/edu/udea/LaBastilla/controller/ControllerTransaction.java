//Aquí inician los import
package edu.udea.LaBastilla.controller;
import edu.udea.LaBastilla.model.ObjetoRespuesta;
import edu.udea.LaBastilla.model.Transaction;
import edu.udea.LaBastilla.services.ServicesTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
//Aquí finalizan los import

/*CLASE DE CONTROLADOR PARA EL MODELO EMPRESA. SE CUENTA CON LOS
 * CONTROLADORES GET (PARA TODAS LAS EMPRESAS Y PARA UNA SOLA), POST
 * PUT, PATCH Y DELETE*/

@RestController
public class ControllerTransaction {

    //Controlador AUTOWIRED para conectar, a través de la interfaz, con la case transacciones
    @Autowired
    private ServicesTransaction servicesTransaction;

    //Controlador GET para obtener los datos de todos los movimientos registradas dada la ID del empleado
    @GetMapping("/users/{id}/movements")
    public ResponseEntity<Object> getTransactionsbyEmployee(@PathVariable Long id){
        try {
            List<Transaction> transactions = servicesTransaction.findByEmployee(id);
            return new ResponseEntity<>(transactions, HttpStatus.OK);
        } 
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Controlador GET para obtener los datos de todos los movimientos registradas dada la ID de la emrpresa
    @GetMapping("/enterprises/{id}/movements")
    public ResponseEntity<Object> getTransactionsbyEnterprise(@PathVariable Long id){
        try {
            List<Transaction> transactions = servicesTransaction.findByEnterprise(id);
            return new ResponseEntity<>(transactions, HttpStatus.OK);
        } 
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Controlador POST para crear un movimiento asociado a una empresa dado el ID
    @PostMapping("/enterprises/{id}/movements")
    public ResponseEntity<String> postTransaction(@RequestBody Transaction transaction, @PathVariable Long id){
        try {
            String mensaje = servicesTransaction.setTransaction(transaction);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        } 
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Controlador PATCH para actualizar algunos atributos del movimiento dada el ID de la empresa
    @PatchMapping("/enterprises/{id}/movements")
    public ResponseEntity<ObjetoRespuesta> patchTransaction(@RequestBody Transaction transactionUpdated, @PathVariable Long id){
        try {
            Transaction transactionDB = servicesTransaction.updateTransaction(transactionUpdated, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualización exitosa", transactionDB), HttpStatus.OK);
        } 
        catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Controlador DELETE para eliminar un movimiento dada la ID de la empresa
    @DeleteMapping("/enterprises/{id}/movements")
    public ResponseEntity<ObjetoRespuesta> deleteTransactions(@PathVariable Long id){
        try {
            String mensaje = servicesTransaction.deleteTransactions();
            return new ResponseEntity<>(new ObjetoRespuesta(mensaje, null), HttpStatus.OK);
        } 
        catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
