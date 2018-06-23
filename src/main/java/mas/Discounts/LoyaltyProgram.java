package mas.Discounts;


import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Darek on 2018-06-23.
 */
@Entity
public class LoyaltyProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private BigDecimal discount;
    private int minimumVisits = 5;

    public LoyaltyProgram(){}

    public LoyaltyProgram(String name, BigDecimal discount) {
        this.name = name;
        this.discount = discount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public int getMinimumVisits() {
        return minimumVisits;
    }

    public void setMinimumVisits(int minimumVisits) {
        this.minimumVisits = minimumVisits;
    }
}
