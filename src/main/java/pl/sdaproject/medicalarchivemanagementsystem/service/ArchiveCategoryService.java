package pl.sdaproject.medicalarchivemanagementsystem.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import pl.sdaproject.medicalarchivemanagementsystem.model.ArchiveCategory;
import pl.sdaproject.medicalarchivemanagementsystem.repository.ArchiveCategoryRepository;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ArchiveCategoryService {

    private final ArchiveCategoryRepository archiveCategoryRepository;

    public ArchiveCategory createArchiveCategory(String category, Integer years) {
        final ArchiveCategory archiveCategory = ArchiveCategory.builder()
                .archiveCategory(category)
                .storagePeriodYears(years)
                .build();

        return archiveCategoryRepository.save(archiveCategory);
    }

    public ArchiveCategory fetchArchiveCategory(Long id) {
        return archiveCategoryRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Archive Category with id: " + id + "doesn't exist."));
    }
}