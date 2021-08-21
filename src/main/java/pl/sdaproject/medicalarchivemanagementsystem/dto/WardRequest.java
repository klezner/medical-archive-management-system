package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

/**
 * WardRequest
 *
 * @author MKgn
 */
@Getter
public class WardRequest {

    @NotBlank(message = "Ward name can't be null.")
    private String name;
    @NotBlank(message = "Ward abbreviation can't be null.")
    private String abbreviation;
}
