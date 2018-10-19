package be.thomasmore.travelmore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="boeking")

public class Boeking {

    @Id
    private int id;
    @Column(name = "gebruikersId")
    private int gebruikersId;
    @Column(name = "reisId")
    private int reisId;
    @Column(name = "aantalPersonen")
    private int aantalPersonen;
    @Column(name = "opmerking")
    private String opmerking;
    @Column(name = "betalingId")
    private int betalingId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGebruikersId() {
        return gebruikersId;
    }

    public void setGebruikersId(int gebruikersId) {
        this.gebruikersId = gebruikersId;
    }

    public int getReisId() {
        return reisId;
    }

    public void setReisId(int reisId) {
        this.reisId = reisId;
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

    public int getBetalingId() {
        return betalingId;
    }

    public void setBetalingId(int betalingId) {
        this.betalingId = betalingId;
    }
}
