package utils;

import exceptions.ContrasennaInvalidaException;
import exceptions.CorreoInvalidoException;
import exceptions.NombreNoValidoException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import java.util.Scanner;

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


    public static boolean validarContrasenna(String contrasenna) {
        boolean valido = false;
        if (!contrasenna.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$")) {
            throw new ContrasennaInvalidaException("La contraseña no es válida.");
        } else {
            valido = true;
        }

        return valido;
    }

    public static String pideString(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        String cadena = "";
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensaje);
                cadena = scanner.nextLine();
                if (!cadena.isEmpty()) {
                    valido = true;
                } else {
                    System.out.println("Error: No puedes introducir una cadena vacia.");
                }
            } catch (Exception e) {
                System.out.println("Error: Ingresa una cadena válida.");
            }
        }
        return cadena;
    }

    public static LocalDate pideFecha(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        LocalDate fecha = null;
        boolean valido = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        while (!valido) {
            try {
                System.out.print(mensaje);
                String input = scanner.nextLine();
                fecha = LocalDate.parse(input, formatter);
                valido = true;
            } catch (DateTimeParseException e) {
                System.out.println("Error: Ingresa una fecha válida en el formato DD-MM-YYYY.");
            }
        }
        return fecha;
    }

    public static String validarNombre(String msn) throws NombreNoValidoException {
        Scanner sc = new Scanner(System.in);
        String nombre = "";

        System.out.println(msn);
        nombre = sc.nextLine();
        if (nombre.isEmpty()) {
            throw new NombreNoValidoException("Error: El nombre no puede estar vacío.");
        } else if (!nombre.matches("^[A-Za-zÁÉÍÓÚáéíóúÄËÏÖÜäëïöüÂÊÎÔÛâêîôûÀÈÌÒÙàèìòùÑñ\\-\\s]+$")) {
            throw new NombreNoValidoException("Error: El nombre solo puede contener letras, espacios y guiones.");
        }
        return nombre;
    }
}