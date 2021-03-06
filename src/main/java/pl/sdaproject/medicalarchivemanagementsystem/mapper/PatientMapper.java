package pl.sdaproject.medicalarchivemanagementsystem.mapper;

import org.springframework.stereotype.Component;
import pl.sdaproject.medicalarchivemanagementsystem.dto.PatientResponse;
import pl.sdaproject.medicalarchivemanagementsystem.model.Patient;

@Component
public class PatientMapper {

    public PatientResponse mapPatientToPatientResponse(Patient patient) {

        return PatientResponse.builder()
                .id(patient.getId())
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .pesel(patient.getPesel())
                .street(patient.getAddress().getStreet())
                .number(patient.getAddress().getNumber())
                .city(patient.getAddress().getCity())
                .zipCode(patient.getAddress().getZipCode())
                .build();
    }
}
