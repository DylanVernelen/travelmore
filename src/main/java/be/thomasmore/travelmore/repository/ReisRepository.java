package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Reis;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class ReisRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;


    public List<Reis> findAll() {
        return entityManager.createNamedQuery(Reis.FIND_ALL, Reis.class).getResultList();
    }

    public void insert(Reis reis) {entityManager.persist(reis);}

    public  List<Reis> filter(Reis filterReis){
        String queryString = "SELECT r FROM Reis r";
        queryString += " WHERE r.vertrek.id = :vertrekId";
        queryString += " AND r.bestemming.id = :bestemmingId";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("vertrekId", filterReis.getVertrek().getId());
        query.setParameter("bestemmingId", filterReis.getBestemming().getId());
        return query.getResultList();
    }
}
