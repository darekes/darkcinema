package mas.Hall;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Darek on 2018-06-20.
 */
@Entity
public class TraditionalHall extends AbstractHall {

    private String projectorBrand;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private LocalDate projectorExpiryDate;

    public TraditionalHall() {
        super();
    }

    public TraditionalHall(BigDecimal surface, int numberOfSeats, Floor floor, BigDecimal screenSurface, String projectorBrand, LocalDate projectorExpiryDate) {
        super(surface, numberOfSeats, floor, screenSurface);
        this.projectorBrand = projectorBrand;
        this.projectorExpiryDate = projectorExpiryDate;
    }
}
