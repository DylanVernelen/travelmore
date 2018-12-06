package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.domain.Transportmiddel;
import be.thomasmore.travelmore.service.ReisService;
import org.primefaces.event.SelectEvent;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@ManagedBean
@SessionScoped
public class ReisController {
    private Reis nieuweReis = new Reis();
    private List<Reis> gefilterdeReizen;
    private Locatie bestemming = new Locatie();
    private Locatie vertrek = new Locatie();
    private Transportmiddel transportmiddel = new Transportmiddel();
    private int filterVertrekId;
    private int filterBestemmingId;
    private int filterTransportmiddelId;
    private int filterBudget;
    private int filterPlaatsen;
    private Date vertrekDatum;
    private Date eindDatum;
    @Inject
    private ReisService reisService;



    public List<Reis> getAll(){
        return this.reisService.findAll();
    }

    public String filter(){
        Reis filterReis = new Reis();
        Locatie vertrek = new Locatie();
        vertrek.setId(filterVertrekId);
        Locatie bestemming = new Locatie();
        bestemming.setId(filterBestemmingId);
        Transportmiddel transportmiddel = new Transportmiddel();
        transportmiddel.setId(filterTransportmiddelId);
        filterReis.setVertrek(vertrek);
        filterReis.setBestemming(bestemming);
        filterReis.setTransportmiddel(transportmiddel);
        filterReis.setKostprijs(filterBudget);
        filterReis.setAantalPlaatsen(filterPlaatsen);
        gefilterdeReizen = reisService.filter(filterReis);
        return "reizenFilter";
    }

    public Reis getNieuweReis() {
        return nieuweReis;
    }

    public void setNieuweReis(Reis nieuweReis) {
        this.nieuweReis = nieuweReis;
    }

    public void createReis(){
        this.nieuweReis.setBestemming(this.bestemming);
        this.nieuweReis.setEinddatum(this.eindDatum);
        this.nieuweReis.setEinddatum(this.vertrekDatum);
        this.nieuweReis.setVertrek(this.vertrek);
        this.nieuweReis.setTransportmiddel(this.transportmiddel);
        this.reisService.insert(nieuweReis);
    }


    public Locatie getBestemming() {
        return bestemming;
    }

    public Date getVertrekDatum() {
        return vertrekDatum;
    }

    public void setVertrekDatum(Date vertrekDatum) {
        this.vertrekDatum = vertrekDatum;
    }

    public Date getEindDatum() {
        return eindDatum;
    }

    public void setEindDatum(Date eindDatum) {
        this.eindDatum = eindDatum;
    }

    public void setBestemming(Locatie bestemming) {
        this.bestemming = bestemming;
    }

    public Locatie getVertrek() {
        return vertrek;
    }

    public void setVertrek(Locatie vertrek) {
        this.vertrek = vertrek;
    }

    public Transportmiddel getTransportmiddel() {
        return transportmiddel;
    }

    public void setTransportmiddel(Transportmiddel transportmiddel) {
        this.transportmiddel = transportmiddel;
    }
    public void deleteReis(int id){
        this.reisService.delete(id);

    }

    public List<Reis> getGefilterdeReizen() {
        return gefilterdeReizen;
    }

    public void setGefilterdeReizen(List<Reis> gefilterdeReizen) {
        this.gefilterdeReizen = gefilterdeReizen;
    }

    public int getFilterVertrekId() {
        return filterVertrekId;
    }

    public void setFilterVertrekId(int filterVertrekId) {
        this.filterVertrekId = filterVertrekId;
    }

    public int getFilterBestemmingId() {
        return filterBestemmingId;
    }

    public void setFilterBestemmingId(int filterBestemmingId) {
        this.filterBestemmingId = filterBestemmingId;
    }

    public int getFilterTransportmiddelId() {
        return filterTransportmiddelId;
    }

    public void setFilterTransportmiddelId(int filterTransportmiddelId) {
        this.filterTransportmiddelId = filterTransportmiddelId;
    }

    public int getFilterBudget() {
        return filterBudget;
    }

    public void setFilterBudget(int filterBudget) {
        this.filterBudget = filterBudget;
    }

    public int getFilterPlaatsen() {
        return filterPlaatsen;
    }

    public void setFilterPlaatsen(int filterPlaatsen) {
        this.filterPlaatsen = filterPlaatsen;
    }
}
