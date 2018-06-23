package mas.Discounts;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Darek on 2018-06-23.
 */
public interface LoyaltyProgramRepository extends CrudRepository<LoyaltyProgram, Long>{
    List<LoyaltyProgram> findAll();
}
