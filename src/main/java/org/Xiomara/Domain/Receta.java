package org.Xiomara.Domain;

import java.util.ArrayList;
import java.util.List;

public class Receta {
private static final long serialVersionUID = 1l;
    private int id;
    private String nombre;

    private String descripcion;
    private List<String> ingredientes;

    public Receta(int id, String nombre, List<String> descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = String.valueOf(descripcion);
        this.ingredientes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void addIngrediente(String ingrediente) {
        this.ingredientes.add(ingrediente);
    }

    @Override
    public String toString() {
        return "Receta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", ingredientes=" + ingredientes +
                '}';
    }
}