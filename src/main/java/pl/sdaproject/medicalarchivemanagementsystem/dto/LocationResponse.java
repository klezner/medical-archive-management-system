package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LocationResponse {
    private Long id;
    private Integer roomNumber;
    private Integer floor;
}
