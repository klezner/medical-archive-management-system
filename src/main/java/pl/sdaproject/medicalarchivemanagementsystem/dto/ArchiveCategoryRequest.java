package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Builder
public class ArchiveCategoryRequest {
    @NotBlank
    @Pattern(regexp = "[A-Z]+")
    private String categoryName;
    @NotBlank
    @Min(1)
    @Pattern(regexp = "[0-9]+")
    private Integer storagePeriodYears;
}
