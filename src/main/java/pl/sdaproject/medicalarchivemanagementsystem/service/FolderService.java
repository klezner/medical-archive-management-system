package pl.sdaproject.medicalarchivemanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdaproject.medicalarchivemanagementsystem.model.*;
import pl.sdaproject.medicalarchivemanagementsystem.repository.FolderRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FolderService {

    private final PatientService patientService;
    private final LocationService locationService;
    private final ArchiveCategoryService archiveCategoryService;
    private final FolderRepository folderRepository;

    public Folder createFolder(Integer year, Integer ledgerId, Integer numberOfFolders, String typeLabel, String statusLabel, Long archiveCategoryId, Long locationId, Hospitalization hospitalization, Long patientId) {
        final Folder folder = Folder.builder()
                .year(year)
                .ledgerId(ledgerId)
                .numberOfFolders(numberOfFolders)
                .type(FolderType.valueOf(typeLabel))
                .status(FolderStatus.valueOf(statusLabel))
                .archiveCategory(archiveCategoryService.fetchArchiveCategory(archiveCategoryId))
                .location(locationService.fetchLocation(locationId))
                .hospitalization(hospitalization)
                .patient(patientService.fetchPatient(patientId))
                .build();

        return folderRepository.save(folder);
    }

    public Folder fetchFolder(Long id) {

        return folderRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Folder with id: " + id + " not found"));
    }

    public List<Folder> fetchAllFolders() {

        return folderRepository.findAll();
    }


    public List<Folder> fetchAllFoldersWithArchiveCategory(ArchiveCategory archiveCategory) {

        return folderRepository.findByArchiveCategory(archiveCategory);
    }

    public List<Folder> fetchAllFoldersWithSelectedFolderStatus(FolderStatus folderStatus) {

        return folderRepository.findByStatus(folderStatus);
    }
  
    @Transactional
    public Folder updateFolder(Long id, Integer year, Integer ledgerId, Integer numberOfFolders, String typeLabel, String statusLabel, Long archiveCategoryId, Long locationId, LocalDate hospitalizationDateFrom, LocalDate hospitalizationDateTo, Long patientId) {
        final Folder folder = folderRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Folder with id: " + id + " not found"));

        folder.setYear(year);
        folder.setLedgerId(ledgerId);
        folder.setNumberOfFolders(numberOfFolders);
        folder.setType(FolderType.valueOf(typeLabel));
        folder.setStatus(FolderStatus.valueOf(statusLabel));
        folder.setArchiveCategory(archiveCategoryService.fetchArchiveCategory(archiveCategoryId));
        folder.setLocation(locationService.fetchLocation(locationId));
        folder.getHospitalization().setHospitalizationFrom(hospitalizationDateFrom);
        folder.getHospitalization().setHospitalizationTo(hospitalizationDateTo);
        folder.setPatient(patientService.fetchPatient(patientId));

        return folderRepository.save(folder);
    }

    public List<Folder> fetchAllFoldersWithLocation(Location location) {

        return folderRepository.findByLocation(location);
    }
}
