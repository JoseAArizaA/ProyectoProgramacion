import controller.UsuarioController;
import model.Usuario;
import view.Vista;

public class Main {
    public static void main(String[] args) {
        UsuarioController.cargarUsuarios();

        switch (Vista.mostrarMenuLogin()){
            case 1:
               //Iniciar sesión
                switch (Vista.mostrarMenuEleccion()){
                    case 1:
                        //Creador
                        String usuarioCreador = Vista.pedirUsuario();
                        String contrasenaCreador = Vista.pedirContrasena();
                        if(UsuarioController.iniciarSesionCreador(usuarioCreador, contrasenaCreador)){
                            // Si el inicio de sesión es exitoso, se muestra el menú del creador
                            System.out.println("Inicio de sesión exitoso como creador.");
                        }else{
                            // Si el inicio de sesión falla, se muestra un mensaje de error
                            System.out.println("Error: Usuario o contraseña incorrectos.");
                        }
                        break;

                    case 2:
                        //Voluntario
                        String usuarioVoluntario = Vista.pedirUsuario();
                        String contrasenaVoluntario = Vista.pedirContrasena();
                        if(UsuarioController.iniciarSesionVoluntario(usuarioVoluntario, contrasenaVoluntario)) {
                            // Si el inicio de sesión es exitoso, se muestra el menú del voluntario
                            System.out.println("Inicio de sesión exitoso como voluntario.");
                        }else{
                            System.out.println("Error: Usuario o contraseña incorrectos.");
                        }
                        break;
                }
                break;

            case 2:
                //Registrarse
                UsuarioController.registrarUsuario();
                break;

        }
    }



}