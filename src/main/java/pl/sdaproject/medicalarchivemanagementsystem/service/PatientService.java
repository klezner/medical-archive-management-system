package pl.sdaproject.medicalarchivemanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdaproject.medicalarchivemanagementsystem.model.Patient;
import pl.sdaproject.medicalarchivemanagementsystem.repository.PatientRepository;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public Patient createPatient(String firstName, String lastName, String pesel) {
        final Patient patient = Patient.builder()
                .firstName(firstName)
                .lastName(lastName)
                .pesel(pesel)
                .build();

        return patientRepository.save(patient);
    }
}
