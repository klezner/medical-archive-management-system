package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class FolderWithArchiveCategoryRequest {

    @NotNull
    private Long archiveCategoryId;
}
