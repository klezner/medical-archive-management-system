package pl.sdaproject.medicalarchivemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sdaproject.medicalarchivemanagementsystem.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
