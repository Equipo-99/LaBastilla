//Aquí inician los import
package edu.udea.LaBastilla.services;
import edu.udea.LaBastilla.model.Enterprise;
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
    ServicesEnterpriseInterface servicesEnterpriseInterface;

    //Método sobreescrito para obtener la empresa dada su ID
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            long id = Long.parseLong(username);
            Enterprise user = servicesEnterpriseInterface.getEnterprise(id);
            return new MyUserDetail(user);
        } 
        catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}
