package pl.sdaproject.medicalarchivemanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sdaproject.medicalarchivemanagementsystem.dto.ArchiveCategoryRequest;
import pl.sdaproject.medicalarchivemanagementsystem.dto.ArchiveCategoryResponse;
import pl.sdaproject.medicalarchivemanagementsystem.mapper.ArchiveCategoryMapper;
import pl.sdaproject.medicalarchivemanagementsystem.model.ArchiveCategory;
import pl.sdaproject.medicalarchivemanagementsystem.service.ArchiveCategoryService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ArchiveCategoryController {

    private final ArchiveCategoryMapper archiveCategoryMapper;
    private final ArchiveCategoryService archiveCategoryService;

    @PostMapping(path = "/archiveCategory")
    public ResponseEntity<ArchiveCategoryResponse> addArchiveCategory(@RequestBody @Valid ArchiveCategoryRequest request) {
        final ArchiveCategory archiveCategory = archiveCategoryService.createArchiveCategory(
                request.getCategoryName(),
                request.getStorageYears());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(archiveCategoryMapper.mapArchiveCategoryToArchiveCategoryResponse(archiveCategory));
    }

    @GetMapping(path = "/archiveCategory/{id}")
    public ResponseEntity<ArchiveCategoryResponse> getArchiveCategory(@PathVariable Long id) {
        final ArchiveCategory archiveCategory = archiveCategoryService.fetchArchiveCategory(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(archiveCategoryMapper.mapArchiveCategoryToArchiveCategoryResponse(archiveCategory));
    }

    @GetMapping(path = "/archiveCategory")
    public ResponseEntity<List<ArchiveCategoryResponse>> getAllArchiveCategories() {
        final List<ArchiveCategory> archiveCategories = archiveCategoryService.fetchAllArchiveCategories();

        if (archiveCategories.size() == 0) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ArrayList<>());
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(archiveCategories.stream()
                            .map(archiveCategoryMapper::mapArchiveCategoryToArchiveCategoryResponse)
                            .collect(Collectors.toList()));
        }
    }

    @PutMapping(path = "/archiveCategory")
    public ResponseEntity<ArchiveCategoryResponse> editArchiveCategory(@RequestBody @Valid ArchiveCategoryRequest request) {
        final ArchiveCategory archiveCategory = archiveCategoryService.editArchiveCategory(
                request.getId(),
                request.getCategoryName(),
                request.getStorageYears());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(archiveCategoryMapper.mapArchiveCategoryToArchiveCategoryResponse(archiveCategory));
    }
}
