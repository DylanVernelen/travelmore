package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.repository.LocatieRepository;
import be.thomasmore.travelmore.repository.LocatieRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class LocatieService {
    @Inject
    private LocatieRepository locatieRepository;



    public List<Locatie> findAllLocations() {
        return locatieRepository.findAll();
    }

    public Locatie findById(int id)
    {
        return locatieRepository.findById(id);
    }
    public void updateName(int id, String newName) {
        Locatie locatie = locatieRepository.findById(id);
        locatie.setNaam(newName);
    }

    public void insert(Locatie locatie) {
        locatieRepository.insert(locatie);
    }

    public void delete(int id)
    {
        locatieRepository.delete(id);
    }

}
