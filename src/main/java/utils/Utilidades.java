package utils;

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

    public static boolean validarContraseña(String contraseña) {
        String regexContraseña = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\d)(?=.*[@#$%^&+=!]).{8,}$";
        return contraseña.matches(regexContraseña);
    }
}
