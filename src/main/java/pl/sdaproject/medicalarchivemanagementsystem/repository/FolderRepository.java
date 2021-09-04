package pl.sdaproject.medicalarchivemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sdaproject.medicalarchivemanagementsystem.model.ArchiveCategory;
import pl.sdaproject.medicalarchivemanagementsystem.model.Folder;
import pl.sdaproject.medicalarchivemanagementsystem.model.FolderStatus;

import java.util.List;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {

    List<Folder> findByArchiveCategory(ArchiveCategory archiveCategory);

    List<Folder> findByFolderStatus(FolderStatus folderStatus);
}
