package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Builder
public class LocationRequest {

    private Long id;
    @NotBlank(message = "Room number can't be null")
    @Pattern(regexp = "[0-9]{1,3}")
    private String roomNumber;
    @NotNull(message = "Floor can't be null")
    private Integer floor;
}
