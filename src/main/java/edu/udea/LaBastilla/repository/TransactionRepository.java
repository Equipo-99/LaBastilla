package edu.udea.LaBastilla.repository;

import edu.udea.LaBastilla.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("SELECT t from Transaction t WHERE employee_id = :id")
    public List<Transaction> findByEmployee(Long id);

    @Query("SELECT t from Transaction t WHERE enterprise_id = :id")
    public List<Transaction> findbyEnterprise(Long id);
}
