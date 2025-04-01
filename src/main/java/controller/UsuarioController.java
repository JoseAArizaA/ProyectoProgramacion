package controller;
import model.CreadorIniciativa;
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

    public static void registrarUsuario() {
        Usuario usuario = ViewRegistro.pideDatosUsuario();

        if (usuario != null) {
                usuarios.add(usuario);
            System.out.println("Usuario registrado con éxito");

            // Guardar el usuario en el archivo correspondiente según su rol
            if (usuario instanceof Voluntario) {
                // Guardar TODOS los voluntarios
                HashSet<Voluntario> todosVoluntarios = new HashSet<>();
                for (Usuario u : usuarios) {
                    if (u instanceof Voluntario) {
                        todosVoluntarios.add((Voluntario) u);
                    }
                }
                guardarVoluntarios(todosVoluntarios, ARCHIVO_VOLUNTARIOS);

            } else if (usuario instanceof CreadorIniciativa) {
                // Guardar TODOS los creadores
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


    private static void guardarVoluntarios(HashSet<Voluntario> voluntarios, String ARCHIVO_VOLUNTARIOS) {
        HashSetContenedor<Voluntario> listaVoluntarios = new HashSetContenedor<>(voluntarios);
        XMLManager.writeXML(listaVoluntarios, ARCHIVO_VOLUNTARIOS);
    }

    private static void guardarCreadores(HashSet<CreadorIniciativa> creadores, String ARCHIVO_CREADORES) {
        HashSetContenedor<CreadorIniciativa> listaCreadores = new HashSetContenedor<>(creadores);
        XMLManager.writeXML(listaCreadores, ARCHIVO_CREADORES);
    }

    public static void cargarUsuarios() {
        cargarVoluntarios("voluntarios.xml");
        cargarCreadores("creadores.xml");
    }

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


}
