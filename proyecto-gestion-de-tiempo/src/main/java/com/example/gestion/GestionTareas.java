package com.example.gestion;

import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;

public class GestionTareas {
    private GestionUsuarios gestionUsuarios;
    private Map<String, String> tareasAsignadas = new HashMap<>();

    public GestionTareas(GestionUsuarios gestionUsuarios) {
        this.gestionUsuarios = gestionUsuarios;
    }

    public void mostrarMenuTareas() {
        while (true) {
            if (gestionUsuarios.usuarios.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay usuarios disponibles. Por favor, crea un usuario.");
                gestionUsuarios.mostrarMenu();
                continue;
            }

            String input = JOptionPane.showInputDialog("Seleccione una opción:\n" +
                    "1. Asignar tarea\n" +
                    "2. Mostrar tareas asignadas\n" +
                    "3. Volver al menú principal");

            if (input == null || input.equals("3")) {
                break;
            }

            switch (input) {
                case "1":
                    asignarTarea();
                    break;
                case "2":
                    mostrarTareasAsignadas();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        }
    }

    private void asignarTarea() {
        try {
            String usuario = JOptionPane.showInputDialog("Ingrese el nombre del usuario al que desea asignar la tarea:");
            if (usuario == null) {
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                return;
            }
            if (gestionUsuarios.existeUsuario(usuario)) {
                String tarea = JOptionPane.showInputDialog("Ingrese la tarea a asignar:");
                if (tarea != null && !tarea.trim().isEmpty()) {
                    tareasAsignadas.put(usuario, tarea);
                    JOptionPane.showMessageDialog(null, "Tarea asignada a " + usuario + ": " + tarea);
                } else {
                    JOptionPane.showMessageDialog(null, "La tarea no puede estar vacía.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no existe.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.getMessage());
        }
    }

    private void mostrarTareasAsignadas() {
        if (tareasAsignadas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay tareas asignadas.");
            return;
        }
        StringBuilder listaTareas = new StringBuilder("Tareas Asignadas:\n");
        for (Map.Entry<String, String> entry : tareasAsignadas.entrySet()) {
            listaTareas.append("Usuario: ").append(entry.getKey()).append(" - Tarea: ").append(entry.getValue()).append("\n");
        }
        JOptionPane.showMessageDialog(null, listaTareas.toString());
    }
} 