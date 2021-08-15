package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * WardResponse
 *
 * @author MKgn
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WardResponse {

    private Long id;
    private String wardName;
}
