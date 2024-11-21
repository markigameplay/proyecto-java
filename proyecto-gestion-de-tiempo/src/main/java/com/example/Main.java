package com.example;

// Importaciones necesarias
import com.example.gestion.*;
import com.example.gestion.GestionConfiguracion;
import com.example.gestion.GestionNotificaciones;
import com.example.gestion.GestionProyectos;
import com.example.gestion.GestionReportes;
import com.example.gestion.GestionTareas;
import com.example.gestion.GestionTiempo;
import com.example.gestion.GestionUsuarios;
import javax.swing.JOptionPane;

/**
 * Clase principal que contiene el menú de la aplicación
 */
public class Main {
    /**
     * Método principal que muestra el menú y maneja la selección del usuario
     */
    public static void main(String[] args) {
        
        // Mostrar el menú principal usando JOptionPane
        String input = JOptionPane.showInputDialog(null, "Seleccione una opción:\n" +
                "1. Gestión de Tareas\n" +
                "2. Gestión de Proyectos\n" +
                "3. Gestión de Usuarios\n" +
                "4. Gestión de Tiempo\n" +
                "5. Gestión de Reportes\n" +
                "6. Gestión de Notificaciones\n" +
                "7. Gestión de Configuración\n" +
                "8. Salir");

        // Bucle do-while para manejar la selección del usuario
        do {
            // Verificar si la entrada es nula
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Operación cancelada");
                break; // Salir del bucle si se cancela
            }

            try {
                // Convertir la entrada del usuario a entero
                int opcion = Integer.parseInt(input);

                // Manejar la selección del usuario
                switch(opcion) {
                    case 1:
                        GestionUsuarios usuarios = new GestionUsuarios();
                        // Solicitar el nombre del usuario
                        String nombreUsuario = JOptionPane.showInputDialog("Ingrese el nombre del usuario:");
                        if (nombreUsuario != null && !nombreUsuario.trim().isEmpty()) {
                            usuarios.agregarUsuario(nombreUsuario);
                        }
                        GestionTareas tareas = new GestionTareas(usuarios);
                        tareas.mostrarMenuTareas();
                        break;
                    case 2:
                        GestionProyectos proyectos = new GestionProyectos();
                        proyectos.mostrarMenu();
                        break;
                    case 3:
                        GestionUsuarios Usuarios = new GestionUsuarios();
                        Usuarios.mostrarMenu();
                        break;
                    case 4:
                        GestionTiempo tiempo = new GestionTiempo();
                        tiempo.mostrarMenu();
                        break;
                    case 5:
                        GestionReportes reportes = new GestionReportes();
                        reportes.mostrarMenu();
                        break;
                    case 6:
                        GestionNotificaciones notificaciones = new GestionNotificaciones();
                        notificaciones.mostrarMenu();
                        break;
                    case 7:
                        GestionConfiguracion config = new GestionConfiguracion();
                        config.mostrarMenu();
                        break;
                    case 8:
                        JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido");
            }

            // Mostrar el menú principal nuevamente
            input = JOptionPane.showInputDialog(null, "Seleccione una opción:\n" +
                    "1. Gestión de Tareas\n" +
                    "2. Gestión de Proyectos\n" +
                    "3. Gestión de Usuarios\n" +
                    "4. Gestión de Tiempo\n" +
                    "5. Gestión de Reportes\n" +
                    "6. Gestión de Notificaciones\n" +
                    "7. Gestión de Configuración\n" +
                    "8. Salir");
        } while (input != null && !input.equals("8")); // Continuar el bucle mientras la entrada no sea nula y no sea la opción de salir
    }
}