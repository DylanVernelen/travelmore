package be.thomasmore.travelmore.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "rol")
@NamedQueries(
        {
                @NamedQuery(
                        name = Rol.FIND_ALL,
                        query = "SELECT l FROM Rol l"
                ),

        }
)
public class Rol {
    public static final String FIND_ALL = "Rol.findAll";

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
