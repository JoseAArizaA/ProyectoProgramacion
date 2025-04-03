package view;

import controller.ActividadController;
import controller.IniciativaController;
import controller.VoluntarioController;
import exceptions.FechaNoValidaException;
import exceptions.LimiteCaracteresException;
import exceptions.NombreNoValidoException;
import model.*;
import utils.Utilidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static model.EstadoActividad.*;
import static utils.Utilidades.*;

public class Vista {

    public static int mostrarMenuVoluntario() {
        System.out.println("Bienvenido al menú de voluntario: ");
        System.out.println("1. Solicitar actividad/es para unirse");
        System.out.println("2. Ver actividades en las que participo");
        System.out.println("3. Asignar estado a una actividad");
        System.out.println("4. Ver puntos");
        System.out.println("5. Cerrar sesión");
        int opcion = leeEntero("Selecciona una opción: ");
        return opcion;
    }

    public static int mostrarMenuCreador() {
        System.out.println("Bienvenido al menú de creador: ");
        System.out.println("1. Crear iniciativa");
        System.out.println("2. Eliminar iniciativa");
        System.out.println("3. Gestionar iniciativa");
        System.out.println("4. Asignar iniciativa");
        System.out.println("5. Cerrar sesión");
        int opcion = leeEntero("Selecciona una opción: ");
        return opcion;
    }
    public static int mostrarMenuLogin() {
        System.out.println("Bienvenido al menú de login: ");
        System.out.println("1. Iniciar sesión");
        System.out.println("2.Registrarse");
        int opcion = leeEntero("Selecciona una opción: ");
        return opcion;
    }

    public static Actividad pideDatosActividad() throws FechaNoValidaException, NombreNoValidoException, LimiteCaracteresException {
        Scanner sc = new Scanner(System.in);

        String nombre = validarNombre("Asigna un nombre para la actividad: ");
        String descripcion = maximoCaracteresDescripcion("Descripción: ");
        LocalDate  fechaInicio = leeFecha("Indique la fecha de inicio a continuación: ");
        LocalDate fechaFin = leeFecha("Asigne la fecha de finalización prevista: ");
        EstadoActividad estado = eligeEstado();
        String comentario = maximoCaracteresComentario("Comentario: ");
        leeCadena("Por último seleccione un encargado entre la lista de voluntarios: ");
        VoluntarioController.muestraVoluntarios();
        Voluntario voluntarioEncargado = VoluntarioController.obtenerVoluntario(sc.nextLine());

        return new Actividad(nombre, descripcion, fechaInicio, fechaFin, voluntarioEncargado, estado, comentario);
    }

    public static Iniciativa pideDatosIniciativa() throws NombreNoValidoException, LimiteCaracteresException {

        String nombre = validarNombre("Elija un nombre para la iniciativa: ");
        String descripcion = maximoCaracteresDescripcion("Descripción: ");
        Utilidades.leeCadena("Creador de la iniciativa: ");
        CreadorIniciativa creador = obtenerCreadorActual();

        IniciativaController.iniciarIniciativa(nombre, descripcion, creador);
        Actividad nuevaActividad = IniciativaController.agregarActividad("Seleccione la actividad que desea añadir: ");

        IniciativaController.agregarActividadAIniciativa(nuevaActividad);

        return new Iniciativa(nombre, descripcion, creador);
    }

    public static int mostrarMenuEleccion(){
        System.out.println("¿Cómo quiere iniciar sesión?");
        System.out.println("1. Creador");
        System.out.println("2. Voluntario");
        int opcion = leeEntero("Selecciona una opción: ");
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

    public static EstadoActividad eligeEstado(){
        Scanner sc = new Scanner(System.in);

        leeCadena("Seleccione el índice correspondiente al estado de la actividad: ");
        leeCadena("1. No iniciada");
        leeCadena("2. En curso");
        leeCadena("3. Finalizada");
        int opcion = sc.nextInt();

        EstadoActividad estado;

        switch (opcion) {
            case 1:
                estado = NoIniciada;
                break;
            case 2:
                estado = EnProgreso;
                break;
            case 3:
                estado = Completada;
                break;
            default:
                leeCadena("Opción no válida. Seleccionando estado por defecto: No iniciada");
                estado = NoIniciada;
        }

        return estado;
    }

    public static CreadorIniciativa obtenerCreadorActual() {
        Usuario usuarioActual = Sesion.getInstancia().getUsuarioActual();
        return new CreadorIniciativa(usuarioActual.getNombre(), usuarioActual.getUsuario(), usuarioActual.getContrasena(), usuarioActual.getEmail(), usuarioActual.getRol());
    }
}
