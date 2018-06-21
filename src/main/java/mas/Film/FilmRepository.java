package mas.Film;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Darek on 2018-06-21.
 */
public interface FilmRepository extends CrudRepository<Film, Long> {
    List<Film> findByTitle(String title);
}
