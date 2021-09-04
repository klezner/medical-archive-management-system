package pl.sdaproject.medicalarchivemanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdaproject.medicalarchivemanagementsystem.model.ArchiveCategory;
import pl.sdaproject.medicalarchivemanagementsystem.repository.ArchiveCategoryRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ArchiveCategoryService {

    private final ArchiveCategoryRepository archiveCategoryRepository;

    public ArchiveCategory createArchiveCategory(String categoryName, Integer storageYears) {

        return archiveCategoryRepository.findByCategoryNameAndStorageYears(categoryName, storageYears)
                .orElseGet(() -> archiveCategoryRepository.save(
                        ArchiveCategory.builder().categoryName(categoryName).storageYears(storageYears).build())
                );
    }

    public ArchiveCategory fetchArchiveCategory(Long id) {
        return archiveCategoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Archive category with id: " + id + " not found"));
    }

    public List<ArchiveCategory> fetchAllArchiveCategories() {

        return archiveCategoryRepository.findAll();
    }

    @Transactional
    public ArchiveCategory editArchiveCategory(Long id, String categoryName, Integer storageYears) {
        final ArchiveCategory archiveCategory = archiveCategoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Archive category with id: " + id + " not found"));

        archiveCategory.setCategoryName(categoryName);
        archiveCategory.setStorageYears(storageYears);

        return archiveCategoryRepository.save(archiveCategory);
    }
}
