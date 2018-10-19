package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.repository.BetalingRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class BetalingService {
    @Inject
    private BetalingRepository betalingRepository;
}
