package org.Xiomara.aplication;

import org.Xiomara.Domain.Receta;
import org.Xiomara.aplication.Service.RecetaServiceImpl;

import javax.swing.*;
import java.util.List;

public class Menu {
private final RecetaServiceImpl recetaService;

    public Menu(RecetaServiceImpl recetaService) {
        this.recetaService = recetaService;
    }

    public void iniciar() {
        while (true) {
            String opcion = JOptionPane.showInputDialog(null,
                    "Gestión de Recetas\n" +
                            "1. Crear receta\n" +
                            "2. Buscar receta\n" +
                            "3. Listar recetas\n" +
                            "4. Actualizar receta\n" +
                            "5. Eliminar receta\n" +
                            "6. Salir",
                    "Menú Principal", JOptionPane.QUESTION_MESSAGE);

            if (opcion == null || opcion.equals("6")) {
                JOptionPane.showMessageDialog(null, "Gracias por usar el sistema. ¡Hasta luego!");
                break;
            }

            switch (opcion) {
                case "1":
                    crearReceta();
                    break;
                case "2":
                    buscarReceta();
                    break;
                case "3":
                    listarRecetas();
                    break;
                case "4":
                    actualizarReceta();
                    break;
                case "5":
                    eliminarReceta();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void crearReceta() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la receta:"));
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la receta:");
        String ingredientesInput = JOptionPane.showInputDialog("Ingrese los ingredientes separados por comas:");
        List<String> ingredientes = List.of(ingredientesInput.split(","));

        Receta receta = new Receta(id, nombre, ingredientes);
        recetaService.crearReceta(receta);
        JOptionPane.showMessageDialog(null, "Receta creada exitosamente.");
    }

    private void buscarReceta() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la receta a buscar:"));
        Receta receta = recetaService.buscarReceta(id);
        if (receta != null) {
            JOptionPane.showMessageDialog(null, receta.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Receta no encontrada.");
        }
    }

    private void listarRecetas() {
        List<Receta> recetas = recetaService.listarRecetas();
        StringBuilder sb = new StringBuilder("Lista de recetas:\n");
        recetas.forEach(r -> sb.append(r).append("\n"));
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private void actualizarReceta() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la receta a actualizar:"));
        Receta receta = recetaService.buscarReceta(id);
        if (receta != null) {
            String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre de la receta:");
            String nuevosIngredientes = JOptionPane.showInputDialog("Ingrese los nuevos ingredientes separados por comas:");
            List<String> ingredientes = List.of(nuevosIngredientes.split(","));
            receta.setNombre(nuevoNombre);
            receta.setIngredientes(ingredientes);

            recetaService.actualizarReceta(receta);
            JOptionPane.showMessageDialog(null, "Receta actualizada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Receta no encontrada.");
        }
    }

    private void eliminarReceta() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la receta a eliminar:"));
        recetaService.eliminarReceta(id);
        JOptionPane.showMessageDialog(null, "Receta eliminada exitosamente.");
    }
}




