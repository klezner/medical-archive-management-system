package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Builder
public class FolderRequest {

    private Long id;
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
    @NotNull
    private Long hospitalizationId;
    @NotNull
    private Long patientId;
}
