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

    public void crearIniciativas(String nombre, String descripcion, CreadorIniciativa creador, List<Actividad> actividades) {
        Iniciativa iniciativa = new Iniciativa(nombre, descripcion, creador, actividades);
        iniciativasCreadas.add(iniciativa);
    }

    public void gestionarActividades(Iniciativa iniciativa, String accion) {

    }

    public void asignarVoluntario(Actividad actividad, Voluntario voluntario) {

    }

    @Override
    public String getRol() {
        return "Creador";
    }
}
