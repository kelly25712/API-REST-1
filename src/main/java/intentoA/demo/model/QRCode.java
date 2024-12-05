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


@Entity
public class QRCode{
    @Id
   
    @NotNull(message = "The concept can not be null" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCode")
    @JsonProperty("idCode")
    private Integer idCode;


    @NotNull(message = "The code can not be null" )
    @NotNull(message = "The code cannot be null")
    @Min(value = 1, message = "The code must be greater than or equal to 1")
    @Max(value = 1000, message = "The code must be less than or equal to 1000")
    private Integer code;
    
    @NotNull(message = "The amount can not be null" )
     @Min(value = 0, message = "The amount must be at least 0.")
    @Max(value = 1000, message = "The amount must be at most 1000.")
    @Column(name="amount")
    @JsonProperty("amount")
    private float amount;

    @NotNull(message = "The concept can not be null" )
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idAccount")
    @JsonProperty("idAccount")
    @JsonBackReference
    private Account idAccount;

    public Account getIdAccount(){
        return idAccount;
    }

    public void setIdAccount (Account idAccount){
        this.idAccount = idAccount;
    }

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

    @Override
    public String toString() {
        return "QRCode{" + "idCode=" + idCode + ", code=" + code + ", amount=" + amount + '}';
    }
    
    
    
}