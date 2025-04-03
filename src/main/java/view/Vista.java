package view;

import model.Actividad;
import model.EstadoActividad;
import model.Iniciativa;
import model.Voluntario;
import utils.Utilidades;

import java.time.LocalDate;
import java.util.Scanner;

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

    public static Iniciativa pideDatosIniciativa() {
        Iniciativa iniciativa = null;

        Scanner teclado = new Scanner(System.in);
        String nombre = Utilidades.pideString("Nombre de la iniciativa: ");
        String descripcion = Utilidades.pideString("Descripcion de la iniciativa: ");
        /*System.out.print("Creador de la iniciativa: ");
        String creador = teclado.nextLine();
        iniciativa = new Iniciativa(nombre, descripcion, new CreadorIniciativa(creador));
        return iniciativa;*/
        return null;
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

}
