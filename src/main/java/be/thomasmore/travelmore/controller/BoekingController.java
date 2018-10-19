package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Boeking;
import be.thomasmore.travelmore.service.BoekingService;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class BoekingController {
    private Boeking nieuweBoeking = new Boeking();

    @Inject
    private BoekingService boekingService;

    public Boeking getNieuweBoeking() {
        return nieuweBoeking;
    }

    public void setNieuweBoeking(Boeking nieuweBoeking) {
        this.nieuweBoeking = nieuweBoeking;
    }
}
