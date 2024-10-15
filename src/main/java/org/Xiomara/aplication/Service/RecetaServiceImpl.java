package org.Xiomara.aplication.Service;

import org.Xiomara.Domain.Receta;
import org.Xiomara.Interfaces.RecetaRepository;
import org.Xiomara.Interfaces.RecetaService;

import java.util.List;

public class RecetaServiceImpl implements RecetaService {

    private final RecetaRepository recetaRepository;

    public RecetaServiceImpl(RecetaRepository recetaRepository) {
        this.recetaRepository = recetaRepository;
    }

    
    public void crearReceta(Receta receta) {
        recetaRepository.save(receta);
    }

    
    public Receta buscarReceta(int id) {
        return recetaRepository.findById(id);
    }

    
    public List<Receta> listarRecetas() {
        return recetaRepository.findAll();
    }

    
    public void actualizarReceta(Receta receta) {
        recetaRepository.update(receta);
    }

    
    public void eliminarReceta(int id) {
        recetaRepository.delete(id);
    }

}
