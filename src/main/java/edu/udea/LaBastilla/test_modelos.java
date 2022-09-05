package edu.udea.LaBastilla;
import edu.udea.LaBastilla.model.Enterprise;
import edu.udea.LaBastilla.model.Employee;
import edu.udea.LaBastilla.model.Transaction;
import edu.udea.LaBastilla.enums.*;

import java.util.ArrayList;
import java.util.Date;

public class test_modelos{
    public static void main(String[] Args){

        ArrayList<Employee> auxEmp = new ArrayList<>();
        ArrayList<Transaction> auxMov = new ArrayList<>();

        //Es posible crear una instancia de la clase "Enterprise"
        Enterprise Ejemplo = new Enterprise(123456, "Equipo 99", "4567", "77777777", "Carrera 11", auxEmp, auxMov, new Date(), new Date());
        ManejoEmpresa(Ejemplo);

        //Es posible crear una nueva instancia de la clase "Empleado"
        Employee primerEmployee = new Employee("Luis Carlos", "carlos@gmail.com", Ejemplo, Enum_RoleName.ADMINISTRADOR);
        ManejoEmpleado(primerEmployee);
        

    }
    public static Enterprise ManejoEmpresa(Enterprise objetoEnterprise){
        
        //Es posible leer y modificar el nombre de la empresa
        String nombreAntiguo = objetoEnterprise.getName();
        System.out.println("El antiguo nombre de la empresa es: " + nombreAntiguo);    
        String nombreNuevo = "La Bastilla";
        objetoEnterprise.setName(nombreNuevo);
        System.out.println("El nuevo nombre de la empresa es: " + objetoEnterprise.getName());
    
        //Es posible leer y modificar la dirección de la empresa
        String direccion_antigua = objetoEnterprise.getAdress();
        System.out.println("La dirección antigua de la empresa es: " + direccion_antigua);    
        String direccion_nueva = "Calle sexta";
        objetoEnterprise.setAdress(direccion_nueva);
        System.out.println("La dirección nueva de la empresa es: " + objetoEnterprise.getAdress());
    
        //Es posible leer y modificar el teléfono de la empresa
        String telefono_antiguo = objetoEnterprise.getPhone();
        System.out.println("El teléfono antiguo de la empresa es: " + telefono_antiguo);    
        String telefono_nuevo = "6015555555";
        objetoEnterprise.setPhone(telefono_nuevo);
        System.out.println("El teléfono nuevo de la empresa es: " + objetoEnterprise.getPhone());
    
        //Es posible leer y modificar el NIT de la empresa
        String nit_antiguo = objetoEnterprise.getDocument();
        System.out.println("El NIT antiguo de la empresa es: " + nit_antiguo);    
        String nit_nuevo = "888885203-4";
        objetoEnterprise.setDocument(nit_nuevo);
        System.out.println("El NIT nuevo de la empresa es: " + objetoEnterprise.getDocument());

        System.out.println();

        return objetoEnterprise;
    } 
    public static Employee ManejoEmpleado(Employee objetoEmployee){

        //Es posible leer y modificar el nombre del empleado
        String nombreAntiguo = objetoEmployee.getName();
        System.out.println("El antiguo nombre del empleado es: " + nombreAntiguo);    
        String nombreNuevo = "José Alberto";
        objetoEmployee.setName(nombreNuevo);
        System.out.println("El nuevo nombre del empleado es: " + objetoEmployee.getName());

        //Es posible leer y modificar el correo del empleado
        String emailAntiguo = objetoEmployee.getEmail();
        System.out.println("El antiguo email del empleado es: " + emailAntiguo);    
        String emailNuevo = "alberto@hotmail.com";
        objetoEmployee.setEmail(emailNuevo);
        System.out.println("El nuevo nombre del empleado es: " + objetoEmployee.getEmail());

        //Es posible leer y modificar la empresa a la que el empleado pertenece
        Enterprise enterpriseAntigua = objetoEmployee.getEnterprise();
        ArrayList<Employee> auxEmp = new ArrayList<>();
        ArrayList<Transaction> auxMov = new ArrayList<>();
        System.out.println("La empresa a la que el empleado solía pertenecer es: " + enterpriseAntigua.getName());
        Enterprise enterpriseNueva = new Enterprise(12345666, "La Bastilla", "46666567", "770077", "Calle 101", auxEmp, auxMov, new Date(), new Date());
        objetoEmployee.setEnterprise(enterpriseNueva);
        System.out.println("La nueva empresa a la que el empleado pertenece es: " + enterpriseNueva.getName());

        //Es posible leer y modificar el rol del empleado
        Enum_RoleName rolAntiguo = objetoEmployee.getRole();
        System.out.println("El antiguo rol del empleado es: " + rolAntiguo);    
        Enum_RoleName rolNuevo = Enum_RoleName.ADMINISTRADOR;
        objetoEmployee.setRole(rolNuevo);
        System.out.println("El nuevo rol del empleado es: " + objetoEmployee.getRole());

        System.out.println();

        return objetoEmployee;
    }   
    public static Transaction ManejoDinero(Transaction objetoMovimiento){

        //Es posible leer y modificar el monto del movimiento
        float montoAntiguo = objetoMovimiento.getAmount();
        System.out.println("El antiguo monto de la transacción es: " + montoAntiguo);    
        float montoNuevo = 324200;
        objetoMovimiento.setAmount(montoNuevo);
        System.out.println("El nuevo monto de la transacción es: " + objetoMovimiento.getAmount());

        //Es posible leer y modificar el concepto del movimiento
        String conceptoAntiguo = objetoMovimiento.getConcept();
        System.out.println("El antiguo concepto de la transacción es: " + conceptoAntiguo);    
        String conceptoNuevo = "Compra de ejemplares";
        objetoMovimiento.setConcept(conceptoNuevo);
        System.out.println("El nuevo concepto de la transacción es: " + objetoMovimiento.getConcept());

        //Es posible crear montos positivos y negativos
        float montoNegativo = -56200;
        objetoMovimiento.setAmount(montoNegativo);
        System.out.println("El nuevo monto negativo de la transacción es: " + objetoMovimiento.getAmount());

        //Es posible definir qué usuario fue encargado de registrar el movimiento
        String empleadoMovimiento = objetoMovimiento.getEmpleado().getName();
        System.out.println("El empleado a cargo de realizar de la transacción fue: " + empleadoMovimiento);

        System.out.println();

        return objetoMovimiento;
    }
}