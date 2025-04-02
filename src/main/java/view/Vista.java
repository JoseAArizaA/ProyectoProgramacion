package view;

import controller.IniciativaController;
import controller.VoluntarioController;
import exceptions.FechaNoValidaException;
import model.*;
import utils.Utilidades;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static utils.Utilidades.leeFecha;

public class Vista {
    public static int mostrarMenuVoluntario() {
        System.out.println("Bienvenido al menu de voluntario: ");
        System.out.println("1. Solizitar actividad/es para unirse");
        System.out.println("2. Ver actividades en las que participo");
        System.out.println("3. Asignar estado a una actividad");
        System.out.println("4. Ver puntos");
        System.out.println("5. Cerrar sesión");
        int opcion = Utilidades.leeEntero("Selecciona una opcion: ");
        return opcion;
    }

    public static int mostrarMenuCreador() {
        System.out.println("Bienvenido al menu de creador: ");
        System.out.println("1. Crear iniciativa");
        System.out.println("2. Eliminar iniciativa");
        System.out.println("3. Gestionar iniciativa");
        System.out.println("4. Asignar iniciativa");
        System.out.println("5. Cerrar sesión");
        int opcion = Utilidades.leeEntero("Selecciona una opcion: ");
        return opcion;
    }
    public static int mostrarMenuLogin() {
        System.out.println("Bienvenido al menu de login: ");
        System.out.println("1. Iniciar sesión");
        System.out.println("2.Registrarse");
        int opcion = Utilidades.leeEntero("Selecciona una opcion: ");
        return opcion;
    }


    public static Actividad pideDatosActividad() {
        Scanner sc = new Scanner(System.in);

        Utilidades.leeCadena("Asigna un nombre para la actividad: ");
        String nombre = sc.nextLine();

        Utilidades.leeCadena("Descripción: ");
        String descripcion = sc.nextLine();

        String fechaInicio;
        try {
            fechaInicio = leeFecha("Indique la fecha de inicio a continuación: ");
        } catch (FechaNoValidaException e) {
            throw new RuntimeException(e);
        }

        String fechaFin;
        try {
            fechaFin = leeFecha("Indique la fecha prevista para la finalización de la actividad: ");
        } catch (FechaNoValidaException e) {
            throw new RuntimeException(e);
        }

        Utilidades.leeCadena("¿Cuál es el estado actual de la actividad? Opciones disponibles: no iniciada, en curso o finalizada.");
        String estadoActual = sc.nextLine();

        Utilidades.leeCadena("Escriba aquí un comentario: ");
        String comentario = sc.nextLine();

        Utilidades.leeCadena("Por último seleccione un encargado entre la lista de voluntarios: ");
        //VoluntarioController.muestraVoluntarios();
        String voluntarioEncargado = sc.nextLine();

        return new Actividad(nombre, descripcion, fechaInicio, fechaFin, estadoActual, comentario, voluntarioEncargado);
    }


    public static Iniciativa pideDatosIniciativa(ArrayList<Actividad>actividades){
        Scanner sc = new Scanner(System.in);

        Utilidades.leeCadena("Elija un nombre para la iniciativa: " );
        String nombre = sc.nextLine();
        Utilidades.leeCadena("Descripción: ");
        String descripcion = sc.nextLine();
        Utilidades.leeCadena("Creador de la iniciativa: ");
        //autoasignar creador una vez creada la iniciativa??

        return new Iniciativa(nombre, descripcion, creadorIniciativa);
    }
}
