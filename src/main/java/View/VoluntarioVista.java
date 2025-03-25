package View;

import Utils.Utilidades;

import java.util.Scanner;

public class VoluntarioVista {
    private static Scanner sc = new Scanner(System.in);

    public static int mostrarMenu() {
        System.out.println("Bienvenido al menu de voluntario: ");
        System.out.println("1. Seleccionar actividad/es para unirse");
        System.out.println("2. Ver actividades en las que participo");
        System.out.println("3. Asignar estado y comentario a una actividad");
        System.out.println("4. Ver puntos");
        System.out.println("5. Cerrar sesión");
        int opcion = Utilidades.leeEntero("Selecciona una opcion: ");
        return opcion;
    }

}
