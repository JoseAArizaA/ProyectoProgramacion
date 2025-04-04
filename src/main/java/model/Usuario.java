package model;

import exceptions.CorreoInvalidoException;
import exceptions.NombreNoValidoException;
import exceptions.UsuarioNoValidoException;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public abstract class Usuario implements Serializable {
    private static Usuario instance;
    protected String nombre;
    protected String usuario;
    protected String contrasena;
    protected String email;

    public Usuario(String nombre, String usuario, String contrasena, String email) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.email = email;
    }

    public static Usuario getInstancia() {
        if (instance == null) {
            instance = new Usuario() {
                @Override
                public String getRol() {
                    return "";
                }
            };
        }
        return instance;
    }

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws NombreNoValidoException {
        if(nombre == null || !nombre.matches(nombreRegex)){
            throw new NombreNoValidoException("Por favor, introduzca un nombre válido. Caracteres especiales como guiones o puntos no están permitidos.");
        }
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) throws UsuarioNoValidoException{
        if(usuario == null || !usuario.matches(usuarioRegex)){
            throw new UsuarioNoValidoException("El usuario debe contener entre 3 y 20 caracteres alfanuméricos. \nNo se permite el uso de caracteres especiales como vocales acentuadas, comas, puntos, guiones, etc.");
        }
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws CorreoInvalidoException {
        if(email == null || !email.matches(emailRegex)){
            throw new CorreoInvalidoException("Debe introducir una dirección de correo electrónico válida.");
        }
        this.email = email;
    }

    public static Usuario getInstance() {
        if (instance == null) {
            instance = new Usuario() {
                @Override
                public String getRol() {
                    return "";
                }
            };
        }
        return instance;
    }

    public static void setInstance(Usuario instance) {
        Usuario.instance = instance;
    }

    private String hashPassword(String contrasena) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(contrasena.getBytes());
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al hashear la contraseña", e);
        }
    }

    public abstract String getRol();
}
