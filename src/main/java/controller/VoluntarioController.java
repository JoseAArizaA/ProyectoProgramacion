package controller;


import model.Actividad;
import model.Voluntario;

import java.util.List;



public class VoluntarioController {


            private List<Voluntario> voluntarios;

            public VoluntarioController(List<Voluntario> voluntarios) {
                this.voluntarios = voluntarios;
            }

            public void agregarVoluntario(Voluntario voluntario) {
                if (!voluntarios.contains(voluntario)) {
                    voluntarios.add(voluntario);
                    System.out.println("Voluntario agregado: " + voluntario.getNombre());
                } else {
                    System.out.println("El voluntario ya está registrado.");
                }
            }

            public Voluntario buscarVoluntarioPorUsuario(String usuario) {
                for (Voluntario v : voluntarios) {
                    if (v.getUsuario().equals(usuario)) {
                        return v;
                    }
                }
                System.out.println("Voluntario no encontrado.");
                return null;
            }

            public void asignarActividadAVoluntario(String usuario, Actividad actividad) {
                Voluntario voluntario = buscarVoluntarioPorUsuario(usuario);
                if (voluntario != null) {
                    voluntario.unirseActividad(actividad);
                }
            }

            public void actualizarPuntos(String usuario, int puntos) {
                Voluntario voluntario = buscarVoluntarioPorUsuario(usuario);
                if (voluntario != null) {
                    voluntario.setPuntos(voluntario.getPuntos() + puntos);
                    System.out.println("Se han actualizado los puntos de " + usuario + ". Puntos actuales: " + voluntario.getPuntos());
                }
            }

            public void listarVoluntarios() {
                for (Voluntario v : voluntarios) {
                    System.out.println("Voluntario: " + v.getNombre() + " - Usuario: " + v.getUsuario() + " - Puntos: " + v.getPuntos());
                }
            }
        }


