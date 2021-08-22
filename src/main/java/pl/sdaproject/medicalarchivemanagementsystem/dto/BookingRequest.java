package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
public class BookingRequest {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private Long folderId;
    @NotNull
    private Long staffId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate bookingDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDate;
}