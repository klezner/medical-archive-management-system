package pl.sdaproject.medicalarchivemanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sdaproject.medicalarchivemanagementsystem.dto.*;
import pl.sdaproject.medicalarchivemanagementsystem.mapper.FolderMapper;
import pl.sdaproject.medicalarchivemanagementsystem.model.*;
import pl.sdaproject.medicalarchivemanagementsystem.service.ArchiveCategoryService;
import pl.sdaproject.medicalarchivemanagementsystem.service.FolderService;
import pl.sdaproject.medicalarchivemanagementsystem.service.HospitalizationService;
import pl.sdaproject.medicalarchivemanagementsystem.service.LocationService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/folder")
public class FolderController {

    private final LocationService locationService;
    private final HospitalizationService hospitalizationService;
    private final ArchiveCategoryService archiveCategoryService;
    private final FolderMapper folderMapper;
    private final FolderService folderService;

    @PostMapping
    public ResponseEntity<FolderResponse> addFolder(@RequestBody @Valid FolderRequest request) {

        final Hospitalization hospitalization = hospitalizationService.createHospitalization(
                request.getHospitalizationDateFrom(),
                request.getHospitalizationDateTo(),
                request.getWardId()
        );

        final Folder folder = folderService.createFolder(
                request.getYear(),
                request.getLedgerId(),
                request.getNumberOfFolders(),
                request.getTypeLabel().toUpperCase(),
                request.getStatusLabel().toUpperCase(),
                request.getArchiveCategoryId(),
                request.getLocationId(),
                hospitalization,
                request.getPatientId()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(folderMapper.mapFolderToFolderResponse(folder));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<FolderResponse> getFolder(@PathVariable Long id) {
        final Folder folder = folderService.fetchFolder(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(folderMapper.mapFolderToFolderResponse(folder));
    }

    @GetMapping
    public ResponseEntity<List<FolderResponse>> getAllFolders() {
        final List<Folder> folders = folderService.fetchAllFolders();

        if (folders.size() == 0) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ArrayList<>());
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(folders.stream()
                            .map(folderMapper::mapFolderToFolderResponse)
                            .collect(Collectors.toList()));
        }
    }

    @PutMapping
    public ResponseEntity<FolderResponse> editFolder(@RequestBody @Valid FolderRequest request) {
        final Folder folder = folderService.updateFolder(
                request.getId(),
                request.getYear(),
                request.getLedgerId(),
                request.getNumberOfFolders(),
                request.getTypeLabel().toUpperCase(),
                request.getStatusLabel().toUpperCase(),
                request.getArchiveCategoryId(),
                request.getLocationId(),
                request.getHospitalizationDateFrom(),
                request.getHospitalizationDateTo(),
                request.getPatientId()
        );

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(folderMapper.mapFolderToFolderResponse(folder));
    }

    @PostMapping(path = "archiveCategory")
    public ResponseEntity<List<FolderResponse>> getAllFoldersWithArchiveCategoryId(@RequestBody @Valid FolderWithArchiveCategoryIdRequest request) {
        final ArchiveCategory archiveCategory = archiveCategoryService.fetchArchiveCategory(request.getArchiveCategoryId());

        final List<Folder> folders = folderService.fetchAllFoldersWithArchiveCategory(archiveCategory);

        if (folders.size() == 0) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ArrayList<>());
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(folders.stream()
                            .map(folderMapper::mapFolderToFolderResponse)
                            .collect(Collectors.toList()));
        }
    }

    @PostMapping(path = "folderStatus")
    public ResponseEntity<List<FolderResponse>> getAllFoldersWithSelectedFolderStatus(@RequestBody @Valid FolderWithSelectedFolderStatusRequest request) {
        final FolderStatus folderStatus = FolderStatus.valueOf(request.getFolderStatusLabel());

        final List<Folder> folders = folderService.fetchAllFoldersWithSelectedFolderStatus(folderStatus);

        if (folders.size() == 0) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ArrayList<>());
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(folders.stream()
                            .map(folderMapper::mapFolderToFolderResponse)
                            .collect(Collectors.toList()));
        }
    }

    @PostMapping(path = "/location")
    public ResponseEntity<List<FolderResponse>> getAllFoldersWithLocation(@RequestBody @Valid FolderWithLocationRequest request) {
        final Location location = locationService.fetchLocation(request.getLocationId());

        final List<Folder> folders = folderService.fetchAllFoldersWithLocation(location);

        if (folders.size() == 0) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ArrayList<>());
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(folders.stream()
                            .map(folderMapper::mapFolderToFolderResponse)
                            .collect(Collectors.toList()));
        }
    }

    @PostMapping(path = "/patientandhospitalization")
    public ResponseEntity<List<FolderResponse>> getAllFoldersWithPatientAndHospitalization(@RequestBody @Valid FolderWithPatientAndHospitalizationDatesRequest request) {
        final List<Hospitalization> hospitalizations = hospitalizationService.fetchAllHospitalizationsByDates(request.getHospitalizationDateFrom(), request.getHospitalizationDateTo());

        final List<Folder> folders = hospitalizations.stream()
                .flatMap(hospitalization -> hospitalization.getFolders().stream()
                        .filter(folder -> folder.getPatient().getId() == request.getPatientId()))
                .collect(Collectors.toList());

        if (folders.size() == 0) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ArrayList<>());
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(folders.stream()
                            .map(folderMapper::mapFolderToFolderResponse)
                            .collect(Collectors.toList()));
        }
    }
}
