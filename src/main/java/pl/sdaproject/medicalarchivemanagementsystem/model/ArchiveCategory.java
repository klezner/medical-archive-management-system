package pl.sdaproject.medicalarchivemanagementsystem.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

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
    @NotNull
    @Min(1)
    private Integer storagePeriodYears;
    @OneToMany(mappedBy = "archiveCategory")
    private Set<Folder> folder;
}
