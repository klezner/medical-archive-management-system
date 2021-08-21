package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
}
