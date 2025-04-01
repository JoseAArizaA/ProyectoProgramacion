package controller;

import Exceptions.IniciativaIncorrectaException;
import Exceptions.NombreIniciativaIncorrectoException;
import Exceptions.NombreYDescripcionIniciativaIncorrectoException;
import model.CreadorIniciativa;
import model.Iniciativa;

import java.util.List;

public class CreadorController {
    private CreadorIniciativa creador;

    public CreadorController(CreadorIniciativa creador) {
        this.creador = creador;
    }

    public void crearIniciativa(String nombre, String descripcion) throws NombreIniciativaIncorrectoException {
        try {
            creador.crearIniciativa(nombre, descripcion);
            System.out.println("Iniciativa creada con éxito.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear la iniciativa: " + e.getMessage());
        }
    }

    public void eliminarIniciativa(Iniciativa iniciativa) {
        if (creador.eliminarIniciativa(iniciativa)) {
            System.out.println("Iniciativa eliminada con éxito.");
        } else {
            System.out.println("No se encontró la iniciativa para eliminar.");
        }
    }

    public void actualizarIniciativa(Iniciativa iniciativa, String nuevoNombre, String nuevaDescripcion) throws NombreYDescripcionIniciativaIncorrectoException, IniciativaIncorrectaException {
        try {
            creador.actualizarIniciativa(iniciativa, nuevoNombre, nuevaDescripcion);
            System.out.println("Iniciativa actualizada con éxito.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al actualizar la iniciativa: " + e.getMessage());
        }
    }

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

