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

    public void agregarPuntos(int puntos) {
        if (puntos > 0) {
            this.puntos += puntos;
        }
    }

    public void solicitarActividad(Actividad actividad) {
    }

    public void cambiarEstadoActividad(Actividad actividad, EstadoActividad nuevoEstado, String comentario) {
        if (actividadesAsignadas.contains(actividad)) {
            actividad.cambiarEstado(String.valueOf(nuevoEstado), comentario);
            System.out.println("El estado de la actividad ha cambiado a: " + nuevoEstado.getMensaje());

            if (nuevoEstado == EstadoActividad.Completada) {
                agregarPuntos(10);
                System.out.println("¡Has ganado 10 puntos! Puntos actuales: " + puntos);
            }
        } else {
            System.out.println("No estás inscrito en esta actividad.");
        }
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

