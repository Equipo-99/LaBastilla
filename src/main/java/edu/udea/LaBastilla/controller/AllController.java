//Aquí inician los import
package edu.udea.LaBastilla.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import edu.udea.LaBastilla.model.Employee;
//Aquí finalizan los import

/*CONTROLADOR PARA CONECTAR EL BACKEND CON EL FRONTEND EN
 * SUS DOS PÁGINAS MÁS ELEMENTALES*/

@Controller
public class AllController {

    //Controlador para redireccionar a la página de login
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
