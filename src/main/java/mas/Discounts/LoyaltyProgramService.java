package mas.Discounts;

import mas.Person.Client;
import mas.Reservation.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darek on 2018-06-23.
 */
@Service
public class LoyaltyProgramService {

    @Autowired
    LoyaltyProgramRepository loyaltyProgramRepository;

    public List<LoyaltyProgram> getAllLoyaltyPrograms(){
        List<LoyaltyProgram> list = new ArrayList<>();
        Iterable<LoyaltyProgram> iterable = loyaltyProgramRepository.findAll();
        iterable.forEach(list::add);
        return list;
    }
}
