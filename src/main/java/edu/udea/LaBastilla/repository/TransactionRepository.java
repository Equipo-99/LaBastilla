package edu.udea.LaBastilla.repository;

import edu.udea.LaBastilla.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    //@Query("SELECT * from Transaction WHERE employee_id= ?")
    //public List<Transaction> findByEmployee(Long id);

    //@Query("SELECT * from Transaction WHERE employee_id in (SELECT id from employee where enterprise_id = ?")
    //public List<Transaction> findbyEnterprise(Long id);
}
