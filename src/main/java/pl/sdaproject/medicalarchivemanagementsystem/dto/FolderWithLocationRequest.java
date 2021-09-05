package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class FolderWithLocationRequest {

    @NotNull
    private Long locationId;
}
