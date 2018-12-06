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

    public void insert(Reis reis) {
        entityManager.persist(reis);
    }

    public List<Reis> filter(Reis filterReis) {
        String queryString = "SELECT r FROM Reis r";

        queryString += filterReis.getVertrek().getId() != 0 ? " AND r.vertrek.id = :vertrekId" : "";
        queryString += filterReis.getBestemming().getId() != 0 ? " AND r.bestemming.id = :bestemmingId" : "";
        queryString += filterReis.getTransportmiddel().getId() != 0 ? " AND r.transportmiddel.id = :transportmiddelId" : "";
        queryString += filterReis.getKostprijs() > 0 ? " AND r.kostprijs <= :kostprijs" : "";
        queryString += filterReis.getAantalPlaatsen() > 0 ? " AND r.aantalPlaatsen >= :plaatsen" : "";

        queryString = queryString.replaceFirst("AND", "WHERE");
        Query query = entityManager.createQuery(queryString);

        if (filterReis.getVertrek().getId() != 0) {
            query.setParameter("vertrekId", filterReis.getVertrek().getId());
        }
        if (filterReis.getBestemming().getId() != 0) {
            query.setParameter("bestemmingId", filterReis.getBestemming().getId());
        }
        if (filterReis.getTransportmiddel().getId() != 0) {
            query.setParameter("transportmiddelId", filterReis.getTransportmiddel().getId());
        }
        if (filterReis.getKostprijs() > 0) {
            query.setParameter("kostprijs", filterReis.getKostprijs());
        }
        if (filterReis.getAantalPlaatsen() > 0) {
            query.setParameter("plaatsen", filterReis.getAantalPlaatsen());
        }
        return query.getResultList();
    }

    /* public void delete(Reis reis) {
    //  entityManager.remove(entityManager.contains(entityManager) ? entityManager : entityManager.merge(reis));
      entityManager.merge(reis);
      entityManager.createNativeQuery()
      entityManager.remove(reis);
      //   entityManager.remove(reis);

     }*/

        public void delete(int id)
        {

           Reis reis = entityManager.find(Reis.class, id);

            if(reis != null)
                entityManager.remove( reis );
            else
                System.out.println("Ongeldige reis: " + id);
        }


}
