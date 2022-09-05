package edu.udea.LaBastilla.controlador;
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

    @GetMapping("/enterprise/{nameEmpresa}")
    public ResponseEntity<Object> getUsuario(@PathVariable String nameEmpresa){
        try {
            Enterprise enterprise = gestorEmpresa.getEmpresa(nameEmpresa);
            return new ResponseEntity<>(enterprise,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/enterprise")
    public ResponseEntity<String> postEmpresa(@RequestBody Enterprise enterpriseParametro){
        try {
            String mensaje = gestorEmpresa.setEmpresa(enterpriseParametro);
            return new ResponseEntity<>(mensaje,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/enterprise/{nameEmpresa}")
    public ResponseEntity<ObjetoRespuesta> putEmpresa(@RequestBody Enterprise enterpriseUpdate, @PathVariable String nameEmpresa){
        try {
            Enterprise enterpriseGuardada = gestorEmpresa.updateEmpresaAll(enterpriseUpdate,nameEmpresa);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualizacion exitosa", enterpriseGuardada),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/enterprise/{nameEmpresa}")
    public ResponseEntity<ObjetoRespuesta> patchEmpresa(@RequestBody Enterprise enterpriseUpdate, @PathVariable String nameEmpresa){
        try {
            Enterprise enterpriseGuardada = gestorEmpresa.updateEmpresa(enterpriseUpdate,nameEmpresa);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualizacion exitosa", enterpriseGuardada),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/enterprise/{nameEmpresa}")
    public ResponseEntity<ObjetoRespuesta> deleteEmpresa(@PathVariable String nameEmpresa){
        try {
            String mensaje = gestorEmpresa.deleteEmpresa(nameEmpresa);
            return new ResponseEntity<>(new ObjetoRespuesta(mensaje,null),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

