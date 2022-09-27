//Aquí inician los import
package edu.udea.LaBastilla.services;
import edu.udea.LaBastilla.model.Transaction;
import edu.udea.LaBastilla.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//Aquí finalizan los import

/*CLASE DE SERVICIOS PARA LAS TRANSACCIONES, SE CONECTA CON LA INTERFAZ */

@Service
public class ServicesTransaction {

    //Variable de conexión al repositorio de los movimientos
    @Autowired
    private TransactionRepository repository;

    //Método para obtener todas las transacciones
    public List<Transaction> getTransactions() {
        return repository.findAll(Sort.by("id"));
    }

    //Método para obtener todas las transacciones dada la ID del empleado
    public List<Transaction> findByEmployee(Long id) {
        return repository.findByEmployee(id);
    }

    //Método para obtener todas las transacciones dada la ID de la empresa
    public List<Transaction> findByEnterprise(Long id) {
        return repository.findbyEnterprise(id);
    }

    //Método para obtener un movimiento dado su ID con JPA
    public Transaction getTransaction(Long id) throws Exception {
        Optional<Transaction> transactionDB = repository.findById(id);
        if (transactionDB.isPresent())
            return transactionDB.get();
        throw new Exception("Transacción no existe");
    }

    //Método para crear un nuevo movimiento con JPA
    public String setTransaction(Transaction newTransaction) {
        repository.save(newTransaction);
        return "Transacción creada exitosamente";
    }        

    //Método para actualizar algunos de los atributos de un movimiento dada su ID con JPA
    public Transaction updateTransaction(Transaction transactionUpdated, Long id) throws Exception {
        Transaction transactionDB = getTransaction(id);

        if (transactionUpdated.getConcept() != null && !transactionUpdated.getConcept().equals(""))
            transactionDB.setConcept(transactionUpdated.getConcept());
        
        if (transactionUpdated.getAmount() != 0.0)
            transactionDB.setAmount(transactionUpdated.getAmount());
        
        if (transactionUpdated.getEnterprise() != null)
            transactionDB.setEnterprise(transactionUpdated.getEnterprise());
        
        if (transactionUpdated.getEmployee() != null)
            transactionDB.setEmployee(transactionUpdated.getEmployee());

        return repository.save(transactionDB);
    }

    //Método para eliminar un empleado dada su ID con JPA
    public String deleteTransactions() {
        repository.deleteAll();
        return "Transacciones eliminada exitosamente";
    }

    public String deleteTransaction(Long id) {
        repository.deleteById(id);
        return "Transacción eliminado exitosamente";
    }

}
