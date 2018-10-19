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
    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
