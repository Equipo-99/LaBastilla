package edu.udea.LaBastilla.controller;

import edu.udea.LaBastilla.services.ServicesTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransactionFrontController {
    @Autowired
    private ServicesTransaction servicesTransaction;

    @GetMapping("/transactions")
    public String getTransactions(Model model){
        model.addAttribute("transactions", servicesTransaction.getTransactions());
        return "transactions";
    }
}
