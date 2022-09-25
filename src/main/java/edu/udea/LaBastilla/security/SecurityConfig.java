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

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    SuccessGoogle successGoogle;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder getPassowrdEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login*").permitAll()
                .antMatchers("/oauth/**").permitAll()

                .and()

                .formLogin()
                .loginPage("/login")
                .usernameParameter("id")
                .passwordParameter("id")
                .defaultSuccessUrl("/")
    

                .and()
                .oauth2Login()
                .loginPage("/login")
                .successHandler(successGoogle)

                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
            ;           

        http.csrf().disable();
    }    
}
