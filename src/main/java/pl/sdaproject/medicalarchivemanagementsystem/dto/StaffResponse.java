package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Builder;
import lombok.Getter;

/**
 * @author MKgn
 */
@Getter
@Builder
public class StaffResponse {

    private Long id;
    private String name;
    private String surname;
    private String role;
    private String wardAbbreviation;
}
