package model;

import exceptions.CorreoNoValidoException;
import exceptions.NombreNoValidoException;
import exceptions.UsuarioNoValidoException;

import java.io.Serializable;

public abstract class Usuario implements Serializable {
    protected String nombre;
    protected String usuario;
    protected String contrasena;
    protected String email;
    protected String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
    protected String nombreRegex = "^[A-Za-zÁÉÍÓÚáéíóúÄËÏÖÜäëïöüÂÊÎÔÛâêîôûÀÈÌÒÙàèìòùÑñ]";
    protected String usuarioRegex = "^[A-Za-z0-9]{3,20}";

    public Usuario(String nombre, String usuario, String contrasena, String email) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.email = email;
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

    public void setEmail(String email) throws CorreoNoValidoException {
        if(email == null || !email.matches(emailRegex)){
            throw new CorreoNoValidoException("Debe introducir una dirección de correo electrónico válida.");
        }
        this.email = email;
    }

    public abstract String getRol();
}
