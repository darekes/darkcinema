package mas.Person;

import javax.persistence.Entity;
import java.time.LocalDate;

/**
 * Created by Darek on 2018-06-20.
 */

@Entity
public class FilmDirector extends Person{

    private int amountOfFilms;
    private int amountOfAwards;
    private String country;
    private Boolean hasOscarAward;

    public FilmDirector() {
        super();
    }

    public FilmDirector(String firstName, String lastName, LocalDate birthDate, int amountOfFilms, int amountOfAwards, String country, Boolean hasOscarAward) {
        super(firstName, lastName, birthDate);
        this.amountOfFilms = amountOfFilms;
        this.amountOfAwards = amountOfAwards;
        this.country = country;
        this.hasOscarAward = hasOscarAward;
    }

    public int getAmountOfFilms() {
        return amountOfFilms;
    }

    public void setAmountOfFilms(int amountOfFilms) {
        this.amountOfFilms = amountOfFilms;
    }

    public int getAmountOfAwards() {
        return amountOfAwards;
    }

    public void setAmountOfAwards(int amountOfAwards) {
        this.amountOfAwards = amountOfAwards;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getHasOscarAward() {
        return hasOscarAward;
    }

    public void setHasOscarAward(Boolean hasOscarAward) {
        this.hasOscarAward = hasOscarAward;
    }
}
