package edu.udea.LaBastilla.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import edu.udea.LaBastilla.model.Enterprise;
import edu.udea.LaBastilla.services.ServicesEnterpriseInterface;

@Controller
public class FrontEndController {

    @Autowired
    private ServicesEnterpriseInterface servicesEnterpriseInterface;

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    //Controlador para crear una nueva empresa
    @PostMapping("/enterprise/new")
    public String postEnterprise(@ModelAttribute("enterprise") Enterprise enterprise){      
        try {
            String mensaje = servicesEnterpriseInterface.setEnterprise(enterprise);
            return "redirect:/empresasTabla";
        } 
        catch (Exception e) {
            return "redirect:/error";
        }
    }
    
}
