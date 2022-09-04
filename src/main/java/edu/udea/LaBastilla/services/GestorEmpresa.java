package edu.udea.LaBastilla.services;

import edu.udea.LaBastilla.model.Empresa;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;

@Service
public class GestorEmpresa {
    private ArrayList<Empresa> empresas;

    public GestorEmpresa(){
        this.empresas = new ArrayList<>();

        this.empresas.add(new Empresa(1,"Equipo_99","100-1","6027776543","Cali",null,null,new Date(),new Date()));
        this.empresas.add(new Empresa(2,"La_Bastilla","200-1","6027444543","Medellin",null,null,new Date(),new Date()));
    }

    public Empresa getEmpresa(String nombreEmpresa) throws Exception {
        for (Empresa empresa:this.empresas){
            if(empresa.getName().equals(nombreEmpresa)){
                return empresa;
            }
        }
        throw new Exception("La empresa no existe");
    }
    public String setEmpresa(Empresa empresaParametro) throws Exception {
        try {
            getEmpresa(empresaParametro.getName());
        } catch (Exception e){
            this.empresas.add(empresaParametro);
            return "Empresa creada exitosamente";
        }
        throw new Exception("La empresa ya existe");
    }

    public Empresa updateEmpresa(Empresa empresaUpdate,String nombreEmpresa) throws Exception {
        try {
            Empresa empresaSaved = getEmpresa(nombreEmpresa);
            //!Strings.isNullOrEmpty(empresaUpdate.getName();
            if(empresaUpdate.getName() != null && !empresaUpdate.getName().equals("")){
                empresaSaved.setName(empresaUpdate.getName());
            }
            if(empresaUpdate.getDocument() != null && !empresaUpdate.getDocument().equals("")){
                empresaSaved.setDocument(empresaUpdate.getDocument());
            }
            if(empresaUpdate.getPhone() != null && !empresaUpdate.getPhone().equals("")){
                empresaSaved.setPhone(empresaUpdate.getPhone());
            }
            if(empresaUpdate.getAdress() != null && !empresaUpdate.getAdress().equals("")){
                empresaSaved.setAdress(empresaUpdate.getAdress());
            }
            if(empresaUpdate.getUsers() != null){
                empresaSaved.setUsers(empresaUpdate.getUsers());
            }
            if(empresaUpdate.getTransactions() != null){
                empresaSaved.setTransactions(empresaUpdate.getTransactions());
            }
            if(empresaUpdate.getCreatedAt() != null){
                empresaSaved.setCreatedAt(empresaUpdate.getCreatedAt());
            }
            if(empresaUpdate.getUpdatedAt() != null){
                empresaSaved.setUpdatedAt(empresaUpdate.getUpdatedAt());
            }
            return empresaSaved;
        }catch (Exception e){
            throw new Exception("La empresa no existe. Falló la actualizacion de datos");
        }
    }
    public Empresa updateEmpresaAll(Empresa empresaUpdate,String nombreEmpresa) throws Exception {
        try {
            Empresa empresaSaved = getEmpresa(nombreEmpresa);
            empresaSaved.setName(empresaUpdate.getName());
            empresaSaved.setDocument(empresaUpdate.getDocument());
            empresaSaved.setPhone(empresaUpdate.getPhone());
            empresaSaved.setAdress(empresaUpdate.getAdress());
            empresaSaved.setUsers(empresaUpdate.getUsers());
            empresaSaved.setTransactions(empresaUpdate.getTransactions());
            empresaSaved.setCreatedAt(empresaUpdate.getCreatedAt());
            empresaSaved.setUpdatedAt(empresaUpdate.getUpdatedAt());
            return empresaSaved;
        }catch (Exception e){
            throw new Exception("La empresa no existe. Falló la actualizacion de datos");
        }
    }

    public String deleteEmpresa(String nombreEmpresa) throws Exception {
        try {
            Empresa empresa =getEmpresa(nombreEmpresa);
            this.empresas.remove(empresa);
            return "Empresa eliminada Exitosamente";
        }catch (Exception e){
            throw new Exception("La empresa no existe. Imposible eliminar");
        }
    }

    public ArrayList<Empresa> getEmpresas(){return empresas;}
    public void setEmpresas(ArrayList<Empresa> empresas){
        this.empresas=empresas;
    }
}
