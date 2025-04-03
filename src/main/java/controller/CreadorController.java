package controller;

import exceptions.IniciativaNoExisteException;
import model.CreadorIniciativa;
import model.Iniciativa;
import view.Vista;

import java.util.List;

public class CreadorController {
    private CreadorIniciativa creador;

    public CreadorController(CreadorIniciativa creador) {
        this.creador = creador;
    }

    /**
     *
     */
    public void agregarIniciativa() {
        Iniciativa iniciativa = Vista.pideDatosIniciativa(creador);
        if (creador.agregarIniciativa(iniciativa)) {
            Vista.mostrarMensaje("Iniciativa creada con éxito.");
        } else {
            Vista.mostrarMensaje("Error al crear la iniciativa.");
        }
    }

    /**
     *
     */
    public void eliminarIniciativa() throws IniciativaNoExisteException {
        String nombre = Vista.pedirNombreIniciativa();
        if (creador.eliminarIniciativa(nombre)) {
            Vista.mostrarMensaje("Iniciativa eliminada con éxito.");
        } else {
            throw new IniciativaNoExisteException("La iniciativa con nombre: " + nombre + " no existe.");
        }
    }

    /**
     *
     */
    public void actualizarIniciativa() {
        Iniciativa iniciativa = Vista.pideDatosIniciativa(creador);
        if (creador.actualizarIniciativa(iniciativa)) {
            Vista.mostrarMensaje("Iniciativa actualizada con éxito.");
        } else {
            Vista.mostrarMensaje("Error al actualizar la iniciativa.");
        }
    }

    /**
     *
     */
    public void listarIniciativas() {
        List<Iniciativa> iniciativas = creador.getIniciativasCreadas();
        if (iniciativas.isEmpty()) {
            System.out.println("No hay iniciativas creadas.");
        } else {
            System.out.println("Iniciativas creadas por " + creador.getNombre() + ":");
            for (Iniciativa i : iniciativas) {
                System.out.println("- " + i.getNombre() + ": " + i.getDescripcion());
            }
        }
    }
}

