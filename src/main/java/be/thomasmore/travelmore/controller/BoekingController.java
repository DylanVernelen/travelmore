package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.*;
import be.thomasmore.travelmore.service.BetalingService;
import be.thomasmore.travelmore.service.BoekingService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import java.util.Date;

@ManagedBean
@SessionScoped
public class BoekingController {
    private Boeking nieuweBoeking = new Boeking();

    @Inject
    private BoekingService boekingService;

    @Inject
    private BetalingService betalingService;

    public String boekReis(Reis reis){
        nieuweBoeking.setReis(reis);
        nieuweBoeking.setAantalPersonen(1);
        Gebruiker gebruiker = new Gebruiker();
        gebruiker.setId(1);
        nieuweBoeking.setGebruiker(gebruiker); //hier de aangemelde gebruiker koppelen aan de boeking

        return "boeking";
    }

    public String betaalReis(BetalingsType betalingsType){
        Betaling betaling = new Betaling();
        Date date = new Date();
        betaling.setDatum(date);
        betaling.setBetalingstype(betalingsType);
        nieuweBoeking.setBetaling(betaling);
        System.out.println("****************************************************");
        System.out.println(nieuweBoeking.getAantalPersonen());
        System.out.println(nieuweBoeking.getOpmerking());
        System.out.println(nieuweBoeking.getReis().getNaam());
        System.out.println(nieuweBoeking.getBetaling().getBetalingstype().getNaam());
        System.out.println("****************************************************");
        //nieuweBoeking.setBetaling(betaling);
        betalingService.insert(betaling);
        //boekingService.insert(nieuweBoeking);
        insertBoeking(nieuweBoeking);

        //stuur email
        return "bedankt";
    }

    public void insertBoeking(Boeking boeking){
        Betaling betaling1 = new Betaling();
        betaling1.setId(1);
        BetalingsType betalingsType1 = new BetalingsType();
        betalingsType1.setId(2);
        betaling1.setBetalingstype(betalingsType1);
        Date date = new Date();
        betaling1.setDatum(date);
        //boeking.setBetaling(betaling1);
        boekingService.insert(boeking);
    }

    public Boeking getNieuweBoeking() {
        return nieuweBoeking;
    }

    public void setNieuweBoeking(Boeking nieuweBoeking) {
        this.nieuweBoeking = nieuweBoeking;
    }
}
