package pl.sdaproject.medicalarchivemanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdaproject.medicalarchivemanagementsystem.model.Ward;
import pl.sdaproject.medicalarchivemanagementsystem.repository.HospitalizationRepository;
import pl.sdaproject.medicalarchivemanagementsystem.model.Hospitalization;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class HospitalizationService {

    @Autowired
    private WardService wardService;
    @Autowired
    private HospitalizationRepository hospitalizationRepository;

    public Hospitalization createHospitalization(LocalDate hospitalizationFrom, LocalDate hospitalizationTo, Long wardId) {

        Hospitalization hospitalization = new Hospitalization();
        hospitalization.setHospitalizationFrom(hospitalizationFrom);
        hospitalization.setHospitalizationTo(hospitalizationTo);
        hospitalization.setWard(wardService.fetchWard(wardId));

        return hospitalizationRepository.save(hospitalization);
    }

    public Hospitalization fetchHospitalization(Long id) {

        return hospitalizationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Hospitalization with id: " + id + " not found"));
    }

    public List<Hospitalization> fetchAllHospitalizationsByDates(LocalDate hospitalizationFrom, LocalDate hospitalizationTo) {

        return hospitalizationRepository.findAllByHospitalizationFromIsBetweenOrHospitalizationToIsBetween(hospitalizationFrom, hospitalizationTo, hospitalizationFrom, hospitalizationTo);
    }

    @Transactional
    public Hospitalization updateHospitalization(Long id, LocalDate hospitalizationFrom, LocalDate hospitalizationTo, Ward ward) {
        final Hospitalization hospitalization = hospitalizationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Hospitalization with id: " + id + " not found"));

        hospitalization.setWard(ward);
        hospitalization.setHospitalizationFrom(hospitalizationFrom);
        hospitalization.setHospitalizationTo(hospitalizationTo);
        return hospitalizationRepository.save(hospitalization);

    }
}
