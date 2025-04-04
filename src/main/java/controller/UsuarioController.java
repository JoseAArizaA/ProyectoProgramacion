package controller;
import model.CreadorIniciativa;
import model.Sesion;
import model.Usuario;
import model.Voluntario;
import utils.HashSetContenedor;
import utils.XMLManager;
import view.ViewRegistro;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement
public class UsuarioController {
    private static Set<Usuario> usuarios = new HashSet<>();
    private static final String ARCHIVO_VOLUNTARIOS = "voluntarios.xml";
    private static final String ARCHIVO_CREADORES = "creadores.xml";

    /**
     * Metodo para regitrar un usuario, pide los datos al usuario y segun
     * si es creador o voluntario lo guarda en el archivo correspondiente
     */
    public static void registrarUsuario() {
        Usuario usuario = ViewRegistro.pideDatosUsuario();

        if (usuario != null) {
                usuarios.add(usuario);
            System.out.println("Usuario registrado con éxito");

            if (usuario instanceof Voluntario) {
                HashSet<Voluntario> todosVoluntarios = new HashSet<>();
                for (Usuario u : usuarios) {
                    if (u instanceof Voluntario) {
                        todosVoluntarios.add((Voluntario) u);
                    }
                }
                guardarVoluntarios(todosVoluntarios, ARCHIVO_VOLUNTARIOS);

            } else if (usuario instanceof CreadorIniciativa) {
                HashSet<CreadorIniciativa> todosCreadores = new HashSet<>();
                for (Usuario u : usuarios) {
                    if (u instanceof CreadorIniciativa) {
                        todosCreadores.add((CreadorIniciativa) u);
                    }
                }
                guardarCreadores(todosCreadores, ARCHIVO_CREADORES);
            }
        } else {
            System.out.println("Error al registrar el usuario");
        }
    }

    /**
     * Guarda los voluntarios en el XML
     * @param voluntarios: Lista de voluntarios que se guardan
     * @param ARCHIVO_VOLUNTARIOS:Archivo donde se guardan los voluntarios
     */
    private static void guardarVoluntarios(HashSet<Voluntario> voluntarios, String ARCHIVO_VOLUNTARIOS) {
        HashSetContenedor<Voluntario> listaVoluntarios = new HashSetContenedor<>(voluntarios);
        XMLManager.writeXML(listaVoluntarios, ARCHIVO_VOLUNTARIOS);
    }

    /**
     * Guarda los creadores en el XML
     * @param creadores: Lista de creadores que se guardan
     * @param ARCHIVO_CREADORES:Archivo donde se guardan los creadores
     */
    private static void guardarCreadores(HashSet<CreadorIniciativa> creadores, String ARCHIVO_CREADORES) {
        HashSetContenedor<CreadorIniciativa> listaCreadores = new HashSetContenedor<>(creadores);
        XMLManager.writeXML(listaCreadores, ARCHIVO_CREADORES);
    }

    /**
     * Metodo que carga los usuarios que estan en los archivos de creadores y voluntarios a la vez
     */
    public static void cargarUsuarios() {
        cargarVoluntarios("voluntarios.xml");
        cargarCreadores("creadores.xml");
    }

    /**
     * Metodo para cargar los voluntarios que estan en el XML
     * @param ARCHIVO_VOLUNTARIOS:Archivo donde estan los voluntarios
     */
    private static void cargarVoluntarios(String ARCHIVO_VOLUNTARIOS) {
        File archivo = new File(ARCHIVO_VOLUNTARIOS);
        boolean archivoExiste = archivo.exists();

        if (!archivoExiste) {
            guardarVoluntarios(new HashSet<>(), ARCHIVO_VOLUNTARIOS);
        }

        if(archivoExiste) {
            HashSetContenedor<Voluntario> lecturaVoluntarios = new HashSetContenedor<>(new HashSet<>());
            HashSetContenedor<Voluntario> leeVoluntarios = XMLManager.readXML(lecturaVoluntarios, ARCHIVO_VOLUNTARIOS);
            if (leeVoluntarios != null && leeVoluntarios.getSet() != null) {
                usuarios.addAll(leeVoluntarios.getSet());
            }
        }

    }

    /**
     * Metodo para cargar los creadores que estan en el XML
     * @param ARCHIVO_CREADORES:Archivo donde estan los creadores
     */
    private static void cargarCreadores(String ARCHIVO_CREADORES) {
        File archivo = new File(ARCHIVO_CREADORES);
        boolean archivoExiste = archivo.exists();

        if (!archivoExiste) {
            guardarCreadores(new HashSet<>(), ARCHIVO_CREADORES);
        }

        if(archivoExiste) {
            HashSetContenedor<CreadorIniciativa> lecturaCreadores = new HashSetContenedor<>(new HashSet<>());
            HashSetContenedor<CreadorIniciativa> leeCreadores = XMLManager.readXML(lecturaCreadores, ARCHIVO_CREADORES);
            if (leeCreadores != null && leeCreadores.getSet() != null) {
                usuarios.addAll(leeCreadores.getSet());
            }
        }
    }

    /**
     * Metodo que recibe el usuario y la constreña de un creador y
     * si se encuentra en el XML de creadores  inicia sesion
     * @param usuario:Usuario con el cual quiere Iniciar Sesion
     * @param contrasena:Contraseña del usuario
     * @return: true si se ha iniciado sesion correctamente, false si no
     */
    public static boolean iniciarSesionCreador(String usuario, String contrasena) {
        HashSetContenedor<CreadorIniciativa> creadores = XMLManager.readXML(new HashSetContenedor<>(new HashSet<>()), "creadores.xml");

        if (creadores == null || creadores.getSet() == null) {
            return false;
        }

        boolean encontrado = false;
        for (CreadorIniciativa creador : creadores.getSet()) {
            if (creador.getUsuario().equals(usuario) &&
                    creador.getContrasena().equals(contrasena)) {
                Sesion.getInstancia().iniciarSesion(creador);
                encontrado = true;
            }
        }
        return encontrado;
    }

    /**
     * Metodo que recibe el usuario y la constreña de un voluntario y
     * si se encuentra en el XML de voluntarios  inicia sesion
     * @param usuario: Usuario del voluntario
     * @param contrasena: Contraseña del voluntario
     * @return: True si se ha iniciado sesion correctamente, false si no
     */
    public static boolean iniciarSesionVoluntario(String usuario, String contrasena) {
        HashSetContenedor<Voluntario> voluntarios = XMLManager.readXML(new HashSetContenedor<>(new HashSet<>()), "voluntarios.xml");

        if (voluntarios == null || voluntarios.getSet() == null) {
            return false;
        }

        boolean encontrado = false;
        for (Voluntario voluntario : voluntarios.getSet()) {
            if (voluntario.getUsuario().equals(usuario) &&
                    voluntario.getContrasena().equals(contrasena)) {
                Sesion.getInstancia().iniciarSesion(voluntario);
                encontrado = true;
            }
        }
        return encontrado;
    }

    /**
     * Metodo que cierra la sesion del usuario
     */
    public static void cerrarSesion() {
        Sesion.getInstancia().cerrarSesion();
        System.out.println("Sesión cerrada correctamente");
    }
}
