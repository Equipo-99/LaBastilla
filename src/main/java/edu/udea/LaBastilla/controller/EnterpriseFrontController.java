//Aquí inician los import
package edu.udea.LaBastilla.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    //Controlador para crear una nueva empresa
    @PostMapping("/enterprises/new")
    public String postEnterprise(@ModelAttribute("enterprise") Enterprise enterprise){      
        try {
            String mensaje = servicesEnterprise.setEnterprise(enterprise);
            return "redirect:/allenterprises";
        } 
        catch (Exception e) {
            return "redirect:/error";
        }
    }

    //Controlador para redireccionar a la página de crear nueva empresa
    @GetMapping("/enterprises/new")
    public String setEnterprise(Model model){
        model.addAttribute("enterprise", new Enterprise());
        return "newEnterprise";
    }

    //Controlador para redireccionar a la página de ver todas las empresas
    @GetMapping("/allenterprises")
    public String getEnterprises(Model model){
        model.addAttribute("enterprises", servicesEnterprise.getEnterprises());
        return "allenterprises";
    }

    //Controlador para redireccionar a la página para actualizar entradas de empresas
    @GetMapping("/enterprises/edit")
    public String getUpdateForm(Model model){
        return "updateEnterprise";
    }

    //Controlador para retornar la empresa que se quiere editar
    @GetMapping("enterprises/edit/{id}")
    public String getEnterprise(@PathVariable Long id, Model model){
        try {
            model.addAttribute("enterpriseUpdated", servicesEnterprise.getEnterprise(id));
            return "updateEnterprise";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    //Controlador para actualizar la empresa seleccionada
    @PutMapping("enterprises/edit")
    public String putEnterprise(@ModelAttribute("enterpriseUpdated") Enterprise enterprise){
        try {
            servicesEnterprise.updateEnterprise(enterprise, enterprise.getId());
            return "redirect:/allenterprises";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    //Método Delete para eliminar entradas de empresas desde el HTML (También se puede con @GetMapping y @PostMapping)
    @DeleteMapping("/enterprises/del/{id}")
    public String deleteEnterprise(@PathVariable Long id, Model model){
        servicesEnterprise.deleteEnterprise(id);
        return "redirect:/allenterprises";
    }
    
}
