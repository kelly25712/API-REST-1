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
import jakarta.validation.constraints.Size;


@Entity
public class Sections {
    @Id
    
	@GeneratedValue(strategy = GenerationType.IDENTITY)

    @NotNull(message = "The idSections can not be null")
    @Column(name = "idSections")
    @JsonProperty("idSections")
    private Integer idSections;
    
    

    @NotBlank(message = "The name can not be null" )
    @Size(max = 15, message = "The name of the contact must be at most 30 characters.")
    @Column(name="name")
    @JsonProperty("name")
    private String name;
    
    @NotNull(message = "The amount cannot be null.")
    @Min(value = 0, message = "The amount must be at least 0.")
    @Max(value = 1000000, message = "The amount must be at most 1,000,000.")   
    @Column(name = "amount")
    @JsonProperty("amount")
    private Double amount;

    

    @NotNull(message = "The idAccount can not be null")
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


    public Sections() {
    }
    public Sections(Integer idSections, String name, double amount) {
        this.idSections = idSections;
        this.name = name;
        this.amount = amount;
    }

    public Integer getIdSections() {
        return idSections;
    }

    public void setIdSections(Integer idSections) {
        this.idSections = idSections;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ola{" + "idSections=" + idSections + ", name=" + name + ", amount=" + amount + '}';
    }
}
