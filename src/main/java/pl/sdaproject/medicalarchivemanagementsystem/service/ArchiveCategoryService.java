package pl.sdaproject.medicalarchivemanagementsystem.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import pl.sdaproject.medicalarchivemanagementsystem.model.ArchiveCategory;
import pl.sdaproject.medicalarchivemanagementsystem.model.Ward;
import pl.sdaproject.medicalarchivemanagementsystem.repository.ArchiveCategoryRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ArchiveCategoryService {

    private final ArchiveCategoryRepository archiveCategoryRepository;

    public ArchiveCategory createArchiveCategory(String categoryName, Integer storagePeriodYears) {

        return archiveCategoryRepository.findByCategoryNameAndStoragePeriodYears(categoryName, storagePeriodYears)
                .orElseGet(() -> archiveCategoryRepository.save(
                        ArchiveCategory.builder().categoryName(categoryName).storagePeriodYears(storagePeriodYears).build())
                );
    }

    public ArchiveCategory fetchArchiveCategory(Long id) {
        return archiveCategoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Archive Category with id: " + id + "doesn't exist."));
    }

    public List<ArchiveCategory> fetchAllArchiveCategories() {

        return archiveCategoryRepository.findAll();
    }
}
