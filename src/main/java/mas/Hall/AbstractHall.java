package mas.Hall;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Darek on 2018-06-20.
 */

@MappedSuperclass
public abstract class AbstractHall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long number;
    private BigDecimal surface;
    private int numberOfSeats;
    @Enumerated(EnumType.STRING)
    private Floor floor;
    private BigDecimal screenSurface;

    public AbstractHall(){}

    public AbstractHall(BigDecimal surface, int numberOfSeats, Floor floor, BigDecimal screenSurface) {
        this.surface = surface;
        this.numberOfSeats = numberOfSeats;
        this.floor = floor;
        this.screenSurface = screenSurface;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public BigDecimal getSurface() {
        return surface;
    }

    public void setSurface(BigDecimal surface) {
        this.surface = surface;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public BigDecimal getScreenSurface() {
        return screenSurface;
    }

    public void setScreenSurface(BigDecimal screenSurface) {
        this.screenSurface = screenSurface;
    }
}
