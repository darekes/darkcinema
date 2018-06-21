package mas.Promotion;

import mas.Reservation.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Darek on 2018-06-21.
 */
public interface PromotionRepository extends CrudRepository<Promotion, Long> {
    List<Promotion> findByName(String name);
}
