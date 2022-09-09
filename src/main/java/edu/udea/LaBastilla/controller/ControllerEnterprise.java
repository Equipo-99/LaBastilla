package edu.udea.LaBastilla.controller;

import edu.udea.LaBastilla.model.Enterprise;
import edu.udea.LaBastilla.services.ServicesEnterpriseInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.udea.LaBastilla.model.ObjetoRespuesta;

import java.util.List;

@RestController
public class ControllerEnterprise {
    @Autowired
    private ServicesEnterpriseInterface servicesEnterprise;

    @GetMapping("/enterprises")
    public ResponseEntity<List<Enterprise>> getEmpresas(){
        return new ResponseEntity<>(servicesEnterprise.getEnterprises(), HttpStatus.OK);
    }

    @GetMapping("/enterprises/{id}")
    public ResponseEntity<Object> getEmpresaPath(@PathVariable Long id){
        try {
            Enterprise enterprise = servicesEnterprise.getEnterprise(id);
            return new ResponseEntity<>(enterprise,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/enterprises")
    public ResponseEntity<String> postEmpresa(@RequestBody Enterprise enterprise){
        try {
            String mensaje = servicesEnterprise.setEnterprise(enterprise);
            return new ResponseEntity<>(mensaje,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/enterprises/{id}")
    public ResponseEntity<ObjetoRespuesta> putEmpresa(@RequestBody Enterprise enterpriseUpdated, @PathVariable Long id){
        try {
            Enterprise enterpriseGuardada = servicesEnterprise.updateEnterpriseAll(enterpriseUpdated, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualizacion exitosa", enterpriseGuardada),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/enterprises/{id}")
    public ResponseEntity<ObjetoRespuesta> patchEmpresa(@RequestBody Enterprise enterpriseUpdated, @PathVariable Long id){
        try {
            Enterprise enterpriseGuardada = servicesEnterprise.updateEnterprise(enterpriseUpdated, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualizacion exitosa", enterpriseGuardada),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/enterprises/{id}")
    public ResponseEntity<ObjetoRespuesta> deleteEmpresa(@PathVariable Long id){
        try {
            String mensaje = servicesEnterprise.deleteEnterprise(id);
            return new ResponseEntity<>(new ObjetoRespuesta(mensaje,null),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

