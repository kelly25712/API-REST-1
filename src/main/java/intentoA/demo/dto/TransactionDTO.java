package intentoA.demo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TransactionDTO {
    @NotNull(message = "The idTransaction can not be null" )
    private Integer idTransaction;

    @NotBlank(message = "The dateOfBirth can not be null" )
    private char type;

    @NotBlank(message = "The date can not be null" )
    @Size(max = 25, message = "The date of must be at most 25 characters.")
    private String date;


    @NotBlank(message = "The TIME can not be null" )
    @Size(max = 12, message = "The time of must be at most 25 characters.")
    private String time;

    @NotNull(message = "The TIME can not be null" )
    @Size(max = 12, message = "The time of must be at most 25 characters.")
    @Min(value = 0, message = "The amount must be at least 0.")
    @Max(value = 1000, message = "The amount must be at most 1000.")
    private double amount;

    @NotBlank(message = "The concept can not be null" )
    @Size(max = 12, message = "The time of must be at most 25 characters.")
    private String concept;


    @NotNull(message = "The destination can not be null" )
    @Size(max = 12, message = "The time of must be at most 25 characters.")
    @Min(value = 0, message = "The field destinationAccount must be a positive number.")
    @Max(value = 999999999, message = "The field destinationAccount cannot be greater than 999999999.")
    private long destinationAccount;


    @NotBlank(message = "The sourceAccount can not be null" )
    @Size(max = 12, message = "The sourceAccount of must be at most 25 characters.")
    @Min(value = 0, message = "The field sourceAccount must be a positive number.")
    @Max(value = 999999999, message = "The field sourceAccount cannot be greater than 999999999.")
    private long sourceAccount;

    @NotNull(message = "The idAccount can not be null" )
    private Integer idAccount;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public long getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(long destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public long getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(long sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }
}
