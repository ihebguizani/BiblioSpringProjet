package Biblio.controller;

import Biblio.models.Reservation;
import Biblio.servicesImpl.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {
    @Autowired
    private ReservationServiceImpl reservationService;

    @GetMapping("/resrv")
    public List<Reservation> getAllRes(){
        return reservationService.getAllRes();
    }
    @PostMapping("/")
    public Reservation addRes(@RequestBody Reservation reservation){
        return reservationService.addRes(reservation);
    }
}
