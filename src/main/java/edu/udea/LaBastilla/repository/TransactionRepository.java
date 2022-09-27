//Aquí inician los import
package edu.udea.LaBastilla.repository;
import edu.udea.LaBastilla.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
//Aquí inician los import

/*CLASE DE INTERFAZ PARA LAS TRANSACCIONES CON JPA*/

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    //Método Query para encontrar una transacción dada la ID del empleado
    @Query("SELECT t from Transaction t WHERE employee_id = :id")
    public List<Transaction> findByEmployee(Long id);

    //Método Query para encontrar una transacción dada la ID de la empresa
    @Query("SELECT t from Transaction t WHERE enterprise_id = :id")
    public List<Transaction> findbyEnterprise(Long id);
}
