package org.Xiomara.Infraestructure.Repository;

import org.Xiomara.Domain.Receta;
import org.Xiomara.Interfaces.RecetaRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ImplRecetaRepository implements RecetaRepository {

    private static final String FILE_NAME = "Receta.dat";

    @Override
    public void save(Receta receta) {
        List<Receta> recetas = findAll();
        recetas.add(receta);
        saveAll(recetas);
    }

    @Override
    public Receta findById(int id) {
        return findAll().stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Receta> findAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Receta>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public void update(Receta receta) {

        List<Receta> recetas = findAll();
        for (int i = 0; i < recetas.size(); i++) {
            if (recetas.get(i).getId() == receta.getId()) {
                recetas.set(i, receta);
                break;
            }
        }
        saveAll(recetas);
    }

    @Override
    public void delete(int id) {
        List<Receta> empleados = findAll();
        empleados.removeIf(e -> e.getId() == id);
        saveAll(empleados);
    }

    private void saveAll(List<Receta> recetas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(recetas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}