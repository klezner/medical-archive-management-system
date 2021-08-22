package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Builder
public class AddressRequest {

    private Long id;
    @NotBlank(message = "Street can't be null")
    private String street;
    @NotBlank(message = "Number can't be null")
    private String number;
    @NotBlank(message = "City can't be null")
    private String city;
    @NotBlank(message = "Zip code cen't be null")
    @Length(min = 6, max = 6, message = "Wrong zipCode length")
    @Pattern(regexp = "[0-9]{2}-[0-9]{3}", message = "wrong zipCode format")
    private String zipCode;
}
