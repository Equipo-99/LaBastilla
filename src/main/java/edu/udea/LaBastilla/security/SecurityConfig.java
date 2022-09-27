//Aquí inician los import
package edu.udea.LaBastilla.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//Aquí finalizan los import

/*CLASE PARA EL CONTROL DE ACCESSO DE USUARIOS Y DEMÁS SEGURIDAD */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    //Variable que usa autowired para usar los servicios de Login
    @Autowired
    UserDetailsService userDetailsService;

    //Variable que usa autowired para conectar con el Login de Google
    @Autowired
    SuccessGoogle successGoogle;

    //Método sobreescrito de WebSecurityConfigureerAdapter
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService);
    }

    //Método Bean para el codificador de contraseña
    @Bean
    public PasswordEncoder getPassowrdEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                //Paths que son permitidos por cualquier usuario
                .antMatchers("/").permitAll()
                .antMatchers("/login*").permitAll()
                .antMatchers("/oauth/**").permitAll()

                .and()

                //Paths y atributos para el inicio de sesión
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("email")
                .defaultSuccessUrl("/")

                //Paths y argumentos para el inicio de sesión con Google
                .and()
                .oauth2Login()
                .loginPage("/login")
                .successHandler(successGoogle)

                //Paths y argumentos para el cierre de sesión
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");

        http.csrf().disable();
    }    
}
