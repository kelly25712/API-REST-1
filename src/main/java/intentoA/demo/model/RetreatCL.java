package intentoA.demo.model;

//import java.security.Timestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "retreatCL")

public class RetreatCL {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @NotNull(message = "The idRetreactCL can not be null")
    @Column(name = "idRetreatCL")
    @JsonProperty("idRetreatCL")
    private Integer idRetreatCL;

    @NotBlank(message = "The date can not be null")
    @Size(max = 25, message = "The name of the contact must be at most 25 characters.")
    @Column(name = "date")
    @JsonProperty("date")
    private String date;

    @NotNull(message = "The amount can not be null")
    @Min(value = 0, message = "The amount must be at least 0.")
    @Max(value = 1000, message = "The amount must be at most 1000.")
    @Column(name = "amount")
    @JsonProperty("amount")
    private float amount;


    @NotBlank(message = "The time can not be null" )
    @Size(max = 25, message = "The name of the contact must be at most 25 characters.")
    @Column(name = "time")
    @JsonProperty("time")
    private String time;

    @NotNull(message = "The idAccount can not be null")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAccount")
    @JsonProperty("idAccount")
    @JsonBackReference
    private Account idAccount;

    public Account getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Account idAccount) {
        this.idAccount = idAccount;
    }

    public Integer getIdRetreatCL() {
        return idRetreatCL;
    }

    public void setIdRetreatCL(Integer idRetreatCL) {
        this.idRetreatCL = idRetreatCL;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String gettime() {
        return time;
    }

    public void settime(String time) {
        this.time = time;
    }

}
