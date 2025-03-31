package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Actividad {
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Voluntario voluntarioEncargado;
    private EstadoActividad estado;
    private String comentario;
    private List<Voluntario> voluntarios;

    public Actividad(String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, Voluntario voluntarioEncargado, EstadoActividad estado, String comentario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.voluntarioEncargado = voluntarioEncargado;
        this.estado = estado;
        this.comentario = "";
        this.voluntarios = new ArrayList<>();
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

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Voluntario getVoluntarioEncargado() {
        return voluntarioEncargado;
    }

    public void setVoluntarioEncargado(Voluntario voluntarioEncargado) {
        this.voluntarioEncargado = voluntarioEncargado;
    }

    public EstadoActividad getEstado() {
        return estado;
    }

    public void setEstado(EstadoActividad estado) {
        this.estado = estado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public List<Voluntario> getVoluntarios() {
        return voluntarios;
    }

    public void setVoluntarios(List<Voluntario> voluntarios) {
        this.voluntarios = voluntarios;
    }

    public void agregarVoluntario(Voluntario voluntario) {
        this.voluntarios.add(voluntario);
    }

    public void cambiarEstado(String nuevoEstado, String comentario) {
        this.estado = EstadoActividad.valueOf(nuevoEstado);
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Actividad:" +
                "\n- Nombre=" + nombre +
                "\n- Descripcion=" + descripcion +
                "\n- FechaInicio=" + fechaInicio +
                "\n- FechaFin=" + fechaFin +
                "\n- VoluntarioEncargado=" + voluntarioEncargado +
                "\n- Estado=" + estado +
                "\n- Comentario=" + comentario;
    }
}
