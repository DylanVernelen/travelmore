package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Boeking;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BoekingRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public void insert(Boeking boeking) {
        entityManager.persist(boeking);
    }
}
