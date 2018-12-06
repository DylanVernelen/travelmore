package be.thomasmore.travelmore.domain;

import javax.inject.Named;
import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "reis")
@NamedQueries(
        {
                @NamedQuery(
                        name = Reis.FIND_ALL,
                        query = "SELECT r FROM Reis r"
                ),
                @NamedQuery(
                        name = Reis.DELETE,
                        query = "DELETE FROM Reis r where r.id = :id"
                )
        }
)
public class Reis {
    public static final String FIND_ALL = "Reis.findAll";
    public static final String DELETE = "Reis.delete";

    @Id
    private int id;

    @ManyToOne
    private Locatie vertrek;

    @ManyToOne
    private Locatie bestemming;

    @ManyToOne
    private Transportmiddel transportmiddel;
    @Column(name = "naam")
    private String naam;
    @Column(name = "aantalPlaatsen")
    private int aantalPlaatsen;
    @Column(name = "kostprijs")
    private double kostprijs;
    @Column(name = "startdatum")
    private Date startdatum;
    @Column(name = "einddatum")
    private Date einddatum;
    @Column(name = "afbeelding")
    private String afbeelding;



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

    public String getAfbeelding() {
        if  (this.afbeelding == null || this.afbeelding.isEmpty()){
            System.out.println("Image not found");
            this.setAfbeelding("unavailable.png");
            return afbeelding;
        } else{
            System.out.println("Image found: " + afbeelding);
            return afbeelding;
        }
    }

    public void setAfbeelding(String afbeelding) { this.afbeelding = afbeelding; }


    /* Pretty dates */
    public String convertDate(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return sdf.format(date);
    }

    public String getStartdatumPretty()
    {
        return this.convertDate(this.startdatum);

    }

    public String getEinddatumPretty()
    {
        return this.convertDate(this.einddatum);
    }

}
