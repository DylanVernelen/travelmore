package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.service.ReisService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class ReisController {
    private Reis nieuweReis = new Reis();

    @Inject
    private ReisService reisService;


    public List<Reis> getAll(){
        return this.reisService.findAll();
    }

    public Reis getNieuweReis() {
        return nieuweReis;
    }

    public void setNieuweReis(Reis nieuweReis) {
        this.nieuweReis = nieuweReis;
    }

    public void createReis(){
        System.out.println("Click");
        System.out.println(nieuweReis.getNaam());
        this.reisService.insert(nieuweReis);
    }

}
