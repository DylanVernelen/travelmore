package be.thomasmore.travelmore.controller;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.domain.Transportmiddel;
import be.thomasmore.travelmore.service.ReisService;
import org.primefaces.event.SelectEvent;
import java.text.ParseException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.Date;
import java.util.Locale;
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
    private String vertrekDatum;
    private String eindDatum;
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


public void setDatums() {
    String expectedPattern = "dd/mm/yyyy";
    SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
    try
    {
        String userInput = this.eindDatum;
        Date einddatum = formatter.parse(this.vertrekDatum);
        Date begindatum = formatter.parse(this.eindDatum);
     this.nieuweReis.setEinddatum(einddatum);
     this.nieuweReis.setStartdatum(begindatum);

    }
    catch (ParseException e)
    {
        // execution will come here if the String that is given
        // does not match the expected format.
        e.printStackTrace();
    }
}


    public void createReis(){
        this.setDatums();
        this.nieuweReis.setBestemming(this.bestemming);
        this.nieuweReis.setVertrek(this.vertrek);
        this.nieuweReis.setTransportmiddel(this.transportmiddel);
        this.reisService.insert(nieuweReis);
    }


    public Locatie getBestemming() {
        return bestemming;
    }

    public String getVertrekDatum() {
        return vertrekDatum;
    }

    public void setVertrekDatum(String vertrekDatum) {
        this.vertrekDatum = vertrekDatum;
    }

    public String getEindDatum() {
        return eindDatum;
    }

    public void setEindDatum(String eindDatum) {
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
    public void deleteReis(Reis reis){

       this.reisService.delete(reis);

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
