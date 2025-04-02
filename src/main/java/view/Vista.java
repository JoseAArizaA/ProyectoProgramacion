package view;

import controller.VoluntarioController;
import model.Actividad;
import model.EstadoActividad;
import model.Voluntario;
import utils.Utilidades;

import java.time.LocalDate;
import java.util.Scanner;

public class Vista {
    public static int mostrarMenuVoluntario() {
        System.out.println("Bienvenido al menu de voluntario: ");
        System.out.println("1. Seleccionar actividad/es para unirse");
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

        Actividad actividad = new Actividad("", "", null, null, null, null, "");
        LocalDate fechaInicio = null;
        LocalDate fechaFin = null;
        Voluntario encargado = null;
        EstadoActividad estado = EstadoActividad.NoIniciada;

        Utilidades.leeCadena("Asigna un nombre para la actividad: ");
        String nombre = sc.nextLine();
        actividad.setNombre(nombre);

        Utilidades.leeCadena("Descripción: ");
        String descripcion = sc.nextLine();
        actividad.setDescripcion(descripcion);

        Utilidades.leeCadena("Indique la fecha de inicio a continuación: ");
        String fechaI = sc.nextLine();
        LocalDate.parse(fechaI);
        actividad.setFechaInicio(fechaInicio);

        Utilidades.leeCadena("Escriba la fecha prevista para la finalización de la actividad: ");
        String fechaF = sc.nextLine();
        LocalDate.parse(fechaF);
        actividad.setFechaFin(fechaFin);

        Utilidades.leeCadena("¿Cuál es el estado actual de la actividad? Opciones disponibles: no iniciada, en curso o finalizada.");
        String estadoActual = sc.nextLine();
        estadoActual.toUpperCase().equals(String.valueOf(estado));
        actividad.setEstado(estado);

        Utilidades.leeCadena("Escriba aquí un comentario: ");
        String comentario = sc.nextLine();
        actividad.setComentario(comentario);

        Utilidades.leeCadena("Por último seleccione un encargado entre la lista de voluntarios: ");
       //VoluntarioController.muestraVoluntarios();
        String voluntarioEncargado = sc.nextLine();
        voluntarioEncargado.equals(String.valueOf(encargado));
        actividad.setVoluntarioEncargado(encargado);

        return actividad;
    }

}
