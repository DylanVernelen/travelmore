package be.thomasmore.travelmore.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BoekingRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;
}
