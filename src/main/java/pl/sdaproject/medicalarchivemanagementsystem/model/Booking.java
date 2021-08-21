package pl.sdaproject.medicalarchivemanagementsystem.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDate bookingDate;
    private LocalDate returnDate;
}
