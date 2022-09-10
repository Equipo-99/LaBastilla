package edu.udea.LaBastilla.services;

import edu.udea.LaBastilla.model.Enterprise;
import edu.udea.LaBastilla.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServicesEnterprise implements ServicesEnterpriseInterface {
    @Autowired
    private EnterpriseRepository repository;

    @Override
    public List<Enterprise> getEnterprises() {
        return repository.findAll();
    }

    @Override
    public Enterprise getEnterprise(Long id) throws Exception {
        Optional<Enterprise> enterpriseDB = repository.findById(id);
        if (enterpriseDB.isPresent()){
            return enterpriseDB.get();
        }
        throw new Exception("Empresa no existe");
    }

    @Override
    public String setEnterprise(Enterprise newEnterprise) {
        repository.save(newEnterprise);
        return "Empresa creada exitosamente";
    }

    @Transactional
    @Override
    public Enterprise updateEnterpriseAll(Enterprise enterpriseUpdated, Long id) {
        return repository.save(enterpriseUpdated);
    }

    @Override
    public Enterprise updateEnterprise(Enterprise enterpriseUpdated, Long id) throws Exception {
        Enterprise enterpriseDB = getEnterprise(id);

        if (enterpriseUpdated.getName() != null && !enterpriseUpdated.getName().equals("")){
            enterpriseDB.setName(enterpriseUpdated.getName());
        }
        if (enterpriseUpdated.getDocument() != null && !enterpriseUpdated.getDocument().equals("")){
            enterpriseDB.setDocument(enterpriseUpdated.getDocument());
        }
        if (enterpriseUpdated.getPhone() != null && !enterpriseUpdated.getPhone().equals("")){
            enterpriseDB.setPhone(enterpriseUpdated.getPhone());
        }
        if (enterpriseUpdated.getAddress() != null && !enterpriseUpdated.getAddress().equals("")){
            enterpriseDB.setAddress(enterpriseUpdated.getAddress());
        }
        if (enterpriseUpdated.getUsers() != null){
            enterpriseDB.setUsers(enterpriseUpdated.getUsers());
        }
        enterpriseDB.setUpdatedAt(new Date());
        return repository.save(enterpriseDB);
    }

    @Override
    public String deleteEnterprise(Long id) {
        repository.deleteById(id);
        return "Empresa eliminada exitosamente";
    }
}
