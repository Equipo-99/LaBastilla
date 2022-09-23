package edu.udea.LaBastilla.controller;

import edu.udea.LaBastilla.services.ServicesEmployeeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeFrontController {
    @Autowired
    private ServicesEmployeeInterface servicesEmployee;

    @GetMapping("/allusers")
    public String getEmployees(Model model){
        model.addAttribute("allusers", servicesEmployee.getEmployees());
        return "allusers";
    }

}
