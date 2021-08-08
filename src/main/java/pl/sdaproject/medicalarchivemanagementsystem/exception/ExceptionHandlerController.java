package pl.sdaproject.medicalarchivemanagementsystem.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerController {

    @ExceptionHandler(HospitalizationDateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleHospitalizationDateException(HospitalizationDateException e) {
        {
            log.warn(e.getMessage());
        }
    }
}
