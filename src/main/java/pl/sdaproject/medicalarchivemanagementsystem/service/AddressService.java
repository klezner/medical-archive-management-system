package pl.sdaproject.medicalarchivemanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdaproject.medicalarchivemanagementsystem.model.Address;
import pl.sdaproject.medicalarchivemanagementsystem.repository.AddressRepository;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public Address createAddress(String street, String number, String city, String zipCode) {
        final Address address = Address.builder()
                .street(street)
                .number(number)
                .city(city)
                .zipCode(zipCode)
                .build();

        return addressRepository.save(address);
    }
}
