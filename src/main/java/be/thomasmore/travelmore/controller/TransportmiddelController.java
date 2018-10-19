package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Transportmiddel;
import be.thomasmore.travelmore.service.TransportmiddelService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class TransportmiddelController {

    @Inject
    private TransportmiddelService transportmiddelService;


    public List<Transportmiddel> getLocations(){
        return this.transportmiddelService.findAll();
    }


}
