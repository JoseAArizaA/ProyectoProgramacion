package controller;

import exceptions.FechaNoValidaException;
import exceptions.NombreNoValidoException;
import model.Actividad;
import model.EstadoActividad;
import model.Voluntario;
import view.Vista;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import static utils.Utilidades.leeCadena;
import static utils.Utilidades.leeFecha;
import static view.Vista.pideDatosActividad;

public class ActividadController {
    private HashSet<Voluntario> voluntarios;
    private ArrayList<Actividad> actividades;
    private Voluntario encargado;

    public ActividadController(HashSet<Voluntario> voluntarios, ArrayList<Actividad> actividades, Voluntario encargado) {
        this.voluntarios = voluntarios;
        this.actividades = actividades;
        this.encargado = encargado;
    }

    public Actividad crearActividad() throws FechaNoValidaException, NombreNoValidoException {
        return pideDatosActividad();
    }

    public Actividad modificarActividad(ArrayList<Actividad> actividades) throws FechaNoValidaException, NombreNoValidoException{
        Scanner sc = new Scanner(System.in);
        int indice = 0;
        Actividad modificada;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        Voluntario nuevoEncargado = null;

        leeCadena("¿Qué actividad quiere modificar?");
        mostrarAcividades(actividades);

        do {
            leeCadena("Ingrese el índice de la actividad que quiera modificar: ");
            for (int i = 0; i < actividades.size(); i++) {
                Actividad activity = actividades.get(i);
                System.out.println(i + ": " + activity.getNombre());
            }
            indice = sc.nextInt();
            modificada = actividades.get(indice - 1);
            leeCadena(modificada.getNombre() + " seleccionada.");
        } while (indice < 0 || indice > actividades.size());

        leeCadena("Seleccione el atributo a modificar: \nnombre \ndescripción \nfecha de inicio \nfecha de fin \nestado \ncomentario \nencargado");
        String atributo = sc.nextLine();
        switch (atributo) {
            case "nombre":
                leeCadena("Ingrese el nuevo nombre: ");
                String nombreNuevo = sc.next();
                if(actividades.contains(nombreNuevo)) {
                    leeCadena("El usuario ya figura en nuestro gestor.");
                }else if(nombreNuevo == null || !nombreNuevo.matches("^[A-Za-zÁÉÍÓÚáéíóúÄËÏÖÜäëïöüÂÊÎÔÛâêîôûÀÈÌÒÙàèìòùÑñ]")){
                    throw new NombreNoValidoException("El nombre introducido no cumple con las condiciones. Por favor, inténtelo de nuevo.");
                }else {
                    modificada.setNombre(nombreNuevo);
                }
                break;
            case "descripción":
                leeCadena("Ingrese una nueva descripción para la actividad:");
                String nuevaDescripcion = sc.next();
                modificada.setDescripcion(nuevaDescripcion);
                break;
            case "fecha de inicio":
                leeFecha("Ingrese la nueva fecha de inicio: ");
                String nuevaFechaInicio = sc.next();
                LocalDate fechaInicioNueva = leeFecha(nuevaFechaInicio);
                if(!fechaInicioNueva.equals(formato)){
                    throw new FechaNoValidaException("La fecha debe cumplir con el siguiente patrón: dd-MM-yyyy");
                }else {
                    modificada.setFechaInicio(fechaInicioNueva);
                }
                break;
            case "fecha de fin":
                leeFecha("Ingrese la nueva fecha de finalización: ");
                String nuevaFechaFin = sc.next();
                LocalDate fechaFinNueva = leeFecha(nuevaFechaFin);
                if(!fechaFinNueva.equals(formato)){
                    throw new FechaNoValidaException("La fecha debe cumplir con el siguiente formato: dd-MM-yyyy");
                }else {
                    modificada.setFechaFin(fechaFinNueva);
                }
                break;
            case "estado":
                leeCadena("Indique el nuevo estado de la actividad: ");
                String nuevoEstado = sc.nextLine();
                sc.next(String.valueOf(nuevoEstado));
                modificada.setEstado(EstadoActividad.valueOf(nuevoEstado));
                break;
            case "comentario":
                leeCadena("Escriba el nuevo comentario: ");
                String nuevoComentario = sc.next();
                modificada.setComentario(nuevoComentario);
                break;
            case "encargado":
                leeCadena("Asigne el nuevo encargado: ");
                sc.next(String.valueOf(nuevoEncargado));
                modificada.setVoluntarioEncargado(nuevoEncargado);

                if (!voluntarios.contains(nuevoEncargado)) {
                    leeCadena("Error al asignar nuevo encargado, asegúrese de que el usuario figura como voluntario en nuestra aplicación.");
                }else if(!nuevoEncargado.getNombre().matches("^[A-Za-zÁÉÍÓÚáéíóúÄËÏÖÜäëïöüÂÊÎÔÛâêîôûÀÈÌÒÙàèìòùÑñ]")){
                    leeCadena("Error al asignar nuevo encargado, el nombre no puede contener comas, puntos, guiones, ni caracteres especiales.");
                }
            default:
                leeCadena("No se encontró el atributo.");
        }

        return modificada;
    }

    public Actividad eliminarActividad(ArrayList<Actividad> actividades) {
        Actividad eliminada = null;
        int indice = 0;

        Scanner sc = new Scanner(System.in);

        do {
            leeCadena("Seleccione el índice de la actividad que quiere eliminar: ");
            for (int i = 0; i < actividades.size(); i++) {
                System.out.println(i + ": " + actividades.get(i));
                indice = sc.nextInt();
                actividades.remove(indice);
            }
        } while (indice < actividades.size() || indice > actividades.size());

        return eliminada;
    }

    public void mostrarAcividades(ArrayList<Actividad>actividades) {
        if (actividades.isEmpty()) {
            leeCadena("No hay actividades que mostrar");
        } else {
            for (Actividad actividad : actividades) {
                System.out.println(actividad);
            }
        }
    }
}
