package be.thomasmore.travelmore.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "locatie")
@NamedQueries(
        {
                @NamedQuery(
                        name = Locatie.FIND_ALL,
                        query = "SELECT l FROM Locatie l"
                )
        }
)
@XmlRootElement(name = "locatie")
public class Locatie {
    public static final String FIND_ALL = "Locatie.findAll";

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
