package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Voluntario extends Usuario {
    private int puntos;
    private ArrayList<Actividad> actividadesAsignadas;

    /**
     * Constructor fullEquip
     */
    public Voluntario(String nombre, String usuario, String contraseña, String email) {
        super(nombre, usuario, contraseña, email);
        this.puntos = 0;
        this.actividadesAsignadas = new ArrayList<>();
    }

    /**
     * Constructor por defecto
     */
    public Voluntario() {
    }

    /**
     * Método GET para puntos
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * Método SET para puntos
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * Método GET para actividadesAsignadas
     */
    public List<Actividad> getActividadesAsignadas() {
        return actividadesAsignadas;
    }

    /**
     * Método SET para actividadesAsignadas
     */
    public void setActividadesAsignadas(ArrayList<Actividad> actividadesAsignadas) {
        this.actividadesAsignadas = actividadesAsignadas;
    }

    /**
     * Método para agregar sumar puntos
     * @param puntos:puntos que se van a sumar
     */
    public void agregarPuntos(int puntos) {
        if (puntos >= 0) {
            this.puntos += puntos;
        }
    }

    /**
     * Método para unirse a una actividad
     * @param actividad: actividad a la que se va a unir
     * @return: true si se une a la actividad, false si no se une
     */
    public boolean unirseActividad(Actividad actividad) {
        boolean agregado = false;
        if (actividad != null && !actividadesAsignadas.contains(actividad)) {
            actividad.agregarVoluntario(this);
            agregado = true;
        }
        return agregado;
    }

    /**
     * Método para cambiar el estado de una actividad
     * @param actividad: Actividad a la que se le va a cambiar el estado
     * @param nuevoEstado: nuevo estado que va a tener la actividad
     * @param comentario: Comentario que se le va a agregar a la actividad
     * @return: true si se cambia el estado de la actividad, false si no se cambia
     */
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

    /**
     * Método para mostrar los puntos
     */
    public void verPuntos() {
        System.out.println("Puntos: " + this.puntos);
    }

    /**
     * Método para mostrar el rol
     */
    @Override
    public String getRol() {
        return "Voluntario";
    }

    /**
     * Método ToString
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + " Usuario= " + usuario;
    }
}

