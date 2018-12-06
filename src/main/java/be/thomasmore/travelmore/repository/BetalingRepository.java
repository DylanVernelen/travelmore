package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Betaling;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class BetalingRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Betaling getLaatsteBetaling(){
        String queryString = "SELECT b FROM Betaling b order by b.id desc";

        Query query = entityManager.createQuery(queryString);
        return (Betaling)query.setMaxResults(1).getSingleResult();
    }

    public void insert(Betaling betaling) {
        entityManager.persist(betaling);
    }
}
