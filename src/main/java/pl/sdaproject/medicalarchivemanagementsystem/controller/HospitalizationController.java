package pl.sdaproject.medicalarchivemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sdaproject.medicalarchivemanagementsystem.dto.CreateHospitalizationRequest;
import pl.sdaproject.medicalarchivemanagementsystem.dto.HospitalizationResponse;
import pl.sdaproject.medicalarchivemanagementsystem.mapper.HospitalizationMapper;
import pl.sdaproject.medicalarchivemanagementsystem.model.Hospitalization;
import pl.sdaproject.medicalarchivemanagementsystem.service.HospitalizationService;

import javax.validation.Valid;
import java.time.LocalDate;

import static pl.sdaproject.medicalarchivemanagementsystem.validator.HospitalizationDateValidator.validateHospitalizationDate;

@RestController
public class HospitalizationController {

    @Autowired
    private HospitalizationService hospitalizationService;

    @Autowired
    private HospitalizationMapper hospitalizationMapper;


    @GetMapping(path = "/hospitalization/{id}")
    public ResponseEntity<HospitalizationResponse> getHospitalization(@PathVariable Long id) {
        final Hospitalization hospitalization = hospitalizationService.fetchHospitalization(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(hospitalizationMapper.mapHospitalizationToHospitalizationResponse(hospitalization));
    }

    @PostMapping("/hospitalization")
    ResponseEntity<HospitalizationResponse> postHospitalization(@RequestBody @Valid CreateHospitalizationRequest request) {
        LocalDate hospitalizedFrom = request.getHospitalizationDateFrom();
        LocalDate hospitalizedTo = request.getHospitalizationDateTo();

        validateHospitalizationDate(hospitalizedFrom, hospitalizedTo);

        Hospitalization hospitalization = hospitalizationService.createHospitalization(hospitalizedFrom, hospitalizedTo);
        HospitalizationResponse responseBody = hospitalizationMapper.mapHospitalizationToHospitalizationResponse(hospitalization);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseBody);
    }
}
