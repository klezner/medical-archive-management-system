package pl.sdaproject.medicalarchivemanagementsystem.exception;

import lombok.Builder;
import lombok.Getter;

/**
 * @author MKgn
 */
@Getter
@Builder
public class HospitalizationExceptionResponse {
    private Integer httpStatusCode;
    private String message;
}
