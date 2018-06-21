package mas.Seance;

import mas.Person.Client;
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
    SeanceRepository seanceRepository;

    public List<Seance> getAllSeances(){
        List<Seance> list = new ArrayList<>();
        Iterable<Seance> iterable = seanceRepository.findAll();
        iterable.forEach(list::add);
        return list;
    }

    public void incrementAmountOfVisitors(Seance seance){
        seance.setAmountOfVisitors(seance.getAmountOfVisitors() + 1);
        if(hasFreeSpaces(seance)){
            seance.setHasFreeSpaces(true);
        } else {
            seance.setHasFreeSpaces(false);
        }
        seanceRepository.save(seance);
    }

    public boolean hasFreeSpaces(Seance seance){
        return seance.getHall().getNumberOfSeats() > seance.getAmountOfVisitors();
    }

    public Seance getSeanceById(Long id){
        List<Seance> list = new ArrayList<>();
        Iterable<Seance> iterable = seanceRepository.findAll();
        iterable.forEach(list::add);
        for(Seance seance : list){
            if(seance.getId().equals(id)){
                return seance;
            }
        }
        return null;
    }
}
