package edu.udea.LaBastilla.controller;

import edu.udea.LaBastilla.model.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.udea.LaBastilla.model.ObjetoRespuesta;
import edu.udea.LaBastilla.services.GestorEmpresa;

import java.util.ArrayList;

@RestController
public class ControladorEmpresa {
    @Autowired
    private GestorEmpresa gestorEmpresa;

    @GetMapping("/enterprises")
    public ResponseEntity<ArrayList<Enterprise>> getEmpresas(){
        return new ResponseEntity<>(gestorEmpresa.getEmpresas(), HttpStatus.OK);
    }

    @GetMapping("/enterprises/{id}")
    public ResponseEntity<Object> getEmpresaPath(@PathVariable String id){
        try {
            Enterprise enterprise = gestorEmpresa.getEmpresa(id);
            return new ResponseEntity<>(enterprise,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/enterprises")
    public ResponseEntity<String> postEmpresa(@RequestBody Enterprise enterpriseParametro){
        try {
            String mensaje = gestorEmpresa.setEmpresa(enterpriseParametro);
            return new ResponseEntity<>(mensaje,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/enterprises/{id}")
    public ResponseEntity<ObjetoRespuesta> putEmpresa(@RequestBody Enterprise enterpriseUpdate, @PathVariable String id){
        try {
            Enterprise enterpriseGuardada = gestorEmpresa.updateEmpresaAll(enterpriseUpdate, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualizacion exitosa", enterpriseGuardada),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/enterprises/{id}")
    public ResponseEntity<ObjetoRespuesta> patchEmpresa(@RequestBody Enterprise enterpriseUpdate, @PathVariable String id){
        try {
            Enterprise enterpriseGuardada = gestorEmpresa.updateEmpresa(enterpriseUpdate, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualizacion exitosa", enterpriseGuardada),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/enterprises/{id}")
    public ResponseEntity<ObjetoRespuesta> deleteEmpresa(@PathVariable String id){
        try {
            String mensaje = gestorEmpresa.deleteEmpresa(id);
            return new ResponseEntity<>(new ObjetoRespuesta(mensaje,null),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

