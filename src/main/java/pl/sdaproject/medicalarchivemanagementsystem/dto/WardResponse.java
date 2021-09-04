package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

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
    private String name;
    private String abbreviation;
}
