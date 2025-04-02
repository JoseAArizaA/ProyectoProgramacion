package view;

import exception.CorreoInvalidoException;
import model.CreadorIniciativa;
import model.Usuario;
import model.Voluntario;
import utils.Utilidades;

import java.util.Scanner;

public class ViewRegistro {
    private static Scanner scanner = new Scanner(System.in);

    public static Usuario pideDatosUsuario() {
        Usuario usuario = null;

        System.out.println("Ingrese tu nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese tu nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();

        System.out.println("Ingrese tu contraseña: ");
        String contrasena = scanner.nextLine();

        String email;
        boolean correoValido;
        do{
            System.out.println("Ingrese tu email: ");
            email = scanner.nextLine();
            correoValido = true;
            try{
                Utilidades.validarCorreo(email);
            } catch (CorreoInvalidoException e){
                System.out.println(e.getMessage());
                correoValido = false;
            }
        }while(!correoValido);

        String rol;
        do{
            System.out.println("Ingrese tu rol (Voluntario o Creador): ");
             rol = scanner.nextLine();
        }while(!rol.equals("Voluntario") && !rol.equals("Creador"));


        if (rol.equals("Voluntario")) {
            usuario = new Voluntario(nombre, nombreUsuario, contrasena, email);
        } else if (rol.equals("Creador")) {
            System.out.println("Ingrese tu ONG: ");
            String ong = scanner.nextLine();
            usuario = new CreadorIniciativa(nombre, nombreUsuario, contrasena, email, ong);
        }
        return usuario;
    }

}
