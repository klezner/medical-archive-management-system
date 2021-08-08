package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
public class CreateHospitalizationRequest {

    @NotNull(message = "Date can't be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate hospitalizationDateFrom;
    @NotNull(message = "Date can't be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate hospitalizationDateTo;
}
