package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Rol;
import be.thomasmore.travelmore.repository.RolRepository;
import be.thomasmore.travelmore.repository.RolRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class RolService {
    @Inject
    private RolRepository rolRepository;



    public List<Rol> findAll() {
        return rolRepository.findAll();
    }



}
