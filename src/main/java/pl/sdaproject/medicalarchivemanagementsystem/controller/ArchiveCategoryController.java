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

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/archiveCategory")
public class ArchiveCategoryController {

    private final ArchiveCategoryMapper archiveCategoryMapper;
    private final ArchiveCategoryService archiveCategoryService;

    @PostMapping
    public ResponseEntity<ArchiveCategoryResponse> addArchiveCategory(@RequestBody @Valid ArchiveCategoryRequest request) {
        final ArchiveCategory archiveCategory = archiveCategoryService.createArchiveCategory(
                request.getArchiveCategory(),
                request.getStoragePeriodYears());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(archiveCategoryMapper.mapArchiveCategoryToArchiveCategoryResponse(archiveCategory));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ArchiveCategoryResponse> getArchiveCategory(@PathVariable Long id) {
        final ArchiveCategory archiveCategory = archiveCategoryService.fetchArchiveCategory(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(archiveCategoryMapper.mapArchiveCategoryToArchiveCategoryResponse(archiveCategory));
    }
}