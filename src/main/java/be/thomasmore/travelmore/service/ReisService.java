package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.repository.ReisRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ReisService {
    @Inject
    private ReisRepository reisRepository;

    public List<Reis> findAll() {
        return reisRepository.findAll();
    }

    public void insert(Reis reis) { reisRepository.insert(reis);}

    public List<Reis> filter(Reis filterReis) {
        return  reisRepository.filter(filterReis);
    }

    public void delete(Reis reis) { reisRepository.delete(reis.getId());}
}
