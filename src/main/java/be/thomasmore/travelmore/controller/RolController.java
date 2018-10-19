package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Rol;
import be.thomasmore.travelmore.service.RolService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class RolController {


    @Inject
    private RolService rolService;


    public List<Rol> getRollen(){
        return this.rolService.findAll();
    }

}
