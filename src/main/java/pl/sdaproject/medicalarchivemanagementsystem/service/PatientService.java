package pl.sdaproject.medicalarchivemanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdaproject.medicalarchivemanagementsystem.model.Address;
import pl.sdaproject.medicalarchivemanagementsystem.model.Patient;
import pl.sdaproject.medicalarchivemanagementsystem.repository.PatientRepository;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public Patient createPatient(String firstName, String lastName, String pesel, Address address) {
        final Patient patient = Patient.builder()
                .firstName(firstName)
                .lastName(lastName)
                .pesel(pesel)
                .address(address)
                .build();

        return patientRepository.save(patient);
    }

    public Patient fetchPatient(Long id) {

        return patientRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Patient with id: " + id + " not found"));
    }
}
