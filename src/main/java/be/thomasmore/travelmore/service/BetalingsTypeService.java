package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.BetalingsType;
import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.repository.BetalingsTypeRepository;
import be.thomasmore.travelmore.repository.LocatieRepository;
import be.thomasmore.travelmore.repository.LocatieRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class BetalingsTypeService {
    @Inject
    private BetalingsTypeRepository betalingsTypeRepository;



    public List<BetalingsType> findAll() {
        return betalingsTypeRepository.findAll();
    }


}
