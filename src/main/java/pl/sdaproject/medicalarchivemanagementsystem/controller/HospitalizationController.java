package pl.sdaproject.medicalarchivemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sdaproject.medicalarchivemanagementsystem.dto.HospitalizationRequest;
import pl.sdaproject.medicalarchivemanagementsystem.dto.HospitalizationResponse;
import pl.sdaproject.medicalarchivemanagementsystem.dto.WardRequest;
import pl.sdaproject.medicalarchivemanagementsystem.dto.WardResponse;
import pl.sdaproject.medicalarchivemanagementsystem.mapper.HospitalizationMapper;
import pl.sdaproject.medicalarchivemanagementsystem.model.Hospitalization;
import pl.sdaproject.medicalarchivemanagementsystem.model.Ward;
import pl.sdaproject.medicalarchivemanagementsystem.service.HospitalizationService;
import pl.sdaproject.medicalarchivemanagementsystem.service.WardService;

import javax.validation.Valid;
import java.time.LocalDate;

import static pl.sdaproject.medicalarchivemanagementsystem.validator.HospitalizationDateValidator.validateHospitalizationDate;

@RestController
public class HospitalizationController {

    @Autowired
    private HospitalizationService hospitalizationService;

    @Autowired
    private WardService wardService;

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
    ResponseEntity<HospitalizationResponse> postHospitalization(@RequestBody @Valid HospitalizationRequest request) {
        LocalDate hospitalizedFrom = request.getHospitalizationDateFrom();
        LocalDate hospitalizedTo = request.getHospitalizationDateTo();
        Long wardId = request.getWardId();

        validateHospitalizationDate(hospitalizedFrom, hospitalizedTo);

        Hospitalization hospitalization = hospitalizationService.createHospitalization(hospitalizedFrom, hospitalizedTo, wardId);
        HospitalizationResponse responseBody = hospitalizationMapper.mapHospitalizationToHospitalizationResponse(hospitalization);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseBody);
    }

    @PutMapping("/hospitalization")
    public ResponseEntity<HospitalizationResponse> editHospitalization(@RequestBody @Valid HospitalizationRequest request) {
        final Hospitalization hospitalization = hospitalizationService.updateHospitalization(
                request.getId(),
                request.getHospitalizationDateFrom(),
                request.getHospitalizationDateTo(),
                wardService.fetchWard(request.getWardId())
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(hospitalizationMapper.mapHospitalizationToHospitalizationResponse(hospitalization));
    }
}
