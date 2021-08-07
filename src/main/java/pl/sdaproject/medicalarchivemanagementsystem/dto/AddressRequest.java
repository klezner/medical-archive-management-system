package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Builder
public class AddressRequest {

    @NotBlank
    private String street;
    @NotBlank
    private String number;
    @NotBlank
    private String city;
    @NotBlank
    @Length(min = 6, max = 6, message = "Wrong zipCode length")
    @Pattern(regexp = "[0-9]{2}-[0-9]{3}", message = "wrong zipCode format")
    private String zipCode;
}
