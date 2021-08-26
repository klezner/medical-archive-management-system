package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Builder
public class FolderRequest {
    @NotNull
    private Integer year;
    @NotNull
    @Min(1)
    private Integer ledgerId;
    @NotNull
    @Min(1)
    private Integer numberOfFolders;
    @NotBlank
    private String typeLabel;
    @NotBlank
    private String statusLabel;
    @NotNull
    private Long archiveCategoryId;
    @NotNull
    private Long locationId;
    //    @NotNull
    //    private Long hospitalizationId;
    @NotNull(message = "Date can't be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate hospitalizationDateFrom;
    @NotNull(message = "Date can't be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate hospitalizationDateTo;
    @NotNull
    private Long wardId;
    @NotNull
    private Long patientId;
}
