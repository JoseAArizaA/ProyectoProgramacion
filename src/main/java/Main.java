import controller.UsuarioController;
import model.Usuario;
import view.Vista;

public class Main {
    public static void main(String[] args) {
        UsuarioController.cargarUsuarios();
        Vista.mostrarMenuLogin();
        UsuarioController.registrarUsuario();

    }



}