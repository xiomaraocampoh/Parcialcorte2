package org.Xiomara.Aplication;

import org.Xiomara.Aplication.Service.RecetaServiceImpl;
import org.Xiomara.Domain.Receta;
import org.Xiomara.Interfaces.RecetaRepository;
import javax.swing.*;
import java.util.Arrays;
import org.Xiomara.Infraestructure.ImplRecetaRepository;

public class Main {
    public static void main(String[] args) {
        RecetaRepository recetaRepository = new ImplRecetaRepository();
        RecetaServiceImpl recetaService = new RecetaServiceImpl(recetaRepository);

        String opcion;
        do {
            opcion = JOptionPane.showInputDialog(null,
                    "Gestión de Recetas\n" +
                            "1. Crear receta\n" +
                            "2. Buscar receta\n" +
                            "3. Listar recetas\n" +
                            "4. Actualizar receta\n" +
                            "5. Eliminar receta\n" +
                            "6. Salir",
                    "Menú Principal", JOptionPane.QUESTION_MESSAGE);

            if ("6".equals(opcion)) {
                JOptionPane.showMessageDialog(null, "Gracias por usar el sistema. ¡Hasta luego!");
                break;
            }

            switch (opcion) {
                case "1":
                    try {
                        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la receta:"));
                        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la receta:");
                        String ingredientes = JOptionPane.showInputDialog("Ingrese los ingredientes separados por comas:");

                        Receta nuevaReceta = new Receta(id, nombre, Arrays.asList(ingredientes.split(",")));
                        recetaService.crearReceta(nuevaReceta);
                        JOptionPane.showMessageDialog(null, "Receta creada exitosamente.");
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "ID inválido. Por favor, ingrese un número.");
                    }
                    break;

                case "2":
                    try {
                        int idBuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la receta a buscar:"));
                        Receta receta = recetaService.buscarReceta(idBuscar);
                        if (receta != null) {
                            JOptionPane.showMessageDialog(null, receta.toString());
                        } else {
                            JOptionPane.showMessageDialog(null, "Receta no encontrada.");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "ID inválido. Por favor, ingrese un número.");
                    }
                    break;

                case "3":
                    StringBuilder lista = new StringBuilder("Lista de recetas:\n");
                    recetaService.listarRecetas().forEach(r -> lista.append(r).append("\n"));
                    JOptionPane.showMessageDialog(null, lista.toString());
                    break;

                case "4":
                    try {
                        int idActualizar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la receta a actualizar:"));
                        Receta recetaExistente = recetaService.buscarReceta(idActualizar);
                        if (recetaExistente != null) {
                            String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre de la receta:");
                            String nuevosIngredientes = JOptionPane.showInputDialog("Ingrese los nuevos ingredientes separados por comas:");
                            recetaExistente.setNombre(nuevoNombre);
                            recetaExistente.setIngredientes(Arrays.asList(nuevosIngredientes.split(",")));
                            recetaService.actualizarReceta(recetaExistente);
                            JOptionPane.showMessageDialog(null, "Receta actualizada exitosamente.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Receta no encontrada.");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "ID inválido. Por favor, ingrese un número.");
                    }
                    break;

                case "5":
                    try {
                        int idEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la receta a eliminar:"));
                        Receta recetaAEliminar = recetaService.buscarReceta(idEliminar);
                        if (recetaAEliminar != null) {
                            recetaService.eliminarReceta(idEliminar);
                            JOptionPane.showMessageDialog(null, "Receta eliminada exitosamente.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Receta no encontrada.");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "ID inválido. Por favor, ingrese un número.");
                    }
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (true);
    }
}


