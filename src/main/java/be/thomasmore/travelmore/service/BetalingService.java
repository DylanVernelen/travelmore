package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Betaling;
import be.thomasmore.travelmore.repository.BetalingRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class BetalingService {
    @Inject
    private BetalingRepository betalingRepository;

    public Betaling getLaatsteBetaling(){
        return betalingRepository.getLaatsteBetaling();
    }

    public void insert(Betaling betaling) {
        betalingRepository.insert(betaling);
    }
}
