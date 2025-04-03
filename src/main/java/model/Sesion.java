package model;
public class Sesion {
        private static Sesion instancia;
        private Usuario usuarioActual;

    /**
     * Constructor por defecto
     */
    private Sesion() {}

    /**
     * Metodo que devuelve la instancia de la clase Sesion
     * @return:Instancia de la clase Sesion
     */
    public static Sesion getInstancia() {
            if (instancia == null) {
                instancia = new Sesion();
            }
            return instancia;
    }

    /**
     * Inicia la sesion del usuario
     * @param usuario: Usuario que inicia sesion
     */
    public void iniciarSesion(Usuario usuario) {
            this.usuarioActual = usuario;
    }

    /**
     * Cierra la sesion del usuario
     */
    public void cerrarSesion() {
            this.usuarioActual = null;
    }

    /**
     * Metodo que devuelve el usuario actual
     * @return:Usuario actual
     */
    public Usuario getUsuarioActual() {
            return usuarioActual;
    }

    /**
     * Metodo que devuelve si la sesion esta activa
     * @return: true si la sesion esta activa, false si no
     */
    public boolean estaActiva() {
            return usuarioActual != null;
    }
}
