//Aquí inician los import
package edu.udea.LaBastilla.services;
import edu.udea.LaBastilla.model.Enterprise;
import java.util.List;
//Aquí finalizan los import

/*CLASE DE INTERFAZ PARA LA EMPRESA*/

public interface ServicesEnterpriseInterface {
    public List<Enterprise> getEnterprises();
    public Enterprise getEnterprise(Long id) throws Exception;
    public String setEnterprise(Enterprise newEnterprise);
    public Enterprise updateEnterpriseAll(Enterprise enterpriseUpdated, Long id);
    public Enterprise updateEnterprise(Enterprise enterpriseUpdated, Long id) throws Exception;
    public String deleteEnterprise(Long id);
}
