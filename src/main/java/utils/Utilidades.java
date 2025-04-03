package utils;

import exceptions.ContrasennaInvalidaException;
import exceptions.CorreoInvalidoException;

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


    public static boolean validarContraseña(String contraseña) {
        boolean valido = false;
        if (!contraseña.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\d)(?=.*[@#$%^&+=!]).{8,}$")){
            throw new ContrasennaInvalidaException("La contraseña no es válida.");
        } else {
            valido = true;
        }

        return valido;
    }

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