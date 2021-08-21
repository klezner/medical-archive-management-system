package pl.sdaproject.medicalarchivemanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdaproject.medicalarchivemanagementsystem.model.Folder;
import pl.sdaproject.medicalarchivemanagementsystem.model.FolderStatus;
import pl.sdaproject.medicalarchivemanagementsystem.model.FolderType;
import pl.sdaproject.medicalarchivemanagementsystem.repository.FolderRepository;

@Service
@RequiredArgsConstructor
public class FolderService {

    private final FolderRepository folderRepository;

    public Folder createFolder(Integer year, Integer ledgerId, Integer numberOfFolders, String typeLabel, String statusLabel) {
        final Folder folder = Folder.builder()
                .year(year)
                .ledgerId(ledgerId)
                .numberOfFolders(numberOfFolders)
                .type(FolderType.valueOf(typeLabel))
                .status(FolderStatus.valueOf(statusLabel))
                .build();

        return folderRepository.save(folder);
    }
}
