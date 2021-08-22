package pl.sdaproject.medicalarchivemanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sdaproject.medicalarchivemanagementsystem.dto.AddressRequest;
import pl.sdaproject.medicalarchivemanagementsystem.dto.AddressResponse;
import pl.sdaproject.medicalarchivemanagementsystem.mapper.AddressMapper;
import pl.sdaproject.medicalarchivemanagementsystem.model.Address;
import pl.sdaproject.medicalarchivemanagementsystem.service.AddressService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/address")
public class AddressController {

    private final AddressMapper addressMapper;
    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressResponse> addAddress(@RequestBody @Valid AddressRequest request) {
        final Address address = addressService.createAddress(
                request.getStreet(),
                request.getNumber(),
                request.getCity(),
                request.getZipCode());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(addressMapper.mapAddressToAddressResponse(address));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AddressResponse> getAddress(@PathVariable Long id) {
        final Address address = addressService.fetchAddress(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(addressMapper.mapAddressToAddressResponse(address));
    }

    @PutMapping
    public ResponseEntity<AddressResponse> editAddress(@RequestBody @Valid AddressRequest request) {
        final Address address = addressService.updateAddress(
                request.getId(),
                request.getStreet(),
                request.getNumber(),
                request.getCity(),
                request.getZipCode());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(addressMapper.mapAddressToAddressResponse(address));
    }
}
