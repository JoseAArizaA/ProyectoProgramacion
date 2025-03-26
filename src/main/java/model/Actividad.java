package Model;

import java.time.LocalDate;

public class Actividad {
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Voluntario voluntarioEncargado;
    private EstadoActividad estado;
    private String comentario;
}
