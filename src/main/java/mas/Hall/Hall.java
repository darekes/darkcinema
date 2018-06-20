package mas.Hall;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by Darek on 2018-06-20.
 */

@Entity
public class Hall extends AbstractHall{

    public Hall() {
    }

    public Hall(BigDecimal surface, int numberOfSeats, Floor floor, BigDecimal screenSurface) {
        super(surface, numberOfSeats, floor, screenSurface);
    }
}
