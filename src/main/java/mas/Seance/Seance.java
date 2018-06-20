package mas.Seance;

import mas.Film.Film;
import mas.Hall.Hall;
import mas.Reservation.Reservation;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Darek on 2018-06-20.
 */
@Entity
public class Seance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private LocalDate endDate;
    private int amountOfVisitors;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="hallId")
    private Hall hall;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="filmId")
    private Film film;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="reservationId")
    private Reservation reservation;


    public Seance(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.amountOfVisitors = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getAmountOfVisitors() {
        return amountOfVisitors;
    }

    public void setAmountOfVisitors(int amountOfVisitors) {
        this.amountOfVisitors = amountOfVisitors;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
