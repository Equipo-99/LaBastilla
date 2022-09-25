//Aquí inician los import
package edu.udea.LaBastilla.model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
//Aquí finalizan los import

import edu.udea.LaBastilla.enums.Enum_RoleName;

/*CLASE MODELO PARA LOS DETALLES DEL USUARIO. NECESARIA PARA LA
 * CONFIGURACIÓN DE SEGURIDAD*/

public class MyUserDetail implements UserDetails{

    private String username;
    private String password;
    private List<GrantedAuthority> authorities;
    private Employee id;

    public MyUserDetail(Profile profile){
        this.username = profile.getId();
        this.password = profile.getId();

        this.id = profile.getEmployee();
        List<GrantedAuthority> roles = new ArrayList<>();
        for(Enum_RoleName rol: this.id.getRole())
            roles.add(new SimpleGrantedAuthority(rol.name()));     
        this.authorities = roles; 
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
