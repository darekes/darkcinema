package mas.Person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Darek on 2018-06-11.
 */
public interface ClientRepository extends CrudRepository<Client, Long>{
    List<Client> findByEmailAddress(String emailAddress);
}
