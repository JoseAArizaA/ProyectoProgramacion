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

    public void solizitarActividad(Actividad actividad) {
    }

    public void cambiarEstadoActividad(Actividad actividad, String nuevoEstado, String comentario) {
        if (this.actividadesAsignadas.contains(actividad)) {
            actividad.cambiarEstado(nuevoEstado, comentario);
            System.out.println("El estado de la actividad ha sido cambiado a: " + nuevoEstado);
        } else {
            System.out.println("Usted no se encuentra inscrito en esta actividad.");
        }
    }

    public List<Actividad> verActividadesAsignadas() {
        return this.actividadesAsignadas;
    }

    public void verPuntos() {
        System.out.println("Puntos: " + this.puntos);
    }

    @Override
    public String getRol() {
        return "Voluntario";
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " Usuario= " + usuario;
    }
}

