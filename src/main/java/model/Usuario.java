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

    /**
     * Constructor fullEquip
     */
    public Usuario(String nombre, String usuario, String contrasena, String email) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.email = email;
    }

    /**
     * Constructor por defecto
     */
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

    /**
     * Método GET para nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método SET para nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método GET para usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Método SET para usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Método GET para contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Método SET para contrasena
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Método GET para email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método SET para email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método para obtener la instancia de Usuario
     */
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

    /**
     * Método para establecer la instancia de Usuario
     */
    public static void setInstance(Usuario instance) {
        Usuario.instance = instance;
    }

    /**
     * Método hash para la contraseña
     */
    private String hashPassword(String contrasena) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(contrasena.getBytes());
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al hashear la contraseña", e);
        }
    }

    /**
     * Método para obtener el rol del usuario
     */
    public abstract String getRol();
}
