package intentoA.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Recharge {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "The idRecharge can not be null")
    @Column(name = "idRecharge")
    @JsonProperty("idRecharge")
    private Integer idRecharge;

    @NotNull(message = "The amount can not be null")
    @Schema(description = "Floating amount that must be greater than or equal to 0 and less than 1,000,000.", example = "500.25")
    @NotNull(message = "The amount cannot be null.")
    @Max(value = 1000000, message = "The amount must not be greater than 1,000,000.")
    @Column(name = "amount")
    @JsonProperty("amount")
    private float amount;


    @NotNull(message = "The concept can not be null" )
    @Schema(description = "Long integer that must be positive.", example = "123456789")
    @NotNull(message = "The number cannot be null.")
    @Column(name = "number")
    @JsonProperty("number")
    private long number;


    @NotNull(message = "The idAccount can not be null" )
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAccount")
    @JsonProperty("idAccount")
    @JsonBackReference
    private Account idAccount;


    @NotNull(message = "The idCompany can not be null" )
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCompany", referencedColumnName = "idCompany")
    @JsonProperty("idCompany")
    private RechargeCompanies idCompany;

    public RechargeCompanies getRechargeCompanies() {
        return idCompany;
    }

    public void setRechargeCompany(RechargeCompanies idCompany) {
        this.idCompany = idCompany;
    }

    public Account getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Account idAccount) {
        this.idAccount = idAccount;
    }

    public Recharge() {
    }

    public Recharge(Integer idRecharge, float amount, long number) {
        this.idRecharge = idRecharge;
        this.amount = amount;
        this.number = number;
    }

    public Integer getIdRecharge() {
        return idRecharge;
    }

    public void setIdRecharge(Integer idRecharge) {
        this.idRecharge = idRecharge;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ola{" + "idRecharge=" + idRecharge + " amount=" + amount + ", number=" + number + '}';
    }
}
