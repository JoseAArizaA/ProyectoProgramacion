package model;

import java.io.Serializable;
import exceptions.IniciativaIncorrectaException;
import exceptions.NombreIniciativaIncorrectoException;
import exceptions.NombreYDescripcionIniciativaIncorrectoException;

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
     * Crea una nueva iniciativa, comprobando que los datos que les pasen no sean nulos.
     * @param nombre El nombre de la iniciativa.
     * @param descripcion La descripción de la iniciativa.
     * @return true si la iniciativa se creó correctamente, false en caso contrario.
     * @throws NombreIniciativaIncorrectoException si el nombre o la descripción son nulos o vacíos.
     */
    public boolean crearIniciativa(String nombre, String descripcion) throws NombreIniciativaIncorrectoException {
        if (nombre == null || nombre.isBlank() || descripcion == null || descripcion.isBlank()) {
            throw new NombreIniciativaIncorrectoException("El nombre y la descripción no pueden estar vacíos.");
        }
        Iniciativa iniciativa = new Iniciativa(nombre, descripcion, this);
        return iniciativasCreadas.add(iniciativa);
    }

    public boolean eliminarIniciativa(Iniciativa iniciativa) {
        boolean eliminada = false;
        if (iniciativa!= null && iniciativasCreadas.contains(iniciativa)) {
            iniciativasCreadas.remove(iniciativa);
            eliminada = true;
        }
        return eliminada;
    }

    public boolean actualizarIniciativa(Iniciativa iniciativa, String nuevaIniciativa) {
        boolean actualizada = false;
        if (iniciativa != null && iniciativasCreadas.contains(iniciativa)) {
            iniciativa.setNombre(nuevaIniciativa);
            iniciativa.setDescripcion(nuevaIniciativa);
            iniciativa.setCreador(this);
            actualizada = true;
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
