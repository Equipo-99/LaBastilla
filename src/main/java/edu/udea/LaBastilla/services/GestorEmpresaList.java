package edu.udea.LaBastilla.services;

import edu.udea.LaBastilla.model.Enterprise;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class GestorEmpresaList {
    private ArrayList<Enterprise> enterprises;

    public GestorEmpresaList(){
        this.enterprises = new ArrayList<>();

        this.enterprises.add(new Enterprise("Equipo_99","100-1","6027776543","Cali",null));
        this.enterprises.add(new Enterprise("La_Bastilla","200-1","6027444543","Medellin",null));
    }

    public Enterprise getEmpresa(String nombreEmpresa) throws Exception {
        for (Enterprise enterprise :this.enterprises){
            if(enterprise.getName().equals(nombreEmpresa)){
                return enterprise;
            }
        }
        throw new Exception("La empresa no existe");
    }
    public String setEmpresa(Enterprise enterpriseParametro) throws Exception {
        try {
            getEmpresa(enterpriseParametro.getName());
        } catch (Exception e){
            this.enterprises.add(enterpriseParametro);
            return "Empresa creada exitosamente";
        }
        throw new Exception("La empresa ya existe");
    }

    public Enterprise updateEmpresa(Enterprise enterpriseUpdate, String nombreEmpresa) throws Exception {
        try {
            Enterprise enterpriseSaved = getEmpresa(nombreEmpresa);
            if(enterpriseUpdate.getName() != null && !enterpriseUpdate.getName().equals("")){
                enterpriseSaved.setName(enterpriseUpdate.getName());
            }
            if(enterpriseUpdate.getDocument() != null && !enterpriseUpdate.getDocument().equals("")){
                enterpriseSaved.setDocument(enterpriseUpdate.getDocument());
            }
            if(enterpriseUpdate.getPhone() != null && !enterpriseUpdate.getPhone().equals("")){
                enterpriseSaved.setPhone(enterpriseUpdate.getPhone());
            }
            if(enterpriseUpdate.getAddress() != null && !enterpriseUpdate.getAddress().equals("")){
                enterpriseSaved.setAddress(enterpriseUpdate.getAddress());
            }
            if(enterpriseUpdate.getUsers() != null){
                enterpriseSaved.setUsers(enterpriseUpdate.getUsers());
            }
            if(enterpriseUpdate.getTransactions() != null){
                enterpriseSaved.setTransactions(enterpriseUpdate.getTransactions());
            }
            if(enterpriseUpdate.getCreatedAt() != null){
                enterpriseSaved.setCreatedAt(enterpriseUpdate.getCreatedAt());
            }
            if(enterpriseUpdate.getUpdatedAt() != null){
                enterpriseSaved.setUpdatedAt(enterpriseUpdate.getUpdatedAt());
            }
            return enterpriseSaved;
        }catch (Exception e){
            throw new Exception("La empresa no existe. Falló la actualizacion de datos");
        }
    }
    public Enterprise updateEmpresaAll(Enterprise enterpriseUpdate, String nombreEmpresa) throws Exception {
        try {
            Enterprise enterpriseSaved = getEmpresa(nombreEmpresa);
            enterpriseSaved.setName(enterpriseUpdate.getName());
            enterpriseSaved.setDocument(enterpriseUpdate.getDocument());
            enterpriseSaved.setPhone(enterpriseUpdate.getPhone());
            enterpriseSaved.setAddress(enterpriseUpdate.getAddress());
            enterpriseSaved.setUsers(enterpriseUpdate.getUsers());
            enterpriseSaved.setTransactions(enterpriseUpdate.getTransactions());
            enterpriseSaved.setCreatedAt(enterpriseUpdate.getCreatedAt());
            enterpriseSaved.setUpdatedAt(enterpriseUpdate.getUpdatedAt());
            return enterpriseSaved;
        }catch (Exception e){
            throw new Exception("La empresa no existe. Falló la actualizacion de datos");
        }
    }

    public String deleteEmpresa(String nombreEmpresa) throws Exception {
        try {
            Enterprise enterprise =getEmpresa(nombreEmpresa);
            this.enterprises.remove(enterprise);
            return "Empresa eliminada exitosamente";
        }catch (Exception e){
            throw new Exception("La empresa no existe. Falló la eliminación de empresa");
        }
    }

    public ArrayList<Enterprise> getEmpresas(){return enterprises;}
    public void setEmpresas(ArrayList<Enterprise> enterprises){
        this.enterprises = enterprises;
    }
}
