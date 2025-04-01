package utils;

import exception.CorreoInvalidoException;

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

}
