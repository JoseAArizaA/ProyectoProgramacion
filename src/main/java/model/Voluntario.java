package model;

import java.util.ArrayList;
import java.util.List;

public class Voluntario extends Usuario {
    private int puntos;
    private List<Actividad> actividadesAsignadas;

    public Voluntario(String nombre, String usuario, String contraseña, String email) {
        super(nombre, usuario, contraseña, email);
        this.puntos = 0;
        this.actividadesAsignadas = new ArrayList<>();
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public List<Actividad> getActividadesAsignadas() {
        return actividadesAsignadas;
    }

    public void setActividadesAsignadas(List<Actividad> actividadesAsignadas) {
        this.actividadesAsignadas = actividadesAsignadas;
    }

    public void unirseActividad(Actividad actividad) {

    }

    public void cambiarEstadoActividad(Actividad actividad, String nuevoEstado, String comentario) {

    }

    @Override
    public String getRol() {
        return "Voluntario";
    }
}

