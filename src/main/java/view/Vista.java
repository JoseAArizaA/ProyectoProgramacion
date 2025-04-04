package view;

import model.*;
import utils.Utilidades;

import java.time.LocalDate;
import java.util.Scanner;

public class Vista {

    public static int mostrarMenuVoluntario() {
        System.out.println("Bienvenido al menu de voluntario: ");
        System.out.println("1. Unirse a actividad/es");
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
        System.out.println("3. Actualizar iniciativa");
        System.out.println("4. Listar iniciativas creadas por mi");
        System.out.println("5. Crear actividad");
        System.out.println("6. Eliminar actividad");
        System.out.println("7. Actualizar actividad");
        System.out.println("8. Listar actividades");
        System.out.println("9. Cerrar sesión");
        int opcion = Utilidades.leeEntero("Selecciona una opcion: ");
        return opcion;
    }

    public static Iniciativa pideDatosIniciativa(CreadorIniciativa creador) {
        String nombre = Utilidades.pideString("Nombre de la iniciativa: ");
        String descripcion = Utilidades.pideString("Descripcion de la iniciativa: ");
        return new Iniciativa(nombre, descripcion, creador);
    }

    public static Actividad pideDatosActividad() {
        Actividad actividad = null;

        String nombre = Utilidades.pideString("Nombre de la actividad: ");
        String descripcion = Utilidades.pideString("Descripcion de la actividad: ");
        LocalDate fechaInicio = Utilidades.pideFecha("Fecha de inicio de la actividad (DD-MM-YYYY): ");
        LocalDate fechaFin = Utilidades.pideFecha("Fecha de fin de la actividad (DD-MM-YYYY): ");
        Voluntario voluntarioEncargado = null;
        EstadoActividad estado = EstadoActividad.NoIniciada;
        String comentario = "";

        actividad = new Actividad(nombre, descripcion, fechaInicio, fechaFin, voluntarioEncargado, estado, comentario);
        return actividad;
    }

    public static int mostrarMenuLogin() {
        System.out.println("Bienvenido al menu de login: ");
        System.out.println("1. Iniciar sesión");
        System.out.println("2.Registrarse");
        int opcion = Utilidades.leeEntero("Selecciona una opcion: ");
        return opcion;
    }

    public static int mostrarMenuEleccion(){
        System.out.println("Como quiere Iniciar Sesion: ");
        System.out.println("1. Creador");
        System.out.println("2. Voluntario");
        int opcion = Utilidades.leeEntero("Selecciona una opcion: ");
        return opcion;
    }

    public static String pedirUsuario() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Usuario: ");
        String usuario = teclado.nextLine();
        return usuario;
    }

    public static String pedirContrasena() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Contraseña: ");
        String contrasena = teclado.nextLine();
        return contrasena;
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static String pedirNombreIniciativa() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Nombre de la iniciativa: ");
        String nombre = teclado.nextLine();
        return nombre;
    }
}
