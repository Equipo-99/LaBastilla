package edu.udea.LaBastilla.controller;

import edu.udea.LaBastilla.model.Transaction;
import edu.udea.LaBastilla.services.ServicesEmployeeInterface;
import edu.udea.LaBastilla.services.ServicesEnterpriseInterface;
import edu.udea.LaBastilla.services.ServicesTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TransactionFrontController {
    @Autowired
    private ServicesTransaction servicesTransaction;

    @Autowired
    private ServicesEmployeeInterface servicesEmployee;

    @Autowired
    private ServicesEnterpriseInterface servicesEnterprise;

    // Ver todas las transacciones
    @GetMapping("/transactions")
    public String getTransactions(Model model){
        model.addAttribute("transactions", servicesTransaction.getTransactions());
        return "transactions";
    }

    // Ver página para crear una nueva transacción
    @GetMapping("/transactions/new")
    public String setTransaction(Model model){
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("employees", servicesEmployee.getEmployees());
        model.addAttribute("enterprises", servicesEnterprise.getEnterprises());
        return "newTransaction";
    }

    // Crear nueva transacción
    @PostMapping("/transactions/new")
    public String postTransaction(@ModelAttribute("transaction") Transaction transaction){
        try {
            String mensaje = servicesTransaction.setTransaction(transaction);
            return "redirect:/transactions";
        }
        catch (Exception e) {
            return "redirect:/error";
        }
    }

    // Ver página para actualizar entradas de transacciones
    @GetMapping("/transactions/edit")
    public String getUpdateForm(Model model){
        return "updateTransaction";
    }

    // Retornar la transacción que se quiere editar
    @GetMapping("transactions/edit/{id}")
    public String getTransaction(@PathVariable Long id, Model model){
        try {
            model.addAttribute("transactionUpdated", servicesTransaction.getTransaction(id));
            model.addAttribute("employees", servicesEmployee.getEmployees());
            model.addAttribute("enterprises", servicesEnterprise.getEnterprises());
            return "updateTransaction";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    // Actualizar la transacción seleccionada
    @PutMapping("transactions/edit")
    public String putTransaction(@ModelAttribute("transactionUpdated") Transaction transaction){
        try {
            servicesTransaction.updateTransaction(transaction, transaction.getId());
            return "redirect:/transactions";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    // Eliminar una transacción
    @DeleteMapping("/transactions/del/{id}")
    public String deleteTransaction(@PathVariable Long id, Model model){
        servicesTransaction.deleteTransaction(id);
        return "redirect:/transactions";
    }
}
