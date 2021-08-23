package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.pl.PESEL;
import pl.sdaproject.medicalarchivemanagementsystem.validator.ZipCodeConstraint;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
public class PatientRequest {

    private Long id;
    @NotBlank(message = "First name can't be null")
    private String firstName;
    @NotBlank(message = "Last name can't be null")
    private String lastName;
    @PESEL(message = "Incorrect pesel")
    private String pesel;
    private String street;
    private String number;
    private String city;
    @ZipCodeConstraint(message = "Incorrect zip code")
    private String zipCode;
}
