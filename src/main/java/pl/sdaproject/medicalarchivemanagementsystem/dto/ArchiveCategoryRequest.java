package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Builder
public class ArchiveCategoryRequest {

    @NotBlank
    @Pattern(regexp = "[A-Z]+")
    private String categoryName;
    @NotNull
    @Min(1)
    private Integer storagePeriodYears;
}
