package Model;

import java.util.ArrayList;
import java.util.List;

public class CreadorIniciativa extends Usuario {
    private String nombreONG;
    private List<Iniciativa> iniciativasCreadas;

    public CreadorIniciativa(String nombre, String usuario, String contraseña, String email, String nombreONG) {
        super(nombre, usuario, contraseña, email);
        this.nombreONG = nombreONG;
        this.iniciativasCreadas = new ArrayList<>();
    }

    public String getNombreONG() {
        return nombreONG;
    }

    public void setNombreONG(String nombreONG) {
        this.nombreONG = nombreONG;
    }

    public List<Iniciativa> getIniciativasCreadas() {
        return iniciativasCreadas;
    }

    public void setIniciativasCreadas(List<Iniciativa> iniciativasCreadas) {
        this.iniciativasCreadas = iniciativasCreadas;
    }

    public void crearIniciativa(String nombre, String descripcion) {

    }

    public void gestionarActividad(Iniciativa iniciativa, String accion) {

    }

    public void asignarVoluntario(Actividad actividad, Voluntario voluntario) {

    }

    @Override
    public String getRol() {
        return "Creador";
    }
}
