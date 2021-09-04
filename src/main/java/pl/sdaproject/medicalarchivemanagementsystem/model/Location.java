package pl.sdaproject.medicalarchivemanagementsystem.model;

import lombok.*;

import javax.persistence.*;
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
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Room number can't be null")
    @Pattern(regexp = "[0-9]{1,3}")
    private String roomNumber;
    @NotNull(message = "Floor can't be null")
    private Integer floor;
    @OneToMany(mappedBy = "location")
    private Set<Folder> folders;
}
