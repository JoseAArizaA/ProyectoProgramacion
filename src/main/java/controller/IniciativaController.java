package controller;


import exceptions.ActividadNoExisteException;
import model.Actividad;
import model.Iniciativa;
import model.Voluntario;
import utils.HashSetContenedor;
import utils.Utilidades;
import utils.XMLManager;
import view.Vista;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

import model.Actividad;
import model.Iniciativa;
import utils.Utilidades;
import view.Vista;

public class IniciativaController {
    private Iniciativa iniciativa;
    private HashSet<Iniciativa> iniciativas;
    private static final String ARCHIVO_INICIATIVAS = "iniciativas.xml";

    public IniciativaController(Iniciativa iniciativa) {
        this.iniciativa = iniciativa;
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
     * @param archivoIniciativas: Nombre del archivo XML
     * @return Lista de iniciativas cargadas
     */
    public static ArrayList<Iniciativa> cargarIniciativas(String archivoIniciativas) {
        File archivo = new File(archivoIniciativas);
        boolean archivoExiste = archivo.exists();

        if (!archivoExiste) {
            guardarIniciativas(new HashSet<>(), archivoIniciativas);
        }

        if (archivoExiste) {
            HashSetContenedor<Iniciativa> lecturaIniciativas = new HashSetContenedor<>(new HashSet<>());
            HashSetContenedor<Iniciativa> leeIniciativas = XMLManager.readXML(lecturaIniciativas, archivoIniciativas);
            if (leeIniciativas != null && leeIniciativas.getSet() != null) {
                return new ArrayList<>(leeIniciativas.getSet());
            }
        }
        return new ArrayList<>();
    }

    /**
     * Método para agregar una iniciativa a la lista de iniciativas y guardarla en el archivo XML
     * @param nuevaIniciativa: Iniciativa a agregar
     */
    public void agregarIniciativa(Iniciativa nuevaIniciativa) {
        iniciativas.add(nuevaIniciativa);
        guardarIniciativas(iniciativas, ARCHIVO_INICIATIVAS);
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

