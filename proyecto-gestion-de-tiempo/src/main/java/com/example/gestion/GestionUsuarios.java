package com.example.gestion;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class GestionUsuarios {
    public List<String> usuarios;

    public GestionUsuarios() {
        this.usuarios = new ArrayList<>();
    }

    public void mostrarMenu() {
        String input;
        do {
            input = JOptionPane.showInputDialog(null, "Seleccione una opción:\n" +
                    "1. Agregar Usuario\n" +
                    "2. Verificar Usuario\n" +
                    "3. Mostrar Usuarios\n" +
                    "4. Volver al menú principal");

            if (input != null) {
                switch (input) {
                    case "1":
                        String nombreUsuario = JOptionPane.showInputDialog("Ingrese el nombre del usuario:");
                        if (nombreUsuario != null && !nombreUsuario.trim().isEmpty()) {
                            agregarUsuario(nombreUsuario);
                            JOptionPane.showMessageDialog(null, "Usuario agregado: " + nombreUsuario);
                        }
                        break;
                    case "2":
                        String usuarioAVerificar = JOptionPane.showInputDialog("Ingrese el nombre del usuario a verificar:");
                        if (existeUsuario(usuarioAVerificar)) {
                            JOptionPane.showMessageDialog(null, "El usuario " + usuarioAVerificar + " existe.");
                        } else {
                            JOptionPane.showMessageDialog(null, "El usuario " + usuarioAVerificar + " no existe.");
                        }
                        break;
                    case "3":
                        StringBuilder listaUsuarios = new StringBuilder("Usuarios:\n");
                        for (String usuario : usuarios) {
                            listaUsuarios.append(usuario).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, listaUsuarios.toString());
                        break;
                    case "4":
                        JOptionPane.showMessageDialog(null, "Volviendo al menú principal.");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                }
            }
        } while (input != null && !input.equals("4")); // Permitir volver al menú principal
    }

    public void agregarUsuario(String usuario) {
        usuarios.add(usuario);
    }

    public boolean existeUsuario(String usuario) {
        return usuarios.contains(usuario);
    }
} 