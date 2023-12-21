package Biblio.serviceInterfaces;

import Biblio.models.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAllRes();
    Reservation addRes(Reservation reservation);
}
