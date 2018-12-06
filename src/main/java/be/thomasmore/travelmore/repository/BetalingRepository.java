package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Betaling;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BetalingRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public void insert(Betaling betaling) {
        entityManager.persist(betaling);
    }
}
