package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.repository.ReisRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ReisService {
    @Inject
    private ReisRepository reisRepository;
}
