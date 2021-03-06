package pl.sdaproject.medicalarchivemanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sdaproject.medicalarchivemanagementsystem.dto.PatientRequest;
import pl.sdaproject.medicalarchivemanagementsystem.dto.PatientResponse;
import pl.sdaproject.medicalarchivemanagementsystem.mapper.PatientMapper;
import pl.sdaproject.medicalarchivemanagementsystem.model.Address;
import pl.sdaproject.medicalarchivemanagementsystem.model.Patient;
import pl.sdaproject.medicalarchivemanagementsystem.service.AddressService;
import pl.sdaproject.medicalarchivemanagementsystem.service.PatientService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PatientController {

    private final AddressService addressService;
    private final PatientMapper patientMapper;
    private final PatientService patientService;

    @PostMapping(path = "/patient")
    public ResponseEntity<PatientResponse> addPatient(@RequestBody @Valid PatientRequest request) {
        final Address address = addressService.createAddress(
                request.getStreet(),
                request.getNumber(),
                request.getCity(),
                request.getZipCode());

        final Patient patient = patientService.createPatient(
                request.getFirstName(),
                request.getLastName(),
                request.getPesel(),
                address);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(patientMapper.mapPatientToPatientResponse(patient));
    }

    @GetMapping(path = "/patient/{id}")
    public ResponseEntity<PatientResponse> getPatient(@PathVariable Long id) {
        final Patient patient = patientService.fetchPatient(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(patientMapper.mapPatientToPatientResponse(patient));
    }

    @GetMapping(path = "/patient")
    public ResponseEntity<List<PatientResponse>> getAllPatients() {
        final List<Patient> patients = patientService.fetchAllPatients();

        if (patients.size() == 0) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ArrayList<>());
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(patients.stream()
                            .map(patientMapper::mapPatientToPatientResponse)
                            .collect(Collectors.toList()));
        }
    }

    @PutMapping(path = "/patient")
    public ResponseEntity<PatientResponse> editPatient(@RequestBody @Valid PatientRequest request) {
        final Patient patient = patientService.updatePatient(
                request.getId(),
                request.getFirstName(),
                request.getLastName(),
                request.getPesel(),
                request.getStreet(),
                request.getNumber(),
                request.getCity(),
                request.getZipCode());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(patientMapper.mapPatientToPatientResponse(patient));
    }
}
