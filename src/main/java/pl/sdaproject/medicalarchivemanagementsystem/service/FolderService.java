package pl.sdaproject.medicalarchivemanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdaproject.medicalarchivemanagementsystem.model.Folder;
import pl.sdaproject.medicalarchivemanagementsystem.model.FolderStatus;
import pl.sdaproject.medicalarchivemanagementsystem.model.FolderType;
import pl.sdaproject.medicalarchivemanagementsystem.repository.FolderRepository;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FolderService {

    private final LocationService locationService;
    private final ArchiveCategoryService archiveCategoryService;
    private final FolderRepository folderRepository;

    public Folder createFolder(Integer year, Integer ledgerId, Integer numberOfFolders, String typeLabel, String statusLabel, Long archiveCategoryId, Long locationId) {
        final Folder folder = Folder.builder()
                .year(year)
                .ledgerId(ledgerId)
                .numberOfFolders(numberOfFolders)
                .type(FolderType.valueOf(typeLabel))
                .status(FolderStatus.valueOf(statusLabel))
                .archiveCategory(archiveCategoryService.fetchArchiveCategory(archiveCategoryId))
                .location(locationService.fetchLocation(locationId))
                .build();

        return folderRepository.save(folder);
    }

    public Folder fetchFolder(Long id) {

        return folderRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Folder with id: " + id + " not found"));
    }
}
