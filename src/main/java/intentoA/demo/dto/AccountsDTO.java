package intentoA.demo.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AccountsDTO {

    private Integer idAccount;


    @NotNull(message = "The accountNumber can not be null")
    @Min(value = 0, message = "The field accountNumber must be a positive number and have at least 16 digits.")
    @Digits(integer = 16, fraction = 0, message = "The field accountNumber must have exactly 16 digits.")
        private long accountNumber;

        @NotNull(message = "The balance can not be null" )
        @DecimalMin(value = "0.0", inclusive = true, message = "The field balance must be a non-negative number.")
    private double balance;

    @NotNull(message = "The field idUser cannot be null.")
    private Integer idUser;


    @NotNull(message = "The field pointBBVA' cannot be null.")
    @Min(value = 0, message = "The field pointBBVA must be a non-negative integer.")
    @Max(value = 999999, message = "The field pointBBVA cannot be greater than 999999.")
    private Integer pointBBVA;

  
    @NotNull(message = "The field keyAccount cannot be null.")
    @Min(value = 0, message = "The field keyAccount must be a non-negative integer.")
    @Max(value = 9999, message = "The field keyAccount cannot be greater than 9999.")
    private Integer keyAccount;


    @NotNull(message = "The field idUser cannot be null.")
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
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

    // Corregido: el nombre del getter es ahora "getPointBBVA"
    public Integer getPointBBVA() {
        return pointBBVA;
    }

    public void setPointBBVA(Integer pointBBVA) {
        this.pointBBVA = pointBBVA;
    }

    public Integer getKeyAccount() {
        return keyAccount;
    }

    public void setKeyAccount(Integer keyAccount) {
        this.keyAccount = keyAccount;
    }

}
