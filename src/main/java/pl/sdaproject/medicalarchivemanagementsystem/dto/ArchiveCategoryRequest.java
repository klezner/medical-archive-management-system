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

    private Long id;
    @NotBlank(message = "Category name can't be null")
    @Pattern(regexp = "[A-Z]+")
    private String categoryName;
    @NotNull(message = "Storage years can't be null")
    @Min(1)
    private Integer storageYears;
}
