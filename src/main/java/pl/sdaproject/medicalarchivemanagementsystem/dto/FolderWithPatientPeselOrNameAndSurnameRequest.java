package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Getter;

@Getter
public class FolderWithPatientPeselOrNameAndSurnameRequest {

    private String pesel;
    private String name;
    private String surname;
}
