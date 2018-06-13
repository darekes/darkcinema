package mas.Reservation;

import mas.Clients.Client;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Created by Darek on 2018-06-13.
 */
@Entity
public class Reservation {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate reservationDate;
    private Boolean isPaid;
    private Seance seanceId;
    private Promotion promotionId;
    private Client clietID;

    public Reservation(LocalDate reservationDate, Boolean isPaid, Seance seanceId, Promotion promotionId, Client clietID) {
        this.reservationDate = reservationDate;
        this.isPaid = isPaid;
        this.seanceId = seanceId;
        this.promotionId = promotionId;
        this.clietID = clietID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public Seance getSeanceId() {
        return seanceId;
    }

    public void setSeanceId(Seance seanceId) {
        this.seanceId = seanceId;
    }

    public Promotion getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Promotion promotionId) {
        this.promotionId = promotionId;
    }

    public Client getClietID() {
        return clietID;
    }

    public void setClietID(Client clietID) {
        this.clietID = clietID;
    }
}
