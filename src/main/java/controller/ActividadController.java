package controller;

import exceptions.FechaNoValidaException;
import exceptions.NombreNoValidoException;
import model.Actividad;
import model.EstadoActividad;
import model.Voluntario;
import utils.Utilidades;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import static view.Vista.pideDatosActividad;

public class ActividadController {
    private HashSet<Voluntario> voluntarios;
    private ArrayList<Actividad> actividades;
    private Voluntario encargado;

    /**
     * Constructor de la clase ActividadController
     * @param voluntarios: conjunto de voluntarios
     * @param actividades: lista de actividades
     * @param encargado: voluntario encargado
     */
    public ActividadController(HashSet<Voluntario> voluntarios, ArrayList<Actividad> actividades, Voluntario encargado) {
        this.voluntarios = voluntarios;
        this.actividades = actividades;
        this.encargado = encargado;
    }

    /**
     * Método para crear una actividad
     * @return: Actividad creada
     * @throws FechaNoValidaException:Excepción lanzada si la fecha no es válida
     * @throws NombreNoValidoException: Excepción lanzada si el nombre no es válido
     */
    public Actividad crearActividad() throws FechaNoValidaException, NombreNoValidoException {
        return pideDatosActividad();
    }

    /**
     * Método para modificar una actividad
     * @param actividades: lista de actividades
     * @return: Actividad modificada
     * @throws FechaNoValidaException: Excepción lanzada si la fecha no es válida
     * @throws NombreNoValidoException: Excepción lanzada si el nombre no es válido
     */
    public Actividad modificarActividad(ArrayList<Actividad> actividades) throws FechaNoValidaException, NombreNoValidoException{
        Scanner sc = new Scanner(System.in);
        int indice = 0;
        Actividad modificada;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        Voluntario nuevoEncargado = null;

        Utilidades.pideString("¿Qué actividad quiere modificar?");
        mostrarAcividades(actividades);

        do {
            Utilidades.pideString("Ingrese el índice de la actividad que quiera modificar: ");
            for (int i = 0; i < actividades.size(); i++) {
                Actividad activity = actividades.get(i);
                System.out.println(i + ": " + activity.getNombre());
            }
            indice = sc.nextInt();
            modificada = actividades.get(indice - 1);
            Utilidades.pideString(modificada.getNombre() + " seleccionada.");
        } while (indice < 0 || indice > actividades.size());

        Utilidades.pideString("Seleccione el atributo a modificar: \nnombre \ndescripción \nfecha de inicio \nfecha de fin \nestado \ncomentario \nencargado");
        String atributo = sc.nextLine();
        switch (atributo) {
            case "nombre":
                Utilidades.pideString("Ingrese el nuevo nombre: ");
                String nombreNuevo = sc.next();
                if(actividades.contains(nombreNuevo)) {
                    Utilidades.pideString("El usuario ya figura en nuestro gestor.");
                }else if(nombreNuevo == null || !nombreNuevo.matches("^[A-Za-zÁÉÍÓÚáéíóúÄËÏÖÜäëïöüÂÊÎÔÛâêîôûÀÈÌÒÙàèìòùÑñ]")){
                    throw new NombreNoValidoException("El nombre introducido no cumple con las condiciones. Por favor, inténtelo de nuevo.");
                }else {
                    modificada.setNombre(nombreNuevo);
                }
                break;
            case "descripción":
                Utilidades.pideString("Ingrese una nueva descripción para la actividad:");
                String nuevaDescripcion = sc.next();
                modificada.setDescripcion(nuevaDescripcion);
                break;
            case "fecha de inicio":
                Utilidades.pideFecha("Ingrese la nueva fecha de inicio: ");
                String nuevaFechaInicio = sc.next();
                LocalDate fechaInicioNueva = Utilidades.pideFecha(nuevaFechaInicio);
                if(!fechaInicioNueva.equals(formato)){
                    throw new FechaNoValidaException("La fecha debe cumplir con el siguiente patrón: dd-MM-yyyy");
                }else {
                    modificada.setFechaInicio(fechaInicioNueva);
                }
                break;
            case "fecha de fin":
                Utilidades.pideFecha("Ingrese la nueva fecha de finalización: ");
                String nuevaFechaFin = sc.next();
                LocalDate fechaFinNueva = Utilidades.pideFecha(nuevaFechaFin);
                if(!fechaFinNueva.equals(formato)){
                    throw new FechaNoValidaException("La fecha debe cumplir con el siguiente formato: dd-MM-yyyy");
                }else {
                    modificada.setFechaFin(fechaFinNueva);
                }
                break;
            case "estado":
                Utilidades.pideString("Indique el nuevo estado de la actividad: ");
                String nuevoEstado = sc.nextLine();
                sc.next(String.valueOf(nuevoEstado));
                modificada.setEstado(EstadoActividad.valueOf(nuevoEstado));
                break;
            case "comentario":
                Utilidades.pideString("Escriba el nuevo comentario: ");
                String nuevoComentario = sc.next();
                modificada.setComentario(nuevoComentario);
                break;
            case "encargado":
                Utilidades.pideString("Asigne el nuevo encargado: ");
                sc.next(String.valueOf(nuevoEncargado));
                modificada.setVoluntarioEncargado(nuevoEncargado);

                if (!voluntarios.contains(nuevoEncargado)) {
                    Utilidades.pideString("Error al asignar nuevo encargado, asegúrese de que el usuario figura como voluntario en nuestra aplicación.");
                }else if(!nuevoEncargado.getNombre().matches("^[A-Za-zÁÉÍÓÚáéíóúÄËÏÖÜäëïöüÂÊÎÔÛâêîôûÀÈÌÒÙàèìòùÑñ]")){
                    Utilidades.pideString("Error al asignar nuevo encargado, el nombre no puede contener comas, puntos, guiones, ni caracteres especiales.");
                }
            default:
                Utilidades.pideString("No se encontró el atributo.");
        }

        return modificada;
    }

    /**
     * Método para eliminar una actividad
     * @param actividades: lista de actividades
     * @return: Actividad eliminada
     */
    public Actividad eliminarActividad(ArrayList<Actividad> actividades) {
        Actividad eliminada = null;
        int indice = 0;

        Scanner sc = new Scanner(System.in);

        do {
            Utilidades.pideString("Seleccione el índice de la actividad que quiere eliminar: ");
            for (int i = 0; i < actividades.size(); i++) {
                System.out.println(i + ": " + actividades.get(i));
                indice = sc.nextInt();
                actividades.remove(indice);
            }
        } while (indice < actividades.size() || indice > actividades.size());

        return eliminada;
    }

    /**
     * Método para mostrar las actividades
     * @param actividades: lista de actividades
     */
    public void mostrarAcividades(ArrayList<Actividad>actividades) {
        if (actividades.isEmpty()) {
            Utilidades.pideString("No hay actividades que mostrar");
        } else {
            for (Actividad actividad : actividades) {
                System.out.println(actividad);
            }
        }
    }
}
