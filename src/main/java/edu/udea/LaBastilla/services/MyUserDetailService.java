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

/*CLASE AUXILIAR DE LA CONFIGURACIÓN DE SEGURIDAD */

@Service
public class MyUserDetailService implements UserDetailsService {

    //Variable de apoyo para la interfaz de servicios de la empresa
    @Autowired
    ServicesEmployeeInterface servicesEmployeeInterface;

    //Método sobreescrito para obtener la empresa dada su ID
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            long id = Long.parseLong(username);
            Employee user = servicesEmployeeInterface.getEmployee(id);
            return new MyUserDetail(user);
        } 
        catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}
