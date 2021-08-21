package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Builder
public class LocationRequest {

    @NotBlank
    @Pattern(regexp = "[0-9]{1,3}")
    private String roomNumber;
    @NotNull
    private Integer floor;
}
