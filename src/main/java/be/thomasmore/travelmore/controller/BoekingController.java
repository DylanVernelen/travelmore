package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Betaling;
import be.thomasmore.travelmore.domain.BetalingsType;
import be.thomasmore.travelmore.domain.Boeking;
import be.thomasmore.travelmore.domain.Reis;
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

    public String boekReis(Reis reis){
        nieuweBoeking.setReis(reis);
        nieuweBoeking.setAantalPersonen(1);
        //nieuweBoeking.setGebruiker(); //hier de aangemelde gebruiker koppelen aan de boeking

        return "boeking";
    }

    public String betaalReis(BetalingsType betalingsType){
        Betaling betaling = new Betaling();
        Date date = new Date();
        betaling.setDatum(date);
        betaling.setBetalingstype(betalingsType);
        nieuweBoeking.setBetaling(betaling);
        return "bedankt";
    }

    public Boeking getNieuweBoeking() {
        return nieuweBoeking;
    }

    public void setNieuweBoeking(Boeking nieuweBoeking) {
        this.nieuweBoeking = nieuweBoeking;
    }
}
