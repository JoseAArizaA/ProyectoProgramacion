package controller;

import exceptions.FechaNoValidaException;
import exceptions.NombreNoValidoException;
import model.Actividad;
import model.EstadoActividad;
import model.Voluntario;
import utils.Utilidades;
import view.Vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import static model.EstadoActividad.NoIniciada;

public class ActividadController {
    private HashSet<Voluntario> voluntarios;
    private ArrayList<Actividad> actividades;
    private Voluntario encargado;

    public ActividadController(HashSet<Voluntario> voluntarios, ArrayList<Actividad> actividades, Voluntario encargado) {
        this.voluntarios = voluntarios;
        this.actividades = actividades;
        this.encargado = encargado;
    }

    public Actividad crearActividad(){
        return Vista.pideDatosActividad();
    }

    public Actividad modificarActividad(ArrayList<Actividad> actividades) throws FechaNoValidaException, NombreNoValidoException{
        Scanner sc = new Scanner(System.in);
        int indice = 0;
        int parametero = 0;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Voluntario nuevoEncargado = null;

        Actividad modificada;
        LocalDate fechaInicioNueva =  LocalDate.of(0000, 00, 00);
        LocalDate fechaFinNueva = LocalDate.of(0000, 00, 00);
        EstadoActividad nuevoEstado = NoIniciada;

        Utilidades.leeCadena("¿Qué actividad quiere modificar?");

        do {
            Utilidades.leeCadena("Ingrese el índice de la actividad que quiera modificar: ");
            for (int i = 0; i < actividades.size(); i++) {
                Actividad activity = actividades.get(i);
                System.out.println(i + ": " + activity.getNombre());
            }
            indice = sc.nextInt();
            modificada = actividades.get(indice - 1);
            Utilidades.leeCadena(modificada.getNombre() + " seleccionada.");
        } while (indice < 0 || indice > actividades.size());

        Utilidades.leeCadena("Introduzca el índice del parámetro a modificar: \n1. Nombre \n2. Descripcion \n3. Fecha de inicio \n4. Fecha de fin \n5. Estado \n6. Comentario \n7. Encargado");
        parametero = sc.nextInt();
        switch (parametero) {
            case 1:
                Utilidades.leeCadena("Ingrese el nuevo nombre: ");
                String nombreNuevo = sc.next();
                if(actividades.contains(nombreNuevo)) {
                    Utilidades.leeCadena("El usuario ya figura en nuestro gestor.");
                }else if(nombreNuevo == null || !nombreNuevo.matches("^[A-Za-zÁÉÍÓÚáéíóúÄËÏÖÜäëïöüÂÊÎÔÛâêîôûÀÈÌÒÙàèìòùÑñ]")){
                    throw new NombreNoValidoException("El nombre introducido no cumple con las condiciones. Por favor, inténtelo de nuevo.");
                }else {
                    modificada.setNombre(nombreNuevo);
                }
                break;
            case 2:
                Utilidades.leeCadena("Ingrese una nueva descripción para la actividad:");
                String nuevaDescripcion = sc.next();
                modificada.setDescripcion(nuevaDescripcion);
                break;
            case 3:
                Utilidades.leeFecha("Ingrese la nueva fecha de inicio: ");
                String nuevaFechaInicio = sc.next();
                fechaInicioNueva = Utilidades.leeFecha(nuevaFechaInicio);
                if(!fechaInicioNueva.format(formato).equals(formato)){
                    throw new FechaNoValidaException("La fecha debe cumplir con el siguiente patrón: dd-MM-yyyy");
                }else {
                    modificada.setFechaInicio(fechaInicioNueva);
                }
                break;
            case 4:
                Utilidades.leeFecha("Ingrese la nueva fecha de finalización: ");
                String nuevaFechaFin = sc.next();
                fechaFinNueva = Utilidades.leeFecha(nuevaFechaFin);
                if(!fechaFinNueva.format(formato).equals(formato)){
                    throw new FechaNoValidaException("La fecha debe cumplir con el siguiente formato: dd-MM-yyyy");
                }else {
                    modificada.setFechaFin(fechaFinNueva);
                }
                break;
            case 5:
                Utilidades.leeCadena("Indique el nuevo estado de la actividad: ");
                sc.next(String.valueOf(nuevoEstado));
                modificada.setEstado(nuevoEstado);
                break;
            case 6:
                Utilidades.leeCadena("Escriba el nuevo comentario: ");
                String nuevoComentario = sc.next();
                modificada.setComentario(nuevoComentario);
                break;
            case 7:
                Utilidades.leeCadena("Asigne el nuevo encargado: ");
                sc.next(String.valueOf(nuevoEncargado));
                if (!voluntarios.contains(nuevoEncargado)) {
                    Utilidades.leeCadena("Error al asignar nuevo encargado, asegúrese de que el usuario figura como voluntario en nuestra aplicación.");
                }else if(!nuevoEncargado.getNombre().matches("^[A-Za-zÁÉÍÓÚáéíóúÄËÏÖÜäëïöüÂÊÎÔÛâêîôûÀÈÌÒÙàèìòùÑñ]")){
                    Utilidades.leeCadena("Error al asignar nuevo encargado, el nombre no puede contener comas, puntos, guiones, ni caracteres especiales.");
                } else {
                    actividades.remove(encargado);
                    modificada.setVoluntarioEncargado(nuevoEncargado);
                }
        }

        return modificada;
    }

    public Actividad eliminarActividad(ArrayList<Actividad> actividades) {
        Actividad eliminada = null;
        int indice = 0;

        Scanner sc = new Scanner(System.in);

        do {
            Utilidades.leeCadena("Seleccione el índice de la actividad que quiere eliminar: ");
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
            Utilidades.leeCadena("No hay actividades que mostrar");
        } else {
            for (Actividad actividad : actividades) {
                System.out.println(actividad);
            }
        }
    }

    public void validarFecha(String fecha) throws FechaNoValidaException{
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try{
            LocalDate fechaValidada = LocalDate.parse(fecha, formato);
        }catch (DateTimeParseException e) {
            throw new FechaNoValidaException("Error la fecha debe cumplir con el patrón asignado: dd-MM-yyyy");
        }
    }
}
