package pl.sdaproject.medicalarchivemanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sdaproject.medicalarchivemanagementsystem.dto.AddressRequest;
import pl.sdaproject.medicalarchivemanagementsystem.mapper.AddressMapper;
import pl.sdaproject.medicalarchivemanagementsystem.mapper.AddressResponse;
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
}
