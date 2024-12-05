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

public class CVVcode {
    
    @Id
    @NotNull(message = "The idCvv can not be null" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCvv;


    @NotBlank(message = "The time can not be null" )
    @Size(min=1, max =30, message="The time must be at most 30 characters")
    @Column(name="time")
    @JsonProperty("time")
    private  String time;

    @NotBlank(message = "The code can not be null" )
    @Size(min=1, max =3, message="The code CVV must be at most 3 characters")
    @Column(name="code")
    @JsonProperty("code")
    private String code;
    

    public Integer getIdCvv() {
        return idCvv;
    }

    public void setIdCvv(Integer idCvv) {
        this.idCvv = idCvv;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    
}


