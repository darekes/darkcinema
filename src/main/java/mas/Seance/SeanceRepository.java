package mas.Seance;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Darek on 2018-06-21.
 */
public interface SeanceRepository extends CrudRepository<Seance, Long>{
    List<Seance> findAll();
}
