//Aquí inican los import
package edu.udea.LaBastilla.controller;
import edu.udea.LaBastilla.model.Enterprise;
import edu.udea.LaBastilla.services.ServicesEnterpriseInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.udea.LaBastilla.model.ObjetoRespuesta;
import java.util.List;
//Aquí finalizan los import

/*CLASE DE CONTROLADOR PARA EL MODELO EMPRESA. SE CUENTA CON LOS
 * CONTROLADORES GET (PARA TODAS LAS EMPRESAS Y PARA UNA SOLA), POST
 * PUT, PATCH Y DELETE*/

@RestController
public class ControllerEnterprise {

    //Controlador AUTOWIRED para conectar, a través de la interfaz, con la case empresa
    @Autowired
    private ServicesEnterpriseInterface servicesEnterprise;

    //Controlador GET para obtener los datos de todas las empresas registradas
    /*@GetMapping("/enterprises")
    public ResponseEntity<List<Enterprise>> getEmpresas(){
        return new ResponseEntity<>(servicesEnterprise.getEnterprises(), HttpStatus.OK);
    }*/

    //Controlador GET para obtener los datos de una empresa dada su ID
    @GetMapping("/enterprises/{id}")
    public ResponseEntity<Object> getEmpresaPath(@PathVariable Long id){
        try {
            Enterprise enterprise = servicesEnterprise.getEnterprise(id);
            return new ResponseEntity<>(enterprise,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Controlador POST para crear una empresa
    @PostMapping("/enterprises")
    public ResponseEntity<String> postEmpresa(@RequestBody Enterprise enterprise){
        try {
            String mensaje = servicesEnterprise.setEnterprise(enterprise);
            return new ResponseEntity<>(mensaje,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Controlador PATCH para actualizar algunos atributos de la empresa dada su ID
    @PatchMapping("/enterprises/{id}")
    public ResponseEntity<ObjetoRespuesta> patchEmpresa(@RequestBody Enterprise enterpriseUpdated, @PathVariable Long id){
        try {
            Enterprise enterpriseGuardada = servicesEnterprise.updateEnterprise(enterpriseUpdated, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualizacion exitosa", enterpriseGuardada),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Controlador DELETE para eliminar una empresa dada su ID
    @DeleteMapping("/enterprises/{id}")
    public ResponseEntity<ObjetoRespuesta> deleteEmpresa(@PathVariable Long id){
        try {
            String mensaje = servicesEnterprise.deleteEnterprise(id);
            return new ResponseEntity<>(new ObjetoRespuesta(mensaje,null),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

