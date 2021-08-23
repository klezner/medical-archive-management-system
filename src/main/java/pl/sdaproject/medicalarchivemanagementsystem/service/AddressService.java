package pl.sdaproject.medicalarchivemanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdaproject.medicalarchivemanagementsystem.model.Address;
import pl.sdaproject.medicalarchivemanagementsystem.repository.AddressRepository;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;

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

    public Address fetchAddress(Long id) {

        return addressRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Address with id: " + id + " not found"));
    }

    @Transactional
    public Address updateAddress(Long id, String street, String number, String city, String zipCode) {
        final Address address = addressRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Address with id: " + id + " not found"));

        address.setStreet(street);
        address.setNumber(number);
        address.setCity(city);
        address.setZipCode(zipCode);

        return addressRepository.save(address);
    }
}
