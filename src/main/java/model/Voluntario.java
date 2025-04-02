package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Voluntario extends Usuario {
    private int puntos;
    private ArrayList<Actividad> actividadesAsignadas;

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

    public void setActividadesAsignadas(ArrayList<Actividad> actividadesAsignadas) {
        this.actividadesAsignadas = actividadesAsignadas;
    }

    public void agregarPuntos(int puntos) {
        if (puntos > 0) {
            this.puntos += puntos;
        }
    }

    public void solicitarActividad(Actividad actividad) {
    }

    public boolean cambiarEstadoActividad(Actividad actividad, EstadoActividad nuevoEstado, String comentario) {
        boolean estadoCambiado = false;
        boolean puntosAgregados = false;
        if (actividadesAsignadas.contains(actividad)) {
            actividad.cambiarEstado(String.valueOf(nuevoEstado), comentario);
            estadoCambiado = true;
            if (nuevoEstado == EstadoActividad.Completada) {
                agregarPuntos(10);
                if (comentario == null || comentario.trim().isEmpty()) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Por favor, ingrese un comentario para la actividad completada:");
                    comentario = sc.nextLine();
                }
                actividad.setComentario(comentario);
                puntosAgregados = true;
            }
        }
        return estadoCambiado && puntosAgregados;
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

