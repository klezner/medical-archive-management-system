package pl.sdaproject.medicalarchivemanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdaproject.medicalarchivemanagementsystem.model.Ward;
import pl.sdaproject.medicalarchivemanagementsystem.repository.WardRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author MKgn
 */
@Service
public class WardService {

    @Autowired
    WardRepository wardRepository;

    public Ward createWard(String name, String abbreviation) {

        return wardRepository.findByName(name)
                .orElseGet(() -> wardRepository.save(
                        Ward.builder().name(name).abbreviation(abbreviation).build())
                );
    }

    public Ward fetchWard(Long id) {

        return wardRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Ward with id: " + id + "not found"));
    }

    public List<Ward> fetchAllLocations() {

        return wardRepository.findAll();
    }

    @Transactional
    public Ward updateWard(Long id, String name, String abbreviation) {
        final Ward ward = wardRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Ward with id: " + id + " not found"));

        ward.setName(name);
        ward.setAbbreviation(abbreviation);

        return ward;
    }
}
