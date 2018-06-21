package mas.Seance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Darek on 2018-06-21.
 */
public interface SeanceRepository extends JpaRepository<Seance, Long> {
    List<Seance> findAll();
}
