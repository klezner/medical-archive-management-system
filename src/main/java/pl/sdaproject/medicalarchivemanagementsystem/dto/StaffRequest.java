package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Builder;
import lombok.Getter;
import pl.sdaproject.medicalarchivemanagementsystem.model.Role;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author MKgn
 */
@Getter
@Builder
public class StaffRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotNull
    private Role role;
}
