package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.repository.GebruikerRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class GebruikerService {
    @Inject
    private GebruikerRepository gebruikerRepository;
}
