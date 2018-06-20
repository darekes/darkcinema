package mas.Person;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Darek on 2018-06-20.
 */
public interface FilmDirectorRepository extends CrudRepository<FilmDirector, Long> {
    List<FilmDirector> findByCountry(String country);
}
