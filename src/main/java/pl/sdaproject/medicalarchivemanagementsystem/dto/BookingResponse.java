package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingResponse {

    private Long id;
    private Integer year;
    private Integer ledgerId;
    private String folderStatus;
    private String staffName;
    private String staffSurname;
    private LocalDate bookingDate;
    private LocalDate returnDate;
}
