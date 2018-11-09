package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.repository.GebruikerRepository;
import be.thomasmore.travelmore.domain.Gebruiker;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Stateless
public class GebruikerService {
    @Inject
    private GebruikerRepository gebruikerRepository;

    public void insert(Gebruiker gebruiker) {
        gebruikerRepository.insert(gebruiker);
    }

    public Gebruiker gebruikerLogin(String email, String wachtwoord){ return gebruikerRepository.gebruikerLogin(email, wachtwoord); }

}
