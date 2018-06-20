package mas.Person;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Created by Darek on 2018-06-20.
 */
public interface SalesmanRepository extends CrudRepository<Salesman, Long> {
    List<Salesman> findByPersonalIdNumber(Long personalIdNumber);
}
