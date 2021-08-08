package pl.sdaproject.medicalarchivemanagementsystem.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

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
    @Pattern(regexp = "[A-Z]+")
    private String categoryName;
    @NotBlank
    @Min(1)
    @Pattern(regexp = "[0-9]+")
    private Integer storagePeriodYears;
}
