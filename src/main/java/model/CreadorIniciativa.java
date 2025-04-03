package model;

import java.util.ArrayList;
import java.util.List;

public class CreadorIniciativa extends Usuario {
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

    public boolean crearIniciativa(Iniciativa iniciativa) {
        boolean creada = false;
        if (iniciativa != null && !(iniciativasCreadas.contains(iniciativa))) {
            iniciativasCreadas.add(iniciativa);
            creada = true;
        }
        return creada;
    }

    public boolean eliminarIniciativa(Iniciativa iniciativa) {
        boolean eliminada = false;
        if (iniciativa!= null && iniciativasCreadas.contains(iniciativa)) {
            iniciativasCreadas.remove(iniciativa);
            eliminada = true;
        }
        return eliminada;
    }

    public boolean actualizarIniciativa(Iniciativa iniciativa, String nuevaIniciativa) {
        boolean actualizada = false;
        if (iniciativa != null && iniciativasCreadas.contains(iniciativa)) {
            iniciativa.setNombre(nuevaIniciativa);
            iniciativa.setDescripcion(nuevaIniciativa);
            iniciativa.setCreador(this);
            actualizada = true;
        }
        return actualizada;
    }

    @Override
    public String getRol() {
        return "Creador";
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " Usuario: " + usuario;
    }
}
