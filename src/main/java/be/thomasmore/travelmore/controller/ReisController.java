package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.service.ReisService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class ReisController {
    private Reis nieuweReis = new Reis();
    private List<Reis> gefilterdeReizen;

    private int filterVertrekId;
    private int filterBestemmingId;

    @Inject
    private ReisService reisService;


    public List<Reis> getAll(){
        return this.reisService.findAll();
    }

    public List<Reis> getGefilterd(){
        Reis filterReis = new Reis();
        Locatie filterVertrek = new Locatie();
        filterVertrek.setId(filterVertrekId);
        Locatie filterBestemming = new Locatie();
        filterBestemming.setId(filterBestemmingId);
        filterReis.setVertrek(filterVertrek);
        filterReis.setBestemming(filterBestemming);
        return this.reisService.filter(filterReis);
    }

    public String filter(){
        System.out.println(filterVertrekId);
        System.out.println("test");
        return "reizenFilter";
    }

    public Reis getNieuweReis() {
        return nieuweReis;
    }

    public void setNieuweReis(Reis nieuweReis) {
        this.nieuweReis = nieuweReis;
    }

    public void createReis(){
        System.out.println("Click");
        System.out.println(nieuweReis.getNaam());
        this.reisService.insert(nieuweReis);
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
}
