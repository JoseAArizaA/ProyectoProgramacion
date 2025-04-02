package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class CreadorIniciativa extends Usuario implements Serializable {
    private String Ong;
    private List<Iniciativa> iniciativasCreadas;

    public CreadorIniciativa(String nombre, String usuario, String contrasena, String email, String ong) {
        super(nombre, usuario, contrasena, email);
        this.Ong = ong;
        this.iniciativasCreadas = new ArrayList<>();
    }

    public CreadorIniciativa() {
    }

    public String getOng() {
        return Ong;
    }

    public void setOng(String ong) {
        Ong = ong;
    }

    public List<Iniciativa> getIniciativasCreadas() {
        return iniciativasCreadas;
    }

    public void setIniciativasCreadas(List<Iniciativa> iniciativasCreadas) {
        this.iniciativasCreadas = iniciativasCreadas;
    }

    public void crearIniciativa(String nombre, String descripcion, CreadorIniciativa creador) {
        Iniciativa iniciativa = new Iniciativa(nombre, descripcion, creador);
        iniciativasCreadas.add(iniciativa);
    }

    public void eliminarIniciativa(Iniciativa iniciativa) {
        iniciativasCreadas.remove(iniciativa);
    }

    //¿Hace falta?/*public void gestionarActividades(Iniciativa iniciativa, String accion) {}

    @Override
    public String getRol() {
        return "Creador";
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " Usuario: " + usuario;
    }
}
