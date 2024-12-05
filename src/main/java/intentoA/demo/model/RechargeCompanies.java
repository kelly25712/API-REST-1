package intentoA.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class RechargeCompanies {
    @Id
    @NotNull(message = "The concept can not be null" )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCompany")
    @JsonProperty("idCompany")
    private Integer idCompany;


    @NotBlank(message = "The name can not be null" )
    @Size(max = 20, message = "The name of the contact must be at most 30 characters.")
    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RechargeCompanies(Integer idCompany, String name) {
        this.idCompany = idCompany;
        this.name = name;
    }

    public RechargeCompanies() {
    }

    @Override
    public String toString() {
        return "rechargeCompanies{" + "idCompanie=" + idCompany + ", name=" + name + '}';
    }

}