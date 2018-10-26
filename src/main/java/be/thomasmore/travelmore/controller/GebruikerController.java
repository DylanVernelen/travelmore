package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.service.GebruikerService;
import be.thomasmore.travelmore.domain.Gebruiker;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ManagedBean
@ViewScoped

public class GebruikerController {
    private Gebruiker nieuweGebruiker = new Gebruiker();

    @Inject
   private GebruikerService gebruikerService;

    public Gebruiker getNieuweGebruiker() { return nieuweGebruiker;
    }

    public void setNieuweGebruiker(Gebruiker nieuweGebruiker) {
        this.nieuweGebruiker = nieuweGebruiker;
    }

    public void registreer(){


    }
}
