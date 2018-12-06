package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "betaling")

public class Betaling {

    @Id
    private int id;

    @OneToOne
    private BetalingsType betalingsType;
    private Date datum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BetalingsType getBetalingstype() {
        return betalingsType;
    }

    public void setBetalingstype(BetalingsType betalingstype) {
        this.betalingsType = betalingstype;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}
