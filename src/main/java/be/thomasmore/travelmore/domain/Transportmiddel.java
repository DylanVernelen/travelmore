package be.thomasmore.travelmore.domain;

import javax.persistence.*;



@Entity
@Table(name = "transportmiddel")
@NamedQueries(
        {
                @NamedQuery(
                        name = Transportmiddel.FIND_ALL,
                        query = "SELECT t FROM Transportmiddel t"
                ),

        }
)
public class Transportmiddel {
    public static final String FIND_ALL = "transportmiddel.findAll";

    @Id
    private int id;
    @Column(name = "naam")
    private String naam;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}
