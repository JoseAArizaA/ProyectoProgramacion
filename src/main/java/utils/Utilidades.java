package utils;

import exceptions.FechaNoValidaException;
import model.Voluntario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import static model.EstadoActividad.*;

public class Utilidades {
    public static int leeEntero(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        int numero = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensaje);
                numero = Integer.parseInt(scanner.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingresa un número entero válido.");
            }
        }
        return numero;
    }

    public static boolean validarContraseña(String contraseña) {
        String regexContraseña = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\d)(?=.*[@#$%^&+=!]).{8,}$";
        return contraseña.matches(regexContraseña);
    }

    public static String leeCadena(String msn) {
        Scanner sc = new Scanner(System.in);
        String cadena = "";

        do {
            System.out.println(msn);
            cadena = sc.nextLine();
            if (cadena.isEmpty()) {
                System.out.println("Error: Ingrese una cadena de texto válida.");
            }
        } while (cadena.isEmpty());
    return cadena;
    }

    public static LocalDate leeFecha(String msn) throws FechaNoValidaException {
        Scanner sc = new Scanner(System.in);
        LocalDate fecha = null;

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (fecha == null) {
            System.out.println("Introduce una fecha en el formato dd/MM/yyyy:");
            String input = sc.nextLine();
            try {
                fecha = LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                throw new FechaNoValidaException("Error: la fecha no tiene el formato correcto.");
            }
        }
        return fecha;
    }
}