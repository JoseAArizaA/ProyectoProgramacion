package utils;

import exceptions.*;

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
        if (!contrasenna.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\d)(?=.*[@#$%^&+=!]).{8,}$")) {
            throw new ContrasennaInvalidaException("La contraseña no es válida.");
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
    public static String maximoCaracteresDescripcion(String msn) throws LimiteCaracteresException {
        Scanner sc = new Scanner(System.in);
        String descripcion = "";

        do {
            System.out.println(msn);
            descripcion = sc.nextLine();
            if (descripcion.isEmpty()) {
                System.out.println("Error: No puede dejar este campo sin rellenar.");
            } else if (descripcion.length() > 1000) {
                throw new LimiteCaracteresException("La descripción no puede tener más de 1000 caracteres.");
            }
        } while (descripcion.isEmpty());

        return descripcion;
    }

    public static String maximoCaracteresComentario(String msn) throws LimiteCaracteresException {
        Scanner sc = new Scanner(System.in);
        String comentario = "";

        do {
            System.out.println(msn);
            comentario = sc.nextLine();
            if (comentario.isEmpty()) {
                System.out.println("Error: No puede dejar este campo sin rellenar.");
            } else if (comentario.length() > 500) {
                throw new LimiteCaracteresException("El límite de caracteres por comentario es de 500.");
            }
        } while (comentario.isEmpty());

        return comentario;
    }
}