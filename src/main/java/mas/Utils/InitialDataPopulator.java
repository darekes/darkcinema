package mas.Utils;

import mas.Discounts.LoyaltyProgram;
import mas.Discounts.LoyaltyProgramRepository;
import mas.Film.Category;
import mas.Film.Film;
import mas.Film.FilmRepository;
import mas.Hall.Floor;
import mas.Hall.Hall;
import mas.Hall.HallRepository;
import mas.Person.*;
import mas.Reservation.Reservation;
import mas.Reservation.ReservationRepository;
import mas.Seance.Seance;
import mas.Seance.SeanceRepository;
import mas.Seance.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

/**
 * Created by Darek on 2018-06-21.
 */
@Service
public class InitialDataPopulator {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    FilmDirectorRepository filmDirectorRepository;

    @Autowired
    HallRepository hallRepository;

    @Autowired
    LoyaltyProgramRepository loyaltyProgramRepository;

    @Autowired
    SeanceRepository seanceRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    SeanceService seanceService;

    private boolean isInitialDataFilled = false;

    public void fillInitialData() {
        if (!isInitialDataFilled) {

            //clients
            Client client1 = new Client();
            client1.setFirstName("Darek");
            client1.setLastName("Samsel");
            client1.setEmailAddress("dsamsel@mail.com");
            client1.setBirthDate(LocalDate.of(1995, Month.APRIL, 22));
            clientRepository.save(client1);

            Client client2 = new Client();
            client2.setFirstName("Jan");
            client2.setLastName("Kowalski");
            client2.setEmailAddress("jkowlaski@mail.com");
            client2.setBirthDate(LocalDate.of(1991, Month.MAY, 10));
            clientRepository.save(client2);

            Client client3 = new Client();
            client3.setFirstName("Piotr");
            client3.setLastName("Nowakowski");
            client3.setEmailAddress("pnowakowski@mail.com");
            client3.setBirthDate(LocalDate.of(1999, Month.JUNE, 05));
            clientRepository.save(client3);

            //directors
            FilmDirector filmDirector1 = new FilmDirector();
            filmDirector1.setFirstName("John");
            filmDirector1.setLastName("Glen");
            filmDirector1.setBirthDate(LocalDate.of(1932, Month.MAY, 15));
            filmDirector1.setAmountOfAwards(1);
            filmDirector1.setAmountOfFilms(2);
            filmDirector1.setHasOscarAward(false);
            filmDirectorRepository.save(filmDirector1);

            FilmDirector filmDirector2 = new FilmDirector();
            filmDirector2.setFirstName("Andrzej");
            filmDirector2.setLastName("Hoffman");
            filmDirector2.setBirthDate(LocalDate.of(1932, Month.MARCH, 15));
            filmDirector2.setAmountOfAwards(5);
            filmDirector2.setAmountOfFilms(4);
            filmDirector2.setHasOscarAward(false);
            filmDirectorRepository.save(filmDirector2);

            FilmDirector filmDirector3 = new FilmDirector();
            filmDirector3.setFirstName("Olaf");
            filmDirector3.setLastName("Lubaszenko");
            filmDirector3.setBirthDate(LocalDate.of(1968, Month.DECEMBER, 6));
            filmDirector3.setAmountOfAwards(7);
            filmDirector3.setAmountOfFilms(3);
            filmDirector3.setHasOscarAward(false);
            filmDirectorRepository.save(filmDirector3);

            //films
            Film film1 = new Film();
            film1.setTitle("James Bond");
            film1.setCategory(Category.ADVENTURE);
            film1.setProductionYear(1990);
            film1.setLength(BigDecimal.valueOf(1,30));
            film1.setFilmDirector(filmDirector1);
            filmRepository.save(film1);

            Film film2 = new Film();
            film2.setTitle("Ogniem i mieczem");
            film2.setCategory(Category.WAR);
            film2.setProductionYear(1980);
            film2.setLength(BigDecimal.valueOf(2,30));
            film2.setFilmDirector(filmDirector2);
            filmRepository.save(film2);

            Film film3 = new Film();
            film3.setTitle("Poranek kojota");
            film3.setCategory(Category.COMEDY);
            film3.setProductionYear(1970);
            film3.setLength(BigDecimal.valueOf(1,45));
            film3.setFilmDirector(filmDirector3);
            filmRepository.save(film3);

            //halls
            Hall hall1 = new Hall();
            hall1.setNumber(1);
            hall1.setFloor(Floor.FIRST_FLOOR);
            hall1.setNumberOfSeats(8);
            hall1.setScreenSurface(BigDecimal.valueOf(260));
            hall1.setSurface(BigDecimal.valueOf(45));
            hallRepository.save(hall1);

            Hall hall2 = new Hall();
            hall2.setNumber(2);
            hall2.setFloor(Floor.GROUND_FLOOR);
            hall2.setNumberOfSeats(2);
            hall2.setScreenSurface(BigDecimal.valueOf(280));
            hall2.setSurface(BigDecimal.valueOf(40));
            hallRepository.save(hall2);

            Hall hall3 = new Hall();
            hall3.setNumber(3);
            hall3.setFloor(Floor.GROUND_FLOOR);
            hall3.setNumberOfSeats(6);
            hall3.setScreenSurface(BigDecimal.valueOf(300));
            hall3.setSurface(BigDecimal.valueOf(50));
            hallRepository.save(hall3);

            Hall hall4 = new Hall();
            hall4.setNumber(4);
            hall4.setFloor(Floor.SECOND_FLOOR);
            hall4.setNumberOfSeats(30);
            hall4.setScreenSurface(BigDecimal.valueOf(240));
            hall4.setSurface(BigDecimal.valueOf(25));
            hallRepository.save(hall4);


            //promotions
            LoyaltyProgram program = new LoyaltyProgram();
            program.setName("GLOBAL DISCOUNT");
            program.setDiscount(BigDecimal.valueOf(10,0));
            program.setMinimumVisits(5);
            loyaltyProgramRepository.save(program);

            //seances
            Seance seance1 = new Seance();
            seance1.setStartDate(LocalDate.of(2018, Month.JUNE, 26).atTime(10, 0));
            seance1.setEndDate(LocalDate.of(2018, Month.JUNE, 26).atTime(12, 30));
            seance1.setFilm(film1);
            seance1.setHall(hall1);
            seanceRepository.save(seance1);

            Seance seance2 = new Seance();
            seance2.setStartDate(LocalDate.of(2018, Month.JUNE, 28).atTime(10, 0));
            seance2.setEndDate(LocalDate.of(2018, Month.JUNE, 28).atTime(12, 30));
            seance2.setFilm(film2);
            seance2.setHall(hall2);
            seanceRepository.save(seance2);

            //reservations
            Reservation reservation1 = new Reservation();
            reservation1.setIsPaid(false);
            reservation1.setReservationDate(LocalDateTime.now());
            reservation1.setLoyaltyProgram(null);
            reservation1.setClient(client1);
            reservation1.setSeance(seance1);
            seanceService.incrementAmountOfVisitors(seance1);
            reservationRepository.save(reservation1);

            isInitialDataFilled = true;
        }
    }
}
