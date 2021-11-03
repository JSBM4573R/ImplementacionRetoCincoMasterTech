package co.usa.reto4.reto4.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.usa.reto4.reto4.model.Reservations;
import co.usa.reto4.reto4.repository.ReservationsRepository;

@Service
public class ReservationsService {
    
    @Autowired
    private ReservationsRepository reservationsRepository;

    public List<Reservations>getAll(){
        return reservationsRepository.getAll();
    }

    public Optional<Reservations>getReservations(int id){
        return reservationsRepository.getReservations(id);
    }

    public Reservations save(Reservations reservations){
        if (reservations.getIdReservation()==null) {
            return reservationsRepository.save(reservations);
        }else{
            Optional<Reservations> consulta= reservationsRepository.getReservations(reservations.getIdReservation());
            if (consulta.isEmpty()) {
                return reservationsRepository.save(reservations);
            }else{
                return reservations;
            }
        }
    }

    public Reservations update(Reservations reservations){
        if (reservations.getIdReservation()!=null) {
            Optional<Reservations> consulta=reservationsRepository.getReservations(reservations.getIdReservation());
            if (!consulta.isEmpty()) {
                if (reservations.getStartDate()!=null) {
                    consulta.get().setStartDate(reservations.getStartDate());
                }
                if (reservations.getDevolutionDate()!=null) {
                    consulta.get().setDevolutionDate(reservations.getDevolutionDate());
                }
                return reservationsRepository.save(consulta.get());
            }
        }
        return reservations;
    }

    public boolean deleteReservation(int id){
        Optional<Reservations> consulta=reservationsRepository.getReservations(id);
        if (!consulta.isEmpty()) {
            reservationsRepository.delete(consulta.get());
            return true;
        }
        return false;
    }
}
