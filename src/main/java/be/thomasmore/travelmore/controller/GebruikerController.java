package be.thomasmore.travelmore.controller;
import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.service.GebruikerService;
import be.thomasmore.travelmore.domain.Gebruiker;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class GebruikerController {
    private Gebruiker nieuweGebruiker = new Gebruiker();
    private Gebruiker ingelogdeGebruiker = new Gebruiker();
    private String valideerGebruikernaamWachtwoord;
    private String login, boodschap;
    private String mail, password;
    private Boolean ingelogd;

    @Inject
    private GebruikerService gebruikerService;

    public GebruikerController(){
        this.login = "Login";
        this.ingelogd = false;
    }

    public void logout(){
       this.ingelogdeGebruiker = new Gebruiker();
       this.login = "Login";
       this.ingelogd = false;
       this.boodschap = "";
       HttpSession session = (HttpSession)FacesContext.getCurrentInstance()
               .getExternalContext().getSession(false);
       session.removeAttribute("user");
    }

    public void valideer(){
        Gebruiker inkomendeGebruiker = this.gebruikerService.gebruikerLogin(this.mail, this.password);
        if(inkomendeGebruiker != null){
            this.ingelogdeGebruiker = inkomendeGebruiker;
            this.login = "Logout";
            this.ingelogd = true;
            this.resetLoginpoging();
            this.boodschap = "Welkom " + this.ingelogdeGebruiker.getNaam();
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance()
                    .getExternalContext().getSession(false);
            session.setAttribute("user", this.ingelogdeGebruiker);
        } else {
            this.ingelogdeGebruiker.setNaam("Gebruiker niet gevonden");
            this.resetLoginpoging();
        }
    }

    private void resetLoginpoging() {
        this.mail = "";
        this.password = "";
    }

    public void registreer(){


       this.nieuweGebruiker.setRolId(1);

        this.nieuweGebruiker.setRolId(1);

        this.gebruikerService.insert(this.nieuweGebruiker);
        this.nieuweGebruiker = new Gebruiker();
        this.index();
    }

    public String index() {
        return "reizen.xhtml";
    }

    public Gebruiker getNieuweGebruiker() { return nieuweGebruiker; }
    public void setNieuweGebruiker(Gebruiker nieuweGebruiker) {
        this.nieuweGebruiker = nieuweGebruiker;
    }
    public Gebruiker getIngelogdeGebruiker() {
        return ingelogdeGebruiker;
    }
    public void setIngelogdeGebruiker(Gebruiker ingelogdeGebruiker) {
        this.ingelogdeGebruiker = ingelogdeGebruiker;
    }
    public String getValideerGebruikernaamWachtwoord() {
        return valideerGebruikernaamWachtwoord;
    }
    public void setValideerGebruikernaamWachtwoord(String valideerGebruikernaamWachtwoord) { this.valideerGebruikernaamWachtwoord = valideerGebruikernaamWachtwoord; }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIngelogd() {
        return ingelogd;
    }

    public void setIngelogd(Boolean ingelogd) {
        this.ingelogd = ingelogd;
    }

    public String getBoodschap() {
        return boodschap;
    }

    public void setBoodschap(String boodschap) {
        this.boodschap = boodschap;
    }
}
