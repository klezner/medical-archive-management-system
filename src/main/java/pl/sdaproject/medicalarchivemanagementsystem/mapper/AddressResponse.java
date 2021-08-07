package pl.sdaproject.medicalarchivemanagementsystem.mapper;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddressResponse {

    private String street;
    private String number;
    private String city;
    private String zipCode;
}
