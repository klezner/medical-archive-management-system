package pl.sdaproject.medicalarchivemanagementsystem.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(nullable = false)
    private Folder folder;
    @OneToOne
    @JoinColumn(nullable = false)
    private Staff staff;
    private LocalDate bookingDate;
    private LocalDate returnDate;
}
