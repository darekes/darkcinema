package mas.Reservation;

import mas.Discounts.LoyaltyProgram;
import mas.Person.Client;
import mas.Seance.Seance;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
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
    @JoinColumn(name="loyaltyProgramId")
    private LoyaltyProgram loyaltyProgram;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="clientId")
    private Client client;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="seanceId")
    private Seance seance;
    private BigDecimal cost;
    @Enumerated(EnumType.STRING)
    private State state;

    public Reservation(){
        this.cost = BigDecimal.valueOf(30,0);
        state = State.NEW;
    }

    public Reservation(LocalDateTime reservationDate, Boolean isPaid) {
        this.reservationDate = reservationDate;
        this.isPaid = isPaid;
        this.cost = BigDecimal.valueOf(30,0);
        state = State.NEW;
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

    public LoyaltyProgram getLoyaltyProgram() {
        return loyaltyProgram;
    }

    public void setLoyaltyProgram(LoyaltyProgram loyaltyProgram) {
        this.loyaltyProgram = loyaltyProgram;
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

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
