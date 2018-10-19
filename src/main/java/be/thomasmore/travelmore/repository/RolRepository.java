package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Rol;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class RolRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Rol findById(int id) {
        return entityManager.find(Rol.class, id);
    }

    public List<Rol> findAll() {
        return entityManager.createNamedQuery(Rol.FIND_ALL, Rol.class).getResultList();
    }



}
