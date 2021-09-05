package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
public class FolderWithPatientAndHospitalizationDatesRequest {

    @NotNull
    private Long patientId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate hospitalizationDateFrom;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate hospitalizationDateTo;
}
