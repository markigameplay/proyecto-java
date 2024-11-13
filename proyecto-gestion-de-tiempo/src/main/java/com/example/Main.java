package com.example;

import java.util.Scanner;
import com.example.gestion.*;
import com.example.gestion.GestionConfiguracion;
import com.example.gestion.GestionNotificaciones;
import com.example.gestion.GestionProyectos;
import com.example.gestion.GestionReportes;
import com.example.gestion.GestionTareas;
import com.example.gestion.GestionTiempo;
import com.example.gestion.GestionUsuarios;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        
        String input = JOptionPane.showInputDialog(null, "Seleccione una opción:\n" +
                "1. Gestión de Tareas\n" +
                "2. Gestión de Proyectos\n" +
                "3. Gestión de Usuarios\n" +
                "4. Gestión de Tiempo\n" +
                "5. Gestión de Reportes\n" +
                "6. Gestión de Notificaciones\n" +
                "7. Gestión de Configuración\n" +
                "8. Salir");

        int opcion = Integer.parseInt(input);

        switch(opcion) {
            case 1:
                GestionTareas tareas = new GestionTareas();
                tareas.mostrarMenu();
                break;
            case 2:
                GestionProyectos proyectos = new GestionProyectos();
                proyectos.mostrarMenu();
                break;
            case 3:
                GestionUsuarios usuarios = new GestionUsuarios();
                usuarios.mostrarMenu();
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
                System.out.println("¡Hasta luego!");
                break;
            default:
                System.out.println("Opción no válida");
        }
    }
}