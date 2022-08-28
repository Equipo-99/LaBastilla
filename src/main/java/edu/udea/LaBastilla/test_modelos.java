package edu.udea.LaBastilla;
import edu.udea.LaBastilla.model.Empresa;

import java.util.Date;

import edu.udea.LaBastilla.model.Empleado;
import edu.udea.LaBastilla.model.MovimientoDinero;

public class test_modelos{
    public static void main(String[] Args){

        //Es posible crear una instancia de la clase "Empresa"
        Empresa Ejemplo = new Empresa("Equipo 99","La nube","6013336445","900668597-8");
        ManejoEmpresa(Ejemplo);

        //Es posible crear una nueva instancia de la clase "Empleado"
        Empleado PrimerEmpleado = new Empleado("Luis Carlos", "carlos@gmail.com", Ejemplo, "Operario");
        ManejoEmpleado(PrimerEmpleado);

        //Es posible crear una nueva instancia de la clase "MovimientoDinero"
        MovimientoDinero Movimientos = new MovimientoDinero(100200, "Venta de libro", 150000, Ejemplo, new Date(2022, 8, 10), new Date(2022, 8, 28));
        ManejoDinero(Movimientos);
        

    }
    public static Empresa ManejoEmpresa(Empresa Objeto_empresa){      
        
        //Es posible leer y modificar el nombre de la empresa
        String nombre_antiguo = Objeto_empresa.getNombre();
        System.out.println("El antiguo nombre de la empresa es: " + nombre_antiguo);    
        String nombre_nuevo = "La Bastilla";
        Objeto_empresa.setNombre(nombre_nuevo);
        System.out.println("El nuevo nombre de la empresa es: " + Objeto_empresa.getNombre());
    
        //Es posible leer y modificar la dirección de la empresa
        String direccion_antigua = Objeto_empresa.getDireccion();
        System.out.println("La dirección antigua de la empresa es: " + direccion_antigua);    
        String direccion_nueva = "Calle sexta";
        Objeto_empresa.setDireccion(direccion_nueva);
        System.out.println("La dirección nueva de la empresa es: " + Objeto_empresa.getDireccion());
    
        //Es posible leer y modificar el teléfono de la empresa
        String telefono_antiguo = Objeto_empresa.getTelefono();
        System.out.println("El teléfono antiguo de la empresa es: " + telefono_antiguo);    
        String telefono_nuevo = "6015555555";
        Objeto_empresa.setTelefono(telefono_nuevo);
        System.out.println("El teléfono nuevo de la empresa es: " + Objeto_empresa.getTelefono());
    
        //Es posible leer y modificar el NIT de la empresa
        String nit_antiguo = Objeto_empresa.getNIT();
        System.out.println("El NIT antiguo de la empresa es: " + nit_antiguo);    
        String nit_nuevo = "888885203-4";
        Objeto_empresa.setNIT(nit_nuevo);
        System.out.println("El NIT nuevo de la empresa es: " + Objeto_empresa.getNIT());

        return Objeto_empresa;
    } 
    public static Empleado ManejoEmpleado(Empleado Objeto_empleado){

        //Es posible leer y modificar el nombre del empleado
        String nombre_antiguo = Objeto_empleado.getName();
        System.out.println("El antiguo nombre del empleado es: " + nombre_antiguo);    
        String nombre_nuevo = "José Alberto";
        Objeto_empleado.setName(nombre_nuevo);
        System.out.println("El nuevo nombre del empleado es: " + Objeto_empleado.getName());

        //Es posible leer y modificar el correo del empleado
        String email_antiguo = Objeto_empleado.getEmail();
        System.out.println("El antiguo email del empleado es: " + email_antiguo);    
        String email_nuevo = "alberto@hotmail.com";
        Objeto_empleado.setEmail(email_nuevo);
        System.out.println("El nuevo nombre del empleado es: " + Objeto_empleado.getEmail());

        //Es posible leer y modificar la empresa a la que el empleado pertenece
        Empresa empresa_antigua = Objeto_empleado.getEnterprise();
        System.out.println("La empresa a la que el empleado solía pertenecer es: " + empresa_antigua.getNombre());    
        Empresa nueva_empresa = new Empresa("Nueva", "-----", "123", "999-0");
        Objeto_empleado.setEnterprise(nueva_empresa);
        System.out.println("La nueva empresa a la que el empleado pertenece es: " + nueva_empresa.getNombre());

        //Es posible leer y modificar el rol del empleado
        String rol_antiguo = Objeto_empleado.getRole();
        System.out.println("El antiguo rol del empleado es: " + rol_antiguo);    
        String rol_nuevo = "Adiministrador";
        Objeto_empleado.setRole(rol_nuevo);
        System.out.println("El nuevo rol del empleado es: " + Objeto_empleado.getRole());

        return Objeto_empleado;
    }   
    public static MovimientoDinero ManejoDinero(MovimientoDinero Objeto_dinero){

        //Es posible leer y modificar el monto del movimiento
        float monto_antiguo = Objeto_dinero.getMonto();
        System.out.println("El antiguo monto de la transacción es: " + monto_antiguo);    
        float monto_nuevo = 324200;
        Objeto_dinero.setMonto(monto_nuevo);
        System.out.println("El nuevo nombre de la transacción es: " + Objeto_dinero.getMonto());

        //Es posible leer y modificar el concepto del movimiento
        String concepto_antiguo = Objeto_dinero.getConcepto();
        System.out.println("El antiguo concepto de la transacción es: " + concepto_antiguo);    
        String concepto_nuevo = "Compra de ejemplares";
        Objeto_dinero.setConcepto(concepto_nuevo);
        System.out.println("El nuevo concepto de la transacción es: " + Objeto_dinero.getConcepto());

        //Es posible crear montos positivos y negativos
        float monto_negativo = -56200;
        Objeto_dinero.setMonto(monto_negativo);
        System.out.println("El nuevo monyo negativo de la transacción es: " + Objeto_dinero.getMonto());

        //Es posible definir qué usuario fue encargado de registrar el movimiento

        return Objeto_dinero;
    }
}
