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

    @NotBlank (message = "id problem_response")
    private Long id;
    @NotBlank(message = "Ward name can't be null.")
    private String name;
    @NotBlank(message = "Ward abbreviation can't be null.")
    private String abbreviation;
}
