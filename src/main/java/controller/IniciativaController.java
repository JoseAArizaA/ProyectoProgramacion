package controller;


import exceptions.ActividadNoExisteException;
import model.Actividad;
import model.Iniciativa;
import utils.Utilidades;
import view.Vista;

public class IniciativaController {
    private Iniciativa iniciativa;

    public IniciativaController(Iniciativa iniciativa) {
        this.iniciativa = iniciativa;
    }

    public void agregarActividad() {
        Actividad actividad = Vista.pideDatosActividad();
        if (iniciativa.agregarActividad(actividad)) {
            Vista.mostrarMensaje("Actividad creada con éxito.");
        } else {
            Vista.mostrarMensaje("Error al crear la actividad.");
        }
    }

    public void eliminarActividad() {
        String nombre = Utilidades.pideString("Nombre de la actividad a eliminar: ");
        if (iniciativa.eliminarActividad(nombre)) {
            Vista.mostrarMensaje("Actividad eliminada con éxito.");
        } else {
            throw new ActividadNoExisteException("La actividad con nombre: " + nombre + " no existe.");
        }
    }

    public void actualizarActividad() {
        Actividad actividad = Vista.pideDatosActividad();
        if (iniciativa.actualizarActividad(actividad)) {
            Vista.mostrarMensaje("Actividad actualizada con éxito.");
        } else {
            Vista.mostrarMensaje("Error al actualizar la actividad.");
        }
    }

    public void listarActividades() {
        if (iniciativa.getActividades().isEmpty()) {
            Vista.mostrarMensaje("No hay actividades creadas.");
        } else {
            Vista.mostrarMensaje("Actividades de la iniciativa: " + iniciativa.getNombre());
            for (Actividad actividad : iniciativa.getActividades()) {
                Vista.mostrarMensaje(actividad.toString());
            }
        }
    }
}

