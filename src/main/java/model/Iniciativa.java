package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Iniciativa {
    private String nombre;
    private String descripcion;
    private CreadorIniciativa creador;
    private List<Actividad> actividades;

    public Iniciativa(String nombre, String descripcion, CreadorIniciativa creador) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.creador = creador;
        this.actividades = new ArrayList<>();
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

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public void agregarActividad(String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, Voluntario voluntarioEncargado, EstadoActividad estado, String comentario) {
        Actividad actividad = new Actividad(nombre, descripcion, fechaInicio, fechaFin, voluntarioEncargado, estado, comentario);
        this.actividades.add(actividad);
    }

    public void eliminarActividad(Actividad actividad) {
        this.actividades.remove(actividad);
    }

    public void modificarActividad(Actividad actividad, Actividad nuevaActividad) {
        int index = this.actividades.indexOf(actividad);
        if (index!= -1) {
            this.actividades.set(index, nuevaActividad);
        }
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
