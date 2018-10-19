package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "betaling")

public class Reis {
    @Id
    private int id;
    @ManyToOne
    @Column(name = "vertrek")
    private Locatie vertrek;
    @ManyToOne
    @Column(name = "bestemming")
    private Locatie bestemming;
    @ManyToOne
    @Column(name = "transportmiddel")
    private Transportmiddel transportmiddel;
    private String naam;
    private int aantalPlaatsen;
    private double kostprijs;
    private Date startdatum;
    private Date einddatum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Locatie getVertrek() {
        return vertrek;
    }

    public void setVertrek(Locatie vertrek) {
        this.vertrek = vertrek;
    }

    public Locatie getBestemming() {
        return bestemming;
    }

    public void setBestemming(Locatie bestemming) {
        this.bestemming = bestemming;
    }

    public Transportmiddel getTransportmiddel() {
        return transportmiddel;
    }

    public void setTransportmiddel(Transportmiddel transportmiddel) {
        this.transportmiddel = transportmiddel;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getAantalPlaatsen() {
        return aantalPlaatsen;
    }

    public void setAantalPlaatsen(int aantalPlaatsen) {
        this.aantalPlaatsen = aantalPlaatsen;
    }

    public double getKostprijs() {
        return kostprijs;
    }

    public void setKostprijs(double kostprijs) {
        this.kostprijs = kostprijs;
    }

    public Date getStartdatum() {
        return startdatum;
    }

    public void setStartdatum(Date startdatum) {
        this.startdatum = startdatum;
    }

    public Date getEinddatum() {
        return einddatum;
    }

    public void setEinddatum(Date einddatum) {
        this.einddatum = einddatum;
    }
}
