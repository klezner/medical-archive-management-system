package pl.sdaproject.medicalarchivemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sdaproject.medicalarchivemanagementsystem.model.Staff;

/**
 * @author MKgn
 */
@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
}
