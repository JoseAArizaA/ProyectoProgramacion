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
        for (Actividad a : actividades) {
            if (a.getNombre().equalsIgnoreCase(nombreActividad) && actividades != null) {
                actividades.remove(a);
                eliminada = true;
                break;
            }
        }
        return eliminada;
    }

    public boolean actualizarActividad(Actividad nuevaActividad) {
        boolean modificada = false;
        for (Actividad a : actividades) {
            if (a.getNombre().equalsIgnoreCase(nuevaActividad.getNombre())) {
                a.setDescripcion(nuevaActividad.getDescripcion());
                a.setFechaInicio(nuevaActividad.getFechaInicio());
                a.setFechaFin(nuevaActividad.getFechaFin());
                a.setVoluntarioEncargado(nuevaActividad.getVoluntarioEncargado());
                a.setEstado(nuevaActividad.getEstado());
                a.setComentario(nuevaActividad.getComentario());
                modificada = true;
                break;
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
