//Aquí inician los import
package edu.udea.LaBastilla.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import edu.udea.LaBastilla.model.Enterprise;
import edu.udea.LaBastilla.services.ServicesEnterpriseInterface;
//Aquí finalizan los import

/*CLASE DE CONTROLADOR PARA LA CONEXIÓN CON EL FRONTEND DE LA
 * EMPRESA*/

@Controller
public class EnterpriseFrontController {

    //Variable de apoyo para la interfaz de servicios de la empresa
    @Autowired
    private ServicesEnterpriseInterface servicesEnterprise;

    //Controlador para redireccionar a la página de inicio
    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    //Controlador para crear una nueva empresa
    @PostMapping("/enterprise/new")
    public String postEnterprise(@ModelAttribute("enterprise") Enterprise enterprise){      
        try {
            String mensaje = servicesEnterprise.setEnterprise(enterprise);
            return "tableEnterprises";
        } 
        catch (Exception e) {
            return "redirect:/error";
        }
    }

    //Controlador para redireccionar a la página de crear nueva empresa
    @GetMapping("/enterprise/new")
    public String setEnterprise(Model model){
        model.addAttribute("enterprise", new Enterprise());
        return "newEnterprise";
    }

    //Controlador para redireccionar a la página de ver todas las empresas
    @GetMapping("/enterprises")
    public String getEnterprises(Model model){
        model.addAttribute("enterprises", servicesEnterprise.getEnterprises());
        return "enterprises";
    }
    
}
