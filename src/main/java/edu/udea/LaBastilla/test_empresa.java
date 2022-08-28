package edu.udea.LaBastilla;

import edu.udea.LaBastilla.model.Empresa;

public class test_empresa{
    public static void main(String[] Args){

        //Es posible crear una instancia de la clase "Empresa"
        Empresa Ejemplo = new Empresa("Equipo 99","La nube","6013336445","900668597-8");

        //Es posible leer y modificar el nombre de la empresa
        String nombre_antiguo = Ejemplo.getNombre();
        System.out.println("El antiguo nombre de la empresa es: " + nombre_antiguo);

        String nombre_nuevo = "La Bastilla";
        Ejemplo.setNombre(nombre_nuevo);
        System.out.println("El nuevo nombre de la empresa es: " + Ejemplo.getNombre());

        //Es posible leer y modificar la dirección de la empresa
        String direccion_antigua = Ejemplo.getDireccion();
        System.out.println("La dirección antigua de la empresa es: " + direccion_antigua);

        String direccion_nueva = "Calle sexta";
        Ejemplo.setDireccion(direccion_nueva);
        System.out.println("La dirección nueva de la empresa es: " + Ejemplo.getDireccion());

        //Es posible leer y modificar el teléfono de la empresa
        String telefono_antiguo = Ejemplo.getTelefono();
        System.out.println("El teléfono antiguo de la empresa es: " + telefono_antiguo);

        String telefono_nuevo = "6015555555";
        Ejemplo.setTelefono(telefono_nuevo);
        System.out.println("El teléfono nuevo de la empresa es: " + Ejemplo.getTelefono());

        //Es posible leer y modificar el NIT de la empresa
        String nit_antiguo = Ejemplo.getNIT();
        System.out.println("El NIT antiguo de la empresa es: " + nit_antiguo);

        String nit_nuevo = "888885203-4";
        Ejemplo.setNIT(nit_nuevo);
        System.out.println("El NIT nuevo de la empresa es: " + Ejemplo.getNIT());

        /*
        OUTPUT

        El antiguo nombre de la empresa es: Equipo 99
        El nuevo nombre de la empresa es: La Bastilla
        La dirección antigua de la empresa es: La nube
        La dirección nueva de la empresa es: Calle sexta
        El teléfono antiguo de la empresa es: 6013336445
        El teléfono nuevo de la empresa es: 6015555555
        El NIT antiguo de la empresa es: 900668597-8
        El NIT nuevo de la empresa es: 888885203-4 
        
        */

    }
}
