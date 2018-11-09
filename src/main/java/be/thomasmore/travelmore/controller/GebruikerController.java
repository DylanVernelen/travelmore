package be.thomasmore.travelmore.controller;
import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.service.GebruikerService;
import be.thomasmore.travelmore.domain.Gebruiker;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

@ManagedBean
@SessionScoped
public class GebruikerController {
    private Gebruiker nieuweGebruiker = new Gebruiker();
    private Gebruiker ingelogdeGebruiker = new Gebruiker();
    private String email;
    private String wachtwoord;

    @Inject
   private GebruikerService gebruikerService;

    public void valideer(){
        Gebruiker inkomendeGebruiker = this.gebruikerService.gebruikerLogin(this.email, this.wachtwoord);
        if(inkomendeGebruiker != null){
            this.ingelogdeGebruiker = inkomendeGebruiker;
        } else {
            this.ingelogdeGebruiker.setNaam("Gebruiker niet gevonden");
        }
    }

    public Gebruiker getNieuweGebruiker() {
        return nieuweGebruiker;

    }


    public void setNieuweGebruiker(Gebruiker nieuweGebruiker) {
        this.nieuweGebruiker = nieuweGebruiker;
    }

    public void registreer(){
        this.nieuweGebruiker.setRolId(1);
        this.gebruikerService.insert(this.nieuweGebruiker);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public Gebruiker getIngelogdeGebruiker() {
        return ingelogdeGebruiker;
    }

    public void setIngelogdeGebruiker(Gebruiker ingelogdeGebruiker) {
        this.ingelogdeGebruiker = ingelogdeGebruiker;
    }
}
