package utils;

import exceptions.FechaNoValidaException;
import model.Voluntario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import exceptions.ContraseñaInvalidaException;
import exceptions.CorreoInvalidoException;

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

    public static boolean validarCorreo(String email) {
        boolean valido = false;
        if (!email.matches("^[\\w.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new CorreoInvalidoException("El correo electrónico no es válido.");
        } else {
            valido = true;
        }
        return valido;
    }


    public static boolean validarContraseña(String contraseña) {
        boolean valido = false;
        if (!contraseña.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\d)(?=.*[@#$%^&+=!]).{8,}$")){
            throw new ContraseñaInvalidaException("La contraseña no es válida.");
        } else {
            valido = true;
        }

        return valido;
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
            System.out.println("Introduce una fecha en el siguiente formato: dd/MM/yyyy:");
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