package mas.Reservation;

import mas.Person.Client;
import mas.Promotion.Promotion;
import mas.Seance.Seance;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

/**
 * Created by Darek on 2018-06-21.
 */
public class ReservationForm {

    private Seance seance;
    private Client client;
    private Promotion promotion;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime reservationDate;
    public boolean isPaid;

    public ReservationForm(){}

    public ReservationForm(Seance seance, Client client, Promotion promotion, LocalDateTime reservationDate, boolean isPaid) {
        this.seance = seance;
        this.client = client;
        this.promotion = promotion;
        this.reservationDate = reservationDate;
        this.isPaid = isPaid;
    }

    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
