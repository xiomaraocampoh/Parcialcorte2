package org.Xiomara.Infraestructure;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.Xiomara.Domain.Receta;
import org.Xiomara.Interfaces.RecetaRepository;

import java.util.List;

public class ImplRecetaRepository implements RecetaRepository {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("RecetaPU");

    @Override
    public void save(Receta receta) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(receta);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Receta findById(int id) {
        EntityManager em = emf.createEntityManager();
        Receta receta = em.find(Receta.class, id);
        em.close();
        return receta;
    }

    @Override
    public List<Receta> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Receta> recetas = em.createQuery("SELECT r FROM Receta r", Receta.class).getResultList();
        em.close();
        return recetas;
    }

    @Override
    public void update(Receta receta) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(receta);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Receta receta = em.find(Receta.class, id);
        if (receta != null) {
            em.remove(receta);
        }
        em.getTransaction().commit();
        em.close();
    }
}

