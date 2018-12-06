package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.service.LocatieService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class LocatieController {

    private Locatie newLocation = new Locatie();
    private String naam;

    @Inject
    private LocatieService locatieService;

    public Locatie getNewLocation() {
        return newLocation;
    }

    public void setNewLocation(Locatie newLocation) {
        this.newLocation = newLocation;
    }

    public List<Locatie> getLocations(){
        return this.locatieService.findAllLocations();
    }

    public void submit(){
        this.newLocation.setNaam(this.naam);
        this.locatieService.insert(newLocation);
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}
