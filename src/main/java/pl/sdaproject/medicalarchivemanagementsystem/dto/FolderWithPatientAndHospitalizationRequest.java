package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class FolderWithPatientAndHospitalizationRequest {
    @NotNull
    private Long patientId;
    @NotNull
    private Long hospitalizationId;
}
