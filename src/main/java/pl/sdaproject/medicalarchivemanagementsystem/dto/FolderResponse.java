package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FolderResponse {

    private Long id;
    private Integer year;
    private Integer ledgerId;
    private Integer numberOfFolders;
    private String typeLabel;
    private String statusLabel;
    private String categoryName;
    private Integer storagePeriodYears;
    private String roomNumber;
    private Integer floor;
}
