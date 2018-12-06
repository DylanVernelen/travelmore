package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Betaling;
import be.thomasmore.travelmore.domain.BetalingsType;
import be.thomasmore.travelmore.service.BetalingService;
import be.thomasmore.travelmore.service.BetalingsTypeService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class BetalingsTypeController {

    @Inject
    private BetalingsTypeService betalingTypeService;

    public List<BetalingsType> getBetalingsTypes(){
        return this.betalingTypeService.findAll();
    }

}
