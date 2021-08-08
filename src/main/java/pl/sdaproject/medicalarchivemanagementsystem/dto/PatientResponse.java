package pl.sdaproject.medicalarchivemanagementsystem.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PatientResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String pesel;
}
