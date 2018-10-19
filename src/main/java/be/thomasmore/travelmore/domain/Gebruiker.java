package be.thomasmore.travelmore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "gebruiker")

public class Gebruiker {
    @Id
    private int id;
    @Column(name = "rolId")
    private int rolId;
    @Column(name = "naam")
    private String naam;
    @Column(name = "adres")
    private String adres;
    @Column(name = "woonplaats")
    private String woonplaats;
    @Column(name = "email")
    private String email;
    @Column(name = "wachtwoord")
    @Size(min = 6)
    private String wachtwoord;

    public Gebruiker() {
    }

    public Gebruiker(int id, int rolId, String naam, String adres, String woonplaats, String email, String wachtwoord) {
        this.id = id;
        this.rolId = rolId;
        this.naam = naam;
        this.adres = adres;
        this.woonplaats = woonplaats;
        this.email = email;
        this.wachtwoord = wachtwoord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }
}
