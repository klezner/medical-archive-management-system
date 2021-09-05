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

    private Long id;
    @NotBlank(message = "Name can't be null")
    private String name;
    @NotBlank(message = "Surname can't be null")
    private String surname;
    @NotNull(message = "Role can't be null")
    private Role role;
    @NotNull(message = "Ward can't be null")
    private Long wardId;
}
