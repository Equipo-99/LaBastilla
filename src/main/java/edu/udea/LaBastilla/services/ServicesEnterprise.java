//Aquí inician los import
package edu.udea.LaBastilla.services;
import edu.udea.LaBastilla.model.Enterprise;
import edu.udea.LaBastilla.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//Aquí finalizan los import

/*CLASE DE SERVICIOS PARA LA EMPRESA, SE CONECTA CON LA INTERFAZ */

@Service
public class ServicesEnterprise implements ServicesEnterpriseInterface {

    //Variable de conexión al repositorio de la empresa
    @Autowired
    private EnterpriseRepository repository;

    //Método para obtener todas las empresas con JPA
    @Override
    public List<Enterprise> getEnterprises() {
        return repository.findAll(Sort.by("id"));
    }

    //Método para obtener una empresa dado su ID con JPA
    @Override
    public Enterprise getEnterprise(Long id) throws Exception {
        Optional<Enterprise> enterpriseDB = repository.findById(id);
        if (enterpriseDB.isPresent())
            return enterpriseDB.get();
        throw new Exception("Empresa no existe");
    }

    //Método para crear una nueva empresa con JPA
    @Override
    public String setEnterprise(Enterprise newEnterprise) {
        repository.save(newEnterprise);
        return "Empresa creada exitosamente";
    }

    //Método para actualizar algunos de los atributos de la empresa dada su ID con JPA
    @Override
    public Enterprise updateEnterprise(Enterprise enterpriseUpdated, Long id) throws Exception {
        Enterprise enterpriseDB = getEnterprise(id);

        if (enterpriseUpdated.getName() != null && !enterpriseUpdated.getName().equals(""))
            enterpriseDB.setName(enterpriseUpdated.getName());
        
        if (enterpriseUpdated.getDocument() != null && !enterpriseUpdated.getDocument().equals(""))
            enterpriseDB.setDocument(enterpriseUpdated.getDocument());
        
        if (enterpriseUpdated.getPhone() != null && !enterpriseUpdated.getPhone().equals(""))
            enterpriseDB.setPhone(enterpriseUpdated.getPhone());
        
        if (enterpriseUpdated.getAddress() != null && !enterpriseUpdated.getAddress().equals(""))
            enterpriseDB.setAddress(enterpriseUpdated.getAddress());
        
        if (enterpriseUpdated.getUsers() != null)
            enterpriseDB.setUsers(enterpriseUpdated.getUsers());

        return repository.save(enterpriseDB);
    }

    //Método para eliminar una empresa dada su ID con JPA
    @Override
    public String deleteEnterprise(Long id) {
        repository.deleteById(id);
        return "Empresa eliminada exitosamente";
    }
}
