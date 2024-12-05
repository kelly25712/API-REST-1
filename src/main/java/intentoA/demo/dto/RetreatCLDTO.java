package intentoA.demo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RetreatCLDTO {

    @NotNull(message = "The idRetreactCL can not be null")
    private Integer idRetreatCL;

    @NotBlank(message = "The date can not be null")
    @Size(max = 25, message = "The name of the contact must be at most 25 characters.")
    private String date;

   
    @NotNull(message = "The amount can not be null")
    @Min(value = 0, message = "The amount must be at least 0.")
    @Max(value = 1000, message = "The amount must be at most 1000.")
    private float amount;


    @NotBlank(message = "The time can not be null" )
    @Size(max = 25, message = "The name of the contact must be at most 25 characters.")
    private String time;


    @NotNull(message = "The idAccount can not be null")
    private Integer idAccount;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }
}
