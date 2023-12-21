package Biblio.servicesImpl;

import Biblio.models.Reservation;
import Biblio.repositories.ReservationRepo;
import Biblio.serviceInterfaces.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepo reservationRepo;

    @Override
    public List<Reservation> getAllRes(){
        return reservationRepo.findAll();
    }
    @Override
    public Reservation addRes(Reservation reservation){
        return reservationRepo.save(reservation);
    }
}
