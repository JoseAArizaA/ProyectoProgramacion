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
        if (nombre == null || nombre.trim().isEmpty() || descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre y la descripción de la actividad no pueden estar vacíos.");
        }
        if (fechaInicio == null || fechaFin == null || fechaInicio.isAfter(fechaFin)) {
            throw new IllegalArgumentException("Fechas inválidas. La fecha de inicio debe ser antes de la fecha de fin.");
        }
        if (estado == null) {
            throw new IllegalArgumentException("El estado de la actividad no puede ser nulo.");
        }

        for (Actividad act : actividades) {
            if (act.getNombre().equalsIgnoreCase(nombre)) {
                throw new IllegalArgumentException("Ya existe una actividad con el mismo nombre en esta iniciativa.");
            }
        }

        Actividad nuevaActividad = new Actividad(nombre, descripcion, fechaInicio, fechaFin, voluntarioEncargado, estado, comentario);
        this.actividades.add(nuevaActividad);
        System.out.println("Actividad agregada con éxito.");
    }

    public boolean eliminarActividad(Actividad actividad) {
        if (actividad == null) {
            throw new IllegalArgumentException("La actividad a eliminar no puede ser nula.");
        }
        return this.actividades.remove(actividad);
    }

    public void modificarActividad(Actividad actividad, Actividad nuevaActividad) {
        if (actividad == null || nuevaActividad == null) {
            throw new IllegalArgumentException("Las actividades no pueden ser nulas.");
        }
        int index = this.actividades.indexOf(actividad);
        if (index != -1) {
            this.actividades.set(index, nuevaActividad);
            System.out.println("Actividad modificada correctamente.");
        } else {
            System.out.println("No se encontró la actividad para modificar.");
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
