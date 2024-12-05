package intentoA.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class RechargeDTO {


    @NotNull(message = "The idRecharge can not be null")
    private Integer idRecharge;

    @NotNull(message = "The amount can not be null")
    @Schema(description = "Floating amount that must be greater than or equal to 0 and less than 1,000,000.", example = "500.25")
    @NotNull(message = "The amount cannot be null.")
    @Max(value = 1000000, message = "The amount must not be greater than 1,000,000.")
    private float amount;

    @Schema(description = "Long integer that must be positive.", example = "123456789")
    @NotNull(message = "The number cannot be null.")
    private long number;


    @NotNull(message = "The idAccount can not be null" )
    private Integer idAccount;

    @NotNull(message = "The idCompany can not be null" )
    private Integer idCompany;

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

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }
}
