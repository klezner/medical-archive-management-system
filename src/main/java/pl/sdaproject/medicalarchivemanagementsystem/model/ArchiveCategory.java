package pl.sdaproject.medicalarchivemanagementsystem.model;

import lombok.*;

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
@Setter
public class ArchiveCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Category name can't be null")
    @Pattern(regexp = "[A-Z]+")
    private String categoryName;
    @NotNull(message = "Storage years can't be null")
    @Min(1)
    private Integer storageYears;
    @OneToMany(mappedBy = "archiveCategory")
    private Set<Folder> folders;
}
