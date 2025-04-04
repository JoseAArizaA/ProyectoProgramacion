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

    /**
     * Constructor fullEquip
     **/
    public Actividad(String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, Voluntario voluntarioEncargado, EstadoActividad estado, String comentario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.voluntarioEncargado = voluntarioEncargado;
        this.estado = estado;
        this.comentario = "";
    }

    /**
     * Método GET para nombre
     **/
    public String getNombre() {
        return nombre;
    }

    /**
     * Método SET para nombre
     **/
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método GET para descripcion
     **/
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método SET para descripcion
     **/
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método GET para fechaInicio
     **/
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Método SET para fechaInicio
     **/
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Método GET para fechaFin
     **/
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    /**
     * Método SET para fechaFin
     **/
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Método GET para voluntarioEncargado
     **/
    public Voluntario getVoluntarioEncargado() {
        return voluntarioEncargado;
    }

    /**
     * Método SET para voluntarioEncargado
     **/
    public void setVoluntarioEncargado(Voluntario voluntarioEncargado) {
        this.voluntarioEncargado = voluntarioEncargado;
    }

    /**
     * Método GET para estado
     **/
    public EstadoActividad getEstado() {
        return estado;
    }

    /**
     * Método SET para estado
     **/
    public void setEstado(EstadoActividad estado) {
        this.estado = estado;
    }

    /**
     * Método GET para comentario
     **/
    public String getComentario() {
        return comentario;
    }

    /**
     * Método SET para comentario
     **/
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * Método GET para voluntarios
     **/
    public List<Voluntario> getVoluntarios() {
        return voluntarios;
    }

    /**
     * Método SET para voluntarios
     **/
    public void setVoluntarios(List<Voluntario> voluntarios) {
        this.voluntarios = voluntarios;
    }

    /**
     * Método para agregar un voluntario a la lista de voluntarios
     **/
    public void agregarVoluntario(Voluntario voluntario) {
        this.voluntarios.add(voluntario);
    }

    /**
     * Método para cambiar el estado de la actividad
     **/
    public void cambiarEstado(String nuevoEstado, String comentario) {
        this.estado = EstadoActividad.valueOf(nuevoEstado);
        this.comentario = comentario;
    }

    /**
     * Método toString
     **/
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
