package view;

import utils.Utilidades;

import java.util.Scanner;

public class CreadorVista {
    private static Scanner sc = new Scanner(System.in);

    public static int verMenuCreador() {
        int opcion;

        System.out.println("Bienvenido al menu de creador: ");
        System.out.println("1. Ver actividades");
        System.out.println("2. Crear actividad");
        System.out.println("3. Modificar actividad");
        System.out.println("4. Eliminar actividad");
        System.out.println("5. Asignar voluntarios");
        System.out.println("6. Ver iniciativas");
        System.out.println("7. Crear iniciativa");
        System.out.println("8. Modificar iniciativa");
        System.out.println("9. Eliminar iniciativa");
        System.out.println("10. Cerrar sesión");

        opcion = Utilidades.leeEntero("Selecciona una opcion: ");
        return opcion;
    }
}
