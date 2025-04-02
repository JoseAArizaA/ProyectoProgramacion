package model;

import java.util.ArrayList;
import java.util.List;

public class Iniciativa {
    private String nombre;
    private String descripcion;
    private CreadorIniciativa creador;
    private ArrayList<Actividad> actividades;

    public Iniciativa(String nombre, String descripcion, CreadorIniciativa creador) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.creador = creador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CreadorIniciativa getCreador() {
        return creador;
    }

    public void setCreador(CreadorIniciativa creador) {
        this.creador = creador;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<Actividad> actividades) {
        this.actividades = actividades;
    }

    public boolean agregarActividad(Actividad actividad) {
        boolean agregada = false;
        if (actividad != null && !(actividades.contains(actividad))) {
            actividades.add(actividad);
            agregada = true;
        }
        return agregada;
    }

    public boolean eliminarActividad(String nombreActividad) {
        boolean eliminada = false;
        for (int i = 0; i < actividades.size(); i++) {
            if (actividades.get(i).getNombre().equalsIgnoreCase(nombreActividad) && actividades != null) {
                actividades.remove(i);
                eliminada = true;
            }
        }
        return eliminada;
    }

    public boolean modificarActividad(String nombreActividad, Actividad nuevaActividad) {
        boolean modificada = false;
        for (int i = 0; i < actividades.size(); i++) {
            if (actividades.get(i).getNombre().equalsIgnoreCase(nombreActividad) && actividades != null) {
                actividades.set(i, nuevaActividad);
                modificada = true;
            }
        }
        return modificada;
    }

    @Override
    public String toString() {
        return "Iniciativa:" +
                "\n - Nombre= " + nombre +
                "\n - Descripción= " + descripcion +
                "\n - Creador= " + creador +
                "\n - Actividades= " +
                "\n" + actividades;
    }
}
