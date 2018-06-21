package mas.Reservation;

import mas.Seance.Seance;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Darek on 2018-06-13.
 */
public interface ReservationRepository extends CrudRepository<Reservation, Long>{
    List<Reservation> findAll();
}
