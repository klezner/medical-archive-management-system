package pl.sdaproject.medicalarchivemanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NotNull
    private Integer year;
    @NotNull
    @Min(1)
    private Integer ledgerId;
    @NotNull
    @Min(1)
    private Integer numberOfFolders;
    @NotNull
    @Enumerated(EnumType.STRING)
    private FolderType type;
    @NotNull
    @Enumerated(EnumType.STRING)
    private FolderStatus status;
    @ManyToOne
    @JoinColumn(nullable = false)
    private ArchiveCategory archiveCategory;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Location location;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Hospitalization hospitalization;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Patient patient;
}
