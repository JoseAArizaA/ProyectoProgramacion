package model;

import Exceptions.IniciativaIncorrectaException;
import Exceptions.NombreIniciativaIncorrectoException;
import Exceptions.NombreYDescripcionIniciativaIncorrectoException;

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
     * @param descripcion
     * @return
     * @throws NombreIniciativaIncorrectoException
     */
    public boolean crearIniciativa(String nombre, String descripcion) throws NombreIniciativaIncorrectoException {
        if (nombre == null || nombre.isBlank() || descripcion == null || descripcion.isBlank()) {
            throw new NombreIniciativaIncorrectoException("El nombre y la descripción no pueden estar vacíos.");
        }
        Iniciativa iniciativa = new Iniciativa(nombre, descripcion, this);
        return iniciativasCreadas.add(iniciativa);
    }

    public boolean eliminarIniciativa(Iniciativa iniciativa) {
        return iniciativasCreadas.remove(iniciativa);
    }

    public void actualizarIniciativa(Iniciativa iniciativa, String nuevoNombre, String nuevaDescripcion) throws NombreYDescripcionIniciativaIncorrectoException, IniciativaIncorrectaException {
        if (iniciativa != null || iniciativasCreadas.contains(iniciativa)) {
            iniciativa.setNombre(nuevoNombre);
            iniciativa.setDescripcion(nuevaDescripcion);
            if (nuevoNombre != null || nuevoNombre.isEmpty() || nuevaDescripcion != null || !nuevaDescripcion.isBlank()) {
                iniciativa.setNombre(nuevoNombre);
                iniciativa.setDescripcion(nuevaDescripcion);
            } else {
                throw new NombreYDescripcionIniciativaIncorrectoException("El nombre y la descripción no pueden estar vacíos.");
            }
        } else {
            throw new IniciativaIncorrectaException("La iniciativa no pertenece a este creador.");
        }
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
