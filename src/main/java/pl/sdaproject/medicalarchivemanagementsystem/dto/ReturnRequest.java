package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
public class ReturnRequest {
    @NotNull
    private Long folderId;
    @NotNull
    private Long staffId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDate;
}
