package controller;

import exceptions.IniciativaNoExisteException;
import model.CreadorIniciativa;
import model.Iniciativa;
import utils.HashSetContenedor;
import utils.XMLManager;
import view.Vista;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static controller.IniciativaController.ARCHIVO_INICIATIVAS;

public class CreadorController {
    private static CreadorIniciativa creador;

    public CreadorController(CreadorIniciativa creador) {
        this.creador = creador;
    }

    /**
     * Método para guardar las iniciativas en un archivo XML
     * @param iniciativas: Conjunto de iniciativas a guardar
     * @param archivoIniciativas: Nombre del archivo XML
     */
    public static void guardarIniciativas(HashSet<Iniciativa> iniciativas, String archivoIniciativas) {
        HashSetContenedor<Iniciativa> listaIniciativas = new HashSetContenedor<>(iniciativas);
        XMLManager.writeXML(listaIniciativas, archivoIniciativas);
    }

    /**
     * Método para cargar las iniciativas desde un archivo XML
     *
     * @param archivoIniciativas: Nombre del archivo XML
     * @return Lista de iniciativas cargadas
     */
    public static HashSet<Iniciativa> cargarIniciativas(String archivoIniciativas) {
        File archivo = new File(archivoIniciativas);
        boolean archivoExiste = archivo.exists();

        if (!archivoExiste) {
            guardarIniciativas(new HashSet<>(), archivoIniciativas);
        }

        if (archivoExiste) {
            HashSetContenedor<Iniciativa> lecturaIniciativas = new HashSetContenedor<>(new HashSet<>());
            HashSetContenedor<Iniciativa> leeIniciativas = XMLManager.readXML(lecturaIniciativas, archivoIniciativas);
            if (leeIniciativas != null && leeIniciativas.getSet() != null) {
                return new HashSet<>(leeIniciativas.getSet());
            }
        }
        return new HashSet<>();
    }

    /**
     * Método para agregar una iniciativa a la lista de iniciativas y guardarla en el archivo XML
     *
     * @param nuevaIniciativa : Iniciativa a agregar
     * @param iniciativas
     */
    public void agregarIniciativa(Iniciativa nuevaIniciativa, HashSet<Iniciativa> iniciativas) {
        iniciativas.add(nuevaIniciativa);
        guardarIniciativas(iniciativas, ARCHIVO_INICIATIVAS);
    }

    /**
     *Metodo para crear una iniciativa
     */
    public static void crearIniciativa() {
        Iniciativa iniciativa = Vista.pideDatosIniciativa(creador);
        if (creador.crearIniciativa(iniciativa)) {
            Vista.mostrarMensaje("Iniciativa creada con éxito.");
        } else {
            Vista.mostrarMensaje("Error al crear la iniciativa.");
        }
    }

    /**
     *Metodo para eliminar una iniciativa
     */
    public static void eliminarIniciativa() throws IniciativaNoExisteException {
        String nombre = Vista.pedirNombreIniciativa();
        if (creador.eliminarIniciativa(nombre)) {
            Vista.mostrarMensaje("Iniciativa eliminada con éxito.");
        } else {
            throw new IniciativaNoExisteException("La iniciativa con nombre: " + nombre + " no existe.");
        }
    }

    /**
     *Metodo para actualizar una iniciativa
     */
    public static void actualizarIniciativa() {
        Iniciativa iniciativa = Vista.pideDatosIniciativa(creador);
        if (creador.actualizarIniciativa(iniciativa)) {
            Vista.mostrarMensaje("Iniciativa actualizada con éxito.");
        } else {
            Vista.mostrarMensaje("Error al actualizar la iniciativa.");
        }
    }

    /**
     *Metodo para listar las iniciativas
     */
    public static void listarIniciativas() {
        List<Iniciativa> iniciativas = creador.getIniciativasCreadas();
        if (iniciativas.isEmpty()) {
            Vista.mostrarMensaje("No hay iniciativas creadas.");
        } else {
            Vista.mostrarMensaje("Iniciativas creadas por " + creador.getNombre() + ":");
            for (Iniciativa iniciativa : iniciativas) {
                Vista.mostrarMensaje(iniciativa.toString());
            }
        }
    }
}

