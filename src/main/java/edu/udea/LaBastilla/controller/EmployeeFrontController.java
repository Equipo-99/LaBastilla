//Aquí inician los import
package edu.udea.LaBastilla.controller;
import edu.udea.LaBastilla.enums.Enum_RoleName;
import edu.udea.LaBastilla.model.Employee;
import edu.udea.LaBastilla.services.ServicesEmployeeInterface;
import edu.udea.LaBastilla.services.ServicesEnterpriseInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//Aquí finalizan los import

/*CONTROLADOR PARA CONECTAR EL BACKEND CON EL FRONTEND DEL
 * EMPLEADO*/

@Controller
public class EmployeeFrontController {

    //Controlador AUTOWIRED para conectar, a través de la interfaz, con la case empleado
    @Autowired
    private ServicesEmployeeInterface servicesEmployee;
    
    //Controlador AUTOWIRED para conectar, a través de la interfaz, con la case empresa
    @Autowired
    private ServicesEnterpriseInterface servicesEnterprise;    

    //Controlador para ver todos los empleados
    @GetMapping("/allusers")
    public String getEmployees(Model model){
        model.addAttribute("allusers", servicesEmployee.getEmployees());
        return "allusers";
    }

    //Controlador para redireccionar a la página para crear un nuevo empleado
    @GetMapping("/allusers/new")
    public String setEmployee(Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("Enum_RoleName", Enum_RoleName.values());
        model.addAttribute("enterprises", servicesEnterprise.getEnterprises());
        return "newUser";
    }

    //Controlador para crear un nuevo empleado
    @PostMapping("/allusers/new")
    public String postEmployee(@ModelAttribute("employee") Employee employee){
        try {
            String mensaje = servicesEmployee.setEmployee(employee);
            return "redirect:/allusers";
        }
        catch (Exception e) {
            return "redirect:/error";
        }
    }

    //Controlador para redireccionar a la página para actualizar entradas de usuarios
    @GetMapping("/allusers/edit")
    public String getUpdateForm(Model model){
        return "updateEmployee";
    }

    //Controlador para retornar el usuario que se quiere editar
    @GetMapping("/allusers/edit/{id}")
    public String getEmployee(@PathVariable Long id, Model model){
        try {
            model.addAttribute("employeeUpdated", servicesEmployee.getEmployee(id));
            model.addAttribute("Enum_RoleName", Enum_RoleName.values());
            model.addAttribute("enterprises", servicesEnterprise.getEnterprises());
            return "updateEmployee";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    //Controlador para actualizar el usuario seleccionado
    @PutMapping("/allusers/edit")
    public String putEmployee(@ModelAttribute("employeeUpdated") Employee employee){
        try {
            servicesEmployee.updateEmployee(employee, employee.getId());
            return "redirect:/allusers";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    //Controlador para eliminar un empleado
    @DeleteMapping("/allusers/del/{id}")
    public String deleteEmployee(@PathVariable Long id, Model model){
        servicesEmployee.deleteEmployee(id);
        return "redirect:/allusers";
    }

}
