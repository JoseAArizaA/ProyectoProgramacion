package model;

import java.util.ArrayList;
import java.util.List;

public class Iniciativa {
    private String nombre;
    private String descripcion;
    private CreadorIniciativa creador;
    private ArrayList<Actividad> actividades;

    /**
     * Constructor fullEquip
     **/
    public Iniciativa(String nombre, String descripcion, CreadorIniciativa creador) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.creador = creador;
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
     * Método GET para creador
     **/
    public CreadorIniciativa getCreador() {
        return creador;
    }

    /**
     * Método SET para creador
     **/
    public void setCreador(CreadorIniciativa creador) {
        this.creador = creador;
    }

    /**
     * Método GET para actividades
     **/
    public List<Actividad> getActividades() {
        return actividades;
    }

    /**
     * Método SET para actividades
     **/
    public void setActividades(ArrayList<Actividad> actividades) {
        this.actividades = actividades;
    }

    /**
     * Método que agrega una actividad a la lista de actividades.
     * @param actividad: Actividad que se va a agregar.
     * @return: true si se agrega la actividad, false si no se agrega.
     */
    public boolean agregarActividad(Actividad actividad) {
        boolean agregada = false;
        if (actividad != null && !(actividades.contains(actividad))) {
            actividades.add(actividad);
            agregada = true;
        }
        return agregada;
    }

    /**
     * Método que elimina una actividad de la lista de actividades.
     * @param nombreActividad: Nombre de la actividad a eliminar.
     * @return: true si se elimina la actividad, false si no se elimina.
     */
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

    /**
     * Método que actualiza una actividad de la lista de actividades.
     * @param nuevaActividad: Actividad con los nuevos datos.
     * @return: true si se actualiza la actividad, false si no se actualiza.
     */
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

    /**
     * Método toString
     */
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
