package model;

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

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
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

    public void setEmail(String email) {
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
