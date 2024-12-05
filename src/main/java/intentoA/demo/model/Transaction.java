package intentoA.demo.model;

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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Transaction {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @NotNull(message = "The idTransaction can not be null" )
    @Column(name = "idTransaction")
    @JsonProperty("idTransaction")
    private Integer idTransaction;


    @NotBlank(message = "The dateOfBirth can not be null" )
    @Column(name = "type")
    @JsonProperty("type")
    private char type;


    @NotBlank(message = "The date can not be null" )
    @Size(max = 25, message = "The date of must be at most 25 characters.")
    @Column(name = "date")
    @JsonProperty("date")
    private String date;
    
    
    @NotBlank(message = "The TIME can not be null" )
    @Size(max = 12, message = "The time of must be at most 25 characters.")
    @Column(name = "time")
    @JsonProperty("time")
    private String time;

    @NotNull(message = "The dateOfBirth can not be null" )
    @Min(value = 0, message = "The amount must be at least 0.")
    @Max(value = 1000, message = "The amount must be at most 1000.")
    @Column(name = "amount")
    @JsonProperty("amount")
    private double amount;

    @NotBlank(message = "The concept can not be null" )
    @Size( max = 50, message = "The concept must be at most 50 characters")
    @Column(name = "concept")
    @JsonProperty("concept")
    private String concept;


    @Min(value = 0, message = "The field destinationAccount must be a positive number.")
    @Max(value = 999999999, message = "The field destinationAccount cannot be greater than 999999999.")
    @Column(name = "destinationAccount")
    @JsonProperty("destinationAccount")
    private long destinationAccount;


    @Min(value = 0, message = "The field sourceAccount must be a positive number.")
    @Max(value = 999999999, message = "The field sourceAccount cannot be greater than 999999999.")
    @Column(name = "sourceAccount")
    @JsonProperty("sourceAccount")
    private long sourceAccount;

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

    @Override
    public String toString() {
        return "Transaction{" + "idTransaction=" + idTransaction + ", type=" + type + ", date=" + date + ", time="
                + time + ", amount=" + amount + ", concept=" + concept + ", destinationAccount=" + destinationAccount
                + ", SourceAccount=" + sourceAccount + '}';
    }

    public Transaction() {
    }

    public Transaction(Integer idTransaction, char type, String date, String time, double amount, String concept,
            long destinationAccount, long sourceAccount) {
        this.idTransaction = idTransaction;
        this.type = type;
        this.date = date;
        this.time = time;
        this.amount = amount;
        this.concept = concept;
        this.destinationAccount = destinationAccount;
        this.sourceAccount = sourceAccount;
    }

    public Integer getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Integer idTransaction) {
        this.idTransaction = idTransaction;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public String getdate() {
        return date;
    }

    public void setdate(String date) {
        this.date = date;
    }

    public String gettime() {
        return time;
    }

    public void settime(String time) {
        this.time = time;
    }

    public double getamount() {
        return amount;
    }

    public void setamount(double amount) {
        this.amount = amount;
    }

    public String getconcept() {
        return concept;
    }

    public void setconcept(String concept) {
        this.concept = concept;
    }

    public long getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(long destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public long getsourceAccount() {
        return sourceAccount;
    }

    public void setsourceAccount(long sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

}
