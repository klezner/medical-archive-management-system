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

    private Long folderId;
    private Long staffId;
    private LocalDate bookingDate;
    private LocalDate returnDate;
}
