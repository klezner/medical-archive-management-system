package pl.sdaproject.medicalarchivemanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdaproject.medicalarchivemanagementsystem.model.Ward;
import pl.sdaproject.medicalarchivemanagementsystem.repository.WardRepository;

import java.util.NoSuchElementException;

/**
 * @author MKgn
 */
@Service
public class WardService {

    @Autowired
    WardRepository wardRepository;

    public Ward createWard(String wardName) {

        Ward ward = new Ward();
        ward.setWardName(wardName);

        return wardRepository.save(ward);
    }

    public Ward fetchWard(Long id) {
        return wardRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Ward with id: " + id + "not found"));
    }
}
