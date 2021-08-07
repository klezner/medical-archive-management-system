package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Builder
public class AddressRequest {

    @NotNull
    private String street;
    @NotNull
    private String number;
    @NotNull
    private String city;
    @NotNull
    @Length(min = 6, max = 6, message = "Wrong zipCode length")
    @Pattern(regexp = "[0-9]{2}-[0-9]{3}", message = "wrong zipCode format")
    private String zipCode;
}
