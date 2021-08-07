package pl.sdaproject.medicalarchivemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sdaproject.medicalarchivemanagementsystem.model.ArchiveCategory;

@Repository
public interface ArchiveCategoryRepository extends JpaRepository<ArchiveCategory, Long> {
}