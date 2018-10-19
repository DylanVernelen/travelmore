package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.BetalingsType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BetalingsTypeRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;


    public List<BetalingsType> findAll() {
        return entityManager.createNamedQuery(BetalingsType.FIND_ALL, BetalingsType.class).getResultList();
    }

}
