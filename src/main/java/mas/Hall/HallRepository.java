package mas.Hall;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Darek on 2018-06-21.
 */
public interface HallRepository extends CrudRepository<Hall, Long> {
    List<Hall> findAll();
    List<Hall> findByNumber(int number);
}
