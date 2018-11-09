package be.thomasmore.travelmore.controller;
import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.service.GebruikerService;
import be.thomasmore.travelmore.domain.Gebruiker;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@ManagedBean
@ViewScoped
@SessionScoped
public class GebruikerController {
    private Gebruiker nieuweGebruiker = new Gebruiker();
    private String gebruikernaam;
    private String wachtwoord;

    @Inject
   private GebruikerService gebruikerService;


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


    public String getGebruikernaam() {
        return gebruikernaam;
    }

    public void setGebruikernaam(String gebruikernaam) {
        this.gebruikernaam = gebruikernaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }
}
