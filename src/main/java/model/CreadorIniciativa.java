package model;

import java.util.ArrayList;
import java.util.List;

public class CreadorIniciativa extends Usuario {
    private String Ong;
    private List<Iniciativa> iniciativasCreadas;

    /**
     * Constructor fullEquip
     **/
    public CreadorIniciativa(String nombre, String usuario, String contrasena, String email, String ong) {
        super(nombre, usuario, contrasena, email);
        this.Ong = ong;
        this.iniciativasCreadas = new ArrayList<>();
    }

    /**
     * Constructor por defecto
     **/
    public CreadorIniciativa() {
    }

    /**
     * Método GET para Ong
     **/
    public String getOng() {
        return Ong;
    }

    /**
     * Método SET para Ong
     **/
    public void setOng(String ong) {
        Ong = ong;
    }

    /**
     * Método GET para iniciativasCreadas
     **/
    public List<Iniciativa> getIniciativasCreadas() {
        return iniciativasCreadas;
    }

    /**
     * Método SET para iniciativasCreadas
     **/
    public void setIniciativasCreadas(List<Iniciativa> iniciativasCreadas) {
        this.iniciativasCreadas = iniciativasCreadas;
    }

    /**
     *Metodo que agrega una iniciativa a la lista de iniciativas creadas.
     * @param iniciativa:Iniciativa que se va a agregar.
     * @return: true si se agrega la iniciativa, false si no se agrega.
     */
    public boolean crearIniciativa(Iniciativa iniciativa) {
        boolean agregada = false;
        if (iniciativa != null && !iniciativasCreadas.contains(iniciativa)) {
            iniciativasCreadas.add(iniciativa);
            agregada = true;
        }
        return agregada;
    }

    /**
     * Metodo que elimina una iniciativa de la lista de iniciativas creadas.
     * @param nombreIniciativa: Iniciativa que se va a eliminar.
     * @return: true si se elimina la iniciativa, false si no se elimina.
     */
    public boolean eliminarIniciativa(String nombreIniciativa) {
        boolean eliminada = false;
        for (Iniciativa iniciativa : iniciativasCreadas) {
            if (iniciativa.getNombre().equalsIgnoreCase(nombreIniciativa)) {
                iniciativasCreadas.remove(iniciativa);
                eliminada = true;
                break;
            }
        }
        return eliminada;
    }

    /**
     * Metodo que actualiza una iniciativa existente por otra nueva.
     * @param nuevaIniciativa La iniciativa que se a actualizado.
     * @return
     */
    public boolean actualizarIniciativa(Iniciativa nuevaIniciativa) {
        boolean actualizada = false;
        for (Iniciativa iniciativa : iniciativasCreadas) {
            if (iniciativa.getNombre().equalsIgnoreCase(nuevaIniciativa.getNombre())) {
                iniciativa.setNombre(nuevaIniciativa.getNombre());
                iniciativa.setDescripcion(nuevaIniciativa.getDescripcion());
                actualizada = true;
                break;
            }
        }
        return actualizada;
    }

    /**
     * Metodo que devuelve el rol del usuario.
     * @return: String con el rol del usuario.
     */
    @Override
    public String getRol() {
        return "Creador";
    }

    /**
     * Metodo toString
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + " Usuario: " + usuario;
    }
}
