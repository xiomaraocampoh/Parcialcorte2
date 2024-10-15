package org.Xiomara.Interfaces;

import org.Xiomara.Domain.Receta;

import java.util.List;

public interface RecetaRepository {
    
    void save(Receta receta);
    Receta findById(int id);
    List<Receta> findAll();
    void update(Receta receta);
    void delete(int id);

}
