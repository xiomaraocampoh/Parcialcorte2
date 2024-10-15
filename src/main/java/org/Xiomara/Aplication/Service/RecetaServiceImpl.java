package org.Xiomara.Aplication.Service;

import org.Xiomara.Domain.Receta;
import org.Xiomara.Interfaces.RecetaRepository;
import org.Xiomara.Interfaces.RecetaService;

import java.util.List;

public class RecetaServiceImpl implements RecetaService {
    private final RecetaRepository recetaRepository;

    public RecetaServiceImpl(RecetaRepository recetaRepository) {
        this.recetaRepository = recetaRepository;
    }

    @Override
    public void crearReceta(Receta receta) {
        recetaRepository.save(receta);
    }

    @Override
    public Receta buscarReceta(int id) {
        return recetaRepository.findById(id);
    }

    @Override
    public List<Receta> listarRecetas() {
        return recetaRepository.findAll();
    }

    @Override
    public void actualizarReceta(Receta receta) {
        recetaRepository.update(receta);
    }

    @Override
    public void eliminarReceta(int id) {
        recetaRepository.delete(id);
    }
}

