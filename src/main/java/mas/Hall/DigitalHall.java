package mas.Hall;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Darek on 2018-06-20.
 */

@Entity
public class DigitalHall extends AbstractHall {

    private Boolean is3DAvailable;
    @ElementCollection
    private List<Resolution> availableResolutions;

    public DigitalHall() {
        super();
    }

    public DigitalHall(BigDecimal surface, int numberOfSeats, Floor floor, BigDecimal screenSurface, Boolean is3DAvailable, List<Resolution> availableResolutions) {
        super(surface, numberOfSeats, floor, screenSurface);
        this.is3DAvailable = is3DAvailable;
        this.availableResolutions = availableResolutions;
    }

    public Boolean getIs3DAvailable() {
        return is3DAvailable;
    }

    public void setIs3DAvailable(Boolean is3DAvailable) {
        this.is3DAvailable = is3DAvailable;
    }

    public List<Resolution> getAvailableResolutions() {
        return availableResolutions;
    }

    public void setAvailableResolutions(List<Resolution> availableResolutions) {
        this.availableResolutions = availableResolutions;
    }
}
