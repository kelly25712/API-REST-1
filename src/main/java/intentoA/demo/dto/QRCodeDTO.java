package intentoA.demo.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class QRCodeDTO {
    private Integer idCode;

    
    @NotNull(message = "The code cannot be null")
    @Min(value = 1, message = "The code must be greater than or equal to 1")
    @Max(value = 1000, message = "The code must be less than or equal to 1000")
    private Integer code;



    @NotNull(message = "The code cannot be null")
     @Min(value = 0, message = "The amount must be at least 0.")
    @Max(value = 1000, message = "The amount must be at most 1000.")
    private float amount;

    @NotNull(message = "The idAccount cannot be null")
    private Integer idAccount;

    public Integer getIdCode() {
        return idCode;
    }

    public void setIdCode(Integer idCode) {
        this.idCode = idCode;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }
}
