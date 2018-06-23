package mas.Seance;

import mas.Film.Film;
import mas.Hall.Hall;
import mas.Reservation.Reservation;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Darek on 2018-06-20.
 */
@Entity
public class Seance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private LocalDateTime startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private LocalDateTime endDate;
    private int amountOfVisitors;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="hallId")
    private Hall hall;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="filmId")
    private Film film;
    private boolean hasFreeSpaces;

    public Seance(){
        this.amountOfVisitors = 0;
        this.hasFreeSpaces = true;
    }

    public Seance(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.amountOfVisitors = 0;
        this.hasFreeSpaces = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
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

    public boolean getHasFreeSpaces() {
        return hasFreeSpaces;
    }

    public void setHasFreeSpaces(boolean hasFreeSpaces) {
        this.hasFreeSpaces = hasFreeSpaces;
    }
}
