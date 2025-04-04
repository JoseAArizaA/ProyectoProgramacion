package view;

import exceptions.ContrasennaInvalidaException;
import exceptions.CorreoInvalidoException;
import model.CreadorIniciativa;
import model.Usuario;
import model.Voluntario;
import utils.Utilidades;

import java.util.Scanner;

public class ViewRegistro {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Metodo que pide los datos del usuario y devuelve un objeto de tipo CreadorIniciativa o Voluntario
     * @return: Devuel un creado o voluntario con sus datos
     */
    public static Usuario pideDatosUsuario() {
        Usuario usuario = null;

        System.out.println("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese su nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();

        String contrasena;
        boolean contrasenaValida = false;
        do{
            System.out.println("Ingrese su contraseña: ");
            contrasena = scanner.nextLine();
            contrasenaValida = true;
            try{
                Utilidades.validarContraseña(contrasena);
            } catch (ContrasennaInvalidaException e){
                System.out.println(e.getMessage());
                contrasenaValida = false;
            }
        }while (!contrasenaValida);



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
            System.out.println("Ingrese su rol (Voluntario o Creador): ");
             rol = scanner.nextLine();
        }while(!rol.equals("Voluntario") && !rol.equals("Creador"));


        if (rol.equals("Voluntario")) {
            usuario = new Voluntario(nombre, nombreUsuario, contrasena, email);
        } else if (rol.equals("Creador")) {
            System.out.println("Ingrese su ONG: ");
            String ong = scanner.nextLine();
            usuario = new CreadorIniciativa(nombre, nombreUsuario, contrasena, email, ong);
        }
        return usuario;
    }

}
