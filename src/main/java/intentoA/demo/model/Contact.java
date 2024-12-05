package intentoA.demo.model;

import org.hibernate.validator.constraints.Range;

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
import jakarta.validation.constraints.Size;

@Entity
public class Contact {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "The idContact can not be null" )
    @Column(name="idContact")
    @JsonProperty("idContact")
    private Integer idContact;


    @NotBlank(message = "The name can not be null" )
    @Size(max = 30, message = "The name  must be at most 25 characters.")
    @Column(name="name")
    @JsonProperty("name")
    private String name;
    

    @NotNull(message = "The noAccount can not be null" )
    @Min(value = 0, message = "The field noAccount must be a positive number.")
    @Max(value = 999999999, message = "The field noAccount cannot be greater than 999999999.")
    @Column(name="noAccount")
    @JsonProperty("noAccount")
    private long noAccount;

   

    @NotNull(message = "The idAccount can not be null" )
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

    public Integer getIdContact() {
        return idContact;
    }

    @Override
    public String toString() {
        return "Contact{" + "idContact=" + idContact + ", name=" + name + ", noAccount=" + noAccount + '}';
    }

    public Contact() {
    }

    public Contact(Integer idContact, String name, long noAccount) {
        this.idContact = idContact;
        this.name = name;
        this.noAccount = noAccount;
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
    
}
