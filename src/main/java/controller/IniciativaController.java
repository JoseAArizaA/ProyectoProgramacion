package controller;


import exceptions.ActividadNoExisteException;
import exceptions.FechaNoValidaException;
import exceptions.NombreNoValidoException;
import model.Actividad;
import model.Iniciativa;
import utils.HashSetContenedor;
import utils.Utilidades;
import utils.XMLManager;
import view.Vista;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import static view.Vista.pideDatosActividad;

public class IniciativaController {
    private static Iniciativa iniciativa;
    private HashSet<Iniciativa> iniciativas;
    private static HashSet<Actividad> actividades = new HashSet<>();
    static final String ARCHIVO_INICIATIVAS = "iniciativas.xml";
    static final String ARCHIVO_ACTIVIDADES = "actividades.xml";

    public IniciativaController(Iniciativa iniciativa) {
        this.iniciativa = iniciativa;
    }


    /**
     * Método para guardar las actividades en un archivo XML
     * @param actividades
     * @param archivoActividades
     */
    public static void guardarActividades(HashSet<Actividad> actividades, String archivoActividades) {
        HashSetContenedor<Actividad> listaActividades = new HashSetContenedor<>(actividades);
        XMLManager.writeXML(listaActividades, archivoActividades);
    }

    /**
     * Método para cargar las actividades desde un archivo XML
     *
     * @return
     */
    public static HashSet<Actividad> cargarActividades() {
        File archivo = new File("actividades.xml");
        boolean archivoExiste = archivo.exists();

        if (!archivoExiste) {
            guardarActividades(new HashSet<>(), "actividades.xml");
        }

        if (archivoExiste) {
            HashSetContenedor<Actividad> lecturaActividades = new HashSetContenedor<>(new HashSet<>());
            HashSetContenedor<Actividad> leeActividades = XMLManager.readXML(lecturaActividades, "actividades.xml");
            if (leeActividades != null && leeActividades.getSet() != null) {
                ArrayList<Actividad> actividades = new ArrayList<>(leeActividades.getSet());
            }
        }
        return null;
    }

    /**
     * Método para agregar una actividad a la lista de actividades
     * @param actividad
     */
    public static void agregarActividad(Actividad actividad) {
        actividades.add(actividad);
        guardarActividades(new HashSet<>(actividades), ARCHIVO_ACTIVIDADES);
    }

    /**
     * Método para crear una actividad, y guardarla en el archivo XML
     * @return: Actividad creada
     * @throws FechaNoValidaException
     * @throws NombreNoValidoException
     */
    public static Actividad crearActividad() throws FechaNoValidaException, NombreNoValidoException {
        Actividad nuevaActividad = pideDatosActividad();
        agregarActividad(nuevaActividad);
        return nuevaActividad;
    }



    /**
     *Metodo para agregar una actividad a la iniciativa
     */
    public void agregarActividad() {
        Actividad actividad = Vista.pideDatosActividad();
        if (iniciativa.agregarActividad(actividad)) {
            Vista.mostrarMensaje("Actividad creada con éxito.");
        } else {
            Vista.mostrarMensaje("Error al crear la actividad.");
        }
    }

    /**
     * Método para eliminar una actividad de la iniciativa
     */
    public static void eliminarActividad() {
        String nombre = Utilidades.pideString("Nombre de la actividad a eliminar: ");
        if (iniciativa.eliminarActividad(nombre)) {
            Vista.mostrarMensaje("Actividad eliminada con éxito.");
        } else {
            throw new ActividadNoExisteException("La actividad con nombre: " + nombre + " no existe.");
        }
    }

    /**
     * Método para actualizar una actividad de la iniciativa
     */
    public static void actualizarActividad() {
        Actividad actividad = Vista.pideDatosActividad();
        if (iniciativa.actualizarActividad(actividad)) {
            Vista.mostrarMensaje("Actividad actualizada con éxito.");
        } else {
            Vista.mostrarMensaje("Error al actualizar la actividad.");
        }
    }

    /**
     * Método para listar las actividades de la iniciativa
     */
    public static void listarActividades() {
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

