package intentoA.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

//import javax.persistence.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "account")
public class Account {

    @Id

    @NotNull(message = "The field idAccount cannot be null.")

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAccount")
    @JsonProperty("idAccount")
    @JsonManagedReference
    private Integer idAccount;

    @NotNull(message = "The accountNumber can not be null")
    @Min(value = 0, message = "The field accountNumber must be a positive number and have at least 16 digits.")
    @Digits(integer = 16, fraction = 0, message = "The field accountNumber must have exactly 16 digits.")
    @Column(name = "accountNumber")
    @JsonProperty("accountNumber")
    private Long accountNumber;


    @NotNull(message = "The balance can not be null" )
    @DecimalMin(value = "0.0", inclusive = true, message = "The field balance must be a non-negative number.")
    @Column(name = "balance")
    @JsonProperty("balance")
    private Double balance;

    @NotNull(message = "The field idUser cannot be null.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser")
    @JsonProperty("idUser")
    @JsonBackReference
    private User idUser;

    @NotNull(message = "The field pointBBVA' cannot be null.")
    @Min(value = 0, message = "The field pointBBVA must be a non-negative integer.")
    @Max(value = 999999, message = "The field pointBBVA cannot be greater than 999999.")
    @Column(name = "pointBBVA")
    @JsonProperty("pointBBVA")
    public Integer pointBBVA;

    @NotNull(message = "The field keyAccount cannot be null.")
    @Min(value = 0, message = "The field keyAccount must be a non-negative integer.")
    @Max(value = 9999, message = "The field keyAccount cannot be greater than 9999.")
    @Column(name = "keyAccount")
    @JsonProperty("keyAccount")
    private Integer keyAccount;

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Integer getId() {
        return idAccount;
    }

    public void setId(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getpointBBVA() {
        return pointBBVA;
    }

    public void setpointBBVA(Integer pointBBVA) {
        this.pointBBVA = pointBBVA;
    }

    public Integer getKeyAccount() {
        return keyAccount;
    }

    public void setKeyAccount(Integer keyAccount) {
        this.keyAccount = keyAccount;
    }

}
