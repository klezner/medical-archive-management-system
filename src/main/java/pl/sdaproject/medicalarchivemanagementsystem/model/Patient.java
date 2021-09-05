package pl.sdaproject.medicalarchivemanagementsystem.model;

import lombok.*;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "First name can't be null")
    private String firstName;
    @NotBlank(message = "Last name can't be null")
    private String lastName;
    @PESEL(message = "Incorrect pesel")
    private String pesel;
    @OneToOne
    private Address address;
    @OneToMany(mappedBy = "patient")
    private Set<Folder> folders;
}
