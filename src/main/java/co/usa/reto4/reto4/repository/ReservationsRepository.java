package co.usa.reto4.reto4.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.usa.reto4.reto4.model.Reservations;
import co.usa.reto4.reto4.repository.crud.ReservationsCrudRepository;


@Repository
public class ReservationsRepository {
    
    @Autowired
    private ReservationsCrudRepository reservationsCrudRepository;

    public List<Reservations>getAll(){
        return (List<Reservations>)reservationsCrudRepository.findAll();
    }

    public Optional<Reservations>getReservations(int id){
        return reservationsCrudRepository.findById(id);
    }

    public Reservations save(Reservations reservations){
        return reservationsCrudRepository.save(reservations);
    }

    public void delete(Reservations reservations){
        reservationsCrudRepository.delete(reservations);
    }
}
