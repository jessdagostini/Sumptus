package sumptus.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

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
    private Date purchase_date;
    private Date payment_day;
    private Boolean paid;    
    private BigDecimal true_value;
    private Double percentage;   
    private Date true_payday;    

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

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public Date getPayment_day() {
        return payment_day;
    }

    public void setPayment_day(Date payment_day) {
        this.payment_day = payment_day;
    }

    public String getPaid() {
        if(paid == true){
            return "Pago";
        } else {
            return "-";
        }
    }
    
    public Boolean savePaid(){
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }
    
    public BigDecimal getTrue_value() {
        return true_value;
    }

    public void setTrue_value(BigDecimal true_value) {
        this.true_value = true_value;
    }
    
    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }
    
    public Date getTrue_payday() {
        return true_payday;
    }

    public void setTrue_payday(Date true_payday) {
        this.true_payday = true_payday;
    }
}
