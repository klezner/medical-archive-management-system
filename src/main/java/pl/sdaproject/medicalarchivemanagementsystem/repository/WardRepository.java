package pl.sdaproject.medicalarchivemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sdaproject.medicalarchivemanagementsystem.model.Ward;

import java.util.Optional;

@Repository
public interface WardRepository extends JpaRepository<Ward, Long> {

    Optional<Ward> findByName(String name);
}
