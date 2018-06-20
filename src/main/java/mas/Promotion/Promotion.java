package mas.Promotion;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Darek on 2018-06-20.
 */

@Entity
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private LocalDate endDate;
    private String name;
    private Boolean isActive;
    private String regulations;
    private BigDecimal discount;

    public Promotion(LocalDate startDate, LocalDate endDate, String name, Boolean isActive, String regulations, BigDecimal discount) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
        this.isActive = isActive;
        this.regulations = regulations;
        this.discount = discount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getNazwa() {
        return name;
    }

    public void setNazwa(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getRegulations() {
        return regulations;
    }

    public void setRegulations(String regulations) {
        this.regulations = regulations;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}