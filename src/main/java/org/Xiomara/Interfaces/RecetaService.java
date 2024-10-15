package org.Xiomara.Interfaces;

import org.Xiomara.Domain.Receta;

import java.util.List;

public interface RecetaService {
    void crearReceta(Receta receta);
    Receta buscarReceta(int id);
    List<Receta> listarRecetas();
    void actualizarReceta(Receta receta);
    void eliminarReceta(int id);
}
