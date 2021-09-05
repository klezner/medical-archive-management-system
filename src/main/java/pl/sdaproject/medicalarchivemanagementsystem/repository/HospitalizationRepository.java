package pl.sdaproject.medicalarchivemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sdaproject.medicalarchivemanagementsystem.model.Hospitalization;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HospitalizationRepository extends JpaRepository<Hospitalization, Long> {

    List<Hospitalization> findAllByHospitalizationFromIsBetweenOrHospitalizationToIsBetween(LocalDate hospitalizationFromStart, LocalDate hospitalizationFromEnd, LocalDate hospitalizationToStart, LocalDate hospitalizationToEnd);
}
