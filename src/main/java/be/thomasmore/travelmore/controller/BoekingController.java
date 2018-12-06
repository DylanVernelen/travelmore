package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.*;
import be.thomasmore.travelmore.service.BetalingService;
import be.thomasmore.travelmore.service.BoekingService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.Date;

@ManagedBean
@SessionScoped
public class BoekingController {
    private Boeking nieuweBoeking = new Boeking();

    @Inject
    private BoekingService boekingService;

    @Inject
    private BetalingService betalingService;

    @Inject
    private GebruikerController gebruikerController;

    public String boekReis(Reis reis){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        Gebruiker ingelogd = (Gebruiker)session.getAttribute("user");
        if(ingelogd == null){
            return "reizenfilter";
        }
        nieuweBoeking.setReis(reis);
        nieuweBoeking.setAantalPersonen(1);
        nieuweBoeking.setGebruiker(ingelogd);

        return "boeking";
    }

    public String betaalReis(BetalingsType betalingsType){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        Gebruiker ingelogd = (Gebruiker)session.getAttribute("user");
        if(ingelogd == null){
            return "reizenfilter";
        }
        Betaling betaling = new Betaling();
        Date date = new Date();
        betaling.setDatum(date);
        betaling.setBetalingstype(betalingsType);
        System.out.println("****************************************************");
        System.out.println(nieuweBoeking.getAantalPersonen());
        System.out.println(nieuweBoeking.getOpmerking());
        System.out.println(nieuweBoeking.getReis().getNaam());
        System.out.println("****************************************************");
        //nieuweBoeking.setBetaling(betaling);
        betalingService.insert(betaling);
        //boekingService.insert(nieuweBoeking);
        insertBoeking(nieuweBoeking);

        //stuur email
        return "bedankt";
    }

    public void insertBoeking(Boeking boeking){
        Betaling betaling = betalingService.getLaatsteBetaling();
        boeking.setBetaling(betaling);
        boekingService.insert(boeking);
    }

    public Boeking getNieuweBoeking() {
        return nieuweBoeking;
    }

    public void setNieuweBoeking(Boeking nieuweBoeking) {
        this.nieuweBoeking = nieuweBoeking;
    }
}
