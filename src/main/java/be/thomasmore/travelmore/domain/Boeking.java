package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.domain.Betaling;

@Entity
@Table(name="boeking")

public class Boeking {

    @Id
    private int id;
    @ManyToOne
    private Gebruiker gebruiker;
    @ManyToOne
    private Reis reis;
    @Column(name = "aantalPersonen")
    private int aantalPersonen;
    @Column(name = "opmerking")
    private String opmerking;
    @OneToOne(cascade = {CascadeType.ALL})
    private Betaling betaling;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Gebruiker getGebruiker() {
        return gebruiker;
    }

    public void setGebruiker(Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
    }

    public Reis getReis() {
        return reis;
    }

    public void setReis(Reis reis) {
        this.reis = reis;
    }

    public int getAantalPersonen() {
        return aantalPersonen;
    }

    public void setAantalPersonen(int aantalPersonen) {
        this.aantalPersonen = aantalPersonen;
    }

    public String getOpmerking() {
        return opmerking;
    }

    public void setOpmerking(String opmerking) {
        this.opmerking = opmerking;
    }

    public Betaling getBetaling() {
        return betaling;
    }

    public void setBetaling(Betaling betaling) {
        this.betaling = betaling;
    }
}
