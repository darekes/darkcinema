package mas.Reservation;

import mas.Person.Client;
import mas.Promotion.Promotion;
import mas.Seance.Seance;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Darek on 2018-06-13.
 */
@Entity
public class Reservation {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private LocalDateTime reservationDate;
    private boolean isPaid;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="promotionId")
    private Promotion promotion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="clientId")
    private Client client;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="seanceId")
    private Seance seance;

    public Reservation(){}

    public Reservation(LocalDateTime reservationDate, Boolean isPaid) {
        this.reservationDate = reservationDate;
        this.isPaid = isPaid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean paid) {
        isPaid = paid;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }
}
