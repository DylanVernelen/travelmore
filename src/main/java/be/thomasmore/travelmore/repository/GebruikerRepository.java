package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Gebruiker;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GebruikerRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;


    public void insert(Gebruiker gebruiker) {
        entityManager.persist(gebruiker);
    }

    public Gebruiker gebruikerLogin(String email, String wachtwoord){
        Gebruiker gebruiker = new Gebruiker();
        try {
            gebruiker = entityManager.createNamedQuery(Gebruiker.LOGIN_GEBRUIKER, Gebruiker.class)
                    .setParameter("OpgegevenEmail", email)
                    .setParameter("OpgegevenWachtwoord", wachtwoord)
                    .getSingleResult();
        } catch (Exception e) {
            gebruiker = null;
        }

        return gebruiker;
    }
}
