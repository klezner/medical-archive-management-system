package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Builder;
import lombok.Getter;
import pl.sdaproject.medicalarchivemanagementsystem.validator.ZipCodeConstraint;

@Getter
@Builder
public class AddressRequest {

    private Long id;
    private String street;
    private String number;
    private String city;
    @ZipCodeConstraint(message = "Incorrect zip code")
    private String zipCode;
}
