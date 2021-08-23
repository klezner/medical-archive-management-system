package pl.sdaproject.medicalarchivemanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdaproject.medicalarchivemanagementsystem.model.Address;
import pl.sdaproject.medicalarchivemanagementsystem.model.Patient;
import pl.sdaproject.medicalarchivemanagementsystem.repository.PatientRepository;

import javax.transaction.Transactional;
import java.util.List;
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

        return patientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Patient with id: " + id + " not found"));
    }

    public List<Patient> fetchAllPatients() {

        return patientRepository.findAll();
    }

    @Transactional
    public Patient updatePatient(Long id, String firstName, String lastName, String pesel, String street, String number, String city, String zipCode) {
        final Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Patient with id: " + id + " not found"));

        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setPesel(pesel);
        patient.getAddress().setStreet(street);
        patient.getAddress().setNumber(number);
        patient.getAddress().setCity(city);
        patient.getAddress().setZipCode(zipCode);

        return patientRepository.save(patient);
    }
}
