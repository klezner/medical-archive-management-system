package pl.sdaproject.medicalarchivemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sdaproject.medicalarchivemanagementsystem.model.Folder;
import pl.sdaproject.medicalarchivemanagementsystem.model.Staff;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingResponse {

    private Integer year;
    private Integer ledgerId;
    private String folderStatus;
    private String staffName;
    private String staffSurname;
    private LocalDate bookingDate;
    private LocalDate returnDate;
}
