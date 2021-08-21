package pl.sdaproject.medicalarchivemanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hospitalization {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDate hospitalizationFrom;
    private LocalDate hospitalizationTo;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Ward ward;
}
