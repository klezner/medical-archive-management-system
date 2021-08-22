package pl.sdaproject.medicalarchivemanagementsystem.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

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
    @NotBlank(message = "Street can't be null")
    private String street;
    @NotBlank(message = "Number can't be null")
    private String number;
    @NotBlank(message = "City can't be null")
    private String city;
    @NotBlank(message = "Zip code can't be null")
    @Length(min = 6, max = 6, message = "Wrong zip code length")
    @Pattern(regexp = "[0-9]{2}-[0-9]{3}", message = "Wrong zip code format")
    private String zipCode;
}
