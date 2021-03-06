package pl.sdaproject.medicalarchivemanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hospitalization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate hospitalizationFrom;
    private LocalDate hospitalizationTo;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Ward ward;
    @OneToMany(mappedBy = "hospitalization")
    private Set<Folder> folders;
}
