package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Voluntario extends Usuario implements Serializable {
    private int puntos;
    private ArrayList<Actividad> actividadesAsignadas;

    public Voluntario(String nombre, String usuario, String contraseña, String email) {
        super(nombre, usuario, contraseña, email);
        this.puntos = 0;
        this.actividadesAsignadas = new ArrayList<>();
    }

    public Voluntario() {
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
        if (puntos >= 0) {
            this.puntos += puntos;
        }
    }

    public boolean unirseActividad(Actividad actividad) {
        boolean agregado = false;
        if (actividad != null && actividadesAsignadas.contains(actividad)) {
            actividad.agregarVoluntario(this);
            agregado = true;
        }
        return agregado;
    }

    public boolean cambiarEstadoActividad(Actividad actividad, EstadoActividad nuevoEstado, String comentario) {
        Scanner sc = new Scanner(System.in);
        boolean estadoCambiado = false;
        boolean puntosAgregados = false;
        if (actividadesAsignadas.contains(actividad)) {
            actividad.cambiarEstado(String.valueOf(nuevoEstado), comentario);
            estadoCambiado = true;
            if (nuevoEstado == EstadoActividad.Completada) {
                agregarPuntos(10);
                System.out.println("Por favor, ingrese un comentario para la actividad completada:");
                comentario = sc.nextLine();
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

