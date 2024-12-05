package intentoA.demo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SectionsDTO {
    

    @NotNull(message = "The idSections can not be null")
    private Integer idSections;


    @NotBlank(message = "The name can not be null" )
    @Size(max = 15, message = "The name of the contact must be at most 30 characters.")
    private String name;


    @NotNull(message = "The amount cannot be null.")
    @Min(value = 0, message = "The amount must be at least 0.")
    @Max(value = 1000000, message = "The amount must be at most 1,000,000.")    
    private Double amount;

    @NotNull(message = "The idAccount can not be null")
    private Integer idAccount;

    // Getter y setter para id
    public Integer getIdSections() {
        return idSections;
    }

    public void setIdSections(Integer idSections) {
        this.idSections = idSections;
    }

    // Getter y setter para name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter y setter para amount
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    // Getter y setter para idAccount
    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }
}
