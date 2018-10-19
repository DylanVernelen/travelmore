package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Betaling;
import be.thomasmore.travelmore.service.BetalingService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class BetalingController {
    private Betaling nieuweBetaling = new Betaling();

    @Inject
    private BetalingService betalingService;

    public Betaling getNieuweBetaling() {
        return nieuweBetaling;
    }

    public void setNieuweBetaling(Betaling nieuweBetaling) {
        this.nieuweBetaling = nieuweBetaling;
    }
}
