package sumptus.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 *
 * @author Jessica Dagostini
 */
public class Outlay {
    private Integer id;
    private User user;
    private Area area;
    private PayForm pform;
    private String description;
    private BigDecimal cost;
    private Timestamp purchase_date;
    private Timestamp payment_day;
    private Boolean paid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public PayForm getPform() {
        return pform;
    }

    public void setPform(PayForm pform) {
        this.pform = pform;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Timestamp getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Timestamp purchase_date) {
        this.purchase_date = purchase_date;
    }

    public Timestamp getPayment_day() {
        return payment_day;
    }

    public void setPayment_day(Timestamp payment_day) {
        this.payment_day = payment_day;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }
    
}
