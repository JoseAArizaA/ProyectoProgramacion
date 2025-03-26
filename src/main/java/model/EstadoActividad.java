package model;

public enum EstadoActividad {
    NoIniciada("No iniciada"), EnProgreso("En progreso"), Completada("Completada");

    private final String mensaje;

    EstadoActividad(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
