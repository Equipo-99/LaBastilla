package edu.udea.LaBastilla;

public class TestModels {
    public static void main(String[] Args){
        /*
        //Es posible crear una instancia de la clase "Empresa"
        Empresa Ejemplo = new Empresa("Equipo 99","La nube","6013336445","900668597-8");
        ManejoEmpresa(Ejemplo);

        //Es posible crear una nueva instancia de la clase "Empleado"
        Empleado PrimerEmpleado = new Empleado("Luis Carlos", "carlos@gmail.com", Ejemplo, Enum_RoleName.OPERARIO);
        ManejoEmpleado(PrimerEmpleado);

        //Es posible crear una nueva instancia de la clase "MovimientoDinero"
        MovimientoDinero Movimientos = new MovimientoDinero(100200, "Venta de libro", 150000, Ejemplo, PrimerEmpleado, new Date(2022, 8, 10), new Date(2022, 8, 28));
        ManejoDinero(Movimientos);
        

    }
    public static Empresa ManejoEmpresa(Empresa objetoEmpresa){      
        
        //Es posible leer y modificar el nombre de la empresa
        String nombreAntiguo = objetoEmpresa.getNombre();
        System.out.println("El antiguo nombre de la empresa es: " + nombreAntiguo);    
        String nombreNuevo = "La Bastilla";
        objetoEmpresa.setNombre(nombreNuevo);
        System.out.println("El nuevo nombre de la empresa es: " + objetoEmpresa.getNombre());
    
        //Es posible leer y modificar la dirección de la empresa
        String direccion_antigua = objetoEmpresa.getDireccion();
        System.out.println("La dirección antigua de la empresa es: " + direccion_antigua);    
        String direccion_nueva = "Calle sexta";
        objetoEmpresa.setDireccion(direccion_nueva);
        System.out.println("La dirección nueva de la empresa es: " + objetoEmpresa.getDireccion());
    
        //Es posible leer y modificar el teléfono de la empresa
        String telefono_antiguo = objetoEmpresa.getTelefono();
        System.out.println("El teléfono antiguo de la empresa es: " + telefono_antiguo);    
        String telefono_nuevo = "6015555555";
        objetoEmpresa.setTelefono(telefono_nuevo);
        System.out.println("El teléfono nuevo de la empresa es: " + objetoEmpresa.getTelefono());
    
        //Es posible leer y modificar el NIT de la empresa
        String nit_antiguo = objetoEmpresa.getNIT();
        System.out.println("El NIT antiguo de la empresa es: " + nit_antiguo);    
        String nit_nuevo = "888885203-4";
        objetoEmpresa.setNIT(nit_nuevo);
        System.out.println("El NIT nuevo de la empresa es: " + objetoEmpresa.getNIT());

        System.out.println();

        return objetoEmpresa;
    } 
    public static Empleado ManejoEmpleado(Empleado objetoEmpleado){

        //Es posible leer y modificar el nombre del empleado
        String nombreAntiguo = objetoEmpleado.getName();
        System.out.println("El antiguo nombre del empleado es: " + nombreAntiguo);    
        String nombreNuevo = "José Alberto";
        objetoEmpleado.setName(nombreNuevo);
        System.out.println("El nuevo nombre del empleado es: " + objetoEmpleado.getName());

        //Es posible leer y modificar el correo del empleado
        String emailAntiguo = objetoEmpleado.getEmail();
        System.out.println("El antiguo email del empleado es: " + emailAntiguo);    
        String emailNuevo = "alberto@hotmail.com";
        objetoEmpleado.setEmail(emailNuevo);
        System.out.println("El nuevo nombre del empleado es: " + objetoEmpleado.getEmail());

        //Es posible leer y modificar la empresa a la que el empleado pertenece
        Empresa empresaAntigua = objetoEmpleado.getEnterprise();
        System.out.println("La empresa a la que el empleado solía pertenecer es: " + empresaAntigua.getNombre());    
        Empresa empresaNueva = new Empresa("Nueva", "-----", "123", "999-0");
        objetoEmpleado.setEnterprise(empresaNueva);
        System.out.println("La nueva empresa a la que el empleado pertenece es: " + empresaNueva.getNombre());

        //Es posible leer y modificar el rol del empleado
        Enum_RoleName rolAntiguo = objetoEmpleado.getRole();
        System.out.println("El antiguo rol del empleado es: " + rolAntiguo);    
        Enum_RoleName rolNuevo = Enum_RoleName.ADMINISTRADOR;
        objetoEmpleado.setRole(rolNuevo);
        System.out.println("El nuevo rol del empleado es: " + objetoEmpleado.getRole());

        System.out.println();

        return objetoEmpleado;
    }   
    public static MovimientoDinero ManejoDinero(MovimientoDinero objetoMovimiento){

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
        String empleadoMovimiento = objetoMovimiento.getEmployee().getName();
        System.out.println("El empleado a cargo de realizar de la transacción fue: " + empleadoMovimiento);

        System.out.println();

        return objetoMovimiento;
    */
    }
}
