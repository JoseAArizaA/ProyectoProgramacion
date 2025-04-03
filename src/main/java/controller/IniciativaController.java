package controller;


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
            Vista.mostrarMensaje("Error al eliminar la actividad.");
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
}

