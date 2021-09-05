package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class FolderBorrowedBySelectedStaffIdRequest {

    @NotNull
    private Long staffId;
}
