import controller.UsuarioController;
import controller.CreadorController;
import controller.IniciativaController;
import controller.VoluntarioController;
import exceptions.FechaNoValidaException;
import exceptions.NombreNoValidoException;
import model.CreadorIniciativa;
import model.Voluntario;
import view.Vista;

public class Main {
    public static void main(String[] args) throws FechaNoValidaException, NombreNoValidoException {
        // Cargar datos existentes
        UsuarioController.cargarUsuarios();
        CreadorController.cargarIniciativas("iniciativas.xml");
        IniciativaController.cargarActividades();

        boolean salir = false;
        while (!salir) {
            int opcionPrincipal = Vista.mostrarMenuLogin();
            switch (opcionPrincipal) {
                case 1:
                    int opcionInicioSesion = Vista.mostrarMenuEleccion();
                    //Iniciar sesión
                    switch (opcionInicioSesion) {
                        case 1:
                            //Creador
                            String usuarioCreador = Vista.pedirUsuario();
                            String contrasenaCreador = Vista.pedirContrasena();
                            if (UsuarioController.iniciarSesionCreador(usuarioCreador, contrasenaCreador)) {
                                // Si el inicio de sesión es exitoso, se muestra el menú del creador
                                System.out.println("Inicio de sesión exitoso como creador.");
                            } else {
                                // Si el inicio de sesión falla, se muestra un mensaje de error
                                System.out.println("Error: Usuario o contraseña incorrectos.");
                            }
                            break;

                        case 2:
                            //Voluntario
                            String usuarioVoluntario = Vista.pedirUsuario();
                            String contrasenaVoluntario = Vista.pedirContrasena();
                            if (UsuarioController.iniciarSesionVoluntario(usuarioVoluntario, contrasenaVoluntario)) {
                                // Si el inicio de sesión es exitoso, se muestra el menú del voluntario
                                System.out.println("Inicio de sesión exitoso como voluntario.");
                            } else {
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


            // Guardar datos antes de salir
            UsuarioController.registrarUsuario();
            CreadorController.guardarIniciativas(CreadorController.cargarIniciativas("iniciativas.xml"), "iniciativas.xml");
            IniciativaController.guardarActividades(IniciativaController.cargarActividades(), "actividades.xml");

            System.out.println("¡Gracias por usar nuestro programa!");
        }

        /*private static void gestionarMenuCreador (CreadorIniciativa creador){
            boolean cerrarSesion = false;
            while (!cerrarSesion) {
                int opcion = Vista.mostrarMenuCreador();
                switch (opcion) {
                    case 1: // Crear iniciativa
                        CreadorController.crearIniciativa();
                        break;
                    case 2: // Eliminar iniciativa
                        CreadorController.eliminarIniciativa();
                    case 3: // Actualizar iniciativa
                        CreadorController.actualizarIniciativa();
                        break;
                    case 4: // Listar iniciativas creadas
                        CreadorController.listarIniciativas();
                        break;
                    case 5: // Crear actividad
                        IniciativaController.crearActividad();
                        break;
                    case 6: // Eliminar actividad
                        IniciativaController.eliminarActividad();
                        break;
                    case 7: // Actualizar actividad
                        IniciativaController.actualizarActividad();
                        break;
                    case 8: // Listar actividades
                        IniciativaController.listarActividades();
                        break;
                    case 9: // Cerrar sesión
                        cerrarSesion = true;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }
        }*/

        /*private static void gestionarMenuVoluntario (Voluntario voluntario){
            boolean cerrarSesion = false;
            while (!cerrarSesion) {
                int opcion = Vista.mostrarMenuVoluntario();
                switch (opcion) {
                    case 1:
                        VoluntarioController.
                        break;
                    case 2:
                        VoluntarioController.;
                        break;
                    case 3:
                        VoluntarioController.
                        break;
                    case 4:
                        Voluntario.verPuntos();
                        break;
                    case 5: // Cerrar sesión
                        cerrarSesion = true;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }
        }*/
    }
}