package pl.sdaproject.medicalarchivemanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sdaproject.medicalarchivemanagementsystem.model.Hospitalization;

@Repository
public interface HospitalizationRepository extends JpaRepository<Hospitalization, Long> {
}
