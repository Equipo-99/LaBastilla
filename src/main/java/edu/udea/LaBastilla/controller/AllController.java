package edu.udea.LaBastilla.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import edu.udea.LaBastilla.model.Employee;

@Controller
public class AllController {

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("employee", new Employee());
        return "login";
    }

    //Controlador para redireccionar a la página de inicio
    @GetMapping("/")
    public String getIndex(){
        return "index";
    }
    
}
