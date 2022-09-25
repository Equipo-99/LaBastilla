package edu.udea.LaBastilla.security;

import edu.udea.LaBastilla.services.ServiceProfileInterface;
import edu.udea.LaBastilla.services.ServicesEmployeeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.webservices.WebServicesProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SuccessGoogle implements AuthenticationSuccessHandler {
    @Autowired
    ServicesEmployeeInterface servicesEmployee;
    ServiceProfileInterface serviceProfile;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        DefaultOidcUser user = (DefaultOidcUser) authentication.getPrincipal();
        System.out.println(user);
        String correoUser = user.getEmail();
        System.out.println(correoUser + " Correo Google!!!");
        try {
            serviceProfile.getProfile(correoUser);
            response.sendRedirect("/");
        } catch (Exception e) {
            e.printStackTrace();
            new SecurityContextLogoutHandler().logout(request,response,authentication);
            //logout
            //response.sendRedirect("/login");

        }
    }

}