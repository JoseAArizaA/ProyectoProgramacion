package controller;

import model.CreadorIniciativa;
import model.Iniciativa;

import java.util.List;

public class CreadorController {
    private CreadorIniciativa creador;

    public CreadorController(CreadorIniciativa creador) {
        this.creador = creador;
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

