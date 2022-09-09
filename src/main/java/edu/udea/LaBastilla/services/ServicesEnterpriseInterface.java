package edu.udea.LaBastilla.services;

import edu.udea.LaBastilla.model.Enterprise;

import java.util.List;

public interface ServicesEnterpriseInterface {
    public List<Enterprise> getEnterprises();
    public Enterprise getEnterprise(Long id) throws Exception;
    public String setEnterprise(Enterprise newEnterprise);
    public Enterprise updateEnterpriseAll(Enterprise enterpriseUpdated, Long id);
    public Enterprise updateEnterprise(Enterprise enterpriseUpdated, Long id) throws Exception;
    public String deleteEnterprise(Long id);
}
