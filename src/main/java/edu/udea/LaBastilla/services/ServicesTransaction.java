package edu.udea.LaBastilla.services;

import edu.udea.LaBastilla.model.Transaction;
import edu.udea.LaBastilla.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServicesTransaction {
    @Autowired
    private TransactionRepository repository;

    public List<Transaction> getTransactions() {
        return repository.findAll();
    }

    public Transaction getTransaction(Long id) throws Exception {
        Optional<Transaction> transactionDB = repository.findById(id);
        if (transactionDB.isPresent()){
            return transactionDB.get();
        }
        throw new Exception("Transacción no existe");
    }

    public String setTransaction(Transaction newTransaction) {
        repository.save(newTransaction);
        return "Transacción creada exitosamente";
    }

    @Transactional
    public Transaction updateTransactionAll(Transaction transactionUpdated) {
        return repository.save(transactionUpdated);
    }

    public Transaction updateTransaction(Transaction transactionUpdated, Long id) throws Exception {
        Transaction transactionDB = getTransaction(id);

        if (transactionUpdated.getConcept() != null && !transactionUpdated.getConcept().equals("")){
            transactionDB.setConcept(transactionUpdated.getConcept());
        }
        if (transactionUpdated.getAmount() != 0.0){
            transactionDB.setAmount(transactionUpdated.getAmount());
        }
        //if (transactionUpdated.getEnterprise() != null){
        //    transactionDB.setEnterprise(transactionUpdated.getEnterprise());
        //}
        //if (transactionUpdated.getEmployee() != null){
        //    transactionDB.setEmployee(transactionUpdated.getEmployee());
        //}
        transactionDB.setUpdatedAt(new Date());
        return repository.save(transactionDB);
    }

    public String deleteTransaction(Long id) {
        repository.deleteById(id);
        return "Transacción eliminada exitosamente";
    }

    //public List<Transaction> findByEmployee(Long id) {
    //    return repository.findByEmployee(id);
    //}

    //public List<Transaction> findByEnterprise(Long id) {
    //    return repository.findbyEnterprise(id);
    //}
}
