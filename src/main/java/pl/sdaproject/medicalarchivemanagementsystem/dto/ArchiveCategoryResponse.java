package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ArchiveCategoryResponse {
    private Long id;
    private String archiveCategory;
    private Integer storagePeriodYears;
}