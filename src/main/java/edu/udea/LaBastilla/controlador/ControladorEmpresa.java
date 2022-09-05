package edu.udea.LaBastilla.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.udea.LaBastilla.model.ObjetoRespuesta;
import edu.udea.LaBastilla.servicios.GestorEmpresa;
import edu.udea.LaBastilla.model.Empresa;
import java.util.ArrayList;

@RestController
public class ControladorEmpresa {
    @Autowired
    private GestorEmpresa gestorEmpresa;

    @GetMapping("/enterprises")
    public ResponseEntity<ArrayList<Empresa>> getEmpresas(){
        return new ResponseEntity<>(gestorEmpresa.getEmpresas(), HttpStatus.OK);
    }

    @GetMapping("/enterprise/{nameEmpresa}")
    public ResponseEntity<Object> getUsuario(@PathVariable String nameEmpresa){
        try {
            Empresa empresa = gestorEmpresa.getEmpresa(nameEmpresa);
            return new ResponseEntity<>(empresa,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/enterprise")
    public ResponseEntity<String> postEmpresa(@RequestBody Empresa empresaParametro){
        try {
            String mensaje = gestorEmpresa.setEmpresa(empresaParametro);
            return new ResponseEntity<>(mensaje,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/enterprise/{nameEmpresa}")
    public ResponseEntity<ObjetoRespuesta> putEmpresa(@RequestBody Empresa empresaUpdate,@PathVariable String nameEmpresa){
        try {
            Empresa empresaGuardada = gestorEmpresa.updateEmpresaAll(empresaUpdate,nameEmpresa);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualizacion exitosa",empresaGuardada),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/enterprise/{nameEmpresa}")
    public ResponseEntity<ObjetoRespuesta> patchEmpresa(@RequestBody Empresa empresaUpdate,@PathVariable String nameEmpresa){
        try {
            Empresa empresaGuardada = gestorEmpresa.updateEmpresa(empresaUpdate,nameEmpresa);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualizacion exitosa",empresaGuardada),HttpStatus.OK);
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

