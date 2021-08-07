package pl.sdaproject.medicalarchivemanagementsystem.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ArchiveCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Length(min = 1)
    private String archiveCategory;
    @NotBlank
    @Length(min = 1)
    private Integer storagePeriodYears;
}