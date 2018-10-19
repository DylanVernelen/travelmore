package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "betaling")

public class Betaling {

    @Id
    private int id;

    @OneToOne
    private Boeking boeking;

    //@Column(name = "betalingstype")
    //private Betalingstype betalingstype;
    private Date datum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boeking getBoeking() {
        return boeking;
    }

    public void setBoeking(Boeking boeking) {
        this.boeking = boeking;
    }

  /*  public Betalingstype getBetalingstype() {
        return betalingstype;
    }

    public void setBetalingstype(Betalingstype betalingstype) {
        this.betalingstype = betalingstype;
    }
*/
    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}
