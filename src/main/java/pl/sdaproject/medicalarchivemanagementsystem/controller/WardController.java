package pl.sdaproject.medicalarchivemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sdaproject.medicalarchivemanagementsystem.dto.WardRequest;
import pl.sdaproject.medicalarchivemanagementsystem.dto.WardResponse;
import pl.sdaproject.medicalarchivemanagementsystem.mapper.WardMapper;
import pl.sdaproject.medicalarchivemanagementsystem.model.Ward;
import pl.sdaproject.medicalarchivemanagementsystem.service.WardService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * WardController
 *
 * @author MKgn
 */
@RestController
@RequestMapping(path = "/ward")
public class WardController {

    @Autowired
    WardService wardService;

    @Autowired
    WardMapper wardMapper;

    @GetMapping(path = "/ward/{id}")
    public ResponseEntity<WardResponse> getWard(@PathVariable Long id) {
        final Ward ward = wardService.fetchWard(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(wardMapper.mapWardToWardResponse(ward));
    }

    @PostMapping("/ward")
    ResponseEntity<WardResponse> postWard(@RequestBody @Valid WardRequest request) {

        Ward ward = wardService.createWard(request.getName(), request.getAbbreviation());
        WardResponse responseBody = wardMapper.mapWardToWardResponse(ward);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseBody);
    }

    @GetMapping(path = "ward")
    ResponseEntity<List<WardResponse>> getAllWards() {
        final List<Ward> wards = wardService.fetchAllLocations();

        if (wards.size() == 0) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ArrayList<>());
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(wards.stream()
                            .map(wardMapper::mapWardToWardResponse)
                            .collect(Collectors.toList()));
        }
    }

    @PutMapping
    public ResponseEntity<WardResponse> editWard(@RequestBody @Valid WardRequest request) {
        final Ward ward = wardService.updateWard(
                request.getId(),
                request.getName(),
                request.getAbbreviation()
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(wardMapper.mapWardToWardResponse(ward));
    }
}
