package pl.sdaproject.medicalarchivemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sdaproject.medicalarchivemanagementsystem.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByPeselOrFirstNameAndLastName(String pesel, String name, String surname);
}
