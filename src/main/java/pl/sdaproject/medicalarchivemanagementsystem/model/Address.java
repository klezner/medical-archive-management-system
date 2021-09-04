package pl.sdaproject.medicalarchivemanagementsystem.model;

import lombok.*;
import pl.sdaproject.medicalarchivemanagementsystem.validator.ZipCodeConstraint;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String number;
    private String city;
    @ZipCodeConstraint(message = "Incorrect zip code")
    private String zipCode;
}
