package intentoA.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class User {
    @Id
    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUser")
    @JsonProperty("idUser")
    private Integer idUser;

    @NotBlank(message = "The dateOfBirth can not be null" )
    @Size(max=45,message="The name must be at most 45 characters")
    @Column(name="name")
    @JsonProperty("name")
    private String name;

    @NotBlank(message = "The dateOfBirth can not be null" )
    @Size(max=35,message="The date of birth must be at most 35 characters")
    @Column(name="dateOfBirth")
    @JsonProperty("dateOfBirth")
    private String dateOfBirth;

    @NotBlank(message = "The dateOfBirth can not be null" )
    @Column(name="address")
    @Size(max=50,message="The addres must be at most 50 characters")
    @JsonProperty("address")
    private String address;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
