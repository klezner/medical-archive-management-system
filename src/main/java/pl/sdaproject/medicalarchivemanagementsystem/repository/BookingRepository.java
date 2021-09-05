package pl.sdaproject.medicalarchivemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sdaproject.medicalarchivemanagementsystem.model.Booking;
import pl.sdaproject.medicalarchivemanagementsystem.model.Staff;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByStaff(Staff staff);
}
