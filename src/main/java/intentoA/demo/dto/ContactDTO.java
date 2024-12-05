package intentoA.demo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ContactDTO {

    @NotNull(message = "The idContact can not be null")
    private Integer idContact;

    @NotBlank(message = "The name can not be null")
    @Size(max = 30, message = "The name  must be at most 25 characters.")
    @Size(max = 25, message = "The name of the contact must be at most 25 characters.")
    private String name;

    @NotNull(message = "The noAccount can not be null")
    @Min(value = 0, message = "The field noAccount must be a positive number.")
    @Max(value = 999999999, message = "The field noAccount cannot be greater than 999999999.")
    private long noAccount;

    @NotNull(message = "The idAccount can not be null")
    private Integer idAccount;

    public Integer getIdContact() {
        return idContact;
    }

    public void setIdContact(Integer idContact) {
        this.idContact = idContact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNoAccount() {
        return noAccount;
    }

    public void setNoAccount(long noAccount) {
        this.noAccount = noAccount;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }
}
