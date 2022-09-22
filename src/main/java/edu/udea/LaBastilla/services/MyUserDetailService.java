package edu.udea.LaBastilla.services;
import edu.udea.LaBastilla.model.Enterprise;
import edu.udea.LaBastilla.model.MyUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    ServicesEnterpriseInterface servicesEnterpriseInterface;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            long id = Long.parseLong(username);
            Enterprise user = servicesEnterpriseInterface.getEnterprise(id);
            return new MyUserDetail(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException(e.getMessage());
        }

    }
}
