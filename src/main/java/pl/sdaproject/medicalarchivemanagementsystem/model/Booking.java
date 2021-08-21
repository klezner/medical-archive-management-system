package pl.sdaproject.medicalarchivemanagementsystem.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Booking {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDate bookingDate;
    private LocalDate loanDate;
    private LocalDate returnDate;
}
