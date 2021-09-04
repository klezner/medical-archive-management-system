package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class FolderWithArchiveCategoryIdRequest {
    @NotNull
    private Long archiveCategoryId;
}
