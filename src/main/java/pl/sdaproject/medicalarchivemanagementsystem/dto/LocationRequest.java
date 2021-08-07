package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
public class LocationRequest {
    @NotBlank
    @Length(min = 1)
    private Integer roomNumber;
    @NotBlank
    @Length(min = 1)
    private Integer floor;
}