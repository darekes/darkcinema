package mas.Hall;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by Darek on 2018-06-20.
 */

@Entity
public class HallForDisabled extends AbstractHall {

    private int amountOfToilets;
    private int amountOfWheelchairs;

    public HallForDisabled(){
        super();
    }

    public HallForDisabled(BigDecimal surface, int numberOfSeats, Floor floor, BigDecimal screenSurface, int amountOfToilets, int amountOfWheelchairs) {
        super(surface, numberOfSeats, floor, screenSurface);
        this.amountOfToilets = amountOfToilets;
        this.amountOfWheelchairs = amountOfWheelchairs;
    }

    public int getAmountOfToilets() {
        return amountOfToilets;
    }

    public void setAmountOfToilets(int amountOfToilets) {
        this.amountOfToilets = amountOfToilets;
    }

    public int getAmountOfWheelchairs() {
        return amountOfWheelchairs;
    }

    public void setAmountOfWheelchairs(int amountOfWheelchairs) {
        this.amountOfWheelchairs = amountOfWheelchairs;
    }
}
