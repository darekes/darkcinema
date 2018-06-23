package mas.Person;

import javax.persistence.Entity;
import java.time.LocalDate;

/**
 * Created by Darek on 2018-06-20.
 */

@Entity
public class Client extends Person{

    private String emailAddress;
    private int numberOfVisits;

    public Client(){
        super();
        this.numberOfVisits = 0;
    }

    public Client(String firstName, String lastName, LocalDate birthDate, String emailAddress) {
        super(firstName, lastName, birthDate);
        this.emailAddress = emailAddress;
        this.numberOfVisits = 0;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getNumberOfVisits() {
        return numberOfVisits;
    }

    public void setNumberOfVisits(int numberOfVisits) {
        this.numberOfVisits = numberOfVisits;
    }

}
