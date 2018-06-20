package mas.Person;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.Period;

/**
 * Created by Darek on 2018-06-20.
 */

@Entity
public class Salesman extends Person{

    private Long personalIdNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate employmentDate;
    private int jobSeniority;

    public Salesman(){
        super();
    }

    public Salesman(String firstName, String lastName, LocalDate birthDate, Long personalIdNumber, LocalDate employmentDate) {
        super(firstName, lastName, birthDate);
        this.personalIdNumber = personalIdNumber;
        this.employmentDate = employmentDate;
        setJobSeniority(employmentDate);
    }

    public void setJobSeniority(LocalDate employmentDate){
        jobSeniority = Period.between(employmentDate, LocalDate.now()).getYears();
    }

    public Long getPersonalIdNumber() {
        return personalIdNumber;
    }

    public void setPersonalIdNumber(Long personalIdNumber) {
        this.personalIdNumber = personalIdNumber;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public int getJobSeniority() {
        return jobSeniority;
    }

    public void setJobSeniority(int jobSeniority) {
        this.jobSeniority = jobSeniority;
    }
}
