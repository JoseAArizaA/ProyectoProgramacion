package model;

import java.util.ArrayList;
import java.util.List;

public class CreadorIniciativa extends Usuario {
    private String Ong;
    private List<Iniciativa> iniciativasCreadas;

    public CreadorIniciativa(String nombre, String usuario, String contrasena, String email, String ong) {
        super(nombre, usuario, contrasena, email);
        this.Ong = ong;
        this.iniciativasCreadas = new ArrayList<>();
    }

    public CreadorIniciativa() {
    }

    public String getOng() {
        return Ong;
    }

    public void setOng(String ong) {
        Ong = ong;
    }

    public List<Iniciativa> getIniciativasCreadas() {
        return iniciativasCreadas;
    }

    public void setIniciativasCreadas(List<Iniciativa> iniciativasCreadas) {
        this.iniciativasCreadas = iniciativasCreadas;
    }

    /**
     *
     * @param iniciativa
     * @return
     */
    public boolean agregarIniciativa(Iniciativa iniciativa) {
        boolean agregada = false;
        if (iniciativa != null && !iniciativasCreadas.contains(iniciativa)) {
            iniciativasCreadas.add(iniciativa);
            agregada = true;
        }
        return agregada;
    }

    /**
     *
     * @param nombreIniciativa
     * @return
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

    @Override
    public String getRol() {
        return "Creador";
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " Usuario: " + usuario;
    }
}
