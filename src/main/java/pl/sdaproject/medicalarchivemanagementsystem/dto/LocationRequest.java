package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
public class LocationRequest {
    @NotBlank
    private Integer roomNumber;
    @NotBlank
    private Integer floor;
}
