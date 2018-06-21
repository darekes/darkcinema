package mas.Seance;

import mas.Reservation.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Darek on 2018-06-21.
 */

@Service
public class SeanceService {


    @Autowired
    SeanceService seanceService;

    public List<Seance> getAllSeances(){
        List<Seance> list = new ArrayList<>();
        Iterable<Seance> iterable = seanceService.getAllSeances();
        iterable.forEach(list::add);
        return list;
    }
}
