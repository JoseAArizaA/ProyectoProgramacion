package controller;

import model.CreadorIniciativa;
import model.Iniciativa;
import view.Vista;

import java.util.List;

public class CreadorController {
    private CreadorIniciativa creador;

    public CreadorController(CreadorIniciativa creador) {
        this.creador = creador;
    }

    public void crearIniciativa() {
        Iniciativa iniciativa = Vista.pideDatosIniciativa();
        if (creador.crearIniciativa(iniciativa)) {
            System.out.println("Iniciativa creada con éxito.");
        } else {
            System.out.println("Error al crear la iniciativa.");
        }
    }

    /**
     * Primero, solicita al usuario el nombre de la iniciativa que desea eliminar.
     * Luego, busca la iniciativa en la lista de iniciativas creadas por el creador.
     * Utiliza un flujo (stream) para filtrar las iniciativas y encontrar la que coincida
     * con el nombre proporcionado. A continuación, intenta eliminar la iniciativa.
     */
    public void eliminarIniciativa() {
        /*String nombreIniciativa = Vista.pideNombreIniciativa();
        Iniciativa iniciativa = creador.getIniciativasCreadas().stream()
                .filter(i -> i.getNombre().equals(nombreIniciativa))
                .findFirst()
                .orElse(null);
        if (creador.eliminarIniciativa(iniciativa)) {
            System.out.println("Iniciativa eliminada con éxito.");
        } else {
            System.out.println("Error al eliminar la iniciativa.");
        }*/
    }

    public void actualizarIniciativa() {

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

