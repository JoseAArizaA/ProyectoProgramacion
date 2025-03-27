package controller;

import model.Usuario;
import view.View;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
    private static List<Usuario> usuarios = new ArrayList<>();

    public static void registrarUsuario() {
        Usuario usuario = View.pideDatosUsuario();



    }

}
