package controller;

import model.Usuario;
import utils.XMLManager;
import view.ViewRegistro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UsuarioController {
    private static Set<Usuario> usuarios = new HashSet<>();

    public static void registrarUsuario() {
        Usuario usuario = ViewRegistro.pideDatosUsuario();

        if (usuario != null) {
            usuarios.add(usuario);
            System.out.println("Usuario registrado con éxito");
        } else {
            System.out.println("Error al registrar usuario");
        }

    }

    public static void guardarUsuarios(String UsuariosXML) {
        if (XMLManager.writeXML(usuarios, UsuariosXML)) {
            System.out.println("Los usuarios se han guardado");
        } else {
            System.out.println("Error al guardar los usuarios");
        }

    }


}
