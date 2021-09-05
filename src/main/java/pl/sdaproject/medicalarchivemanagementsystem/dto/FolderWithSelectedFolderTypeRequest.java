package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class FolderWithSelectedFolderTypeRequest {

    @NotNull
    private String folderTypeLabel;
}
