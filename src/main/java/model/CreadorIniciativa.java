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

    public void gestionarActividades(Iniciativa iniciativa, String accion) {

    }

    public void asignarVoluntario(Actividad actividad, Voluntario voluntario) {
    }

    @Override
    public String getRol() {
        return "Creador";
    }

    @Override
    public String toString() {
        return "Creador: " + usuario;
    }
}
