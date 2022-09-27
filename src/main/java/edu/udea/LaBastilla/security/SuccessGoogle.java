//Aquí inician los import
package edu.udea.LaBastilla.security;
import edu.udea.LaBastilla.services.ServicesEmployeeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//Aquí finalizan los import

/*CLASE PARA MANEJAR EL CORRECTO LOGIN USANDO LOS
 * SERVICIOS PROPORCIONADOS POR GOOGLE*/

@Component
public class SuccessGoogle implements AuthenticationSuccessHandler {

    //Variable de apoyo para la interfaz de servicios deL empleado
    @Autowired
    ServicesEmployeeInterface servicesEmployee;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        
        //Se obtiene el usuario y el correo proporcionado por Google
        DefaultOidcUser user = (DefaultOidcUser) authentication.getPrincipal();
        String userEmail = user.getEmail();
        System.out.println(userEmail);

        try {
            //Se compara el email del usuario con el email de Google
            servicesEmployee.getEmployeeByEmail(userEmail);
            response.sendRedirect("/");
        } 
        catch (Exception e) {
            e.printStackTrace();
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
    }

}
