//Aquí inician los import
package edu.udea.LaBastilla.services;
import edu.udea.LaBastilla.model.Employee;
import edu.udea.LaBastilla.model.MyUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
//Aquí finalizan los import

/*CLASE AUXILIAR DE LA CONFIGURACIÓN DE SEGURIDAD PARA EL LOGIN*/

@Service
public class MyUserDetailService implements UserDetailsService {

    //Variable de apoyo para la interfaz de servicios deL empleado
    @Autowired
    ServicesEmployeeInterface servicesEmployeeInterface;

    //Método sobreescrito para obtener el empleado dado su email
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            //Se obtiene un usuario dado el email proporcionado
            Employee user = servicesEmployeeInterface.getEmployeeByEmail(email);
            return new MyUserDetail(user);
        } 
        catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}
