package Model;

import java.util.ArrayList;
import java.util.List;

public class Iniciativa {
    private String nombre;
    private String descripcion;
    private CreadorIniciativa creador;
    private List<Actividad> actividades;

    public Iniciativa(String nombre, String descripcion, CreadorIniciativa creador, List<Actividad> actividades) {
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

    public void agregarActividades(Actividad actividad) {

    }
}
